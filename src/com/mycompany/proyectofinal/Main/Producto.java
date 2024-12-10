/**
 * Clase Producto que representa un artículo en el inventario.
 * Contiene información básica como ID, nombre, cantidad, precio y una descripción opcional.
 */
package com.mycompany.proyectofinal.Main;

public class Producto {
    // Atributos de la clase Producto
    private int id; // ID único del producto
    private String nombre; // Nombre del producto
    private int cantidad; // Cantidad disponible en inventario
    private double precio; // Precio del producto
    private String descripcion; // Descripción opcional del producto

    /**
     * Constructor de la clase Producto.
     *
     * @param id       El ID del producto.
     * @param nombre   El nombre del producto.
     * @param cantidad La cantidad del producto.
     * @param precio   El precio del producto.
     */
    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id El nuevo ID del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return La cantidad del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidad La nueva cantidad del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Muestra la información del producto en la consola.
     * Incluye el ID, nombre, cantidad y precio del producto.
     */
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: $" + precio);
    }
}


