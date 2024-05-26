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
public class Habitacion {
    private int codigo;
    private String nombre;
    private int planta;
    private double mtsCuadrados;
    private boolean salida;
    //nombre, planta, metros cuadrados, y si tiene o no salida al exterior de la casa
    //código, nombre, planta, metros cuadrados, tiene salida al exterior
    
    public Habitacion(int codigo, String nombre, int planta, double metrosCuadrados, boolean salida){
        this.codigo= codigo;
        this.mtsCuadrados= metrosCuadrados;
        this.nombre= nombre;
        this.planta= planta;
        this.salida= salida;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public double getMtsCuadrados() {
        return mtsCuadrados;
    }

    public void setMtsCuadrados(double mtsCuadrados) {
        this.mtsCuadrados = mtsCuadrados;
    }

    public boolean getSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }
    public boolean equals(Habitacion n){
        return this.codigo == n.getCodigo();
    }

    @Override
    public String toString() {
        return "Habitacion{" + "codigo=" + codigo + ", nombre=" + nombre + ", planta=" + planta + ", mtsCuadrados=" + mtsCuadrados + ", salida=" + salida + '}';
    }
    
    
}
