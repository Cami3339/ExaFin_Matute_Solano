package vista; // El paquete al que pertenece esta clase, generalmente usado para organización del proyecto.

import java.awt.*; // Importa todas las clases del paquete AWT (Abstract Window Toolkit) de Java para manejo de interfaces gráficas.
import javax.swing.*; // Importa todas las clases del paquete Swing para crear interfaces gráficas más modernas.
import javax.swing.border.EmptyBorder; // Importa la clase para crear bordes vacíos (márgenes internos).

public class MenuPrincipalView extends JFrame { // La clase extiende JFrame, por lo tanto es una ventana principal.
    private JTabbedPane pestañas; // Componente de pestañas donde se colocarán los paneles de Clientes, Habitaciones y Reservas.

    public MenuPrincipalView() { // Constructor de la clase.
        setTitle("🌟 Sistema de Reservas - Hotel 🌟"); // Establece el título de la ventana.
        setSize(900, 650); // Establece el tamaño de la ventana.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación cuando se cierra la ventana.
        setLayout(new BorderLayout()); // Establece el layout principal como BorderLayout.

        // Crear y configurar el encabezado
        JLabel header = new JLabel("Bienvenido al Sistema de Reservas del Hotel", JLabel.CENTER); // Etiqueta centrada con texto de bienvenida.
        header.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Establece la fuente del texto.
        header.setForeground(new Color(33, 45, 62)); // Color del texto (azul oscuro).
        header.setBorder(new EmptyBorder(15, 0, 15, 0)); // Márgenes arriba y abajo del texto.
        header.setOpaque(true); // Permite establecer un color de fondo.
        header.setBackground(new Color(224, 242, 241)); // Color de fondo suave.
        add(header, BorderLayout.NORTH); // Agrega el encabezado en la parte superior del BorderLayout.

        // Crear y configurar las pestañas (JTabbedPane)
        pestañas = new JTabbedPane(); // Instancia un nuevo JTabbedPane.
        pestañas.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Fuente para las pestañas.
        pestañas.setBackground(Color.WHITE); // Fondo blanco.
        pestañas.setForeground(new Color(51, 51, 51)); // Texto oscuro para las pestañas.
        pestañas.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Borde gris claro.

        // Agrega tres pestañas con sus respectivos paneles
        pestañas.addTab("🧑‍💼 Clientes", new PanelClientes()); // Pestaña de Clientes con su panel correspondiente.
        pestañas.addTab("🛏 Habitaciones", new PanelHabitaciones()); // Pestaña de Habitaciones.
        pestañas.addTab("📅 Reservas", new PanelReservas()); // Pestaña de Reservas.

        add(pestañas, BorderLayout.CENTER); // Agrega el JTabbedPane en el centro del layout.

        // Crear y configurar el pie de página
        JLabel footer = new JLabel("© 2025 HotelSoft. Todos los derechos reservados.", JLabel.CENTER); // Pie de página con texto centrado.
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12)); // Fuente en estilo itálico.
        footer.setForeground(new Color(100, 100, 100)); // Color gris para el texto.
        footer.setBorder(new EmptyBorder(10, 0, 10, 0)); // Márgenes verticales.
        add(footer, BorderLayout.SOUTH); // Agrega el pie de página en la parte inferior.
    }
}

