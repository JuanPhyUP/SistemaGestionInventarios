package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La clase ValorInventario extiende JFrame y proporciona una interfaz gráfica
 * para calcular y mostrar el valor total de productos individuales y del inventario completo.
 */
public class ValorInventario extends JFrame {

    // Instancia de GestorDeProductos para gestionar los productos del inventario
    private GestorDeProductos gestorDeProductos;

    /**
     * Constructor de la clase ValorInventario.
     * Inicializa la ventana y configura los componentes visuales.
     *
     * @param gestorDeProductos Objeto que maneja el inventario de productos.
     */
    public ValorInventario(GestorDeProductos gestorDeProductos) {
        this.gestorDeProductos = gestorDeProductos;
        setTitle("Gestión de Inventario");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        initComponents(); // Inicializa los componentes de la ventana
    }

    /**
     * Configura los componentes visuales de la ventana, incluyendo los botones
     * para calcular el valor de un producto y el valor total del inventario.
     */
    private void initComponents() {
        // Crear un panel para los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1)); // Dos filas, una columna

        // Botón para calcular el valor total de un producto
        JButton calcularValorProductoButton = new JButton("Calcular Valor de Producto");
        calcularValorProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarValorProducto();
            }
        });
        panel.add(calcularValorProductoButton);

        // Botón para calcular el valor total del inventario
        JButton calcularValorTotalInventarioButton = new JButton("Calcular Valor Total del Inventario");
        calcularValorTotalInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarValorTotalInventario();
            }
        });
        panel.add(calcularValorTotalInventarioButton);

        // Agregar el panel a la ventana
        add(panel);
    }

    /**
     * Calcula el valor total de un producto en inventario.
     * El valor total se calcula multiplicando la cantidad del producto por su precio.
     *
     * @param producto El producto cuyo valor total se va a calcular.
     * @return El valor total del producto.
     */
    public double calcularValorProducto(Producto producto) {
        // Calcula y retorna el valor total usando el precio del producto y la cantidad en inventario
        return producto.getCantidad() * producto.getPrecio();
    }

    /**
     * Solicita al usuario el nombre de un producto, busca el producto en el inventario
     * y muestra su valor total en inventario.
     * Si el producto no es encontrado, muestra un mensaje de error.
     */
    public void mostrarValorProducto() {
        String nombreProducto = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto (ejemplo: Papa):");
        Producto producto = gestorDeProductos.buscarProductoPorNombre(nombreProducto);

        if (producto != null) {
            double valorTotal = calcularValorProducto(producto);
            JOptionPane.showMessageDialog(this, "El valor total de " + producto.getNombre() + " en inventario es: $" + valorTotal,
                    "Valor del Producto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE); // Mensaje si el producto no existe
        }
    }

    /**
     * Calcula el valor total del inventario sumando el valor total de cada producto.
     *
     * @return El valor total del inventario.
     */
    public double calcularValorTotal() {
        double valorTotal = 0;
        List<Producto> productos = gestorDeProductos.getProductos();
        for (Producto producto : productos) {
            valorTotal += calcularValorProducto(producto);
        }
        return valorTotal;
    }

    /**
     * Calcula y muestra el valor total del inventario.
     */
    public void mostrarValorTotalInventario() {
        double total = calcularValorTotal();
        JOptionPane.showMessageDialog(this, "El valor total del inventario es: $" + total,
                "Valor Total del Inventario", JOptionPane.INFORMATION_MESSAGE);
    }
}
