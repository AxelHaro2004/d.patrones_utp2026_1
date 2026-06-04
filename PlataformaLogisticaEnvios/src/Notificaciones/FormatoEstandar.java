package Notificaciones;
public class FormatoEstandar implements FormatoMensaje{

    @Override
    public String formato(String codigo, String estado) {
        return "\nALERTA DE ENVIO ESTANDAR: El paquete "+codigo+" paso al estado "+estado;
    }
}
