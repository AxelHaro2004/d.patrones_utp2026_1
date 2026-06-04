package Seguimiento;
import Servicios.*;

public class ServicioWaze implements ServicioGPS{

    @Override
    public void obtenerRuta(String codigoEnvio, ServicioDeEnvio servicio) {
        int tiempo = servicio.establecerAtributos().TiempoEstimado();
        int retraso = 4;
        int tiempoFinal = tiempo+retraso;
        System.out.println("\n[WAZE]:");
        System.out.println("Escaneando ruta para envio "+codigoEnvio+"... ");
        System.out.println("Alerta de trafico! El envio tendra un retraso de : "+retraso+" horas.");
        System.out.println("Tiempo estimado recalculado: "+tiempoFinal+" horas");
    }
}
