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
    private DefaultTableModel modeloTabla; // Modelo de la tabla

    public ListarProducto(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos; // Inicializar gestor de productos
        initComponents();
    }

    private void initComponents() {
        setTitle("Lista de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");

        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para ordenar productos alfabéticamente
        JButton sortButton = new JButton("Ordenar Alfabéticamente");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarProductosAlfabeticamente();
            }
        });

        // Botón para ordenar productos por precio
        JButton sortByPriceButton = new JButton("Ordenar por Precio");
        sortByPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarProductosPorPrecio();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sortButton);
        buttonPanel.add(sortByPriceButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar productos al iniciar
        cargarProductos();
    }

    private void cargarProductos() {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de cargar
        List<Producto> productos = gestorDeProductos.getProductos(); // Obtener productos
        for (Producto producto : productos) {
            modeloTabla.addRow(new Object[]{
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getCantidad()
            }); // Agregar fila a la tabla
        }
    }

    private void ordenarProductosAlfabeticamente() {
        gestorDeProductos.ordenarProductosAlfabeticamente(); // Llamar al método de ordenación
        cargarProductos(); // Recargar la tabla después de ordenar
    }

    private void ordenarProductosPorPrecio() {
        gestorDeProductos.ordenarProductosPorPrecio(); // Llamar al método de ordenación por precio
        cargarProductos(); // Recargar la tabla después de ordenar
    }
}