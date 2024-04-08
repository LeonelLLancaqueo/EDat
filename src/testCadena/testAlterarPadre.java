/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCadena;
import jerarquicas.ArbolBin;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testAlterarPadre {
    
    public static void main(String[] args) {
        ArbolBin unArbol= new ArbolBin();
        unArbol.insertar(45, 2, 'f');
        unArbol.insertar(32, 45, 'I');
        unArbol.insertar(63, 45, 'D');
        unArbol.insertar(3, 32, 'I');
        unArbol.insertar(5, 32, 'D');
        unArbol.insertar(2, 3, 'D');
        unArbol.insertar(87, 63, 'D');
        unArbol.insertar(20, 87, 'I');
        
        System.out.println("listar Arbol: " + unArbol.toString());
        
        unArbol.alterarPadre(50, 96, 63);
        System.out.println("listar Arbol nuevo: " + unArbol.toString());
    }
}
