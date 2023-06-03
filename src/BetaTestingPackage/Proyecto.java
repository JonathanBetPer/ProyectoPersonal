package BetaTestingPackage;

import java.util.ArrayList;

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

    protected void modificarRecompensa(int valorRecompensa, String descripcionRecompensa){
        this.recompensaAsociada.setValoresRecompensa(valorRecompensa, descripcionRecompensa);
    }

    protected void cambiarAdmision(){
        if (admision){
            admision=false;
        }else {
            admision=true;
        }
    }

    protected void aniadirReporte(Reporte reporte){
        listaReportes.add(reporte);
    }

    protected void aniadirUsuario(BetaTester nuevoBetatester){
        if (admision && listaBetaTesters.size()<numeroVacantes){
            listaBetaTesters.add(nuevoBetatester);
        }else {
            System.out.println("Error al añadir nuevo BetaTester, el proyecto está completo");
            admision=false;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroVacantes() {
        return numeroVacantes;
    }

    public void setNumeroVacantes(int numeroVacantes) {
        this.numeroVacantes = numeroVacantes;
    }

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
