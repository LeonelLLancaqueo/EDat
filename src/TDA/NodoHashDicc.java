/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoHashDicc {
    private Object dato;
    private Object clave;
    private NodoHashDicc enlace;
    public NodoHashDicc(Object clave, Object dato){
        this.clave= clave;
        this.dato= dato;
    }

    public Object getClave() {
        return clave;
    }

    public NodoHashDicc getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoHashDicc enlace) {
        this.enlace = enlace;
    }
    
    public Object getDato() {
        return dato;
    }
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public String toString(){
        return this.dato.toString();
    }
    
}
