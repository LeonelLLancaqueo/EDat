/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Nodo {
    private Object elem;
    private Nodo enlace;
    
    public Nodo(Object nelem){
        this.elem= nelem;
        this.enlace= null;
    }
    public Object getElemento(){
        return this.elem;
    }
    public void setElemento(Object nelem){
        this.elem= nelem;
    }
    public Nodo getEnlace(){
        return this.enlace;
    }
    public void setEnlace(Nodo enlace){
        this.enlace= enlace;
    }
    public String toString(){
        return this.elem.toString();
    }
}   
