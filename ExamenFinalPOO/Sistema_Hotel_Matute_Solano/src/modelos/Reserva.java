package modelo;
import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Pago, Serializable {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public double calcularTotal() {
        long dias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
        double precioPorDia = switch (habitacion.getTipo()) {
            case INDIVIDUAL -> 50;
            case DOBLE -> 80;
            case SUITE -> 120;
        };
        return dias * precioPorDia;
    }

    // Getters, setters, toString
}
