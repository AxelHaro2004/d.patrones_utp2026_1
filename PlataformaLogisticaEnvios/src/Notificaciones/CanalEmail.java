package Notificaciones;
public class CanalEmail implements CanalEnvio{

    @Override
    public void enviar(String mensaje) {
        System.out.println("\n[CORREO ENVIADO]: "+mensaje);
    }
    
}
