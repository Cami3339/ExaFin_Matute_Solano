package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    public LoginView() {
        setTitle("Inicio de Sesión - Hotel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Colores personalizados
        Color fondo = new Color(240, 248, 255); // Azul claro suave
        Color panelColor = new Color(220, 230, 240);
        Color botonColor = new Color(100, 149, 237); // Cornflower blue
        Color textoBoton = Color.WHITE;

        // Fuente moderna
        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 18);

        // Panel superior con título
        JLabel titulo = new JLabel("Sistema de Reservas - Login", JLabel.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(new Color(60, 60, 60));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        titulo.setBackground(fondo);
        titulo.setOpaque(true);
        add(titulo, BorderLayout.NORTH);

        // Panel de campos
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        panelCampos.setBackground(panelColor);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(fuente);
        txtUsuario = new JTextField();
        txtUsuario.setFont(fuente);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(fuente);
        txtContraseña = new JPasswordField();
        txtContraseña.setFont(fuente);

        panelCampos.add(lblUsuario);
        panelCampos.add(txtUsuario);
        panelCampos.add(lblContraseña);
        panelCampos.add(txtContraseña);

        // Botón
        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setFont(fuente);
        btnLogin.setBackground(botonColor);
        btnLogin.setForeground(textoBoton);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(fondo);
        panelBoton.add(btnLogin);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        // Fondo general
        getContentPane().setBackground(fondo);
    }

    // Métodos para acceder desde el controlador
    public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getContraseña() {
        return new String(txtContraseña.getPassword());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void agregarListenerLogin(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }

}
