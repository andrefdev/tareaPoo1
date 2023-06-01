import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Repartidor extends Empleado implements Runnable {
    private int codigo;
    private String pedido;
    private Date horaSalida;
    private Date horaLlegada;

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    public Repartidor(String nombre, String domicilio) {
        this.codigo = codigo;
    }
    public void subirEstadodepedido(int codigo){

    }
    public void pedidoEntregado(){
        System.out.println("El pedido ");
    }

    @Override
    public void run() {
        Random rand = new Random();
        int tiempo = rand.nextInt(90)*100;
        System.out.println("El pedido llega en "+tiempo + " minutos");

    }

    private void realizarEntrega() {
        // Simulamos el tiempo que tarda en entregar el pedido
        try {
            Thread.sleep(10000); // Tiempo de entrega de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Registro la hora de llegada
        horaLlegada = new Date();

        // Imprimir el pedido entregado y la hora de llegada
        System.out.println("Pedido entregado: " + pedido);
        System.out.println("Hora de llegada: " + obtenerHoraFormateada(horaLlegada));
    }

    private String obtenerHoraFormateada(Date fecha) {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(fecha);
    }

    public void iniciarEntrega() {
        // Registro la hora de salida
        horaSalida = new Date();

        // Imprimir el pedido en camino y la hora de salida
        System.out.println("Pedido en camino: " + pedido);
        System.out.println("Hora de salida: " + obtenerHoraFormateada(horaSalida));

        // Crear y ejecutar el hilo de entrega
        Thread hiloEntrega = new Thread(this);
        hiloEntrega.start();
    }
}
