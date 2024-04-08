/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import Utiles.TecladoIn;
import lineales.dinamicas.Lista;
import lineales.estaticas.Cola;
import lineales.estaticas.Pila;

/**
 *
 * @author Leonel LLancaqueo
 */
public class PruebaLista {
    /*public static boolean comprobar(Lista unaLista){
        boolean comprobado= false;
        if(!unaLista.esVacia()){
            int posPrimerCero= unaLista.localizar(0);
            if(posPrimerCero != -1){          
                boolean primerEtapa, segundaEtapa; 
                boolean continuarPrimEtapa=true, continuarSegEtapa;
                Cola colaAux= new Cola(posPrimerCero);
                Pila pilaAux= new Pila(posPrimerCero);
                String cadena="";
                int cont=1;
                while(cont < posPrimerCero){
                    Object elementoRecuperdo= unaLista.recuperar(cont);
                    colaAux.poner(elementoRecuperdo);
                    pilaAux.apilar(elementoRecuperdo);
                    cont++;
                }
                cont= cont+2;
                SEPARAMOS EN DOS ETAPAS: LA PRIMERA ES COMPARAR LA CADENA OBTENIDA CON LA PRIMER CADENA DESPUES DEL CERO
                while(colaAux.obtenerFrente().equals(unaLista.recuperar(cont)) && continuarPrimEtapa){
                    if(){}
                }
                
            } 
        }
        return comprobado;
    }*/
    public static Lista concatenar(Lista listaA, Lista listaB){
        /*Este metodo permite la concatenacion de los elementos de dos listas. retorna una nueva lista con los elementos
        de listaA y listaB*/
        Lista otraLista= new Lista();
        if(!(listaA.esVacia()) && !(listaB.esVacia())){
            otraLista = listaA.clone();
            int cont= 1;
            int longListaB= listaB.longitud();
            int posConcatenacion= listaA.longitud()+1;
            while(cont <= longListaB){
                otraLista.insertar(listaB.recuperar(cont),posConcatenacion);          
                cont++;
                posConcatenacion++;
            }
        }else{
            if(listaA.esVacia()){
                otraLista = listaB.clone();
            }else{
                if(listaB.esVacia()){
                    otraLista = listaA.clone();
                }
            }
        }
        return otraLista;
    }
    public static Lista crearListaInt(){
        Lista unaLista= new Lista();
        boolean continuar;
        int cont=1;
        System.out.println("Desea ingresar elementos a la lista: ");
        System.out.println("1 - si");
        System.out.println("2 - no");
        System.out.print("Ingrese el numero de una opcion: ");
        int opcion= TecladoIn.readInt();
        if(opcion == 1){
            do{
                System.out.println("Ingrese un numero: ");
                int num= TecladoIn.readInt();
                unaLista.insertar(num, cont);
                cont++;
                System.out.println("Desea seguir ingresando elementos a la lista: ");
                System.out.println("1 - si");
                System.out.println("2 - no");
                System.out.print("Ingrese el numero de una opcion: ");
                int opcionSeguir= TecladoIn.readInt();
                switch(opcionSeguir){
                    case 1: continuar= true;break;
                    case 2: continuar= false;break;
                    default: System.out.println("error");
                             continuar= false;break;
                }
            }while(continuar);
        }
        return unaLista;
    }
    public static void main(String[] args) {
        Lista listaA= crearListaInt();
        System.out.println("listaA: "+ listaA.toString());
        Lista listaB= crearListaInt();
        System.out.println("listaB: "+ listaB.toString());
        Lista listaConcatenada= concatenar(listaA, listaB);
        System.out.println("listas concatenadas: " + listaConcatenada.toString());
    }
}
