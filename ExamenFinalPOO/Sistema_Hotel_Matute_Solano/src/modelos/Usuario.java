// Paquete que agrupa las clases modelo
package modelos;

// Clase abstracta Usuario: base para todos los tipos de usuario en el sistema
public abstract class Usuario {
    // Atributos protegidos accesibles por las subclases
    protected String nombre;
    protected String apellido;
    protected String usuario;      // nombre de usuario para login
    protected String contraseña;   // contraseña para login

    // Constructor para inicializar los datos básicos del usuario
    public Usuario(String nombre, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Método abstracto que deben implementar las subclases para indicar el tipo de usuario (ej. Administrador, Recepcionista)
    public abstract String getTipoUsuario();

    // Getters y setters para acceder y modificar los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Método para validar las credenciales recibidas con las almacenadas en el objeto
    // Retorna true si usuario y contraseña coinciden, false en caso contrario
    public boolean validarCredenciales(String usuarioIngresado, String contraseñaIngresada) {
        return this.usuario != null && this.usuario.equals(usuarioIngresado) &&
               this.contraseña != null && this.contraseña.equals(contraseñaIngresada);
    }
}

