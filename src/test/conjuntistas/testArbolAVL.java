/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;

import conjuntistas.ArbolAVL;

/**
 *
 * @author Leonel LLancaqueo
 */
public class testArbolAVL {
    public static void main(String[] args) {
        ArbolAVL unArbol= new ArbolAVL();
        unArbol.insertar(20);
        unArbol.insertar(15);
        unArbol.insertar(30);
        unArbol.insertar(12);
        unArbol.insertar(28);
        unArbol.insertar(35);
        unArbol.insertar(13);
        System.out.println("unArbol toString: "+ unArbol.toString());
        /*
        unArbol.eliminar(24);
        unArbol.eliminar(26);
        System.out.println("unArbol toString: "+ unArbol.toString());
        unArbol.insertar(20);
        System.out.println("unArbol toString: "+ unArbol.toString());
        unArbol.eliminar(14);
        System.out.println("unArbol toString: "+ unArbol.toString());
        */
    }
}
