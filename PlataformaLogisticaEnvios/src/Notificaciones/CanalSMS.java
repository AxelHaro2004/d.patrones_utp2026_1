package Notificaciones;
public class CanalSMS implements CanalEnvio{

    @Override
    public void enviar(String mensaje) {
        System.out.println("\n[SMS ENVIADO]: "+mensaje);
    }
    
}
