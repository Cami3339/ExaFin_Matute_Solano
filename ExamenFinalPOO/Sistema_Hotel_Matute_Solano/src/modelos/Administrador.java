// Paquete donde se encuentran las clases modelo del sistema
package modelos;

// Clase Administrador que hereda de la clase Usuario
public class Administrador extends Usuario {

    // Constructor de la clase Administrador que recibe los datos básicos del usuario
    // Llama al constructor de la superclase Usuario para inicializar los atributos heredados
    public Administrador(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
    }

    // Método que sobreescribe el método abstracto o definido en Usuario para indicar el tipo de usuario
    @Override
    public String getTipoUsuario() {
        // Retorna el tipo específico de usuario como "Administrador"
        return "Administrador";
    }
}

