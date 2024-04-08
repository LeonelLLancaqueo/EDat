/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import lineales.dinamicas.Lista;
import jerarquicas.ArbolBin;
/**
 *
 * @author Leonel LLancaqueo
 */
public class newTestArbol {
    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        arbol.insertar(6, 6, 'r');
        arbol.insertar(2, 6, 'I');
        arbol.insertar(7, 6, 'D');
        arbol.insertar(1, 2, 'I');
        arbol.insertar(4, 2, 'D');
        arbol.insertar(3, 4, 'I');
        arbol.insertar(5, 4, 'D');
        arbol.insertar(8, 7, 'D');
        
        System.out.println("tostring arbol: "+ arbol.toString());
        
        Lista list = new Lista();
        list.insertar(6, 1);
        list.insertar(2, 2);
        list.insertar(4, 3);
        list.insertar(5, 4);
        System.out.println(list.toString());
        System.out.println("da..."+ arbol.verificarPatron(list));
        
        Lista list2 = new Lista();
        list2.insertar(6, 1);
        list2.insertar(2, 2);
        list2.insertar(4, 3);
        System.out.println(list2.toString());
        System.out.println("da..."+ arbol.verificarPatron(list2));
        
        Lista list3 = new Lista();
        list3.insertar(6, 1);
        list3.insertar(7, 2);
        list3.insertar(8, 3);
        System.out.println(list3.toString());
        System.out.println("da..."+ arbol.verificarPatron(list3));
        
        Lista list4 = new Lista();
        list4.insertar(6, 1);
        list4.insertar(7, 2);
        list4.insertar(8, 3);
        list4.insertar(9, 4);
        System.out.println(list4.toString());
        System.out.println("da..."+ arbol.verificarPatron(list4));
        
        Lista list5 = new Lista();
        list5.insertar(6, 1);
        list5.insertar(2, 2);
        list5.insertar(4, 3);
        list5.insertar(5, 4);
        list5.insertar(6, 5);
        System.out.println(list5.toString());
        System.out.println("da..."+ arbol.verificarPatron(list5));
    }
}
