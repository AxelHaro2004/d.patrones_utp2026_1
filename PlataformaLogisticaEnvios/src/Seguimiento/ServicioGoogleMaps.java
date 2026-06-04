package Seguimiento;
import Servicios.*;

public class ServicioGoogleMaps implements ServicioGPS{

    @Override
    public void obtenerRuta(String codigoEnvio, ServicioDeEnvio servicio) {
        int tiempo = servicio.establecerAtributos().TiempoEstimado();
        System.out.println("\n[GOOGLE MAPS]:");
        System.out.println("Escaneando ruta para envio "+codigoEnvio+"... ");
        System.out.println("Ruta despejada. Tiempo estimado de llegada: "+tiempo+" horas");
    }
}
