package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase EditarProducto.
 * Esta clase proporciona una interfaz gráfica para editar productos existentes
 * en el gestor de productos.
 */
public class EditarProducto extends JFrame {
    private GestorDeProductos gestorDeProductos; // Referencia al gestor de productos
    private JTable tablaProductos; // Tabla para mostrar los productos
    private DefaultTableModel modeloTabla; // Modelo de la tabla

    /**
     * Constructor de la clase EditarProducto.
     * Inicializa la ventana y los componentes gráficos.
     *
     * @param gestorDeProductos el gestor de productos que contiene los datos a editar.
     */
    public EditarProducto(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos; // Inicializar gestor de productos
        initComponents();
    }

    /**
     * Configura los componentes gráficos de la ventana.
     */
    private void initComponents() {
        setTitle("Editar Producto");
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

        // Botón para editar el producto seleccionado
        JButton editarButton = new JButton("Editar Producto");
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProducto();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editarButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar productos al iniciar
        cargarProductos();
    }

    /**
     * Carga los productos desde el gestor y los muestra en la tabla.
     */
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

    /**
     * Permite editar un producto seleccionado en la tabla.
     * Abre un cuadro de diálogo para modificar los datos del producto.
     */
    private void editarProducto() {
        int selectedRow = tablaProductos.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) {
            // Obtener datos actuales del producto seleccionado
            int id = (int) modeloTabla.getValueAt(selectedRow, 0);
            String nombre = (String) modeloTabla.getValueAt(selectedRow, 1);
            double precio = (double) modeloTabla.getValueAt(selectedRow, 2);
            int cantidad = (int) modeloTabla.getValueAt(selectedRow, 3);

            // Mostrar un cuadro de diálogo para editar los datos
            JTextField nombreField = new JTextField(nombre);
            JTextField precioField = new JTextField(String.valueOf(precio));
            JTextField cantidadField = new JTextField(String.valueOf(cantidad));

            Object[] message = {
                    "Nombre:", nombreField,
                    "Precio:", precioField,
                    "Cantidad:", cantidadField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Editar Producto", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // Actualizar el producto con los nuevos datos
                try {
                    String nuevoNombre = nombreField.getText();
                    double nuevoPrecio = Double.parseDouble(precioField.getText());
                    int nuevaCantidad = Integer.parseInt(cantidadField.getText());

                    gestorDeProductos.editarProducto(id, nuevoNombre, nuevoPrecio, nuevaCantidad);
                    cargarProductos(); // Recargar la tabla después de editar
                    JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Por favor, verifica.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para editar.");
        }
    }
}
