package BetaTestingPackage;
import java.util.ArrayList;

/**
 * @author Jonathan Betancor Perdomo
 * @since 03/06/2023
 * @version v1
 *
 * Clase Proyecto
 * Maneja todos los atributos y métodos para que el proyecto de BetaTesting
 *
 */

public class Proyecto {

    private int id;
    private static int actualID=0;
    private String nombre;
    private String descripcion;
    private int numeroVacantes;
    private boolean admision;

    private Recompensa recompensaAsociada;

    private ArrayList<Reporte> listaReportes;

    private ArrayList<BetaTester> listaBetaTesters;

    /**
     * Constructor de la clase Proyecto
     * Llama al constructor de la clase Recompensa para crear su propia recompensa
     *
     * @param nombre del proyecto (String)
     * @param descripcion del proyecto (String)
     * @param numeroVacantes del proyecto (int)
     * @param tituloRecompensa del proyecto (String)
     * @param valorRecompensa de la recompensa del proyecto (int)
     * @param descripcionRecompensa de la recompensa del proyecto (String)
     */
    protected Proyecto(String nombre, String descripcion, int numeroVacantes, String tituloRecompensa, int valorRecompensa, String descripcionRecompensa) {
        this.id=actualID+1;
        actualID++;
        this.nombre = nombre;
        this.descripcion = descripcion;

        if (numeroVacantes>0){
            this.numeroVacantes = numeroVacantes;
        }else {
            this.numeroVacantes=50;
        }

        this.admision = true;
        this.recompensaAsociada = new Recompensa(tituloRecompensa,valorRecompensa, descripcionRecompensa);
        this.listaReportes = new ArrayList<>();
        this.listaBetaTesters = new ArrayList<>();
    }

    /**
     * Método que permite modificar los datos de la recompensa de la clase Proyecto
     *
     * @param valorRecompensa de la recompensa del proyecto (int)
     * @param descripcionRecompensa de la recompensa del proyecto (String)
     */
    protected void modificarRecompensa(int valorRecompensa, String descripcionRecompensa){
        this.recompensaAsociada.setValoresRecompensa(valorRecompensa, descripcionRecompensa);
    }

    /**
     * Método que cambia el valor de la admisión al contrario del actual
     */
    protected void cambiarAdmision(){
        if (admision){
            admision=false;
        }else {
            admision=true;
        }
    }

    /**
     * Método que permite añadir un Reporte a la lista de reportes del proyecto
     * @param reporte (Reporte)
     */
    protected void aniadirReporte(Reporte reporte){
        listaReportes.add(reporte);
    }

    /**
     * Método que permite añadir un BetaTester a la lista de betatesters del proyecto,
     * solo si no se ha llenado el número de vacantes y se sguie permitiendo admisiones
     * @param nuevoBetatester (BetaTester)
     */
    protected void aniadirUsuario(BetaTester nuevoBetatester){
        if (admision && listaBetaTesters.size()<numeroVacantes){
            listaBetaTesters.add(nuevoBetatester);
        }else {
            System.out.println("Error al añadir nuevo BetaTester, el proyecto está completo");
            admision=false;
        }

    }

    /**
     * Método getter del nombre del proyecto
     * @return nombre del proyecto (String)
     */
    protected String getNombre() {
        return nombre;
    }

    /**
     * Método setter que cambia el valor del nombre del proyecto
     * @param nombre del proyecto (int)
     */
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter del nombre del proyecto
     * @return nombre del proyecto (String)
     */
    protected String getDescripcion() {
        return descripcion;
    }

    /**
     * Método setter que cambia el valor de la descripcion del proyecto
     * @param descripcion del proyecto (int)
     */
    protected void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método getter del número de vacantes del proyecto
     * @return nombre del proyecto (String)
     */
    protected int getNumeroVacantes() {
        return numeroVacantes;
    }

    /**
     * Método setter que cambia el valor del número de vacantes del proyecto
     * @param numeroVacantes del proyecto (int)
     */
    protected void setNumeroVacantes(int numeroVacantes) {
        this.numeroVacantes = numeroVacantes;
    }

    /**
     * Método que devuelve toda la información relativa al proyecto
     * @return información sobre el proyecto (String)
     */
    @Override
    public String toString() {


        StringBuilder salida = new StringBuilder("Proyecto\n" +
                "\tid=" + id +
                ", nombre " + nombre +
                ", descripcion " + descripcion +
                ", número de vacantes " + numeroVacantes +
                ", admisió " + admision +
                ", recompensa Asociada " + recompensaAsociada.toString()+
                ", \n\tlista de reportes: ");


        for (Reporte e: listaReportes) {
            salida.append(e.toString());
        }

        salida.append("\n\tlista de betaTesters: ");

        for (BetaTester e: listaBetaTesters) {
            salida.append(e.toString());
        }

        return salida.toString();
    }
}
