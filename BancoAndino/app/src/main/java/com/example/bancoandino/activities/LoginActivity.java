package com.example.bancoandino.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bancoandino.R;

/**
 * Pantalla 1: Login.
 * Valida campos vacíos y credenciales fijas antes de navegar
 * a {@link PanelActivity}, enviando el nombre de usuario por Intent.
 *
 * Reto extra: recuerda el último usuario que inició sesión usando
 * SharedPreferences, dejando el campo "usuario" pre-llenado la
 * próxima vez que se abra la app.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String USUARIO_VALIDO = "cliente1";
    private static final String CLAVE_VALIDA = "banco2026";

    private static final String PREFS_NOMBRE = "BancoAndinoPrefs";
    private static final String PREF_ULTIMO_USUARIO = "ultimoUsuario";

    private EditText etUsuario;
    private EditText etClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        Button btnIngresar = findViewById(R.id.btnIngresar);

        precargarUltimoUsuario();

        btnIngresar.setOnClickListener(v -> intentarIngresar());
    }

    /**
     * Reto extra: si hay un usuario guardado de una sesión anterior,
     * se pre-llena el campo "usuario".
     */
    private void precargarUltimoUsuario() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NOMBRE, MODE_PRIVATE);
        String ultimoUsuario = prefs.getString(PREF_ULTIMO_USUARIO, "");
        if (!TextUtils.isEmpty(ultimoUsuario)) {
            etUsuario.setText(ultimoUsuario);
            etClave.requestFocus();
        }
    }

    private void intentarIngresar() {
        String usuario = etUsuario.getText().toString().trim();
        String clave = etClave.getText().toString().trim();

        if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(clave)) {
            Toast.makeText(this, R.string.error_campos_vacios, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!usuario.equals(USUARIO_VALIDO) || !clave.equals(CLAVE_VALIDA)) {
            Toast.makeText(this, R.string.error_credenciales, Toast.LENGTH_SHORT).show();
            return;
        }

        guardarUltimoUsuario(usuario);

        Intent intent = new Intent(LoginActivity.this, PanelActivity.class);
        intent.putExtra("nombreUsuario", usuario);
        startActivity(intent);
        // No se llama finish() aquí: LoginActivity permanece en el back stack
        // para que el botón "Cerrar sesión" de PanelActivity pueda volver
        // simplemente con finish().
    }

    private void guardarUltimoUsuario(String usuario) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NOMBRE, MODE_PRIVATE);
        prefs.edit().putString(PREF_ULTIMO_USUARIO, usuario).apply();
    }
}
