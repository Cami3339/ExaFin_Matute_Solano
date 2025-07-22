package controlador;

// Importación de las clases del modelo y la vista necesarias
import modelos.Administrador;
import modelos.Recepcionista;
import modelos.Usuario;
import vista.LoginView;
import vista.MenuPrincipalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase LoginController
 * Controlador encargado de manejar la lógica del inicio de sesión del sistema.
 */
public class LoginController {
    private LoginView loginView; // Vista asociada al login

    /**
     * Constructor del controlador de login.
     * Recibe una instancia de la vista y le agrega el listener al botón.
     * @param loginView Vista del formulario de inicio de sesión.
     */
    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        // Se agrega un ActionListener al botón de login
        this.loginView.agregarListenerLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCredenciales(); // Al hacer clic, se valida el usuario
            }
        });
    }

    /**
     * Método que valida las credenciales ingresadas por el usuario.
     * Compara contra dos usuarios predefinidos (Administrador y Recepcionista).
     */
    private void validarCredenciales() {
        // Obtiene los datos ingresados por el usuario en la interfaz
        String usuarioIngresado = loginView.getUsuario();
        String contraseñaIngresada = loginView.getContraseña();

        // Usuarios de ejemplo codificados (pueden reemplazarse con base de datos)
        Usuario admin = new Administrador("Juan", "Pérez", "admin", "1234");
        Usuario recep = new Recepcionista("Lucía", "Lopez", "recep", "abcd");

        // Validación de credenciales contra los dos usuarios definidos
        if (admin.validarCredenciales(usuarioIngresado, contraseñaIngresada) ||
            recep.validarCredenciales(usuarioIngresado, contraseñaIngresada)) {

            loginView.dispose(); // Si es correcto, se cierra la ventana de login

            // Se crea y muestra la vista del menú principal
            MenuPrincipalView menu = new MenuPrincipalView();
            menu.setVisible(true);
        } else {
            // Si falla la autenticación, muestra mensaje de error
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        }
    }
}
