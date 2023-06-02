import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Pedido {
    private Cliente cliente;
    private LocalDateTime horaPedido;
    private String productos;
    private int codigo;
    public Pedido(Cliente cliente, String productos){
        Random ran = new Random();
        this.codigo = ran.nextInt(9999)+1000;
        this.cliente = cliente;
        this.horaPedido = LocalDateTime.now();
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", horaPedido=" + horaPedido +
                ", productos='" + productos + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
