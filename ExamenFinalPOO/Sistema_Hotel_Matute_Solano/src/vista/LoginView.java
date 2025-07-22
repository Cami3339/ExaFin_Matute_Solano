package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    public LoginView() {
        setTitle("Inicio de Sesión - Hotel");
        setSize(420, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel principal con padding y fondo
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panelPrincipal.setBackground(new Color(245, 245, 245)); // Fondo claro

        // Etiqueta de título
        JLabel lblTitulo = new JLabel("Inicio de Sesión", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(60, 63, 65));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de campos
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCampos.setOpaque(false);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtContraseña = new JPasswordField();
        txtContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtContraseña.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        panelCampos.add(lblUsuario);
        panelCampos.add(txtUsuario);
        panelCampos.add(lblContraseña);
        panelCampos.add(txtContraseña);

        panelPrincipal.add(panelCampos, BorderLayout.CENTER);

        // Panel botón
        JPanel panelBoton = new JPanel();
        panelBoton.setOpaque(false);
        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(new Color(51, 153, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setPreferredSize(new Dimension(140, 35));
        panelBoton.add(btnLogin);

        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    // Métodos para acceder desde el controlador
    public String getUsuario() {
        return txtUsuario.getText().trim();
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
