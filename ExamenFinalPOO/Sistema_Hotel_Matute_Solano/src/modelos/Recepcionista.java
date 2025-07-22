// Paquete que contiene las clases modelo del sistema
package modelos;

// Clase Recepcionista que extiende (hereda) de la clase Usuario
public class Recepcionista extends Usuario {

    // Constructor que recibe los datos básicos de un usuario y los pasa al constructor de la superclase Usuario
    public Recepcionista(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
    }

    // Método que sobreescribe el método para obtener el tipo de usuario específico
    @Override
    public String getTipoUsuario() {
        // Retorna el tipo específico de usuario: "Recepcionista"
        return "Recepcionista";
    }
}


