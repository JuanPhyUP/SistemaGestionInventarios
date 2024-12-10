package com.mycompany.proyectofinal.Main;

import com.mycompany.proyectofinal.Main.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase GestorDeProductos.
 * Esta clase se encarga de gestionar una lista de productos, incluyendo funcionalidades
 * para agregar, editar, eliminar, ordenar y buscar productos, así como calcular el valor total del inventario.
 */
public class GestorDeProductos {
    private List<Producto> productos;

    /**
     * Constructor de la clase GestorDeProductos.
     * Inicializa una lista vacía de productos.
     */
    public GestorDeProductos() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto a la lista de productos.
     *
     * @param producto el producto que se desea agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Edita un producto existente en la lista, identificándolo por su ID.
     *
     * @param id el ID del producto a editar.
     * @param nuevoNombre el nuevo nombre del producto.
     * @param nuevoPrecio el nuevo precio del producto.
     * @param nuevaCantidad la nueva cantidad del producto.
     * @throws IllegalArgumentException si el producto con el ID especificado no se encuentra.
     */
    public void editarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                producto.setCantidad(nuevaCantidad);
                return;
            }
        }
        throw new IllegalArgumentException("Producto con ID " + id + " no encontrado.");
    }

    /**
     * Calcula el valor total del inventario.
     *
     * @return el valor total, calculado como la suma del precio multiplicado por la cantidad de cada producto.
     */
    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.getCantidad() * producto.getPrecio();
        }
        return valorTotal;
    }

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return la lista de productos.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Ordena la lista de productos alfabéticamente por nombre.
     */
    public void ordenarProductosAlfabeticamente() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getNombre().compareToIgnoreCase(p2.getNombre());
            }
        });
    }

    /**
     * Ordena la lista de productos por precio en orden ascendente.
     */
    public void ordenarProductosPorPrecio() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });
    }

    /**
     * Elimina un producto de la lista, identificándolo por su ID.
     *
     * @param id el ID del producto que se desea eliminar.
     */
    public void borrarProducto(int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }

    /**
     * Verifica si existe un producto con un ID específico.
     *
     * @param id el ID que se desea verificar.
     * @return true si existe un producto con el ID, false en caso contrario.
     */
    public boolean existeProductoConID(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un producto por su nombre.
     *
     * @param nombre el nombre del producto que se desea buscar.
     * @return el producto encontrado, o null si no se encuentra.
     */
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}


