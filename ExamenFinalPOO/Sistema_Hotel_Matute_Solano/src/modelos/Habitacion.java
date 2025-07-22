// Paquete donde se agrupan las clases modelo del sistema
package modelos;

// Importa Serializable para que los objetos Habitacion puedan ser serializados (guardados/recuperados)
import java.io.Serializable;

// Clase que representa una habitación de hotel
public class Habitacion implements Serializable {
    // Número identificador de la habitación
    private int numero;
    
    // Tipo de habitación (ejemplo: Simple, Doble, Suite)
    private TipoHabitacion tipo;
    
    // Estado de disponibilidad de la habitación (true = disponible, false = ocupada)
    private boolean disponible;

    // Constructor para crear una habitación con número, tipo y disponibilidad inicial
    public Habitacion(int numero, TipoHabitacion tipo, boolean disponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    // Getter para obtener el número de la habitación
    public int getNumero() {
        return numero;
    }

    // Setter para asignar/modificar el número de la habitación
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Getter para obtener el tipo de habitación
    public TipoHabitacion getTipo() {
        return tipo;
    }

    // Setter para asignar/modificar el tipo de habitación
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    // Getter para saber si la habitación está disponible
    public boolean isDisponible() {
        return disponible;
    }

    // Setter para modificar el estado de disponibilidad de la habitación
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método toString sobrescrito para mostrar una representación legible de la habitación
    @Override
    public String toString() {
        return "Habitación " + numero + " (" + tipo + ")";
    }
}


