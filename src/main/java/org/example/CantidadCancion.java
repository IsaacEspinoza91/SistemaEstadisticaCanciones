package org.example;

public class CantidadCancion {

    private int cantidad;
    private String nombre;

    public CantidadCancion(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CantidadCancion{" +
                "cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
