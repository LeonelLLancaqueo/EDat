/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrelacionistas;
import interrelacionistas.NodoAdy;
import java.util.Objects;
/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoAdyEtiquetado{
    /* CAMBIAR A INT*/
    private Object etiqueta;
    private NodoVert vertice;
    private NodoAdyEtiquetado sigAdyacente;
    
    public NodoAdyEtiquetado( NodoVert nV){
        this.vertice= nV;
        this.etiqueta= null;
    }
    public NodoAdyEtiquetado( NodoVert nV, Object unEtiqueta){
        this.sigAdyacente= null;
        this.vertice= nV;
        this.etiqueta= unEtiqueta;
    }

    public NodoVert getVertice() {
        return vertice;
    }
    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }
    public Object getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(Object etiqueta) {
        this.etiqueta = etiqueta;
    }
    public void setSigAdyacente(NodoAdyEtiquetado n){
        this.sigAdyacente= n;
    }
    public NodoAdyEtiquetado getSigAdyacente() {
        return this.sigAdyacente;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoAdyEtiquetado other = (NodoAdyEtiquetado) obj;
        if (!Objects.equals(this.vertice, other.vertice)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
        return vertice.getElem() +" "+ etiqueta;
    }
}
