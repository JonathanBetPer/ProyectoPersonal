package BetaTestingPackage;

public abstract class Usuario {

    private int id;
    private static int actualID=0;
    private String nombre;
    private String email;
    private String direccion;

    public Usuario(String nombre, String email, String direccion){
        this.id=actualID+1;
        actualID++;
        this.nombre=nombre;
        this.email=email;
        this.direccion=direccion;
    }

    public void modificarDatos(String nombre, String email, String direccion){
        this.nombre=nombre;
        this.email=email;
        this.direccion=direccion;
    }

    public void eliminarCuenta(int id){
        //Suponemos que debería haber un CRUD a una bbdd y que una sentencia DELETE
        // y junto al ID del usuario eliminariamos la cuenta
        this.id=0;
        this.nombre=null;
        this.email=null;
        this.direccion=null;
    }

    @Override
    public String toString() {
        return "\n\t\tid=" + id +
                ", nombre: " + nombre +
                ", email: " + email +
                ", direccion: " + direccion;
    }
}
