package Servicios;

/*Principio OCP
  Patrón Factory Method*/

public abstract class ServicioDeEnvio {
    private String nombreServicio;

    public ServicioDeEnvio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }
    
    public abstract AtributosServicio establecerAtributos();
    
    public void procesarEnvio(String codigo){
        AtributosServicio atri = establecerAtributos();
        System.out.println("Procesando "+codigo+" via "+nombreServicio);
        System.out.println("Fase: "+atri.Fase()+"\nTiempo estimado: "+atri.TiempoEstimado()+" horas");
    }
}
