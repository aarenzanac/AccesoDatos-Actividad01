/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad01accesodatos;

/**
 *
 * @author alex
 */
public class MiIncidencia {
    
    private String fechaHora;
    private String origen;
    private String destino;
    private String detalle;
    private String tipo;
    
    public MiIncidencia(){
    }
    
    public MiIncidencia(String fechaHora, String origen, String destino, String detalle, String tipo){
    this.fechaHora = fechaHora;
    this.origen = origen;
    this.destino = destino;
    this.detalle = detalle;
    this.tipo = tipo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Fecha: " + fechaHora + " -- Origen: " + origen + " -- Destino: " + destino + " -- Detalle: " + detalle + " -- Tipo: " + tipo;
    }
    
    
}
