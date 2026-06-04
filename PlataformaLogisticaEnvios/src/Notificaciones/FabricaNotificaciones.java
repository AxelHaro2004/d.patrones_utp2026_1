package Notificaciones;

/*Patrón Abstract Factory*/

public interface FabricaNotificaciones {
    CanalEnvio crearCanal();
    FormatoMensaje crearFormato();
}
