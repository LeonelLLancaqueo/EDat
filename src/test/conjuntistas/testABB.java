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
public class testABB {
    public static void main(String[] args) {
        ArbolBB unArbol= new ArbolBB();
        unArbol.insertar(15);
        unArbol.insertar(9);
        unArbol.insertar(20);
        unArbol.insertar(6);
        unArbol.insertar(14);
        unArbol.insertar(13);
        unArbol.insertar(17);
        unArbol.insertar(64);
        unArbol.insertar(26);
        unArbol.insertar(72);
        
        System.out.println("elemento min: " + unArbol.minimoElem());
        System.out.println("lo elimino"+ unArbol.eliminarMinimo());
        /*System.out.println("elemento max: " + unArbol.maximoElem());
        System.out.println("pertence 72: "+ unArbol.pertenece(72));
        System.out.println("listarRango 4-12: "+ unArbol.listarRango(10, 15).toString());
        System.out.println("lista: "+ unArbol.listar().toString());
        System.out.println("eliminar 64: " + unArbol.eliminar(64));
        System.out.println("eliminar 72: " + unArbol.eliminar(72));
        System.out.println("elemento max: " + unArbol.maximoElem());
        System.out.println("lista: "+ unArbol.listar().toString());
        
        System.out.println(unArbol.toString());
        System.out.println("elemento min: " + unArbol.minimoElem());
        System.out.println("lo elimino"+ unArbol.eliminarMinimo());
        System.out.println(unArbol.toString());*/
        System.out.println("Listar mayores que 20: "+ unArbol.listarMayores(12,15).toString());
    }
}
