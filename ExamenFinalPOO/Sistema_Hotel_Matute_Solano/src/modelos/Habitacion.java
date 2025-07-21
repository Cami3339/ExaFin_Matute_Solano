package modelo;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private boolean disponible;

    public Habitacion(int numero, TipoHabitacion tipo, boolean disponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    // Getters, setters, toString
}
