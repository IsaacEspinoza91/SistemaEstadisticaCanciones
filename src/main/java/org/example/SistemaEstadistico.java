package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SistemaEstadistico {

    // Atributos
    private List<Dia> fechas;
    private List<Cancion> canciones;


    // Constructor
    public SistemaEstadistico() {
        this.fechas = new ArrayList<Dia>();
        this.canciones = new ArrayList<Cancion>();
    }


    // Getters y Setters
    public List<Dia> getFechas() {
        return fechas;
    }
    public void setFechas(List<Dia> fechas) {
        this.fechas = fechas;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "SistemaEstadistico{" +
                "fechas=" + fechas +
                "\n, canciones=" + canciones +
                '}';
    }


    // Metodos
    public void addDataByTXT(String archivo){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));//leer el archivo
            String line;
            while ((line = reader.readLine()) != null) {
                boolean existeCancion = false;
                String[] parts = line.split(";");
                int anio = Integer.parseInt(parts[0]);
                int mes = Integer.parseInt(parts[1]);
                int dia = Integer.parseInt(parts[2]);
                String tipoFecha = parts[3];
                String[] nombresCanciones = parts[4].split(",");
                Dia diaActual = new Dia(dia,mes,anio,tipoFecha);
                this.fechas.add(diaActual);

                for(String nombre : nombresCanciones){
                    for (Cancion cancion : canciones) {
                        if (cancion.getNombre().equals(nombre)) {
                            cancion.addFecha(diaActual);
                            existeCancion = true;
                        }
                    }
                    if(!existeCancion || canciones.isEmpty()){
                        Cancion cancionActual = new Cancion(nombre,new ArrayList<>(Arrays.asList(diaActual)));
                        canciones.add(cancionActual);
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int cantidadVecesCancionEnUnMes(String nombreCancion,int numeroMes){
        int cantidad = 0;
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombreCancion)) {
                for (Dia dia : cancion.getFechas()) {
                    if(dia.getMes() == numeroMes){
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }

    public int cantidadVecesCancionEnUnMes(String nombreCancion,int numeroMes, String tipoDia){
        int cantidad = 0;
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombreCancion)) {
                for (Dia dia : cancion.getFechas()) {
                    if (dia.getMes() == numeroMes && dia.getTipo().equals(tipoDia)){
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }

    public int cantidadVecesCancion(String nombreCancion){
        int cantidad = 0;
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombreCancion)) {
                cantidad = cancion.getFechas().size();
            }
        }
        return cantidad;
    }

    public int cantidadVecesCancion(String nombreCancion, String tipoDia){
        int cantidad = 0;
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombreCancion)) {
                for (Dia dia : cancion.getFechas()) {
                    if (dia.getTipo().equals(tipoDia)) {
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }

    public List<String> cancionesEnDia(int anio, int mes, int dia){
        List<String> cancionesEnDia = new ArrayList<>();
        Dia diaAux = new Dia(dia,mes,anio,"d");
        for (Dia d : fechas){
            if(d.getAnio() == anio && d.getMes() == mes && d.getDia() == dia){
                diaAux = d;
            }
        }
        for (Cancion cancion : canciones){
            if(cancion.getFechas().contains(diaAux)){
                cancionesEnDia.add(cancion.getNombre());
                System.out.println(cancion.getNombre());
            }
        }
        return cancionesEnDia;
    }

    public List<CantidadCancion> rankingCanciones(){
        List<CantidadCancion> cantidadCancionesLista = new ArrayList<>();
        for (Cancion cancion : canciones) {
            cantidadCancionesLista.add(new CantidadCancion(cantidadVecesCancion(cancion.getNombre()),cancion.getNombre()));
        }
        ordenarPorCantidad(cantidadCancionesLista);
        return cantidadCancionesLista;
    }

    public void ordenarPorCantidad(List<CantidadCancion> lista) {
        lista.sort((c1, c2) -> Integer.compare(c1.getCantidad(), c2.getCantidad()));
    }

    public List<CantidadCancion> rankingCancionesPorMes(int nMes){
        List<CantidadCancion> cantidadCancionesLista = new ArrayList<>();
        for (Cancion cancion : canciones) {
            if(cantidadVecesCancionEnUnMes(cancion.getNombre(),nMes) != 0) {
                cantidadCancionesLista.add(new CantidadCancion(cantidadVecesCancionEnUnMes(cancion.getNombre(), nMes), cancion.getNombre()));
            }
        }
        ordenarPorCantidad(cantidadCancionesLista);
        return cantidadCancionesLista;
    }



}
