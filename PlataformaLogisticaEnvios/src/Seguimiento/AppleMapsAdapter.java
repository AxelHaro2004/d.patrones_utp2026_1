package Seguimiento;
import Servicios.*;
//04/06: Clase adaptadora para integrar el servicio de Apple Maps al sistema de seguimiento de envíos
public class AppleMapsAdapter implements ServicioGPS {
    private ServicioAppleMaps appleMaps;

    public AppleMapsAdapter(ServicioAppleMaps appleMaps) {
        this.appleMaps = appleMaps;
    }

    @Override
    public void obtenerRuta(String codigoEnvio, ServicioDeEnvio servicio) {
        int tiempo = servicio.establecerAtributos().TiempoEstimado();
        appleMaps.trazarRuta(codigoEnvio, tiempo);
    }
}