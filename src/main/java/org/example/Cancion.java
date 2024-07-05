package org.example;

import java.util.List;

public class Cancion {

    // Atributos
    private String nombre;
    private List<Dia> fechas;


    // Constructor
    public Cancion(String nombre, List<Dia> fechas) {
        this.nombre = nombre;
        this.fechas = fechas;
    }
    public Cancion(String nombre) {
        this.nombre = nombre;
    }


    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Dia> getFechas() {
        return fechas;
    }
    public void setFechas(List<Dia> fechas) {
        this.fechas = fechas;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", fechas=" + fechas +
                '}';
    }

    // Metodos
    public void addFecha(Dia dia) {
        this.fechas.add(dia);
    }




}
