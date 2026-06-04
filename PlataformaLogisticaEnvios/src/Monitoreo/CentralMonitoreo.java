package Monitoreo;
import java.util.ArrayList;
import java.util.List;

/*Patrón Singleton*/

public class CentralMonitoreo {
    private static CentralMonitoreo central;
    private final List<String> historial;

    private CentralMonitoreo() {
        historial = new ArrayList<>();
    }

    public static CentralMonitoreo getInstancia() {
        if(central==null){
            central = new CentralMonitoreo();
        }
        return central;
    }
    
    public void registrarPaso(String codigo, String estado) {
        String registro = "Paquete " + codigo + " -> Estado: " + estado;
        historial.add(registro);
        System.out.println("\n[MONITOREO] " + registro);
    }

    public void mostrarReporteSistema() {
        System.out.println("[REPORTE DE MONITOREO]");
        for (String reg : historial) {
            System.out.println(reg);
        }
    }
    
}
