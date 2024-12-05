package com.mycompany.proyectofinal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.*;

public class GestorDeProductos {
    private List<Producto> productos;

    // Constructor
    public GestorDeProductos() {

        this.productos = new ArrayList<>();
    }

    // Método para añadir un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para listar todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Lista de productos:");
            for (Producto producto : productos) {
                System.out.println("ID: " + producto.getId() +
                        ", Nombre: " + producto.getNombre() +
                        ", Cantidad: " + producto.getCantidad() +
                        ", Precio: $" + producto.getPrecio());
            }
        }
    }public void modificarProducto(int id, String nuevoNombre, int nuevaCantidad, double nuevoPrecio) {
        Producto productoAModificar = null;

        // Buscar el producto por ID
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productoAModificar = producto;
                break;
            }
        }

        // Modificar los atributos si el producto fue encontrado
        if (productoAModificar != null) {
            productoAModificar.setNombre(nuevoNombre);
            productoAModificar.setCantidad(nuevaCantidad);
            productoAModificar.setPrecio(nuevoPrecio);
            System.out.println("com.mycompany.proyectofinal.Producto modificado exitosamente.");
        } else {
            System.out.println("com.mycompany.proyectofinal.Producto con ID " + id + " no encontrado.");
        }
    }public double calcularValorTotal() {
        double valorTotal = 0;

        for (Producto producto : productos) {
            valorTotal += producto.getCantidad() * producto.getPrecio();
        }

        return valorTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }
    // Método para ordenar productos alfabéticamente
    public void ordenarProductosAlfabeticamente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getNombre().compareToIgnoreCase(p2.getNombre());
            }
        });
    }

    // Método para ordenar productos por precio
    public void ordenarProductosPorPrecio() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });
    }
    //Método eliminar producto
    public void borrarProducto(int id) {
        productos.removeIf(producto -> producto.getId() == id); // Eliminar el producto con el ID especificado
    }
}

