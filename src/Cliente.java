import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;
import java.util.Hashtable;

public class Cliente extends Persona {
    private Pedido pedido;

    public Cliente(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio, int dni) {
        super(nombre, fechaNacimiento, email, telefono, domicilio, dni);
    }
    public Pedido getPedido() {
        return pedido;
    }

    public void verEstadoPedido(Repartidor repartidor,int codigo) {
        repartidor.subirEstadodepedido(codigo);
    }

    public String realizarPedido(Almacen almacen, Hashtable hash){
        this.pedido = almacen.gestionarPedido(this, hash);
        return pedido.toString();
    }
}
