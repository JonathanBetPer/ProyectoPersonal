import BetaTestingPackage.Desarrolladora;
import java.util.Scanner;

/**
 * @author Jonathan Betancor Perdomo
 * @since 03/06/2023
 * @version v1
 *
 * Principal. Programa con menú simple que usa la clases del paquete BetaTesting
 *
 * // TODO: 03/06/2023 Falta documentar y añadir funcionalidades
 */

public class Main {

    private static Scanner entrada;
    private static Desarrolladora desarrolladora;
    public static void main(String[] args) {

        entrada=new Scanner(System.in);

        creacionDesarrolladora();

        menu();

        entrada.close();
    }

    public static void creacionDesarrolladora(){

        String nombre, email, direccion, CIF;


        System.out.println("Introduzca el nombre de la desarrolladora: ");
        System.out.print("->\t");
        nombre=entrada.next().trim();


        System.out.println("Introduzca el email: ");
        System.out.print("->\t");
        email=entrada.next().trim();


        System.out.println("Introduzca el direccion: ");
        System.out.print("->\t");
        direccion=entrada.next().trim();


        System.out.println("Introduzca el CIF: ");
        System.out.print("->\t");
        CIF=entrada.next().trim();


        desarrolladora=new Desarrolladora(nombre,email,direccion,CIF);

    }

    public static void crearProyecto(){

        String nombre, descripcion,tituloRecompensa,descripcionRecompensa;
        int numeroVacantes, valorRecompensa;

        System.out.println("Introduzca el nombre del proyecto: ");
        System.out.print("->\t");
        nombre=entrada.next().trim();


        System.out.println("Introduzca la descripcion: ");
        System.out.print("->\t");
        descripcion=entrada.next().trim();


        System.out.println("Introduzca el número de vacantes: ");
        System.out.print("->\t");

        try {
            numeroVacantes=Integer.parseInt(entrada.next());
        }catch (Exception e){
            System.out.println("Error: Número de vacantes incorrecto, estableciento a 50");
            numeroVacantes=50;
        }


        System.out.println("Introduzca el título de la recompensa: ");
        System.out.print("->\t");
        tituloRecompensa=entrada.next().trim();


        System.out.println("Introduzca el valor de la recompensa: ");
        System.out.print("->\t");
        try {
            valorRecompensa=Integer.parseInt(entrada.next());
        }catch (Exception e){
            System.out.println("Error: Recompensa incorrecto, estableciento a 100");
            valorRecompensa=100;
        }


        System.out.println("Introduzca el descripción de la recompensa: ");
        System.out.print("->\t");
        descripcionRecompensa=entrada.next().trim();


        desarrolladora.crearProyecto(nombre,descripcion,numeroVacantes,tituloRecompensa,valorRecompensa,descripcionRecompensa);

    }

    public static void menu(){
        byte menu;

        do{

            System.out.println("* --------------- MENÚ --------------- *");
            System.out.println("  1. Ver Información Desarrolladora");
            System.out.println("  2. Añadir Nuevo Proyecto");
            System.out.println("  3. Ver Información Proyectos Propios");
            System.out.println("  4. Salir");
            System.out.println("* ------------------------------------ *");

            System.out.print("->\t");
            try {
                menu=Byte.parseByte(entrada.next());
            }catch (Exception e){
                menu=-1;
            }

            switch (menu) {

                case 1:
                    System.out.println(desarrolladora.toString());
                break;

                case 2:
                    crearProyecto();
                break;

                case 3:
                    if(!desarrolladora.listarProyectos().equals(" ")){
                        System.out.println(desarrolladora.listarProyectos());
                    }
                break;

                case 4:
                    System.out.println("No se guardará nada ¿Seguro que quieres salir?\n Escriba 'N' para cancelar:\n\t");
                    String comprobacion;
                    comprobacion=entrada.nextLine().toUpperCase();

                    if (comprobacion.equals("N")){
                        menu=-0;
                    }

                break;

                default:
                    System.out.println("Error: Opción incorrecta");
            }
        }while (menu!=8);
    }



}