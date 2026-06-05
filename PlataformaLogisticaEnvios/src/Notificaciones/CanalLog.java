package Notificaciones;
//04/06: (Decorator Concreto) Decorador específico que agrega funcionalidad de logging a cualquier canal de notificación, registrando cuándo se envían las notificaciones y su resultado
public class CanalLog extends CanalDecorator {

    public CanalLog(CanalEnvio canalBase) {
        super(canalBase);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[LOG] Enviando notificacion...");
        canalBase.enviar(mensaje);
        System.out.println("[LOG] Notificacion enviada correctamente.");
    }
}