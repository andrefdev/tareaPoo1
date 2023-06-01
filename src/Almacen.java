import javax.swing.*;
import java.util.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Enumeration;

public class Almacen{
    private int indice = 0;
    private HashMap<Integer, List> cantidadHelados = new HashMap<>();
    public Almacen(){
    }

    public void anadirProducto(int cantidad,int precio, String tipo, int codigoProducto, String composicion) {
        List<Helado> helados = new ArrayList<Helado>();
        for (int i = 0; i < cantidad; i++) {
            helados.add(new Helado(precio, codigoProducto, tipo, composicion));
            cantidadHelados.put(indice, helados);
        }
        indice = indice + 1;
    }

    public boolean buscarProducto(int codigoProducto){
        int cod = 0;
        if(cantidadHelados.size() >= 1){
            for(int i = 0; i < cantidadHelados.size(); i++){
                Helado helado = (Helado) cantidadHelados.get(i).get(0);
                cod = helado.getCodigoProducto();
                if(cod == codigoProducto){
                    return true;
                }
            }
        }
        return false;
    }

    public void eliminarProducto(int indice) {
        cantidadHelados.remove(indice);
    }

    public void actualizarStock(int indice, int cantidad) {
        try{
            System.out.println(cantidadHelados.get(indice).size()-1);
            int cant = cantidadHelados.get(indice).size()-cantidad;
            for (int i = cantidadHelados.get(indice).size()-1; i > cant-1; i--) {
                System.out.println(i);
                cantidadHelados.get(indice).remove(i);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String mostrarHelados(){
        String cantidad = " ";
        try{
            for (int i = 0; i < cantidadHelados.size(); i++){
                cantidad = cantidad + i + ": " + cantidadHelados.get(i).get(1).toString()+ " cantidad:" + cantidadHelados.get(i).size() + "\n";
            }
        }catch(Exception e){

        }
        return cantidad;
    }

    public String mostrarProductosIndice(){
        String cantidad = "";
        for (int i = 0; i < cantidadHelados.size(); i++){
            //String d = "";
            cantidad = i + ": " + cantidad + cantidadHelados.get(i).get(1).toString()+"\n";
        }
        return cantidad;
    }

    public void mostrarkgHelados(){
        for (int i = 0; i < cantidadHelados.size(); i++){
            System.out.println(cantidadHelados.get(i).get(1).toString()+ " cantidad: " + cantidadHelados.get(i).size());
        }
    }
    public void gestionarPedido(Cliente cliente, int indice, int cantidad){
        int pedidosRealizados = 0;
        for (int i = 0; i < cantidad; i++){
            pedidosRealizados++;
            cantidadHelados.get(indice).remove(i);
        }
        System.out.println(pedidosRealizados);
        Pedido pedido = new Pedido(cliente, LocalDateTime.now());
    }
}
