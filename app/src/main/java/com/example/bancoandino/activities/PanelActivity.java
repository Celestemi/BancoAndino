package com.example.bancoandino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancoandino.R;
import com.example.bancoandino.adapter.MovimientoAdapter;
import com.example.bancoandino.model.Movimiento;

import java.util.ArrayList;
import java.util.List;

/**
 * Pantalla 2 - Panel de Cuenta.
 * Recibe el nombre del usuario por Intent, muestra un saldo
 * simulado y una lista de movimientos con RecyclerView.
 */
public class PanelActivity extends AppCompatActivity {

    private TextView tvBienvenida;
    private TextView tvSaldo;
    private RecyclerView rvMovimientos;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        // 1. Conectamos vistas
        tvBienvenida = findViewById(R.id.tvBienvenida);
        tvSaldo = findViewById(R.id.tvSaldo);
        rvMovimientos = findViewById(R.id.rvMovimientos);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        // 2. Recibimos el nombre enviado desde LoginActivity
        String nombre = getIntent().getStringExtra("nombreUsuario");
        if (nombre == null) {
            nombre = "Usuario";
        }
        tvBienvenida.setText("Bienvenido, " + nombre);

        // 3. Saldo simulado (numero fijo)
        tvSaldo.setText("S/ 3,450.00");

        // 4. Configuramos el RecyclerView con al menos 5 movimientos
        List<Movimiento> movimientos = obtenerMovimientosSimulados();
        rvMovimientos.setLayoutManager(new LinearLayoutManager(this));
        rvMovimientos.setAdapter(new MovimientoAdapter(movimientos));

        // 5. Boton "Cerrar sesion": regresa al Login
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanelActivity.this, LoginActivity.class);
                // Limpiamos el historial para que el usuario no pueda
                // regresar al Panel con el boton "atras" del telefono
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * Datos simulados en un ArrayList, tal como indica el Reto:
     * no hace falta base de datos todavia.
     */
    private List<Movimiento> obtenerMovimientosSimulados() {
        List<Movimiento> lista = new ArrayList<>();
        lista.add(new Movimiento("20/08/2026", "Deposito en agencia", 500.00));
        lista.add(new Movimiento("19/08/2026", "Pago Netflix", -35.90));
        lista.add(new Movimiento("18/08/2026", "Transferencia recibida", 150.00));
        lista.add(new Movimiento("17/08/2026", "Compra supermercado", -120.50));
        lista.add(new Movimiento("15/08/2026", "Retiro cajero", -200.00));
        lista.add(new Movimiento("12/08/2026", "Pago de servicios", -85.30));
        return lista;
    }
}
