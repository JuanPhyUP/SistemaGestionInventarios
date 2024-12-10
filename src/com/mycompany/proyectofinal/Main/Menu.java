package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase principal para el menú de la aplicación de gestión de inventario.
 * Proporciona opciones para añadir, ver, editar, eliminar productos y más.
 */
public class Menu extends JFrame {

    private GestorDeProductos gestorDeProductos; // Referencia al gestor de productos

    /**
     * Constructor de la clase Menu.
     * Inicializa el gestor de productos y configura los componentes de la interfaz.
     */
    public Menu() {
        this.gestorDeProductos = new GestorDeProductos(); // Inicializar gestor de productos
        initComponents();
    }

    /**
     * Método para inicializar los componentes de la interfaz gráfica del menú.
     */
    private void initComponents() {
        setTitle("Gestor de Inventario");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes

        // Título del menú
        JLabel titleLabel = new JLabel("   GESTOR DE INVENTARIO", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 15;
        add(titleLabel, gbc);

        // Botón para añadir producto
        JButton addButton = new JButton("Añadir producto");
        addButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AñadirProducto añadirProducto = new AñadirProducto(gestorDeProductos);
                añadirProducto.setVisible(true);
            }
        });
        gbc.gridwidth = 1; // Restablecer gridwidth
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(addButton, gbc);

        // Botón para ver inventario
        JButton viewButton = new JButton("Ver inventario");
        viewButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarProducto listarProductos = new ListarProducto(gestorDeProductos);
                listarProductos.setVisible(true);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(viewButton, gbc);

        // Botón para editar producto
        JButton editButton = new JButton("Editar producto");
        editButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarProducto editarProducto = new EditarProducto(gestorDeProductos); // Crear ventana de edición
                editarProducto.setVisible(true); // Mostrar la ventana
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(editButton, gbc);

        // Botón para calcular valor del inventario
        JButton calcularValorProductoButton = new JButton("Valor producto");
        calcularValorProductoButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        calcularValorProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ValorInventario valorProducto = new ValorInventario(gestorDeProductos);
                valorProducto.mostrarValorProducto(); // Llama al método para mostrar el inventario
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(calcularValorProductoButton, gbc);

        // Botón para calcular el valor total del inventario
        JButton calcularValorTotalButton = new JButton("Valor inventario");
        calcularValorTotalButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        calcularValorTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ValorInventario valorInventario = new ValorInventario(gestorDeProductos);
                valorInventario.mostrarValorTotalInventario(); // Llama al método para mostrar el inventario
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(calcularValorTotalButton, gbc);

        // Botón para eliminar producto
        JButton deleteButton = new JButton("Eliminar producto");
        deleteButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProducto eliminarProducto = new EliminarProducto(gestorDeProductos);
                eliminarProducto.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(deleteButton, gbc);

        // Botón Acerca de
        JButton acercaDeButton = new JButton("Acerca de");
        acercaDeButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        acercaDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcercaDe acercaDe = new AcercaDe();
                acercaDe.setVisible(true);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(acercaDeButton, gbc);

        // Configuración de la ventana
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // No permitir redimensionar
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
