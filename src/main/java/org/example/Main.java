package org.example;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SistemaEstadistico s1 = new SistemaEstadistico();
        s1.addDataByTXT("texto.txt");


        Scanner inTeclado = new Scanner(System.in);
        int opcion, anio, mes, dia;
        String respuestaTipo, nombre;
        do{

            printMenuPrincipal();
            opcion = inTeclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("\nA continuacion ingrese los datos del dia especifico");
                    System.out.println("Anio: ");
                    anio = inTeclado.nextInt();
                    System.out.println("Mes: ");
                    mes = inTeclado.nextInt();
                    System.out.println("Dia: ");
                    dia = inTeclado.nextInt();

                    List<String> cancionesEnDia = s1.cancionesEnDia(anio,mes,dia);
                    System.out.println("\nCanciones tocadas ese dia:");
                    for (int a=0;a<cancionesEnDia.size();a++){
                        System.out.println("\t "+(a+1)+". "+cancionesEnDia.get(a));
                    }
                    break;
                case 2:
                    System.out.println("A continuacion ingrese el nombre de la cancion:");
                    inTeclado.nextLine();
                    nombre = inTeclado.nextLine();
                    System.out.println("\n");
                    for(Cancion c : s1.getCanciones()){
                        if(c.getNombre().equals(nombre)){
                            System.out.println(c.printCancion());
                        }
                    }
                    break;
                case 3:
                    System.out.println("A continuacion se presentan los datos globales de todas las canciones");
                    for(Cancion c : s1.getCanciones()){
                        System.out.println(c.printCancion());
                    }
                    break;
                case 4:
                    System.out.println("A continuacion ingrese el nombre de la cancion:");
                    inTeclado.nextLine();
                    nombre = inTeclado.nextLine();
                    System.out.println("Desea los datos para algun tipo de dia en especifico (d: Domingo, j: Jueves, t:todos)");
                    respuestaTipo = inTeclado.nextLine();
                    for(Cancion c : s1.getCanciones()){
                        if(c.getNombre().equals(nombre)){
                            if(respuestaTipo.equals("d")){
                                System.out.println("\n   La cancion:   "+c.getNombre()+"    fue tocada      "+s1.cantidadVecesCancion(nombre,"d")+"   Domingos");
                            }else if(respuestaTipo.equals("j")){
                                System.out.println("\n   La cancion:   "+c.getNombre()+"    fue tocada      "+s1.cantidadVecesCancion(nombre,"j")+"   Jueves");
                            }else{
                                System.out.println("\n   La cancion:   "+c.getNombre()+"    fue tocada      "+s1.cantidadVecesCancion(nombre)+"   veces");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("A continuacion ingrese el nombre de la cancion:");
                    inTeclado.nextLine();
                    nombre = inTeclado.nextLine();
                    System.out.println("Desea los datos para algun tipo de dia en especifico (d: Domingo, j: Jueves, t:todos)");
                    respuestaTipo = inTeclado.nextLine();
                    System.out.println("Ingrese el numero de mes:");
                    mes = inTeclado.nextInt();
                    for(Cancion c : s1.getCanciones()){
                        if(c.getNombre().equals(nombre)){
                            if(respuestaTipo.equals("d")){
                                System.out.println("\n   La cancion:   "+c.getNombre()+"    fue tocada      "+s1.cantidadVecesCancionEnUnMes(nombre,mes,"d")+"   Domingos");
                            }else if(respuestaTipo.equals("j")){
                                System.out.println("\n   La cancion:   "+c.getNombre()+"    fue tocada      "+s1.cantidadVecesCancionEnUnMes(nombre,mes,"j")+"   Jueves");
                            }else{
                                System.out.println("\n   La cancion:   "+c.getNombre()+"    fue tocada      "+s1.cantidadVecesCancionEnUnMes(nombre,mes)+"   veces");
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("A continuacion se presentan el ranking global de canciones tocadas desde el 2024/01/25:");
                    List<CantidadCancion> listaRanking = s1.rankingCanciones();
                    for(int a=0;a<listaRanking.size();a++){
                        System.out.println("\t "+(a+1)+".-  "+listaRanking.get(a).getNombre() + " -  "+listaRanking.get(a).getCantidad());
                    }
                    break;
                case 7:
                    System.out.println("A continuacion se presentan el ranking en un mes de canciones tocadas desde el 2024/01/25:");
                    System.out.println("Ingrese el numero de mes:");
                    mes = inTeclado.nextInt();
                    List<CantidadCancion> listaRankingMes = s1.rankingCancionesPorMes(mes);
                    for(int a=0;a<listaRankingMes.size();a++){
                        System.out.println("\t "+(a+1)+".-  "+listaRankingMes.get(a).getNombre() + " -  "+listaRankingMes.get(a).getCantidad());
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa");
                    break;
            }
        }while(opcion !=8);

    }



    private static void printMenuPrincipal() {
        System.out.println("\n\n### Sistema Estaditico Canciones - Inicio ###");
        System.out.println("Opciones de analisis\n\n");
        System.out.println("\t1.  Obtener canciones de un dia especifico");
        System.out.println("\t2.  Obtener datos globales de una cancion");
        System.out.println("\t3.  Obtener datos globales de todas las canciones");
        System.out.println("\t4.  Obtener cantidad global de veces tocadas de una cancion");
        System.out.println("\t5.  Obtener cantidad en mes de veces tocadas de una cancion");
        System.out.println("\t6.  Ranking de global de canciones");
        System.out.println("\t7.  Ranking de mensual de canciones");
        System.out.println("\t8.  Salir");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }


}