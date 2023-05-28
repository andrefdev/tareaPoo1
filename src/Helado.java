public class Helado extends Producto{
    String tipo;
    String composicion;


    public Helado(int precio, int codigoProducto, String tipo, String composicion) {
        super(precio, codigoProducto);
        this.tipo = tipo;
        this.composicion = composicion;
    }

    @Override
    public String toString() {
        return "Helado{" +
                "tipo='" + tipo + '\'' +
                ", composicion='" + composicion + '\'' +
                '}';
    }
}
