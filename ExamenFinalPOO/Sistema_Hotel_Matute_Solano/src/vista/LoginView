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
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        panelCampos.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        panelCampos.add(txtUsuario);

        panelCampos.add(new JLabel("Contraseña:"));
        txtContraseña = new JPasswordField();
        panelCampos.add(txtContraseña);

        btnLogin = new JButton("Iniciar Sesión");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnLogin);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
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

