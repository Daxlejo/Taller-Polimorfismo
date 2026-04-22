public class CanalPushMovil implements ICanalEntrega {
    @Override
    public boolean enviar(Notificacion notificacion) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("🔔 ENVIANDO PUSH NOTIFICATION");
        System.out.println("   Dispositivo de: " + notificacion.getDestinatario().getNombre());
        System.out.println("   Título: Notificación UCC");
        System.out.println("   Cuerpo: " + notificacion.getMensaje());
        System.out.println("   ✅ Push enviado exitosamente.");
        System.out.println("═══════════════════════════════════════════");
        return true;
    }

    @Override
    public String getNombreCanal() {
        return "Push Móvil";
    }
}
