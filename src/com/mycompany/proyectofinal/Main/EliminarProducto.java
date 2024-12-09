package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarProducto extends JFrame {
    private GestorDeProductos gestorDeProductos; // Referencia al gestor de productos
    private JTable tablaProductos; // Tabla para mostrar los productos
    private DefaultTableModel modeloTabla; // Modelo de la tabla

    public EliminarProducto(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos; // Inicializar gestor de productos
        initComponents();
    }

    private void initComponents() {
        setTitle("Eliminar Producto");
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

        // Botón para borrar el producto seleccionado
        JButton borrarButton = new JButton("Borrar Producto");
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarProducto();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(borrarButton);
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

    private void borrarProducto() {
        int selectedRow = tablaProductos.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) {
            // Obtener el ID del producto seleccionado
            int id = (int) modeloTabla.getValueAt(selectedRow, 0);

            // Llamar al método de borrar en el gestor de productos
            gestorDeProductos.borrarProducto(id);
            cargarProductos(); // Recargar la tabla después de borrar
            JOptionPane.showMessageDialog(this, "Producto borrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para borrar.");
        }
    }
}
