package Notificaciones;
//04/06: (Decorator Abstracto) Clase decoradora base para los canales de notificación, que permitirá agregar funcionalidades adicionales a los canales existentes sin modificar su código
public abstract class CanalDecorator implements CanalEnvio {
    protected CanalEnvio canalBase;

    public CanalDecorator(CanalEnvio canalBase) {
        this.canalBase = canalBase;
    }
}