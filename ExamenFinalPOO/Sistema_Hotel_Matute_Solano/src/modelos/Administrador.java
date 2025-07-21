package modelo;

public class Administrador extends Usuario {
    public Administrador(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
