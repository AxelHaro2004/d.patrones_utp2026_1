package Notificaciones;
public class FormatoExpress implements FormatoMensaje{

    @Override
    public String formato(String codigo, String estado) {
        return "\nALERTA DE ENVIO EXPRESS: El paquete "+codigo+" paso al estado "+estado;
    }
}
