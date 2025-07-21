package modelo;

public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente(String cedula, String nombre, String apellido, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Getters, setters, toString
}
