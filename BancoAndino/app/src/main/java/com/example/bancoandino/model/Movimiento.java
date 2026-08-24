package com.example.bancoandino.model;

/**
 * Clase modelo que representa un movimiento (transacción) simulado
 * dentro del panel de cuenta.
 */
public class Movimiento {

    private final String fecha;
    private final String descripcion;
    private final double monto;

    public Movimiento(String fecha, String descripcion, double monto) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }
}
