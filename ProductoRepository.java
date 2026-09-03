import java.io.*;
import java.util.*;

public class ProductoRepository {
    private final String archivo;
    private final List<Producto> productos = new ArrayList<Producto>();

    public ProductoRepository(String a) {
        archivo = a;
    }

    /* TODO: validar y construir excepciones */
    public void cargar() throws IOException {

        productos.clear();

        BufferedReader br = new BufferedReader(
                new FileReader(archivo));

        String encabezado = br.readLine();

        if (encabezado == null) {
            throw new IllegalArgumentException(
                    "El archivo está vacío.");
        }

        if (!encabezado.equals(
                "id_producto,nombre,categoria,precio,stock,activo")) {

            throw new IllegalArgumentException(
                    "El encabezado del archivo es incorrecto.");
        }

        String linea;
        int numeroLinea = 1;

        while ((linea = br.readLine()) != null) {

            numeroLinea++;

            if (linea.trim().isEmpty()) {
                continue;
            }

            String[] datos = linea.split(",", -1);

            int id = Integer.parseInt(datos[0].trim());

            String nombre = datos[1].trim();
            String categoria = datos[2].trim();

            double precio = Double.parseDouble(datos[3].trim());

            int stock = Integer.parseInt(datos[4].trim());

            int activo = Integer.parseInt(datos[5].trim());

            Producto producto = new Producto(
                    id,
                    nombre,
                    categoria,
                    precio,
                    stock,
                    activo);

            productos.add(producto);

        }

    }

    public List<Producto> getProductos() {
        return productos;
    }

     /* TODO: implementar este metodo para buscar por Id */
    public Producto buscarPorId(int id) {
        return null;
    }

  
}
