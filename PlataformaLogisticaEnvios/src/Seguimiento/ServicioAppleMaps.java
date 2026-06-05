package Seguimiento;
//04/06: Clase del servicio de Apple Maps, que se integrará al sistema de seguimiento de envíos a través de la clase adaptadora AppleMapsAdapter
public class ServicioAppleMaps {
    public void trazarRuta(String paquete, int tiempoServicio) {
        System.out.println("[APPLE MAPS] Ruta trazada para " + paquete + ". Tiempo: " + tiempoServicio + " horas");
    }
}
