/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author Leonel LLancaqueo
 */
public class testLista {
    public static void main(String[] args) {
        Lista unaLista= new Lista();
        /*PRIMERO TESTEAMOS EL METODO INSERTAR*/
        unaLista.insertar(694,1);
        unaLista.insertar(536,2);
        unaLista.insertar(632,3);
        unaLista.insertar(985,4);
        unaLista.insertar(231,5);
        unaLista.insertar(986,6);
        unaLista.insertar(222,7);
        System.out.println("lista: "+ unaLista.toString());
        unaLista.insertar(111,1);
        unaLista.insertar(222,2);
        unaLista.insertar(333,3);
        unaLista.insertar(444,4);
        unaLista.insertar(555,5);
        unaLista.insertar(666,6);
        unaLista.insertar(777,7);
        System.out.println("lista: "+ unaLista.toString());
        System.out.println("localizar elemento 986:  " + unaLista.localizar(986));
        System.out.println("recuperamos el elemento 986: "+ unaLista.recuperar(unaLista.localizar(986)));
        /*AHORA TESTEAMOS EL METODO ELIMINAR*/
        System.out.println("Espera true: "+ unaLista.eliminar(7));/*ELIMINA EL ELEMENTO 222*/
        System.out.println("lista: "+ unaLista.toString());
        System.out.println("Espera true: "+ unaLista.eliminar(7));/*ELIMINA EL ELEMENTO 111*/
        System.out.println("lista: "+ unaLista.toString());
        System.out.println("Eliminamos el primer elemento ---> Espera true: "+ unaLista.eliminar(1));/*ELIMINA EL PRIMER ELEMENTO*/
        System.out.println("lista: "+ unaLista.toString());
        System.out.println("Eliminamos el ultimo elemento ---> Espera true: "+ unaLista.eliminar(unaLista.longitud()-1)); /*ELIMINA EL ULTIMO ELEMENTO*/
        System.out.println("lista: "+ unaLista.toString());
        Lista otraLista= unaLista.clone();/*CREAMOS UNA LISTA CLON DE LA ORIGINAL*/
        System.out.println("Lista clon: "+ otraLista.toString());/*VISUALIZAMOS LA LISTA CLON*/
        /*PROBAREMOS LA LISTA CLONE*/
        otraLista.vaciar();/*VACIAMOS LA LISTA Y OPERAMOS NUEVAMENTE INSERTANDO Y DESAPILANDO ELEMENTOS*/
        System.out.println("Lista clon: "+ otraLista.toString());
        System.out.println("Eliminamos espera false: "+ otraLista.eliminar(1) );
        System.out.println("Eliminamos espera false: "+ otraLista.eliminar(2) );
        System.out.println("lista Orignial: "+ unaLista.toString());/*VERIFICAMOS QUE NO SE HAYA MODIFICADO LA LISTA ORIGINAL*/
        System.out.println("Insertamos en lista clon: "+ otraLista.insertar(222, 1));
        System.out.println("Insertamos en lista clon: "+ otraLista.insertar(222, 2));
        System.out.println("Insertamos en lista clon: "+ otraLista.insertar(222, 3));
        System.out.println("lista Orignial: "+ unaLista.toString());/*VERIFICAMOS QUE NO SE HAYA MODIFICADO LA LISTA ORIGINAL*/
        System.out.println("lista clon: "+ otraLista.toString());/*VERIFICAMOS Q SE HAYAN REALIZADO LOS CAMBIOS EN LA LISTA CLON*/
        
        
    }
}
