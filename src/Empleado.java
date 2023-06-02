import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Hashtable;

public class Empleado extends Persona{
    private int ruc;
    private int sueldo;

    private Hashtable<String, Gerente> gerentes = new Hashtable<String, Gerente>();
    private Hashtable<Integer, Repartidor> repartidores = new Hashtable<Integer, Repartidor>();


    public Empleado(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio, int ruc, int sueldo, int dni) {
        super(nombre, fechaNacimiento, email, telefono, domicilio, dni);
        this.ruc = ruc;
        this.sueldo = sueldo;
    }
    public Empleado() {}

    public Gerente getGerentes(String email) {
        return gerentes.get(email);
    }


    public Hashtable<Integer, Repartidor> getRepartidores() {
        return repartidores;
    }
    public Gerente buscarGerentes(String email){
        return gerentes.get(email);
    }
    public void agregarRepartidor(Repartidor repartidor){
        repartidores.put(repartidor.getCodigo(), repartidor);
    }

    public void agregarGerente(Gerente gerente){
        gerentes.put(gerente.getEmail(), gerente);
    }

    public void asignarPedido(Pedido pedido){
        Enumeration<Integer> enumKeys = repartidores.keys();
        while(enumKeys.hasMoreElements()) {
            int indice = enumKeys.nextElement();
            Repartidor r = repartidores.get(indice);
            if(r.getPedido() == null){
                r.pedidoAsignado(pedido);
                break;
            }
        }
    }

    public Repartidor buscarRepartidores(int codigo){
        Enumeration<Repartidor> enumRepartidores = repartidores.elements();
        Repartidor r = null;
        while (enumRepartidores.hasMoreElements()) {
            Repartidor repartidor = enumRepartidores.nextElement();
            if (repartidor.getCodigo() == codigo){
                return repartidor;
            }
        }
        return r;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "ruc=" + ruc +
                ", sueldo=" + sueldo +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
