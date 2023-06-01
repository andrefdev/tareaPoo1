import java.time.LocalDateTime;

public class Cliente extends Persona {
    public Cliente(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio) {
        super(nombre, fechaNacimiento, email, telefono, domicilio);
    }
    public void verEstadoPedido(Repartidor repartidor,int codigo) {
        repartidor.subirEstadodepedido(codigo);

    }
    public void realizarPedido(Almacen almacen, int indice, int canitdad){
        almacen.gestionarPedido(this, indice, canitdad);
    }
}
