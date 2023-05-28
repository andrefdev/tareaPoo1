import java.util.*;
import java.time.LocalDateTime;

public class Almacen{
    //private List<Helado> helados = new ArrayList<Helado>();
    private HashMap<Integer, List> cantidadHelados = new HashMap<>();
    public Almacen(){
    }

    public void anadirProducto(int indice, int cantidad,int precio, String tipo, int codigoProducto, String composicion) {
        List<Helado> helados = new ArrayList<Helado>();
        for (int i = 0; i < cantidad; i++) {
            helados.add(new Helado(precio, codigoProducto, tipo, composicion));
            cantidadHelados.put(indice, helados);
        }
    }
    public String mostrarHelados(){
        /*for (int i = 0; i < cantidadHelados.size(); i++){
            System.out.println("La cantidad de " + cantidadHelados.get(i).get(1).toString()+ " Es: " + cantidadHelados.get(i).size());
        }*/
        String cantidad = "";
        for (int i = 0; i < cantidadHelados.size(); i++){
            //String d = "";
            cantidad = cantidad +  "La cantidad de " + cantidadHelados.get(i).get(1).toString()+ " Es: " + cantidadHelados.get(i).size() + "\n";
        }
        return cantidad;
    }

    public void mostrarkgHelados(){
        for (int i = 0; i < cantidadHelados.size(); i++){
            System.out.println("La cantidad de " + cantidadHelados.get(i).get(1).toString()+ " Es: " + cantidadHelados.get(i).size());
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
