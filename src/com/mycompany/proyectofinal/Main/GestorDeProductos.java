package com.mycompany.proyectofinal.Main;

import com.mycompany.proyectofinal.Main.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    // Método para editar un producto
    public void editarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(nuevoNombre); // Actualiza el nombre
                producto.setPrecio(nuevoPrecio); // Actualiza el precio
                producto.setCantidad(nuevaCantidad); // Actualiza la cantidad
                return; // Salir después de actualizar el producto
            }
        }
        throw new IllegalArgumentException("Producto con ID " + id + " no encontrado.");
    }

    // Método para calcular el valor total del inventario
    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.getCantidad() * producto.getPrecio();
        }
        return valorTotal;
    }

    // Método para obtener todos los productos
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

    // Método para eliminar un producto
    public void borrarProducto(int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }

    // Método para verificar si existe un producto con un ID específico
    public boolean existeProductoConID(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return true; // El ID ya existe
            }
        }
        return false; // El ID no existe
    }

    // Método para buscar un producto por nombre
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto; // Devuelve el producto si se encuentra
            }
        }
        return null; // Devuelve null si no se encuentra el producto
    }
}


