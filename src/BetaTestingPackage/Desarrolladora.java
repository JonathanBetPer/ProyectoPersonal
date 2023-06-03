package BetaTestingPackage;

import java.util.ArrayList;

public class Desarrolladora extends Usuario{

    private String CIF;
    private ArrayList<Proyecto> listaProyectos;

    public Desarrolladora(String nombre, String email, String direccion, String CIF) {
        super(nombre, email, direccion);
        this.CIF=CIF;
        listaProyectos=new ArrayList<>();
    }

    public void crearProyecto(String nombre, String descripcion, int numeroVacantes, String tituloRecompensa, int valorRecompensa, String descripcionRecompensa){
       aniadirProyecto(new Proyecto( nombre, descripcion, numeroVacantes, tituloRecompensa, valorRecompensa, descripcionRecompensa));
    }

    private void aniadirProyecto(Proyecto proyectoNuevo){
        listaProyectos.add(proyectoNuevo);
    }

    @Override
    public String toString() {
        return "Desarrolladora: " +
                super.toString() +
                ", CIF: " + CIF;
    }

    public String listarProyectos(){

        StringBuilder salida= new StringBuilder(" ");

        for (Proyecto e:listaProyectos) {
            if(e!=null){
                salida.append(e.toString());
            }
        }

        return salida.toString();
    }

}
