/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.interrelacionalistas;

import interrelacionistas.Grafo;

/**
 *
 * @author Leonel LLancaqueo
 */
public class TestGrafoDos {
    public static void main(String[] args) {
        Grafo nGrafo= new Grafo();
        
        
             
        
        nGrafo.insertarVertice(1);
        nGrafo.insertarVertice(2);
        nGrafo.insertarVertice(3);
        nGrafo.insertarVertice(4);
        nGrafo.insertarVertice(5);
        //nGrafo.insertarVertice(6);
        //nGrafo.insertarVertice(7);
        
        
        nGrafo.insertarArco(1, 2, 30);
        nGrafo.insertarArco(2, 4, 30);
        nGrafo.insertarArco(1, 3, 40);
        nGrafo.insertarArco(3, 2, 50);
        nGrafo.insertarArco(3, 5, 50);
        nGrafo.insertarArco(4, 5, 60);
        /*
        System.out.println("toString: "+ nGrafo.toString());
        System.out.println("primerCaminoMenorPesoYLong: "+ nGrafo.primerCaminoMenorPesoYLong(1, 4, 100, 3).toString());
        System.out.println("CaminoDEPesoEntre: "+ nGrafo.caminoDePesoEntre(1, 4, 70, 90).toString());
        */
        System.out.println(" caminoDeLongitudMenorAux: " + nGrafo.caminoDePesoEntre2(1, 4,180, 200).toString());
        
        
    
    }
}
