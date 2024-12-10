/**
 * Clase para gestionar la ventana de "Añadir Producto".
 * Permite a los usuarios agregar nuevos productos al inventario mediante un formulario.
 */
package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AñadirProducto extends JFrame {

    private JTextField idField; // Campo para el ID del producto
    private JTextField nombreField; // Campo para el nombre del producto
    private JTextField precioField; // Campo para el precio del producto
    private JTextField cantidadField; // Campo para la cantidad del producto
    private GestorDeProductos gestorDeProductos; // Referencia al gestor de productos

    /**
     * Constructor de la clase AñadirProducto.
     * @param gestorDeProductos el gestor de productos que almacena los datos del inventario.
     */
    public AñadirProducto(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos;
        initComponents();
    }

    /**
     * Inicializa los componentes gráficos de la ventana.
     */
    private void initComponents() {
        setTitle("Añadir Producto");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Crear campos de texto
        idField = new JTextField();
        nombreField = new JTextField();
        precioField = new JTextField();
        cantidadField = new JTextField(); // Inicializar campo de cantidad

        // Crear etiquetas
        JLabel idLabel = new JLabel("ID:");
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel precioLabel = new JLabel("Precio:");
        JLabel cantidadLabel = new JLabel("Cantidad:"); // Etiqueta para cantidad

        // Crear botón de añadir
        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        // Añadir componentes al marco
        add(idLabel);
        add(idField);
        add(nombreLabel);
        add(nombreField);
        add(precioLabel);
        add(precioField);
        add(cantidadLabel); // Añadir etiqueta de cantidad
        add(cantidadField); // Añadir campo de cantidad
        add(addButton);
    }

    /**
     * Lógica para agregar un nuevo producto al inventario.
     * Verifica la validez de los datos ingresados y evita duplicados de ID.
     */
    private void agregarProducto() {
        try {
            int id = Integer.parseInt(idField.getText()); // Obtener ID
            String nombre = nombreField.getText();
            double precio = Double.parseDouble(precioField.getText());
            int cantidad = Integer.parseInt(cantidadField.getText()); // Obtener cantidad

            // Verificar si el ID ya existe en el gestor de productos
            if (gestorDeProductos.existeProductoConID(id)) {
                JOptionPane.showMessageDialog(this, "El ID del producto ya existe. No se pueden agregar productos duplicados.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un nuevo producto con el ID, nombre, precio y cantidad
            Producto nuevoProducto = new Producto(id, nombre, cantidad, precio);
            gestorDeProductos.agregarProducto(nuevoProducto);

            // Limpiar campos
            idField.setText("");
            nombreField.setText("");
            precioField.setText("");
            cantidadField.setText(""); // Limpiar campo de cantidad

            JOptionPane.showMessageDialog(this, "Producto añadido con éxito.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID, precio y cantidad válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
