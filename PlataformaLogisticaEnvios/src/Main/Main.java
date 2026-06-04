package Main;
import Envios.*;
import Servicios.*;
import Seguimiento.*;
import Notificaciones.*;
import Monitoreo.*;

public class Main {
    public static void main(String[] args) {
        
        CentralMonitoreo monitoreo = CentralMonitoreo.getInstancia();
        ServicioDeEnvio servicioExpress = new ServicioExpress("Envio Express Premium");
        ServicioDeEnvio servicioEstandar = new ServicioEstandar("Envio Regular Terrestre");
        
        System.out.println("====== SISTEMA DE ENVIOS ======\n");
        System.out.println("Paquete 1:");
        EnvioBuilder builder = new EnvioBuilder();
        builder.setCodigo("EXP-100");
        builder.setOrigen("Lima");
        builder.setDestino("Piura");
        builder.setPeso(3.5);
        
        Envio paqueteExpress = builder.build();
        servicioExpress.procesarEnvio(paqueteExpress.getCodigo());
        
        monitoreo.registrarPaso(paqueteExpress.getCodigo(), paqueteExpress.getEstadoActual());

        ServicioGPS gps = new ServicioGoogleMaps();
        gps.obtenerRuta(paqueteExpress.getCodigo(), servicioExpress);

        FabricaNotificaciones fabricaNormal = new ConfiguradorNotif(new CanalSMS(), new FormatoExpress());
        
        String textoAlerta1 = fabricaNormal.crearFormato().formato(paqueteExpress.getCodigo(), "En Ruta");
        fabricaNormal.crearCanal().enviar(textoAlerta1);

        System.out.println("\n--------------------------------------------------\n");

        System.out.println("Paquete 2:");
        Envio paqueteClonado = paqueteExpress.clone();
        paqueteClonado.setCodigo("EST-100");
        paqueteClonado.setDestino("Tumbes");
        servicioEstandar.procesarEnvio(paqueteClonado.getCodigo());
        
        monitoreo.registrarPaso(paqueteClonado.getCodigo(), paqueteClonado.getEstadoActual());

        gps = new ServicioWaze();
        gps.obtenerRuta(paqueteClonado.getCodigo(), servicioEstandar);

        FabricaNotificaciones fabricaCruzada = new ConfiguradorNotif(new CanalEmail(), new FormatoExpress());
        
        String textoAlerta2 = fabricaCruzada.crearFormato().formato(paqueteClonado.getCodigo(), "En Transito");
        fabricaCruzada.crearCanal().enviar(textoAlerta2);
        paqueteClonado.setEstado("En Transito");
        
        monitoreo.registrarPaso(paqueteClonado.getCodigo(), paqueteClonado.getEstadoActual());

        System.out.println("\n--------------------------------------------------\n");

        monitoreo.mostrarReporteSistema();
    }
}