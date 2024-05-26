/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.Cola;

/**
 *
 * @author Leonel LLancaqueo
 */
public class testColaDinamica {
    public static void main(String[] args) {
        Cola unaColaDinamica= new Cola();
        unaColaDinamica.poner(1);
        unaColaDinamica.poner(2);
        unaColaDinamica.poner(3);
        unaColaDinamica.poner(4);
        unaColaDinamica.poner(5);
        System.out.println("cola: "+ unaColaDinamica.toString());
        unaColaDinamica.sacar();
        System.out.print("sacamos al elemento frente espera: 2 3 4 5 ");
        System.out.println("cola: "+ unaColaDinamica.toString());      
        unaColaDinamica.poner('a');
        unaColaDinamica.poner('b');
        System.out.println("cola: "+ unaColaDinamica.toString());
        System.out.println("A continuacion sacamos todos los elementos: ");
        System.out.print("espera true: "+ unaColaDinamica.sacar());
        System.out.print("espera true: "+ unaColaDinamica.sacar());
        System.out.print("espera true: "+ unaColaDinamica.sacar());
        System.out.print("espera true: "+ unaColaDinamica.sacar());
        System.out.print("espera true: "+ unaColaDinamica.sacar());
        System.out.print("espera true: "+ unaColaDinamica.sacar());
        System.out.print("\nespera false: "+ unaColaDinamica.sacar());
        System.out.print("\nespera false: "+ unaColaDinamica.sacar());
        System.out.println("cola: "+ unaColaDinamica.toString());
        System.out.println("la cola esta vacia: " + unaColaDinamica.esVacia());
        
        System.out.println("prueba de cola clone: ");
        Cola unaNuevaColaDinamica= unaColaDinamica.clone();
        System.out.println("cola: " + unaNuevaColaDinamica.toString());
        unaNuevaColaDinamica.poner(3);
        unaNuevaColaDinamica.poner(3);
        unaNuevaColaDinamica.poner(3);
        unaNuevaColaDinamica.poner(3);
        unaNuevaColaDinamica.sacar();
        unaNuevaColaDinamica.sacar();
        unaNuevaColaDinamica.poner(5);
        unaNuevaColaDinamica.poner(5);
        System.out.println("cola clone: "+ unaNuevaColaDinamica.toString());
        System.out.println("cola original:" + unaColaDinamica.toString());
    }
}
