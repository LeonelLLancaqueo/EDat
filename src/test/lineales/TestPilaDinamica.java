/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.Fecha;
import lineales.dinamicas.Paciente;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Terreno;

/**
 *
 * @author Leonel LLancaqueo
 */
public class TestPilaDinamica {
    public static void main(String[] args) {
        Pila pilaDinamica= new Pila();
        Paciente unPaciente= new Paciente(43684498);
        Terreno unTerreno= new Terreno(6958);
        Fecha unaFecha= new Fecha();
        pilaDinamica.apilar(1);
        pilaDinamica.apilar(2);
        /*System.out.println("el ultimo elemento es: "+ pilaDinamica.obtenerTope());
        pilaDinamica.desapilar();
        System.out.println("el ultimo elemento es: "+ pilaDinamica.obtenerTope());
        pilaDinamica.desapilar();
        System.out.println("el ultimo elemento es: "+ pilaDinamica.obtenerTope());
        pilaDinamica.apilar(unaFecha);
        System.out.println("el ultimo elemento es: "+ pilaDinamica.obtenerTope());
        pilaDinamica.vaciar();
        System.out.println("el ultimo elemento es: "+ pilaDinamica.obtenerTope());
        */
        Pila otraPila= pilaDinamica.clone();
        System.out.println("to string: "+ otraPila.toString());
    }
}
