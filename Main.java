import java.io.*;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductoRepository repo = new ProductoRepository("productos.csv");

    public static void main(String[] args) {
        try {
            repo.cargar();
            int op;
            do {
                System.out.println("\n1. Consultar productos por categoría\n2. Generar carrito de compra\n3. Salir");
                op = leerEntero("Opción: ");
                if (op == 1)
                    consultar();
                else if (op == 2)
                    carrito();
            } while (op != 3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static int leerEntero(String m) {
        while (true)
            try {
                System.out.print(m);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un entero válido.");
            }
    }

    private static void consultar() {
        System.out.print("Categoría: ");
        String c = sc.nextLine();
        List<Producto> r = new ArrayList<Producto>();
        for (Producto p : repo.getProductos()) {
            if (p.getActivo() == 1 && p.getCategoria().equalsIgnoreCase(c))
                r.add(p);
        }

        ordenarPorPrecio(r);
        for (Producto p : r) {
            /* TO-DO: implementar override toString del producto */
            System.out.println(p);
        }

    }

    private static void ordenarPorPrecio(List<Producto> p) {
        /* TO-DO: implementar ordenamiento */
    }

    private static void carrito() throws IOException {
        List<CarritoItem> c = new ArrayList<CarritoItem>();
        boolean seguir = true;
        while (seguir) {
            int id = leerEntero("ID: ");
            Producto p = repo.buscarPorId(id); //@TO-DO Implementar la función buscarPorId
            if (p == null || p.getActivo() == 0) {
                System.out.println("Producto inexistente o inactivo.");
                continue;
            }
            int n = leerEntero("Cantidad: ");
            if (n <= 0 || n > p.getStock()) {
                System.out.println("Cantidad inválida.");
                continue;
            }
            agregar(c, p, n);
            System.out.print("¿Otro? (S/N): ");
            seguir = sc.nextLine().equalsIgnoreCase("S");
        }
        generarArchivoCarrito(c);
    }

    private static void agregar(List<CarritoItem> c, Producto p, int n) {
        /* TO-DO implementar agregar al carrito */
    }

    /* TO-DO Completar escritura*/
    private static void generarArchivoCarrito(List<CarritoItem> c)
            throws IOException {

        FileWriter fw = new FileWriter("carrito_compra.csv");
        BufferedWriter bw = new BufferedWriter(fw);

        // Encabezado del archivo
        bw.write("id_producto,nombre,cantidad,precio_unitario,subtotal");
        bw.newLine();

        // Escribir cada producto del carrito
        for (CarritoItem item : c) {

            Producto producto = item.getProducto();

            String linea = producto.getNombre();//TO-DO Completar

            bw.write(linea);
            bw.newLine();
        }

        bw.close();
    }
}
