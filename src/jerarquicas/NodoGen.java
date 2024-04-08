/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoGen {
    private Object elem;
    private NodoGen HEI;
    private NodoGen HD;
    
    public NodoGen(Object unElem, NodoGen unNodoIzquierdo, NodoGen unNodoDerecho){
        this.elem= unElem;
        this.HEI= unNodoIzquierdo;
        this.HD= unNodoDerecho;
    }
    public Object getElemento(){
        return this.elem;
    }
    public NodoGen getHijoIzquierdo(){
        return this.HEI;
    }
    public NodoGen getHermanoDerecho(){
        return this.HD;
    }
    public void setElemento(Object unelemento){
        this.elem= unelemento;
    }
    
    public void setHijoIzquierdo(NodoGen unNodoGen){
        this.HEI= unNodoGen;
    }
    public void setHermanoDerecho(NodoGen unNodoGen ){
        this.HD= unNodoGen;
    }
    
}
