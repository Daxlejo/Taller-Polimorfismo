public class CanalSMS implements ICanalEntrega {
    @Override
    public boolean enviar(Notificacion notificacion) {
        String mensajeCorto = notificacion.getMensaje();
        if (mensajeCorto.length() > 160) {
            mensajeCorto = mensajeCorto.substring(0, 157) + "...";
        }

        System.out.println("═══════════════════════════════════════════");
        System.out.println("📱 ENVIANDO POR SMS");
        System.out.println("   Para: " + notificacion.getDestinatario().getTelefono());
        System.out.println("   Mensaje: " + mensajeCorto);
        System.out.println("   ✅ SMS enviado exitosamente.");
        System.out.println("═══════════════════════════════════════════");
        return true;
    }

    @Override
    public String getNombreCanal() {
        return "SMS";
    }
}
