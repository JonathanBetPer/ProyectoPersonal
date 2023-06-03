package BetaTestingPackage;

public class Recompensa {
    private int id;
    private static int actualID=0;
    private String titulo;
    private int valor;
    private String descripcion;

    protected Recompensa(String titulo, int valor, String descripcion) {
        this.id=actualID+1;
        actualID++;
        this.titulo = titulo;

        if (valor<0){
            this.valor = valor;
        }else {
            this.valor=50;
        }

        this.descripcion = descripcion;
    }

    protected void setValoresRecompensa(int valor, String descripcion){
        this.valor = valor;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  "\n\t\tid=" + id +
                ", " + titulo  +
                ", con un valor de " + valor +
                ", " + descripcion;
    }
}
