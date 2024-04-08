/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrelacionistas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoVert {
    private Object elem;
    private NodoVert sigVertice;
    private NodoAdyEtiquetado primerAdy;
    
    public NodoVert(Object nElem, NodoVert nSig){
        this.elem= nElem;
        this.sigVertice= nSig;
        this.primerAdy= null;
    }

    public Object getElem() {
        return elem;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }

    public NodoAdyEtiquetado getPrimerAdy() {
        return this.primerAdy;
    }

    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setSigVertice(NodoVert sigVertice) {
        this.sigVertice = sigVertice;
    }

    public void setPrimerAdy(NodoAdyEtiquetado primerAdy) {
        this.primerAdy = primerAdy;
    }
    public boolean equals(NodoVert otroVertice){
        return this.elem.equals(otroVertice.getElem());
    }
    public String toString(){
        return elem.toString();
    }
    
}
