/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolGen;

/**
 *
 * @author Leonel LLancaqueo
 */
public class TestEsHermanoPosterior {
    public static void main(String[] args) {
        ArbolGen a= new ArbolGen();
        
        a.insertar('z', 'z');
        a.insertar('m', 'z');
        a.insertar('f', 'z');
        a.insertar('h', 'z');
        a.insertar('x', 'z');
        a.insertar('k', 'x');
        a.insertar('h', 'x');
        a.insertar('t', 'h');
        a.insertar('ñ', 'h');
        a.insertar('h', 'h');


        
        System.out.println("arbol: " + a.toString());
        System.out.println("esHer..: "+ a.esHermanoPosterior('h', 't'));
    }
}
