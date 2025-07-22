// Paquete principal del programa
package main;

// Importa el controlador que maneja la lógica del login
import controlador.LoginController;

// Importa la vista que contiene la interfaz gráfica del login
import vista.LoginView;

// Clase principal que contiene el método main, punto de entrada del programa
public class main {
    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        // Crea una instancia de la vista de login (interfaz gráfica)
        LoginView login = new LoginView();
        
        // Crea una instancia del controlador del login y le pasa la vista como parámetro
        // Esto conecta la vista con la lógica que la maneja
        new LoginController(login);
        
        // Hace visible la ventana del login para que el usuario la vea y pueda interactuar
        login.setVisible(true);
    }
}
