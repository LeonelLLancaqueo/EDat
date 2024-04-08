/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;

import conjuntistas.ArbolHeap;

/**
 *
 * @author Leonel LLancaqueo
 */
public class testHeap {
    public static void main(String[] args) {
        ArbolHeap unHeap= new ArbolHeap(10);
        unHeap.insertar(300);
        unHeap.insertar(250);
        unHeap.insertar(10);
        unHeap.insertar(150);
        unHeap.insertar(50);
        System.out.println("toString: "+ unHeap.toString());
        unHeap.eliminarCima();
        System.out.println("toString: "+ unHeap.toString());
        unHeap.insertar(20);
        unHeap.insertar(70);
        System.out.println("toString: "+ unHeap.toString());
        unHeap.insertar(1);
        System.out.println("toString: "+ unHeap.toString());
    }
}
