public class Producto {
    private int idProducto;
    private String nombre, categoria;
    private double precio;
    private int stock, activo;

    public Producto(int id, String n, String c, double p, int s, int a) {
        idProducto = id;
        nombre = n;
        categoria = c;
        precio = p;
        stock = s;
        activo = a;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getActivo() {
        return activo;
    }
}
