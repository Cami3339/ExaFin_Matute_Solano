package modelos;

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
        if (dias <= 0) {
            dias = 1; // Al menos 1 día
        }

        double precioPorDia;
        precioPorDia = switch (habitacion.getTipo()) {
            case INDIVIDUAL -> 50;
            case DOBLE -> 80;
            case SUITE -> 120;
            default -> 0;
        };
        return precioPorDia * dias;
    }


    // Getters
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

    // Setters
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
