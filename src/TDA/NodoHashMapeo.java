/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import lineales.dinamicas.Lista;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoHashMapeo {
    private Object dominio;
    private Object rango;
    private NodoHashMapeo enlace;
    
    public NodoHashMapeo(Object dominio, Object elemntoRango){
        this.dominio=  dominio;
        this.rango= elemntoRango;
    }
    public Object getDominio(){
        return this.dominio;
    }
    public Object getRango(){
        return this.rango;
    }
    public void setElemRango(Object elemRango){
        this.rango= elemRango;
    }
    public NodoHashMapeo getEnlace(){
        return this.enlace;
    }
    public void setEnlace(NodoHashMapeo enlace){
        this.enlace= enlace;
    }
    public String toString(){
        return "Dominio: "+ this.dominio + " Rango: "+ this.rango.toString();
    }
}
