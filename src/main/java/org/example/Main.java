package org.example;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SistemaEstadistico s1 = new SistemaEstadistico();
        s1.addDataByTXT("texto.txt");
        //System.out.println(s1);

        System.out.println("Gracia sublime     cantidad  "+s1.cantidadVecesCancionEnUnMes("Gracia sublime",3));
        System.out.println("Senor mi dioss cantidad total   "+s1.cantidadVecesCancion("Señor mi Dios"));
        for(Cancion c : s1.getCanciones()){
            //System.out.println(c.getNombre());
            System.out.println(c);
            if(c.getNombre().equals("Gracia sublime")){
                //System.out.println(c);
            }
        }
        System.out.println("\n\n\n");
        System.out.println(s1.cancionesEnDia(2025,6,13));
        for(CantidadCancion e : s1.rankingCancionesPorMes(5)){
            System.out.println(e);
        }
        //System.out.println(s1);

        Scanner inTeclado = new Scanner(System.in);
        int opcion;
        do{

            printMenuPrincipal();
            opcion = inTeclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("\nA continuacion ingrese los datos del dia especifico");
                    System.out.println("\tAnio: ");
                    int anio = inTeclado.nextInt();
                    System.out.println("\tMes: ");
                    int mes = inTeclado.nextInt();
                    System.out.println("\tDia: ");
                    int dia = inTeclado.nextInt();

                    List<String> cancionesEnDia = s1.cancionesEnDia(anio,mes,dia);
                    for (int a=0;a<cancionesEnDia.size();a++){
                        System.out.println("\t "+a+". "+cancionesEnDia.get(a));
                    }
                    break;
                case 2:
                    System.out.println("A continuacion ingrese el nombre de la cancion:");
                    String nombre = inTeclado.next();
                    for(Cancion c : s1.getCanciones()){
                        if(c.getNombre().equals(nombre)){
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:

            }
        }while(opcion !=6);

    }



    private static void printMenuPrincipal() {
        System.out.println("\n\n### Sistema Estaditico Canciones - Inicio ###");
        System.out.println("Opciones de analisis\n\n");
        System.out.println("\t1.  Obtener canciones de un dia especifico");
        System.out.println("\t2.  Obtener datos globales de una cancion");
        System.out.println("\t3.  Obtener datos globales de todas las canciones");
        System.out.println("\t4.  Ranking de global de canciones");
        System.out.println("\t5.  Ranking de mensual de canciones");
        System.out.println("\t6.  Salir");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }


}