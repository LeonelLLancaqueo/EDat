/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testMultiploLista {
    public static void main(String[] args) {
        Lista unaLista= new Lista();
        unaLista.insertar('A', 1);
        unaLista.insertar('B', 2);
        unaLista.insertar('C', 3);
        unaLista.insertar('D', 4);
        unaLista.insertar('E', 5);
        unaLista.insertar('F', 6);
        unaLista.insertar('G', 7);
        unaLista.insertar('H', 8);
        unaLista.insertar('I', 9);
        unaLista.insertar('J', 10);
        /*Arbol bin*/
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(6, 6, 'r');
        arbol.insertar(2, 6, 'I');
        arbol.insertar(7, 6, 'D');
        arbol.insertar(1, 2, 'I');
        arbol.insertar(4, 2, 'D');
        arbol.insertar(3, 4, 'I');
        arbol.insertar(5, 4, 'D');
        arbol.insertar(8, 7, 'D');
        /*          6
            2               7
       1          4                8
               3     5
        
        */
        
        // System.out.println("lista con multiplos de 3: "+ unaLista.obtenerMultiplos(3).toString());
        System.out.println("decendientes del elemento 4: " + arbol.obtenerDecendientes(4).toString());
    }
}
