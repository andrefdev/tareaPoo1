public class Helado extends Producto{
    String sabor;
    String composicion;


    public Helado(int precio, int codigoProducto, String sabor, String composicion) {
        super(precio, codigoProducto);
        this.sabor = sabor;
        this.composicion = composicion;
    }

    @Override
    public String toString() {
        return "Helado:\n" +
                "tipo='" + sabor + '\n' +
                "composicion='" + composicion;
    }

    public String getSabor() {
        return sabor;
    }

    public String getComposicion() {
        return composicion;
    }
}
