package controlador;

import modelo.Administrador;
import modelo.Recepcionista;
import modelo.Usuario;
import vista.LoginView;
import vista.MenuPrincipalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        // Agrega acción al botón de login
        this.loginView.agregarListenerLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCredenciales();
            }
        });
    }

    private void validarCredenciales() {
        String usuarioIngresado = loginView.getUsuario();
        String contraseñaIngresada = loginView.getContraseña();

        // Simulación de datos hardcoded (se puede reemplazar con DB)
        Usuario admin = new Administrador("Juan", "Pérez", "admin", "1234");
        Usuario recep = new Recepcionista("Lucía", "Lopez", "recep", "abcd");

        if ((usuarioIngresado.equals(admin.usuario) && contraseñaIngresada.equals(admin.contraseña)) ||
            (usuarioIngresado.equals(recep.usuario) && contraseñaIngresada.equals(recep.contraseña))) {

            loginView.dispose(); // Cierra la ventana de login
            MenuPrincipalView menu = new MenuPrincipalView();
            menu.setVisible(true);
        } else {
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        }
    }
}
