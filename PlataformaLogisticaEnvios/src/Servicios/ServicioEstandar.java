package Servicios;
public class ServicioEstandar extends ServicioDeEnvio{

    public ServicioEstandar(String nombreServicio) {
        super(nombreServicio);
    }

    @Override
    public AtributosServicio establecerAtributos() {
        return new AtributosServicio(){
            @Override
            public String Fase(){
                return "Recepcion -> Almacen Central -> Centro de Distribucion -> Clasificacion de Paquetes -> Ruta Regional";
            }
            @Override
            public int TiempoEstimado(){
                return 24;
            }
        };
    }
}
