/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrelacionistas;

import java.util.Objects;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoAdy {
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    
    public NodoAdy(NodoVert nV){
        this.vertice= nV;
        this.sigAdyacente= null;
    }

    public NodoVert getVertice() {
        return vertice;
    }

    public NodoAdy getSigAdyacente() {
        return sigAdyacente;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public void setSigAdyacente(NodoAdy sigAdyacente) {
        this.sigAdyacente = sigAdyacente;
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
        final NodoAdy other = (NodoAdy) obj;
        if (!Objects.equals(this.vertice, other.vertice)) {
            return false;
        }
        return true;
    }
    
}
