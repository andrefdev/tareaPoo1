import java.time.LocalDateTime;

public class Repartidor extends Empleado{
    private int codigo;

    public Repartidor(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio, int ruc, int sueldo, int codigo) {
        super(nombre, fechaNacimiento, email, telefono, domicilio, ruc, sueldo);
        this.codigo = codigo;

    }
    public void subirEstadodepedido(int codigo){

    }
    public void pedidoEntregado(){
        System.out.println("El pedido ");
    }
}
