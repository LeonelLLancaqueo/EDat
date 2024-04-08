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
public class NodoArbol {
    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol(Object unElemento){
       this.elemento= unElemento;
       this.izquierdo= null;
       this.derecho= null;
    }
    public Object getElemento(){
        return this.elemento;
    }
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    public void setElemento(Object unElemento){
        this.elemento= unElemento;
    }
    public void setIzquierdo(NodoArbol unNodoArbol){
        this.izquierdo= unNodoArbol;
    }
    public void setDerecho(NodoArbol unNodoArbol){
        this.derecho= unNodoArbol;
    }
    
}
