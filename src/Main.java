import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                ICanalEntrega[] canales = { new CanalEmail(), new CanalSMS(), new CanalPushMovil() };

                int opcion = 1;
                int contador = 1;

                do {
                        System.out.println("\n╔══════════════════════════════════════════════════════╗");
                        System.out.println("║   SISTEMA DE NOTIFICACIONES UNIVERSITARIAS          ║");
                        System.out.println("╚══════════════════════════════════════════════════════╝");

                        // Datos del usuario destinatario
                        System.out.println("\n── Datos del destinatario ──");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();

                        Usuario usuario = new Usuario("USR-" + contador, nombre, correo, telefono);

                        System.out.println("\n── Seleccione el tipo de notificación ──");
                        System.out.println("  1. Publicación de Calificaciones");
                        System.out.println("  2. Recordatorio de Pago de Matrícula");
                        System.out.println("  3. Cancelación de Clase");
                        System.out.println("  4. Confirmación de Evento");
                        System.out.print("\nOpción: ");
                        int tipoNotif = scanner.nextInt();
                        scanner.nextLine();

                        String codigo = "NOT-" + String.format("%03d", contador++);
                        Notificacion notificacion;

                        switch (tipoNotif) {
                                case 1:
                                        System.out.print("Materia: ");
                                        String materia = scanner.nextLine();
                                        System.out.print("Nota: ");
                                        String nota = scanner.nextLine();
                                        notificacion = new Notificacion(codigo, usuario,
                                                        "Se publicaron las calificaciones de " + materia
                                                                        + ". Su nota final es: " + nota);
                                        break;
                                case 2:
                                        System.out.print("Fecha límite de pago: ");
                                        String fechaLimite = scanner.nextLine();
                                        System.out.print("Monto: ");
                                        String monto = scanner.nextLine();
                                        notificacion = new Notificacion(codigo, usuario,
                                                        "Recordatorio: Su pago de matrícula vence el " + fechaLimite
                                                                        + ". Monto: $" + monto);
                                        break;
                                case 3:
                                        System.out.print("Materia cancelada: ");
                                        String materiaCanc = scanner.nextLine();
                                        System.out.print("Motivo: ");
                                        String motivo = scanner.nextLine();
                                        notificacion = new Notificacion(codigo, usuario,
                                                        "La clase de " + materiaCanc + " ha sido cancelada. Motivo: "
                                                                        + motivo);
                                        break;
                                case 4:
                                        System.out.print("Nombre del evento: ");
                                        String evento = scanner.nextLine();
                                        System.out.print("Fecha del evento: ");
                                        String fechaEvento = scanner.nextLine();
                                        notificacion = new Notificacion(codigo, usuario,
                                                        "Su inscripción al evento '" + evento
                                                                        + "' ha sido confirmada. Fecha: "
                                                                        + fechaEvento);
                                        break;
                                default:
                                        System.out.println("❌ Opción no válida.");
                                        continue;
                        }

                        System.out.println("\n── Seleccione el canal de entrega ──");
                        System.out.println("  1. Correo Electrónico");
                        System.out.println("  2. SMS");
                        System.out.println("  3. Push Notification (App Móvil)");
                        System.out.println("  4. Todos los canales");
                        System.out.print("\nOpción: ");
                        int canalSeleccion = scanner.nextInt();
                        scanner.nextLine();

                        try {
                                System.out.print("\n⏳ Enviando");
                                for (int i = 0; i < 3; i++) {
                                        Thread.sleep(1000);
                                        System.out.print(".");
                                }
                                System.out.println("\n");
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                        }

                        if (canalSeleccion >= 1 && canalSeleccion <= 3) {
                                ICanalEntrega canalElegido = canales[canalSeleccion - 1];
                                ServicioNotificacion servicio = new ServicioNotificacion(canalElegido);
                                servicio.procesarNotificacion(notificacion);
                        } else if (canalSeleccion == 4) {
                                ServicioNotificacion servicio = new ServicioNotificacion(canales[0]);
                                for (ICanalEntrega canal : canales) {
                                        servicio.setCanalEntrega(canal);
                                        servicio.procesarNotificacion(
                                                        new Notificacion(codigo, usuario, notificacion.getMensaje()));
                                }
                        } else {
                                System.out.println("❌ Canal no válido.");
                                continue;
                        }

                        notificacion.setEstado(EstadoNotificacion.ENVIADA);
                        System.out.println("\n── Resultado ──");
                        System.out.println(notificacion);

                        System.out.print("\n¿Desea enviar otra notificación? (1 = Sí / 0 = No): ");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                } while (opcion == 1);

                System.out.println("\n✅ Sistema finalizado. ¡Hasta luego!");
                scanner.close();
        }
}
