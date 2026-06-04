package Servicios;
public class ServicioExpress extends ServicioDeEnvio{

    public ServicioExpress(String nombreServicio) {
        super(nombreServicio);
    }

    @Override
    public AtributosServicio establecerAtributos() {
        return new AtributosServicio(){
            @Override
            public String Fase(){
                return "Despacho Inmediato -> Transito Prioritario -> Clasificacion Automatizada -> Reparto";
            }
            @Override
            public int TiempoEstimado(){
                return 12;
            }
        };
    }
}
