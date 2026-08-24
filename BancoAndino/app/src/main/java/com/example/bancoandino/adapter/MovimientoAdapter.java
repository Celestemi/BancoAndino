package com.example.bancoandino.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancoandino.R;
import com.example.bancoandino.model.Movimiento;

import java.util.List;
import java.util.Locale;

/**
 * Adapter que enlaza la lista de {@link Movimiento} con el RecyclerView
 * de la pantalla de Panel de Cuenta.
 */
public class MovimientoAdapter extends RecyclerView.Adapter<MovimientoAdapter.MovimientoViewHolder> {

    private final List<Movimiento> movimientos;

    public MovimientoAdapter(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @NonNull
    @Override
    public MovimientoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movimiento, parent, false);
        return new MovimientoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovimientoViewHolder holder, int position) {
        Movimiento movimiento = movimientos.get(position);

        holder.tvDescripcion.setText(movimiento.getDescripcion());
        holder.tvFecha.setText(movimiento.getFecha());

        double monto = movimiento.getMonto();
        String signo = monto >= 0 ? "+" : "-";
        String montoFormateado = String.format(Locale.getDefault(), "%sS/ %.2f", signo, Math.abs(monto));
        holder.tvMonto.setText(montoFormateado);

        int color = monto >= 0
                ? holder.itemView.getResources().getColor(R.color.andino_verde)
                : holder.itemView.getResources().getColor(R.color.andino_rojo);
        holder.tvMonto.setTextColor(color);
    }

    @Override
    public int getItemCount() {
        return movimientos.size();
    }

    static class MovimientoViewHolder extends RecyclerView.ViewHolder {
        final TextView tvDescripcion;
        final TextView tvFecha;
        final TextView tvMonto;

        MovimientoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvMonto = itemView.findViewById(R.id.tvMonto);
        }
    }
}
