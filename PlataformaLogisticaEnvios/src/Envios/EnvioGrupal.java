package Envios;
import java.util.ArrayList;
import java.util.List;
//04/06: Clase para representar un envío grupal (Compuesto Composite)
public class EnvioGrupal implements ComponenteEnvio {
    private String codigoGrupo;
    private List<ComponenteEnvio> envios = new ArrayList<>();

    public EnvioGrupal(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public void agregar(ComponenteEnvio envio) { envios.add(envio); }
    public void eliminar(ComponenteEnvio envio) { envios.remove(envio); }

    @Override
    public String getCodigo() { return codigoGrupo; }

    @Override
    public double getPesoTotal() {
        double total = 0;
        for (ComponenteEnvio e : envios) total += e.getPesoTotal();
        return total;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Grupo: " + codigoGrupo + " (" + envios.size() + " envios, " + getPesoTotal() + "kg total)");
        for (ComponenteEnvio e : envios) {
            System.out.print("  -> ");
            e.mostrarDetalle();
        }
    }
}