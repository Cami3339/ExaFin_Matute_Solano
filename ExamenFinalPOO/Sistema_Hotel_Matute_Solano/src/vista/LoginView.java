// Paquete que contiene las clases de la interfaz gráfica
package vista;

// Importaciones para gráficos y eventos
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

// Clase LoginView que representa la ventana de inicio de sesión
// Hereda de JFrame, lo que le permite ser una ventana gráfica
public class LoginView extends JFrame {
    // Campos de entrada y botón
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    // Constructor que configura toda la interfaz gráfica
    public LoginView() {
        // Título de la ventana
        setTitle("Inicio de Sesión - Hotel");
        setSize(400, 300); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout()); // Usa un layout con 5 zonas (Norte, Sur, etc.)

        // Colores personalizados para mejorar la estética
        Color fondo = new Color(240, 248, 255);        // Color de fondo general (azul claro)
        Color panelColor = new Color(220, 230, 240);   // Color del panel de campos
        Color botonColor = new Color(100, 149, 237);   // Color del botón (azul intenso)
        Color textoBoton = Color.WHITE;                // Texto blanco en el botón

        // Fuentes modernas para los textos
        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 18);

        // --- Panel superior con el título ---
        JLabel titulo = new JLabel("Sistema de Reservas - Login", JLabel.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(new Color(60, 60, 60)); // Color del texto del título
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0)); // Espaciado
        titulo.setBackground(fondo);
        titulo.setOpaque(true); // Permite mostrar color de fondo
        add(titulo, BorderLayout.NORTH); // Añade el título en la parte superior

        // --- Panel central con los campos de entrada ---
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10)); // Grid de 2x2 con espacios
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30)); // Margen interior
        panelCampos.setBackground(panelColor); // Color de fondo

        // Campo Usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(fuente);
        txtUsuario = new JTextField();
        txtUsuario.setFont(fuente);

        // Campo Contraseña
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(fuente);
        txtContraseña = new JPasswordField();
        txtContraseña.setFont(fuente);

        // Agrega componentes al panel central
        panelCampos.add(lblUsuario);
        panelCampos.add(txtUsuario);
        panelCampos.add(lblContraseña);
        panelCampos.add(txtContraseña);

        // --- Panel inferior con el botón ---
        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setFont(fuente);
        btnLogin.setBackground(botonColor);
        btnLogin.setForeground(textoBoton);
        btnLogin.setFocusPainted(false); // Elimina el borde al enfocar
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding interno

        JPanel panelBoton = new JPanel(); // Panel para centrar el botón
        panelBoton.setBackground(fondo);
        panelBoton.add(btnLogin);

        // Agrega los paneles al frame principal
        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        // Color de fondo general del contenido
        getContentPane().setBackground(fondo);
    }

    // --- Métodos públicos para que el controlador acceda a los datos ---

    // Obtiene el nombre de usuario ingresado
    public String getUsuario() {
        return txtUsuario.getText();
    }

    // Obtiene la contraseña ingresada como String (se convierte desde char[])
    public String getContraseña() {
        return new String(txtContraseña.getPassword());
    }

    // Muestra un mensaje emergente (por ejemplo, error de login)
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Permite agregar un listener al botón de login desde el controlador
    public void agregarListenerLogin(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }
}
