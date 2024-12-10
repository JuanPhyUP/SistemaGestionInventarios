package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La clase EliminarProducto extiende JFrame y permite la visualización y eliminación
 * de productos en el inventario a través de una interfaz gráfica.
 */
public class EliminarProducto extends JFrame {

    // Referencia al gestor de productos que maneja el inventario
    private GestorDeProductos gestorDeProductos;

    // Tabla para mostrar los productos
    private JTable tablaProductos;

    // Modelo de la tabla que define las columnas y datos de la misma
    private DefaultTableModel modeloTabla;

    /**
     * Constructor de la clase EliminarProducto.
     * Inicializa la ventana y configura los componentes visuales.
     *
     * @param gestorDeProductos El gestor que maneja los productos del inventario.
     */
    public EliminarProducto(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos; // Inicializa el gestor de productos
        initComponents(); // Inicializa los componentes de la ventana
    }

    /**
     * Configura los componentes visuales de la ventana, incluyendo la tabla
     * para mostrar los productos y el botón para eliminar un producto.
     */
    private void initComponents() {
        setTitle("Eliminar Producto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana sin finalizar la aplicación
        setLayout(new BorderLayout()); // Usa un diseño BorderLayout

        // Crear el modelo de la tabla con las columnas ID, Nombre, Precio y Cantidad
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");

        // Crear la tabla con el modelo definido
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaProductos); // Agregar la tabla a un JScrollPane
        add(scrollPane, BorderLayout.CENTER); // Agregar el JScrollPane al centro de la ventana

        // Crear el botón para borrar un producto
        JButton borrarButton = new JButton("Borrar Producto");
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarProducto(); // Llamar al método para borrar el producto
            }
        });

        // Crear un panel para el botón y agregarlo al pie de la ventana
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(borrarButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar los productos al iniciar la ventana
        cargarProductos();
    }

    /**
     * Carga los productos del inventario y los muestra en la tabla.
     * Este método limpia la tabla antes de agregar los nuevos datos.
     */
    private void cargarProductos() {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
        List<Producto> productos = gestorDeProductos.getProductos(); // Obtener todos los productos
        for (Producto producto : productos) {
            modeloTabla.addRow(new Object[]{
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getCantidad()
            }); // Agregar cada producto a la tabla
        }
    }

    /**
     * Elimina el producto seleccionado de la tabla y del inventario.
     * Si no se ha seleccionado ningún producto, muestra un mensaje de error.
     */
    private void borrarProducto() {
        int selectedRow = tablaProductos.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) {
            // Obtener el ID del producto seleccionado
            int id = (int) modeloTabla.getValueAt(selectedRow, 0);

            // Llamar al método de borrar en el gestor de productos
            gestorDeProductos.borrarProducto(id);
            cargarProductos(); // Recargar la tabla después de eliminar el producto
            JOptionPane.showMessageDialog(this, "Producto borrado exitosamente."); // Mostrar mensaje de éxito
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para borrar."); // Mostrar mensaje si no hay selección
        }
    }
}
