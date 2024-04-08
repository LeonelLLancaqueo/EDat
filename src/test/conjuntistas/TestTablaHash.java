/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;
import conjuntistas.TablaHash;
/**
 *
 * @author Leonel LLancaqueo
 */
public class TestTablaHash {
    public static void main(String[] args) {
        TablaHash n= new TablaHash();
        
        n.insertar(1);
        n.insertar(2);
        n.insertar(3);
        n.insertar(4);
        n.insertar(5);
        n.insertar(6);
        n.insertar(7);
        n.insertar(8);
        n.insertar(9);
        n.insertar(40);
        n.insertar(51);
        n.insertar(66);
        n.insertar(23);
        n.insertar(71);
        n.insertar(69);
        n.insertar(16);
        n.insertar(13);
        n.insertar(35);
        n.insertar(47);
        n.insertar(88);
        
        
        System.out.println("lista de elementos tabla hash: "+ n.listar().toString());
        System.out.println("lista de elementos tabla hash: "+ n.toString());
        System.out.println("es vacia?: "+n.esVacia());
        System.out.println("buscar 88: " + n.pertenece(88) );
    }
}
