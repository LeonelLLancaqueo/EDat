/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.estaticas.Cola;

/**
 *
 * @author Leonel LLancaqueo
 */
public class testCola {
    
    public static void main(String[] args) {
        /*EN ESTE ALGITMO TESTEAREMOS LA CLASE COLA IMPLEMENTADO SUS PRINCIPALES CONDUCTAS*/
        Cola unaCola= new Cola(10);
        System.out.println("Estado de la cola: "+ unaCola.toString());
        System.out.println("La cola esta vacia?: "+ unaCola.esVacia());
        System.out.println("1Apilar "+ unaCola.poner(1));
        System.out.println("2Desapilar "+ unaCola.sacar());
        System.out.println("3Desapilar "+ unaCola.sacar());
        System.out.println("4Apilar "+ unaCola.poner(2));
        System.out.println("5Apilar "+ unaCola.poner(3));
        System.out.println("6Apilar "+ unaCola.poner(4));
        System.out.println("Estado de la cola: "+ unaCola.toString());
        System.out.println("La cola esta vacia?: "+ unaCola.esVacia());
        Cola otraCola= unaCola.clone();
        System.out.println("Estado de la cola: "+ otraCola.toString());
        System.out.println("7Apilar "+ otraCola.poner(5));
        System.out.println("8Apilar "+ otraCola.poner(6));
        System.out.println("9Apilar "+ otraCola.poner('a'));
        System.out.println("10Desapilar "+ unaCola.sacar());
        System.out.println("11Desapilar "+ unaCola.sacar());
        System.out.println("12Desapilar "+ unaCola.sacar());
        System.out.println("13Desapilar "+ unaCola.sacar());
        System.out.println("14Desapilar "+ unaCola.sacar());
        System.out.println("15Desapilar "+ unaCola.sacar());
        System.out.println("16Desapilar "+ unaCola.sacar());
        System.out.println("17Apilar "+ otraCola.poner('a'));
        System.out.println("18Desapilar "+ unaCola.sacar());
        System.out.println("19Apilar "+ otraCola.poner('b'));
        System.out.println("20Desapilar "+ unaCola.sacar());
        System.out.println("21Apilar "+ otraCola.poner('c'));
        System.out.println("22Desapilar "+ unaCola.sacar());
        System.out.println("23Apilar "+ otraCola.poner('d'));
        System.out.println("24Desapilar "+ unaCola.sacar());
        System.out.println("25Apilar "+ otraCola.poner('e'));
        System.out.println("26Desapilar "+ unaCola.sacar());
        System.out.println("27Estado de la cola: "+ otraCola.toString());
    }
}
