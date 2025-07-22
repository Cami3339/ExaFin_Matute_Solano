// Paquete donde se encuentran las clases modelo del sistema
package modelos;

// Importa la interfaz Serializable para permitir que objetos Cliente puedan ser serializados (guardados/recuperados fácilmente)
import java.io.Serializable;

// Clase Cliente que representa a un cliente y puede ser serializada
public class Cliente implements Serializable {
    // Atributos privados que almacenan los datos del cliente
    private String cedula;    // Documento de identidad del cliente
    private String nombre;    // Nombre del cliente
    private String apellido;  // Apellido del cliente
    private String telefono;  // Teléfono del cliente

    // Constructor que inicializa un objeto Cliente con todos sus datos
    public Cliente(String cedula, String nombre, String apellido, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Métodos getters para obtener el valor de cada atributo

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    // Métodos setters para modificar el valor de cada atributo

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString sobrescrito para representar el objeto Cliente como una cadena legible
    @Override
    public String toString() {
        // Devuelve el nombre completo y la cédula para mostrar información clara del cliente
        return nombre + " " + apellido + " (Cédula: " + cedula + ")";
    }
}

