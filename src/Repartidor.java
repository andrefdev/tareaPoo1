import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Repartidor extends Empleado {
    private int codigo;
    private String direccion;
    private Date horaLlegada;
    private Date horaSalida;
    private Pedido pedido;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Repartidor(int codigo, String direccion) {
        this.codigo = codigo;
        this.direccion = direccion;
    }
    public void pedidoAsignado(Pedido pedido){
        this.pedido = pedido;
    }
    public void subirEstadodepedido(int codigo){

    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", pedido=" + pedido +
                '}';
    }

}
