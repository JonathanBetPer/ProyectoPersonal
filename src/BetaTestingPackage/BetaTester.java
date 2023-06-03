package BetaTestingPackage;

public class BetaTester extends Usuario{
    private String facturacion;
    public BetaTester(String nombre, String email, String direccion, String facturacion) {
        super(nombre, email, direccion);
        this.facturacion=facturacion;
    }
}
