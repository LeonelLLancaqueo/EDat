/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;
import conjuntistas.ArbolBB;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testClonInvertido {
    public static void main(String[] args) {
        ArbolBB unArbol = new ArbolBB();
        unArbol.insertar(25);
        unArbol.insertar(15);
        unArbol.insertar(41);
        unArbol.insertar(7);
        unArbol.insertar(11);
        unArbol.insertar(35);
        unArbol.insertar(45);
        unArbol.insertar(31);
        unArbol.insertar(37);
        unArbol.insertar(47);
        
        System.out.println("unArbol: "+ unArbol.toString());
        //System.out.println("arbolColInvertido: "+ unArbol.clonarParteInvertida(13).toString());
        System.out.println(" suma: " + unArbol.sumarPosordenDesde(35, 110));
        
        
    }
    
}
