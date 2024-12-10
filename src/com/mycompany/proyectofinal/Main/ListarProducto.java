/**
 * Clase para gestionar la ventana de listado de productos.
 * Permite a los usuarios visualizar y ordenar los productos del inventario.
 */
package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListarProducto extends JFrame {
    private GestorDeProductos gestorDeProductos; // Referencia al gestor de productos
    private JTable tablaProductos; // Tabla para mostrar los productos
    private DefaultTableModel modeloTabla; // Modelo de datos para la tabla

    /**
     * Constructor de la clase ListarProducto.
     * @param gestorDeProductos el gestor de productos que contiene los datos del inventario.
     */
    public ListarProducto(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos; // Inicializar gestor de productos
        initComponents(); // Inicializar componentes gráficos
    }

    /**
     * Inicializa los componentes gráficos de la ventana.
     * Configura la tabla para mostrar los productos y los botones de ordenación.
     */
    private void initComponents() {
        setTitle("Lista de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla con las columnas necesarias
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");

        // Crear la tabla y añadirla a un scroll para navegación
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        add(scrollPane, BorderLayout.CENTER);

        // Crear botón para ordenar productos alfabéticamente por nombre
        JButton sortButton = new JButton("Ordenar Alfabéticamente");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarProductosAlfabeticamente();
            }
        });

        // Crear botón para ordenar productos por precio
        JButton sortByPriceButton = new JButton("Ordenar por Precio");
        sortByPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarProductosPorPrecio();
            }
        });

        // Añadir botones a un panel en la parte inferior de la ventana
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sortButton);
        buttonPanel.add(sortByPriceButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar productos en la tabla al iniciar la ventana
        cargarProductos();
    }

    /**
     * Carga los productos desde el gestor de productos y los muestra en la tabla.
     */
    private void cargarProductos() {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de cargar
        List<Producto> productos = gestorDeProductos.getProductos(); // Obtener la lista de productos
        for (Producto producto : productos) {
            modeloTabla.addRow(new Object[]{
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getCantidad()
            }); // Añadir producto como una nueva fila en la tabla
        }
    }

    /**
     * Ordena los productos alfabéticamente por nombre y actualiza la tabla.
     */
    private void ordenarProductosAlfabeticamente() {
        gestorDeProductos.ordenarProductosAlfabeticamente(); // Llamar al método de ordenación
        cargarProductos(); // Recargar la tabla con los productos ordenados
    }

    /**
     * Ordena los productos por precio en orden ascendente y actualiza la tabla.
     */
    private void ordenarProductosPorPrecio() {
        gestorDeProductos.ordenarProductosPorPrecio(); // Llamar al método de ordenación por precio
        cargarProductos(); // Recargar la tabla con los productos ordenados
    }
}
