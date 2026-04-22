import java.util.Date;

public class Notificacion {
    private String codigo;
    private Usuario destinatario;
    private String mensaje;
    private Date fechaEnvio;
    private EstadoNotificacion estado;

    public Notificacion(String codigo, Usuario destinatario, String mensaje) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.fechaEnvio = new Date();
        this.estado = EstadoNotificacion.PENDIENTE;
    }

    public String getCodigo() { return codigo; }
    public Usuario getDestinatario() { return destinatario; }
    public String getMensaje() { return mensaje; }
    public Date getFechaEnvio() { return fechaEnvio; }
    public EstadoNotificacion getEstado() { return estado; }

    public void setEstado(EstadoNotificacion estado) {
        this.estado = estado;
        if (estado == EstadoNotificacion.ENVIADA) {
            this.fechaEnvio = new Date();
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] Para: %s | Estado: %s | Mensaje: %s",
                codigo, destinatario, estado, mensaje);
    }
}
