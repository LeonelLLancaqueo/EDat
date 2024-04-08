/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.estaticas.Pila;

/**
 *
 * @author Leonel LLancaqueo
 */
public class TestPila {
    public static boolean esCapicua(Pila pila){
        /*ESTE METODO VERIFICA SI UNA PILA QUE ALMACENA ENTEROS ES CAPICUA*/
        /*SE CREA UNA PILA AUXILIAR Y SE RECORRE A AMBAS PERO DE MANERA INVERSA MIENTRAS LOS ELEMENTOS
        TENGAN EL MISMO VALOR*/
        Pila pilaAux= pila.clone();
        Pila pilaAux2= pila.clone();
        pilaAux.vaciar();
        boolean esCapicua = true;
        int i=0;
        int k=0;
        boolean continuar= true;
        while(pila.esVacia() != true){
                pilaAux.apilar(pila.obtenerTope());
                pila.desapilar();
                System.out.println("jejeje");
                
        }
        System.out.println("ahhaha");
        /*ALGO ESTA MALL XDDD*/
        while(!(pilaAux.esVacia()) && continuar  ){
            if(!(pilaAux.obtenerTope() == pilaAux2.obtenerTope())){
                continuar= false;
                esCapicua= false;
            }
            pilaAux.desapilar();
            pilaAux2.desapilar();
            System.out.println("looooool");
        }
        return esCapicua;
    }
    public static void main(String[] args) {
        /*
        System.out.println("Ingrese la cantidad de celdas que quiere que tenga la pila: ");
        int tamanio= TecladoIn.readInt();
        Pila pila= new Pila(tamanio);
        System.out.println("la pila esta vacia?: " + pila.esVacio());
        int arreglo[]= {1,2,3};
        pila.apilar(arreglo);
        pila.apilar(1);
        
        pila.apilar(2);
        
        pila.apilar(3);
        
        System.out.println("la pila esta vacia?: " + pila.esVacio());
        System.out.println("el ultimo elemento de la pila es: "+ pila.obtenerTope());
        
        System.out.println("el elemento buscado se encuentra en la posicion: "+ pila.localizar(3));
        
        */
        Pila pila= new Pila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(1);
        System.out.println("La pila es capicua: "+ esCapicua(pila));
    }
}
