package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la ventana "Acerca de".
 * Esta ventana proporciona detalles sobre el proyecto y su equipo.
 */
public class AcercaDe extends JFrame {

    /**
     * Constructor de la clase AcercaDe.
     * Configura la ventana principal y agrega los componentes necesarios.
     */
    public AcercaDe() {
        configurarVentana();
        agregarComponentes();
    }

    /**
     * Configura las propiedades básicas de la ventana.
     *
     * @implNote La ventana tiene un tamaño fijo y se centra en la pantalla.
     */
    private void configurarVentana() {
        setTitle("Acerca de"); // Establece el título de la ventana.
        setSize(600, 400); // Define el tamaño de la ventana.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Configura el cierre de la ventana.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setResizable(false); // Desactiva la posibilidad de redimensionar la ventana.
    }

    /**
     * Agrega los componentes visuales al contenido de la ventana.
     *
     * @implNote Se utiliza un JTextPane para mostrar información en formato HTML.
     */
    private void agregarComponentes() {
        // Crear un panel principal con un diseño de borde.
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega espacio alrededor del contenido.

        // Crear un JTextPane para mostrar información.
        JTextPane infoCompleta = new JTextPane();
        infoCompleta.setContentType("text/html"); // Permite formatear texto en HTML.
        infoCompleta.setText("<html>" +
                "<h1 style='text-align:center;'>Proyecto de Gestión de Inventario</h1>" +
                "<p>El proyecto de Gestión de Inventario es una solución diseñada para optimizar el control y " +
                "la administración de inventarios en empresas de diversos sectores. Su objetivo es facilitar " +
                "la gestión de productos, minimizar errores humanos y aumentar la eficiencia operativa mediante " +
                "herramientas tecnológicas modernas y una interfaz intuitiva.</p>" +
                "<h2>Equipo del Proyecto</h2>" +
                "<p><b>Product Owner:</b><br>Juan Celis<br>Responsable de definir los objetivos del producto y garantizar que " +
                "la solución cumpla con las necesidades del cliente y del mercado.</p>" +
                "<p><b>Scrum Master:</b><br>Andrés Arrieta<br>Encargado de coordinar el desarrollo ágil del proyecto, " +
                "asegurando la fluidez de los procesos y la correcta implementación de la metodología Scrum.</p>" +
                "<p><b>Equipo Técnico:</b><br><br>Gabriel Jiménez (Líder Técnico)<br>Responsable de la arquitectura del sistema, la supervisión " +
                "técnica y la toma de decisiones críticas en el desarrollo.<br><br>Juan Celis<br>Participa activamente en el desarrollo técnico y aporta experiencia " +
                "para garantizar el cumplimiento de los objetivos del producto.<br><br>Andrés Arrieta<br>Desarrollador comprometido con la implementación de las funcionalidades y " +
                "con la calidad del código.</p>" +
                "</html>");
        infoCompleta.setEditable(false); // Impide la edición del texto.

        // Agregar un JScrollPane para manejar contenido largo.
        JScrollPane scrollPane = new JScrollPane(infoCompleta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Configurar la posición inicial de la barra de desplazamiento.
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(0));

        // Agregar el JTextPane al panel principal.
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel principal al contenido de la ventana.
        add(panelPrincipal);
    }
}


