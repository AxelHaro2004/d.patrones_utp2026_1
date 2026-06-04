package Seguimiento;
import Servicios.*;

/*Principio DIP*/

public interface ServicioGPS {
    void obtenerRuta(String codigoEnvio, ServicioDeEnvio servicio);
}
