package BetaTestingPackage;
import java.util.ArrayList;

/**
 * @author Jonathan Betancor Perdomo
 * @since 03/06/2023
 * @version v1
 *
 * Clase Desarolladora
 * Maneja todos los atributos y métodos para que el proyecto de BetaTesting
 * Extiende de la clase padre Usuario
 *
 */
public class Desarrolladora extends Usuario{

    private String CIF;
    private ArrayList<Proyecto> listaProyectos;

    /**
     * Constructor de la clase Desarrolladora
     *
     * @param nombre de la desarrolladora (String)
     * @param email de la desarrolladora (String)
     * @param direccion de la desarrolladora (String)
     * @param CIF de la desarrolladora (String)
     */
    public Desarrolladora(String nombre, String email, String direccion, String CIF) {
        super(nombre, email, direccion);
        this.CIF=CIF;
        listaProyectos=new ArrayList<>();
    }


    /**
     * Método que crea un objeto Proyecto (junto a su recompensa) y a su vez lo añade al ArrayList listaProyectos
     *
     * @param nombre del proyecto (String)
     * @param descripcion del proyecto (String)
     * @param numeroVacantes del proyecto (int)
     * @param tituloRecompensa del proyecto (String)
     * @param valorRecompensa del proyecto (int)
     * @param descripcionRecompensa del proyecto (String)
     */
    public void crearProyecto(String nombre, String descripcion, int numeroVacantes, String tituloRecompensa, int valorRecompensa, String descripcionRecompensa){
       aniadirProyecto(new Proyecto( nombre, descripcion, numeroVacantes, tituloRecompensa, valorRecompensa, descripcionRecompensa));
    }

    /**
     * Método que añade al ArrayList listaProyectos un nuevo proyecto pasado por parámetros
     * @param proyectoNuevo (Proyecto)
     */
    private void aniadirProyecto(Proyecto proyectoNuevo){
        listaProyectos.add(proyectoNuevo);
    }

    /**
     * Método que devuelve la información del objeto
     * @return información sobre la desarrolladora (String)
     */
    @Override
    public String toString() {
        return "Desarrolladora: " +
                super.toString() +
                ", CIF: " + CIF;
    }

    /**
     * Método que devuelve la información sobre todos los proyectos en listaProyectos
     * @return información sobre todos los proyectos (String)
     */
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
