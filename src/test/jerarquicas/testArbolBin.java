/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolBin;
//import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testArbolBin {
    public static void main(String[] args) {
        /*
        ArbolBin unArbol= new ArbolBin();
        System.out.println("Inserto ----> "+ unArbol.insertar(6, 1, 'I')); //VERIFICAR QUE CHAR SEA ACEPTABLE
        System.out.println("Inserto ----> "+ unArbol.insertar(2, 6, 'I'));
        System.out.println("Inserto ----> "+ unArbol.insertar(1, 2, 'I'));
        System.out.println("Inserto ----> "+ unArbol.insertar(4, 2, 'D'));
        System.out.println("Inserto ----> "+ unArbol.insertar(3, 4, 'I'));
        System.out.println("Inserto ----> "+ unArbol.insertar(5, 4, 'D'));
        System.out.println("Inserto ----> "+ unArbol.insertar(7, 6, 'D'));
        System.out.println("Inserto ----> "+ unArbol.insertar(8, 7, 'D'));
        */
        /*
        Lista lis= new Lista();
        lis.insertar(6, 1);
        lis.insertar(2, 2);
        lis.insertar(4, 3);
        //lis.insertar(5, 4);
        //lis.insertar(lis, 5);
        System.out.println("verificar patron: "+ unArbol.verificarPatron(lis)+"\n");
        System.out.println("frontera: " + unArbol.frontera().toString());
        */
        /*
        System.out.println("arbol original: " + unArbol.toString());
        System.out.println("arbol clonInvertido: " + unArbol.clonarInvertido().toString());
        */

        /*
        System.out.println("Arbol Bin listado en Preorden: "+ unArbol.listarPreorden().toString());
        System.out.println("Arbol Bin listado en Inorden: "+ unArbol.listarInorden().toString());
        System.out.println("Arbol Bin listado en Posorden: "+ unArbol.listarPosorden().toString());
        
        System.out.println("Altura ArbolBinario: " + unArbol.alturaArbolBinario());
        */
        /*
        ArbolBin unArbol2= new ArbolBin();
        System.out.println("Inserto ----> "+ unArbol2.insertar(6, 1, 'I')); //VERIFICAR QUE CHAR SEA ACEPTABLE
        System.out.println("Inserto ----> "+ unArbol2.insertar(2, 6, 'I'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(1, 2, 'I'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(4, 2, 'D'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(3, 4, 'I'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(5, 4, 'D'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(7, 6, 'D'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(8, 7, 'D'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(9, 5, 'D'));
        System.out.println("Inserto ----> "+ unArbol2.insertar(10, 9, 'D'));
        
        System.out.println("Altura ArbolBinario: " + unArbol2.alturaArbolBinario());
        
        System.out.println("Elemento  de nodoPadre de nodoHijo con elemento 5(unArbol): "+ unArbol.Padre(8) );
        
        //PROBAMOS EL CLONE()
        ArbolBin arbolBinClon= unArbol.clone();
        //LO RECORREMOS
        System.out.println("Arbol Bin listado en Preorden: "+ arbolBinClon.listarPreorden().toString());
        System.out.println("Arbol Bin listado en Inorden: "+ arbolBinClon.listarInorden().toString());
        System.out.println("Arbol Bin listado en Posorden: "+ arbolBinClon.listarPosorden().toString());
       
        System.out.println("Inserto ----> "+ arbolBinClon.insertar(9, 5, 'D'));
        System.out.println("Inserto ----> "+ arbolBinClon.insertar(10, 9, 'D'));
        
        System.out.println("Arbol original listado en Preorden: "+ unArbol.listarPreorden().toString());
        System.out.println("Arbol clon listado en Preorden: "+ arbolBinClon.listarPreorden().toString());
        */
        
        ArbolBin a= new ArbolBin();
        a.insertar(34, 1, 'D');
        a.insertar(25, 34, 'I');
        a.insertar(17, 34, 'D');
        a.insertar(71, 25, 'I');
        a.insertar(12, 17, 'I');
        a.insertar(23, 17, 'D');
        a.insertar(63, 71, 'D');
        
        ArbolBin b= new ArbolBin();
        a.insertar(34, 1, 'D');
        a.insertar(25, 34, 'I');
        a.insertar(17, 34, 'D');
        a.insertar(71, 25, 'I');
        a.insertar(12, 17, 'I');
        a.insertar(23, 17, 'D');
        //a.insertar(63, 71, 'D');
        
        ArbolBin c= new ArbolBin();
        a.insertar(34, 1, 'D');
        a.insertar(25, 34, 'I');
        a.insertar(67, 34, 'D');
        a.insertar(71, 25, 'I');
        a.insertar(12, 17, 'I');
        a.insertar(23, 17, 'D');
        a.insertar(63, 71, 'D');
        
        ArbolBin aClon= a.clone();
        System.out.println("arbol a y b son iguales: " + a.verificarIguales(b));
        System.out.println("arbol a y c son iguales: " + a.verificarIguales(c));
        System.out.println("arbol a y aClon son iguales: " + a.verificarIguales(aClon));
    }
}
