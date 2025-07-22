// Paquete donde se agrupan las clases modelo
package modelos;

// Importa Serializable para poder guardar objetos Reserva y LocalDate para manejar fechas
import java.io.Serializable;
import java.time.LocalDate;

// Clase Reserva que implementa la interfaz Pago para calcular el total a pagar
// También es Serializable para poder guardar sus objetos fácilmente
public class Reserva implements Pago, Serializable {
    // Atributos de la reserva
    private Cliente cliente;          // Cliente que hizo la reserva
    private Habitacion habitacion;    // Habitación reservada
    private LocalDate fechaInicio;    // Fecha de inicio de la reserva
    private LocalDate fechaFin;       // Fecha de fin de la reserva

    // Constructor para inicializar la reserva con cliente, habitación y fechas
    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Implementación del método calcularTotal() de la interfaz Pago
    @Override
    public double calcularTotal() {
        // Calcula la cantidad de días entre la fecha fin y la fecha inicio
        long dias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
        
        // Si el resultado es 0 o negativo, se asume al menos 1 día para cobrar
        if (dias <= 0) {
            dias = 1; // Mínimo un día de reserva
        }

        // Determina el precio por día basado en el tipo de habitación usando switch
        double precioPorDia;
        precioPorDia = switch (habitacion.getTipo()) {
            case INDIVIDUAL -> 50;
            case DOBLE -> 80;
            case SUITE -> 120;
            default -> 0;
        };
        
        // Retorna el total multiplicando precio por día por la cantidad de días
        return precioPorDia * dias;
    }

    // Getters para obtener los atributos

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    // Setters para modificar los atributos

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Método toString sobrescrito para representar la reserva como cadena de texto legible
    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente.getNombre() + " " + cliente.getApellido() +
                ", habitacion=" + habitacion.getNumero() +
                ", tipo=" + habitacion.getTipo() +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", total=$" + calcularTotal() +
                '}';
    }
}
