package com.mycompany.proyectofinal.Main;

import javax.swing.*;
import java.awt.*;

public class AcercaDe extends JFrame {

    public AcercaDe() {
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Acerca de");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Evitar cambio de tamaño
    }

    private void agregarComponentes() {
        // Crear un panel principal con diseño
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Área de texto con scroll
        JTextPane infoCompleta = new JTextPane();
        infoCompleta.setContentType("text/html");
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
        infoCompleta.setEditable(false);

        // Scroll bar para el área de texto
        JScrollPane scrollPane = new JScrollPane(infoCompleta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Configurar la posición inicial de la barra de desplazamiento
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(0));

        // Agregar el área de texto con scroll al panel principal
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Agregar panel principal a la ventana
        add(panelPrincipal);
    }
}
