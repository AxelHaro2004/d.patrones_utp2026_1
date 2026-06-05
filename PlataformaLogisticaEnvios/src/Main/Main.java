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

        FabricaNotificaciones fabricaNormal = new ConfiguradorNotif(
            new CanalLog(new CanalSMS()), // Decorator: agrega log al canal SMS
            new FormatoExpress()
        );
        
        String textoAlerta1 = fabricaNormal.crearFormato().formato(paqueteExpress.getCodigo(), "En Ruta");
        fabricaNormal.crearCanal().enviar(textoAlerta1);

        System.out.println("\n--------------------------------------------------\n");

        System.out.println("Paquete 2:");
        Envio paqueteClonado = paqueteExpress.clone();
        paqueteClonado.setCodigo("EST-100");
        paqueteClonado.setDestino("Tumbes");
        servicioEstandar.procesarEnvio(paqueteClonado.getCodigo());
        
        monitoreo.registrarPaso(paqueteClonado.getCodigo(), paqueteClonado.getEstadoActual());

        gps = new AppleMapsAdapter(new ServicioAppleMaps()); // Adapter: adapta ServicioAppleMaps a ServicioGPS
        gps.obtenerRuta(paqueteClonado.getCodigo(), servicioEstandar);

        FabricaNotificaciones fabricaCruzada = new ConfiguradorNotif(
            new CanalLog(new CanalEmail()), // Decorator: agrega log al canal Email
            new FormatoExpress()
        );
        
        String textoAlerta2 = fabricaCruzada.crearFormato().formato(paqueteClonado.getCodigo(), "En Transito");
        fabricaCruzada.crearCanal().enviar(textoAlerta2);
        paqueteClonado.setEstado("En Transito");
        
        monitoreo.registrarPaso(paqueteClonado.getCodigo(), paqueteClonado.getEstadoActual());

        System.out.println("\n--------------------------------------------------\n");

        // Paquete 3 - Composite: grupo consolidado de envios
        System.out.println("Paquete 3 (Grupo consolidado):");
        EnvioBuilder builder2 = new EnvioBuilder();
        builder2.setCodigo("EST-201");
        builder2.setOrigen("Lima");
        builder2.setDestino("Cusco");
        builder2.setPeso(2.0);
        Envio e1 = builder2.build();

        EnvioBuilder builder3 = new EnvioBuilder();
        builder3.setCodigo("EST-202");
        builder3.setOrigen("Lima");
        builder3.setDestino("Cusco");
        builder3.setPeso(4.5);
        Envio e2 = builder3.build();

        EnvioBuilder builder4 = new EnvioBuilder();
        builder4.setCodigo("EST-203");
        builder4.setOrigen("Lima");
        builder4.setDestino("Cusco");
        builder4.setPeso(1.0);
        Envio e3 = builder4.build();

        EnvioGrupal grupoCusco = new EnvioGrupal("GRUPO-CUS-01"); // Composite: agrupa envios individuales
        grupoCusco.agregar(e1);
        grupoCusco.agregar(e2);
        grupoCusco.agregar(e3);
        grupoCusco.mostrarDetalle();
        monitoreo.registrarPaso(grupoCusco.getCodigo(), "Consolidado");

        System.out.println("\n--------------------------------------------------\n");

        monitoreo.mostrarReporteSistema();
    }
}