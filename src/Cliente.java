import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;
import java.util.Hashtable;

public class Cliente extends Persona {
    public Cliente(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio) {
        super(nombre, fechaNacimiento, email, telefono, domicilio);
    }
    public void verEstadoPedido(Repartidor repartidor,int codigo) {
        repartidor.subirEstadodepedido(codigo);

    }
    public void realizarPedido(Almacen almacen, Hashtable hash){
        almacen.gestionarPedido(this, hash);
        Random id = new Random();
    }
}
