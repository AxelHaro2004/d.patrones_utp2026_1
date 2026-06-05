package Fachada;
import Envios.*;
import Servicios.*;
import Seguimiento.*;
import Notificaciones.*;
import Monitoreo.*;
/*04/06: (Fachada) Clase que unifica la interacción con los diferentes subsistemas del sistema de envíos,
proporcionando una interfaz simple para despachar envíos, gestionar notificaciones y monitorear el estado de los envíos.*/
public class SistemaEnvio {
    private final CentralMonitoreo monitoreo;

    public SistemaEnvio() {
        this.monitoreo = CentralMonitoreo.getInstancia();
    }

    public void despacharEnvio(Envio envio, ServicioDeEnvio servicio,
                                ServicioGPS gps, CanalEnvio canal, FormatoMensaje formato) {

        System.out.println("====== DESPACHANDO: " + envio.getCodigo() + " ======");
        servicio.procesarEnvio(envio.getCodigo());
        monitoreo.registrarPaso(envio.getCodigo(), envio.getEstadoActual());
        gps.obtenerRuta(envio.getCodigo(), servicio);
        FabricaNotificaciones fabrica = new ConfiguradorNotif(canal, formato);
        String mensaje = fabrica.crearFormato().formato(envio.getCodigo(), "En Ruta");
        fabrica.crearCanal().enviar(mensaje);
        System.out.println("====== DESPACHO COMPLETADO ======\n");
    }
}