package modelos;

import java.io.Serializable;

public class Habitacion implements Serializable {
    private int numero;
    private TipoHabitacion tipo;
    private boolean disponible;

    public Habitacion(int numero, TipoHabitacion tipo, boolean disponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Habitación " + numero + " (" + tipo + ")";
    }
}

