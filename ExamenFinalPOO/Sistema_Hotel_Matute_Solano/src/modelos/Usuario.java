package modelo;

public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contraseña;

    public Usuario(String nombre, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public abstract String getTipoUsuario();

    // Getters y setters
}
