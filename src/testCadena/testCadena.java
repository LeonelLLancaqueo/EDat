/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCadena;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testCadena {

    public static Lista armarLista(Pila pila1){
        Pila pilaAux= new Pila();
        Cola colaAux= new Cola();
        Lista unaLista= new Lista();
        Pila pilaClone= pila1.clone();
        int cont;
        while(!(pilaClone.esVacia())){
            cont =0;
            while(!(pilaClone.esVacia()) && !(pilaClone.obtenerTope().equals('&'))){
                Object simbolo= pilaClone.obtenerTope();
                pilaAux.apilar(simbolo);
                colaAux.poner(simbolo);
                pilaClone.desapilar();
                cont++;
                System.out.println("pasa por aca1");
            }
            if(cont % 2 == 0 ){
                while(!(pilaAux.esVacia())){
                    unaLista.insertar(pilaAux.obtenerTope(), unaLista.longitud()+1);
                    pilaAux.desapilar();
                    System.out.println("pasa por aca2");
                }
                colaAux.vaciar();
            }else{
                while(!(colaAux.esVacia())){
                    unaLista.insertar(colaAux.obtenerFrente(), unaLista.longitud()+1);
                    colaAux.sacar();
                    System.out.println("pasa por aca3");
                }
                pilaAux.vaciar();
            }
            unaLista.insertar('&', unaLista.longitud()+1);
            pilaClone.desapilar();
        
        }
        
        return unaLista;
    }
    public static void main(String[] args) {
        
        Pila unaPila= new Pila();
        
        unaPila.apilar('D');
        unaPila.apilar('B');
        unaPila.apilar('E');
        unaPila.apilar('&');
        unaPila.apilar('F');
        unaPila.apilar('B');
        unaPila.apilar('D');
        unaPila.apilar('&');
        unaPila.apilar('E');
        unaPila.apilar('A');
        unaPila.apilar('C');
        unaPila.apilar('&');
        unaPila.apilar('B');
        unaPila.apilar('A');
        
        System.out.println("pila Original: "+ unaPila.toString());
        System.out.println("otraPila: "+ armarLista(unaPila).toString());
        
        
        /**
        Lista unaLista = new Lista();
        
        unaLista.insertar( 8 , unaLista.longitud()+1);
        unaLista.insertar( 1 , unaLista.longitud()+1);
        unaLista.insertar( 7 , unaLista.longitud()+1);
        unaLista.insertar( 6 , unaLista.longitud()+1);
        unaLista.insertar( 1 , unaLista.longitud()+1);
        unaLista.insertar( 4 , unaLista.longitud()+1);
        unaLista.insertar( 1 , unaLista.longitud()+1);
        unaLista.insertar( 9 , unaLista.longitud()+1);
        
        System.out.println("to string original: "+ unaLista.toString());
        unaLista.insertarPosterior(1, 3);
        System.out.println("to string despues del metodo: "+ unaLista.toString() );
        **/
        
    }
}
