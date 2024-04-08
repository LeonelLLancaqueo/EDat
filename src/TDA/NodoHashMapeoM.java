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
public class NodoHashMapeoM {
    private Object dominio;
    private Lista rango;
    private NodoHashMapeoM enlace;
    
    public NodoHashMapeoM(Object dominio, Object elemntoRango){
        this.dominio=  dominio;
        this.rango= new Lista();
        this.rango.insertar(elemntoRango, 1);
    }
    public Object getDominio(){
        return this.dominio;
    }
    public Lista getRango(){
        return this.rango;
    }
    public void setElemRango(Object elemRango){
        this.rango.insertar(elemRango, this.rango.longitud()+1);
    }
    public NodoHashMapeoM getEnlace(){
        return this.enlace;
    }
    public void setEnlace(NodoHashMapeoM enlace){
        this.enlace= enlace;
    }
    public String toString(){
        return "Dominio: "+ this.dominio + " Rango: "+ this.rango.toString();
    }
}
