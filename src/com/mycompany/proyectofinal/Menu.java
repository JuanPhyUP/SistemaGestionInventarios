package com.mycompany.proyectofinal;

import javax.swing.*;
import java.awt.*;

import com.mycompany.proyectofinal.AñadirProducto;

public class Menu extends JFrame {
    private GestorDeProductos gestorDeProductos; // Agregar gestor de productos

    public Menu() {
        this.gestorDeProductos = new GestorDeProductos(); // Inicializar gestor de productos
        initComponents();
    }


    private void initComponents() {
        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245)); // Fondo gris muy claro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título del menú
        JLabel titleLabel = new JLabel("GESTOR DE INVENTARIO", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 0, 0)); // Texto gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 20, 10);
        panel.add(titleLabel, gbc);

        // Botones
        JButton addButton = createButton("Añadir producto", new Color(192, 192, 192));
        JButton editButton = createButton("Editar producto", new Color(192, 192, 192));
        JButton deleteButton = createButton("Eliminar producto", new Color(192, 192, 192));
        JButton viewButton = createButton("Ver inventario", new Color(192, 192, 192));
        JButton valueButton = createButton("Valor inventario", new Color(192, 192, 192));
        JButton exitButton = createButton("Salir", new Color(128, 128, 128));

        // Agregar ActionListener al botón "Añadir producto"
        addButton.addActionListener(e -> {
            AñadirProducto añadirProducto = new AñadirProducto(gestorDeProductos);
            añadirProducto.setVisible(true);
        });

        // Distribución en el panel
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(addButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(viewButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(editButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(valueButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(deleteButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(exitButton, gbc);

        // Configuración de la ventana
        this.add(panel);
        this.setTitle("Gestor de com.mycompany.proyectofinal.Inventario");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * Crea un botón con estilo predeterminado.
     *
     * @param text  Texto del botón
     * @param color Color de fondo del botón
     * @return JButton configurado
     */
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255))); // Borde gris suave
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
