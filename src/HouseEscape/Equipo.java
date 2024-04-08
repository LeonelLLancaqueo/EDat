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
public class Equipo {
    //nombre del equipo, puntaje exigido para salir de la casa, puntaje total (acumulado en lo que va del juego), 
    //habitación en la que se encuentran actualmente y puntaje actual (acumulado dentro de la habitación en donde están ubicados).
    private String nombre;
    private int puntajeSalida, puntajeActual, habitacionActual, puntajeTotal;
    
    public Equipo(String nombre, int puntajeSalida, int puntajeTotal, int habitacionActual, int puntajeActual){
        this.nombre= nombre;
        this.puntajeSalida= puntajeSalida;
        this.puntajeTotal= puntajeTotal;
        this.habitacionActual=habitacionActual;
        this.puntajeActual= puntajeActual;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeSalida() {
        return puntajeSalida;
    }

    public void setPuntajeSalida(int puntajeSalida) {
        this.puntajeSalida = puntajeSalida;
    }

    public int getPuntajeActual() {
        return puntajeActual;
    }
    public void sumarPuntos(int p){
        this.puntajeActual+= p;
        this.puntajeTotal+= p;
    }
    public void restarPuntos(int p){
        this.puntajeActual -= p;
    }

    public void setPuntajeActual(int puntajeActual) {
        this.puntajeActual = puntajeActual;
    }

    public int getHabitacionActual() {
        return habitacionActual;
    }

    public void setHabitacionActual(int habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
    
    public String toString(){
        return "nombre: "+ nombre+" Puntaje salida: "+ puntajeSalida+ " Puntaje total: "+ puntajeTotal+ " Habitacion: "+ habitacionActual+" PuntajeActual :" + puntajeActual;
    }
    
}
