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
public class NodoABB {
    private Comparable elemento;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    public NodoABB(Comparable unElemento){
       this.elemento= unElemento;
       this.izquierdo= null;
       this.derecho= null;
    }
    public Comparable getElemento(){
        return this.elemento;
    }
    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }
    public NodoABB getDerecho(){
        return this.derecho;
    }
    public void setElemento(Comparable unElemento){
        this.elemento= unElemento;
    }
    public void setIzquierdo(NodoABB unNodoArbol){
        this.izquierdo= unNodoArbol;
    }
    public void setDerecho(NodoABB unNodoArbol){
        this.derecho= unNodoArbol;
    }
}
