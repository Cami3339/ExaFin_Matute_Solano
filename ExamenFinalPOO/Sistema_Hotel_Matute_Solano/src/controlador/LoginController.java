// Paquete que agrupa las clases relacionadas al controlador del sistema
package controlador;

// Importa las clases necesarias desde los paquetes de modelo y vista
import modelos.Administrador;
import modelos.Recepcionista;
import modelos.Usuario;
import vista.LoginView;
import vista.MenuPrincipalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase que controla el proceso de inicio de sesión (login)
public class LoginController {
    // Referencia a la vista del login
    private LoginView loginView;

    // Constructor que recibe la vista de login como parámetro
    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        // Se agrega un listener al botón de login para que ejecute una acción cuando se haga clic
        this.loginView.agregarListenerLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se llama al método para validar las credenciales del usuario
                validarCredenciales();
            }
        });
    }

    // Método privado para validar las credenciales ingresadas por el usuario
    private void validarCredenciales() {
        // Obtiene los datos ingresados en los campos de usuario y contraseña
        String usuarioIngresado = loginView.getUsuario();
        String contraseñaIngresada = loginView.getContraseña();

        // Se crean dos objetos Usuario simulando datos registrados (puedes reemplazar por BD)
        Usuario admin = new Administrador("Juan", "Pérez", "admin", "1234");
        Usuario recep = new Recepcionista("Lucía", "Lopez", "recep", "abcd");

        // Se verifica si las credenciales ingresadas coinciden con las de algún usuario registrado
        if (admin.validarCredenciales(usuarioIngresado, contraseñaIngresada) ||
            recep.validarCredenciales(usuarioIngresado, contraseñaIngresada)) {

            // Si las credenciales son válidas, se cierra la ventana de login
            loginView.dispose();

            // Se crea y muestra la vista del menú principal
            MenuPrincipalView menu = new MenuPrincipalView();
            menu.setVisible(true);
        } else {
            // Si las credenciales no son válidas, se muestra un mensaje de error
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        }
    }
}


