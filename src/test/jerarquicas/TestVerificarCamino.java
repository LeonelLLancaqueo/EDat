/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author Leonel LLancaqueo
 */
public class TestVerificarCamino {
    public static void main(String[] args) {
        ArbolGen unArbol= new ArbolGen();
        
        unArbol.insertar(20, 1);
        unArbol.insertar(54, 20);
        unArbol.insertar(13, 20);
        unArbol.insertar(12, 13);
        unArbol.insertar(15, 13);
        unArbol.insertar(4, 54);//11
        unArbol.insertar(27, 54);
        unArbol.insertar(11, 54);
        unArbol.insertar(17, 27);
        Lista lis= new Lista();
        lis.insertar(20 ,1);
        lis.insertar(54 ,2);
        lis.insertar(5 ,3);
        //lis.insertar(17 ,4);
        //lis.insertar(45 ,4);
        System.out.println(unArbol.toString());
        System.out.println("verificar camino [20,54,27]: "+unArbol.verificarCamino(lis));
        System.out.println("listar entre nivles 1 y 2: "+ unArbol.listarEntreNiveles(0, 2).toString());
        
        System.out.println("eliminarConDecendientes: "+ unArbol.eliminarConDecendientes(17));
        System.out.println(unArbol.toString());
    
        System.out.println("insertar 3 en pos 2 con padre 20: "+ unArbol.insertarEnPosicion(3, 54, 2));
        System.out.println("unArbol toString : "+ unArbol.toString());
    }
}
