package BetaTestingPackage;
import java.util.Date;
import java.util.Timer;

public class Reporte {

    private int id;
    private static int actualID=0;

    private String contenido;
    private Date fecha;

    protected Reporte(String contenido){

        this.id=actualID+1;
        actualID++;
        this.contenido=contenido;
        Object Time;
        this.fecha=new Date();
    }

    public int getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return  "\n\t\tid=" + id +
                ", contenido: " + contenido +
                ", fecha=" + fecha;
    }
}
