package Envios;
import java.util.ArrayList;
import java.util.List;

/*Principio SRP
  Patrón Prototype*/

public class Envio implements Cloneable, ComponenteEnvio//, 04/06: Se agregó ComponenteEnvio (Composite) para permitir que Envio forme parte de una estructura de envíos compuestos (Eso lo puso el copilot de vscode xd)
{
    private String codigo;
    private String origen;
    private String destino;
    private double peso;
    private String estadoActual;

    public Envio(String codigo, String origen, String destino, double peso) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.estadoActual = "Registrado";
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getOrigen() {
        return origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    public String getDestino() {
        return destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getEstadoActual() {
        return estadoActual;
    }
    
    public void setEstado(String nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }
    
    @Override
    public Envio clone(){
        try{
            return (Envio)super.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("Error de clonación: ",e);
        }
    }
    //04:06: Nuevos overrides para implementar ComponenteEnvio (Composite)
    @Override
    public double getPesoTotal() {
        return this.peso;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Envio: " + codigo + " // " + origen + " -> " + destino + " // " + peso + "kg");
    }
}