import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Heladeria {
    int ruc;
    String direccion;

    Hashtable<String, Cliente> clientes = new Hashtable<String, Cliente>();
    Hashtable<Integer, Empleado> empleados = new Hashtable<Integer, Empleado>();

    public Heladeria(int ruc, String direccion) {
        this.ruc = ruc;
        this.direccion = direccion;
    }
    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Hashtable<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Hashtable<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Hashtable<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Hashtable<Integer, Empleado> empleados) {
        this.empleados = empleados;
    }


    public void agregarCliente(Cliente cliente){
        clientes.put(cliente.getEmail(), cliente);
    }

    public void contratarEmpleado(Empleado empleado){
        empleados.put(empleado.getDni(), empleado);
    }
    public Empleado buscarEmpleado(int dni){
        return empleados.get(dni);
    }

    public String obtenerDatosDeEmpleados(){
        Empleado e;
        String dx="";
        Enumeration<Empleado> enu = empleados.elements();
        while(enu.hasMoreElements()){
            e=enu.nextElement();
            dx=dx+e.toString()+"\n";
        }
        return dx;
    }

    public Cliente buscarClientes(String email){
        return clientes.get(email);
    }
    @Override
    public String toString() {
        return "Heladeria{" +
                "ruc=" + ruc +
                ", direccion='" + direccion + '\'' +
                ", clientes=" + clientes +
                ", empleados=" + empleados +
                '}';
    }
}
