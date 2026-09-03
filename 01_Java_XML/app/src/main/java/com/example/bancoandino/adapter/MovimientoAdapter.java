package com.example.bancoandino.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancoandino.R;
import com.example.bancoandino.model.Movimiento;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Adapter del RecyclerView que muestra la lista de movimientos
 * simulados en el Panel de Cuenta (Reto Semana 2).
 */
public class MovimientoAdapter extends RecyclerView.Adapter<MovimientoAdapter.MovimientoViewHolder> {

    private List<Movimiento> listaMovimientos;
    private final DecimalFormat formatoMonto = new DecimalFormat("0.00");

    public MovimientoAdapter(List<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    @NonNull
    @Override
    public MovimientoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movimiento, parent, false);
        return new MovimientoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MovimientoViewHolder holder, int position) {
        Movimiento movimiento = listaMovimientos.get(position);

        holder.tvFecha.setText(movimiento.getFecha());
        holder.tvDescripcion.setText(movimiento.getDescripcion());

        double monto = movimiento.getMonto();
        String montoTexto = (monto >= 0 ? "+ S/ " : "- S/ ") + formatoMonto.format(Math.abs(monto));
        holder.tvMonto.setText(montoTexto);

        // Verde si es un ingreso, rojo si es un gasto
        if (monto >= 0) {
            holder.tvMonto.setTextColor(0xFF2E7D32); // verde
        } else {
            holder.tvMonto.setTextColor(0xFFC62828); // rojo
        }
    }

    @Override
    public int getItemCount() {
        return listaMovimientos.size();
    }

    /**
     * ViewHolder: guarda las referencias de cada fila (item_movimiento.xml)
     * para no llamar a findViewById repetidamente por cada elemento.
     */
    static class MovimientoViewHolder extends RecyclerView.ViewHolder {

        TextView tvFecha;
        TextView tvDescripcion;
        TextView tvMonto;

        public MovimientoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvMonto = itemView.findViewById(R.id.tvMonto);
        }
    }
}
