public class CarritoItem {
    private Producto producto;
    private int cantidad;

    public CarritoItem(Producto p, int c) {
        producto = p;
        cantidad = c;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
