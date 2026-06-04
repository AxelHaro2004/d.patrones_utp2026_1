package Envios;

/*Patrón Builder*/

public class EnvioBuilder {
    private String codigo;
    private String origen;
    private String destino;
    private double peso;

    public void setCodigo(String codigo) {        this.codigo = codigo;    }
    public void setOrigen(String origen) {        this.origen = origen;    }
    public void setDestino(String destino) {        this.destino = destino;    }
    public void setPeso(double peso) {        this.peso = peso;    }
    
    public Envio build() {
        return new Envio(codigo,origen,destino,peso);
    }
}
