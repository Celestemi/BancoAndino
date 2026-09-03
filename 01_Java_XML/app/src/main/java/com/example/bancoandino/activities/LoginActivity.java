package com.example.bancoandino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bancoandino.R;

/**
 * Pantalla 1 - Login.
 * Sigue el mismo patron visto en el Ejercicio de Sesion 1:
 * el XML declara que existe, esta clase decide que hace.
 *
 * Credenciales fijas (sin base de datos todavia), tal como
 * se pide en el Reto de Semana 2.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String USUARIO_VALIDO = "cliente1";
    private static final String CLAVE_VALIDA = "banco2026";

    private EditText etUsuario;
    private EditText etClave;
    private Button btnIngresar;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. Conectamos la Logica con el Diseno usando los IDs del XML
        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        btnIngresar = findViewById(R.id.btnIngresar);
        tvMensaje = findViewById(R.id.tvMensaje);

        // 2. Definimos que pasa cuando el usuario toca el boton
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        });
    }

    private void validarLogin() {
        String usuario = etUsuario.getText().toString().trim();
        String clave = etClave.getText().toString().trim();

        // Validacion de campos vacios (criterio de evaluacion: 4 pts)
        if (usuario.isEmpty() || clave.isEmpty()) {
            Toast.makeText(this, "Completa usuario y clave", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validacion de credenciales fijas
        if (usuario.equals(USUARIO_VALIDO) && clave.equals(CLAVE_VALIDA)) {
            tvMensaje.setVisibility(TextView.GONE);

            // Navegamos a la Pantalla 2 enviando el nombre del usuario (Intent)
            Intent intent = new Intent(LoginActivity.this, PanelActivity.class);
            intent.putExtra("nombreUsuario", usuario);
            startActivity(intent);

        } else {
            tvMensaje.setText("Credenciales incorrectas");
            tvMensaje.setVisibility(TextView.VISIBLE);
        }
    }
}
