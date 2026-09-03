package com.example.bancoandino.model;

/**
 * Clase modelo que representa un movimiento bancario simulado.
 * No se conecta a base de datos: los datos viven en un ArrayList
 * dentro de PanelActivity.
 */
public class Movimiento {

    private String fecha;
    private String descripcion;
    private double monto;

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
