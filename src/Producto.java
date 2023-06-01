public class Producto {
    private int precio;
    protected int codigoProducto;

    public int getPrecio() {
        return precio;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public Producto(int precio, int codigoProducto) {
        this.precio = precio;
        this.codigoProducto = codigoProducto;
    }

}
