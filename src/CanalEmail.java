public class CanalEmail implements ICanalEntrega {
    @Override
    public boolean enviar(Notificacion notificacion) {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("📧 ENVIANDO POR CORREO ELECTRÓNICO");
        System.out.println("   Para: " + notificacion.getDestinatario().getCorreo());
        System.out.println("   Asunto: Notificación " + notificacion.getCodigo());
        System.out.println("   Cuerpo: " + notificacion.getMensaje());
        System.out.println("   ✅ Correo enviado exitosamente.");
        System.out.println("═══════════════════════════════════════════");
        return true;
    }

    @Override
    public String getNombreCanal() {
        return "Correo Electrónico";
    }
}
