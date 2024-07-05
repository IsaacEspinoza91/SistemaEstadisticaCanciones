package org.example;

import java.util.List;

public class Dia {

    // Atributos
    private int dia;
    private int mes;
    private int anio;
    private String tipo;
    //private List<Cancion> canciones;


    // Constructor
    public Dia(int dia, int mes, int anio, String tipo) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.tipo = tipo;
    }


    // Getters y setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Dia{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    // Metodos


}
