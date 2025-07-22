package modelos;

public class Recepcionista extends Usuario {
    public Recepcionista(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
    }

    @Override
    public String getTipoUsuario() {
        return "Recepcionista";
    }
}
