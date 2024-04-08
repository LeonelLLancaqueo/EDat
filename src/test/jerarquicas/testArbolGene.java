/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

//import jerarquicas.NodoGen;
import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testArbolGene {
    public static void main(String[] args) {
        ArbolGen unArbol= new ArbolGen();
        /*
        unArbol.insertar(1, 0);
        unArbol.insertar(2, 1);
        unArbol.insertar(3, 1);
        unArbol.insertar(4, 1);
        unArbol.insertar(15, 1);
        unArbol.insertar(21, 1);
        unArbol.insertar(5, 2);
        unArbol.insertar(6, 5);
        unArbol.insertar(7, 6);
        unArbol.insertar(7, 6);
        unArbol.insertar(7, 6);
        unArbol.insertar(7, 6);
        unArbol.insertar(7, 6);
        unArbol.insertar(7, 6);
        
        /*unArbol.insertar(8, 4);
        unArbol.insertar(9, 4);
        unArbol.insertar(10, 3);
        unArbol.insertar(11, 3);
        
        
        ArbolGen otroArbolGen= new ArbolGen();
        ArbolGen otroArbolGen2= new ArbolGen();
        otroArbolGen.insertar(1, 0);
        System.out.println("to string arbol: "+ unArbol.toString());
        System.out.println("listar en Inorden: "+ unArbol.listarInorden().toString());
        System.out.println("listar en Posorden: "+ unArbol.listarPosorden().toString());
        System.out.println("listar en Preorden: "+ unArbol.listarPreorden().toString());
        ArbolGen unArbolGenClon= unArbol.clone();
        System.out.println("to string arbol: "+ unArbolGenClon.toString());
        
        /*GRADO DE UN SUBARBOL
        System.out.println("grado de unArbol: "+ unArbol.grado());
        /*System.out.println("altura del arbol: "+ unArbol.altura());
        System.out.println("altura del arbol: "+ otroArbolGen.altura());
        System.out.println("altura del arbol: "+ otroArbolGen2.altura());
        System.out.println("nivel de 2: " + unArbol.nivel(2));
        System.out.println("nivel de 5: " + unArbol.nivel(5));
        System.out.println("nivel de 6: " + unArbol.nivel(6));
        System.out.println("nivel de 7: " + unArbol.nivel(7));
        System.out.println("nivel de 10: " + unArbol.nivel(10));
        System.out.println("ancestros de 7: " + unArbol.ancestro(7).toString());
        System.out.println("padre de 7: " + unArbol.padre(7));
        */
        
        unArbol.insertar(1, 0);
        unArbol.insertar(3, 1);
        unArbol.insertar(2, 1);
        unArbol.insertar(6, 3);
        unArbol.insertar(5, 2);
        unArbol.insertar(4, 2);
        unArbol.insertar(7, 5);
        unArbol.insertar(8, 6);
        unArbol.insertar(3, 6);
        
        System.out.println(unArbol.toString());
        Lista lis= new Lista();
        lis.insertar(1, lis.longitud()+1);
        lis.insertar(3, lis.longitud()+1);
        lis.insertar(6, lis.longitud()+1);
        lis.insertar(8, lis.longitud()+1);
        System.out.println("descendienteMasLejano: "+ unArbol.descendienteMasLejano(3));
        //System.out.println("verificar Patron: " +unArbol.verificarPatron(lis));
        //System.out.println("camino que justifica la altura: "+ unArbol.caminoJustificaAltura().toString());
        //System.out.println("camino a hoja mas cercana: " + unArbol.caminoAHojaMasCercana().toString() );
        
        
    }
    
}
