package com.example.bancoandino.activities;

import android.os.Bundle;
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
import java.util.Locale;

/**
 * Pantalla 2: Panel de Cuenta.
 * Recibe el nombre de usuario por Intent, muestra un saldo simulado
 * y una lista de movimientos simulados en un RecyclerView.
 */
public class PanelActivity extends AppCompatActivity {

    private static final double SALDO_SIMULADO = 3450.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        String nombre = getIntent().getStringExtra("nombreUsuario");
        if (nombre == null || nombre.isEmpty()) {
            nombre = "Cliente";
        }

        TextView tvBienvenida = findViewById(R.id.tvBienvenida);
        TextView tvSaldo = findViewById(R.id.tvSaldo);
        RecyclerView rvMovimientos = findViewById(R.id.rvMovimientos);
        Button btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        tvBienvenida.setText(getString(R.string.bienvenida_formato, nombre));
        tvSaldo.setText(String.format(Locale.getDefault(), getString(R.string.saldo_formato), SALDO_SIMULADO));

        rvMovimientos.setLayoutManager(new LinearLayoutManager(this));
        rvMovimientos.setAdapter(new MovimientoAdapter(crearMovimientosSimulados()));

        btnCerrarSesion.setOnClickListener(v -> finish());
    }

    private List<Movimiento> crearMovimientosSimulados() {
        List<Movimiento> lista = new ArrayList<>();
        lista.add(new Movimiento("20/08/2026", "Pago de servicios - luz", -120.00));
        lista.add(new Movimiento("18/08/2026", "Depósito en efectivo", 500.00));
        lista.add(new Movimiento("15/08/2026", "Transferencia recibida", 250.50));
        lista.add(new Movimiento("12/08/2026", "Compra en supermercado", -89.90));
        lista.add(new Movimiento("09/08/2026", "Pago de tarjeta de crédito", -300.00));
        lista.add(new Movimiento("05/08/2026", "Retiro en cajero", -100.00));
        return lista;
    }
}
