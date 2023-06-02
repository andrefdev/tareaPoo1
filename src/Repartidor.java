import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Repartidor extends Empleado implements Runnable{
    private int codigo;
    private String nombre;
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

    public Repartidor(int codigo, String direccion, String nombre) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    public void pedidoAsignado(Pedido pedido){
        this.pedido = pedido;
    }

    public void subirEstadodepedido(int codigo){
        run();
    }

    @Override
    public void run() {
        horaSalida = new Date();

        // Imprimir el pedido en camino y la hora de salida
        String mensaje = "Pedido en camino: " + getPedido() + "\n" + "su pedido se lo entregara el repartidor con codigo: " + getCodigo() + "\n" +
                "Hora de salida: " + obtenerHoraFormateada(horaSalida) + "\n" +
                "----------------------------------------------------------------" + "\n";
        JOptionPane.showMessageDialog(null, mensaje);
        // creamos y se ejecuta el hilo de entrega
        Thread hiloEntrega = new Thread((Runnable) this);
        hiloEntrega.start();
    }

    private String obtenerHoraFormateada(Date fecha) {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(fecha);
    }
    public void realizarEntrega() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Registro la hora de llegada
        horaLlegada = new Date();
        pedido = null;

        // Imprimir el pedido entregado y la hora de llegada
        System.out.println("Pedido entregado: " + getPedido() + "\n" + "Por el repartidor de codigo: " + getCodigo());
        System.out.println("Hora de llegada: " + obtenerHoraFormateada(horaLlegada) + "\n" );
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
