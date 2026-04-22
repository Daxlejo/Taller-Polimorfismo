public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String telefono;

    public Usuario(String id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }

    @Override
    public String toString() {
        return nombre + " (" + correo + ")";
    }
}
