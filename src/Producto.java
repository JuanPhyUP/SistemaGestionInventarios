import java.util.ArrayList;
import java.util.List;

public class Producto {
    // Atributos de la clase Producto
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;

    // Lista estática para almacenar los productos
    private static List<Producto> productos = new ArrayList<>();

    /**
     * Constructor de la clase Producto.
     *
     * @param id       El ID del producto.
     * @param nombre   El nombre del producto.
     * @param cantidad La cantidad del producto.
     * @param precio   El precio del producto.
     */

    // Constructor
    public Producto(int id, String nombre, int cantidad, double precio) {
        // Validación de duplicados
        if (!existeProducto(id)) {
            this.id = id;
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precio = precio;
            // Agregar el producto a la lista
            productos.add(this);
        } else {
            System.out.println("Error: Ya existe un producto con el ID " + id);
        }
    }

    // Método para verificar si existe un producto con el ID dado
    private static boolean existeProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return true;
            }
        }
        return false;
    }


    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para mostrar información del producto
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: $" + precio);

    }
}

