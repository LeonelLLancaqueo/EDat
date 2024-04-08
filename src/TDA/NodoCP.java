/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;
import lineales.dinamicas.Cola;
/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoCP {
    private Cola items;
    private int prioridad;
    private NodoCP enlace;
    
    public NodoCP(int prioridad){
        this.items= new Cola();
        this.enlace= null;
        this.prioridad= prioridad;
    }
    public Cola getItem(){
        return this.items;
    }
    public void setElemento(Cola items){
        this.items= items;
    }
    public NodoCP getEnlace(){
        return this.enlace;
    }
    public void setEnlace(NodoCP enlace){
        this.enlace= enlace;
    }
    public String toString(){
        return this.items.toString();
    }
    public int getPrioridad(){
        return this.prioridad;
    }
}
