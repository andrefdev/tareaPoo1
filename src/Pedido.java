import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Pedido {
    private Cliente cliente;
    private LocalDateTime horaPedido;
    private String productos;
    private int codigo;
    public Pedido(Cliente cliente, LocalDateTime horaPedido, String productos){
        Random ran = new Random();
        this.codigo = ran.nextInt(9999)+1000;
        this.cliente = cliente;
        this.horaPedido = horaPedido;
        this.productos = productos;
    }

}
