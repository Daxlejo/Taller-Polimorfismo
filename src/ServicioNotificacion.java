import java.util.ArrayList;
import java.util.List;

public class ServicioNotificacion {
    private ICanalEntrega canalEntrega;
    private List<Notificacion> historial;

    public ServicioNotificacion(ICanalEntrega canal) {
        this.canalEntrega = canal;
        this.historial = new ArrayList<>();
    }

    public void setCanalEntrega(ICanalEntrega canal) {
        this.canalEntrega = canal;
    }

    public boolean procesarNotificacion(Notificacion notificacion) {
        System.out.println("\n>> Procesando " + notificacion.getCodigo()
                + " vía [" + canalEntrega.getNombreCanal() + "]...\n");

        boolean exito = canalEntrega.enviar(notificacion);

        if (exito) {
            notificacion.setEstado(EstadoNotificacion.ENVIADA);
        } else {
            notificacion.setEstado(EstadoNotificacion.FALLIDA);
        }

        historial.add(notificacion);
        return exito;
    }

    public List<Notificacion> getHistorial() {
        return historial;
    }
}
