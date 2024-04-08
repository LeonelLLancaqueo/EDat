/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HouseEscape;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Desafio {
    //puntaje que otorga, nombre, tipo (lógico, matemático, búsqueda, destreza, etc). No puede haber desafíos con puntajes iguales.
    private int puntaje;
    private String nombre, tipo;
    
    public Desafio(int puntaje, String nombre, String tipo){
        this.puntaje= puntaje;
        this.nombre= nombre;
        this.tipo= tipo;
    }

    public int getPuntaje() {
        return puntaje;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Desafio{" + "puntaje=" + puntaje + ", nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
}
