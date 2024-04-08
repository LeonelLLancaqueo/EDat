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
public class TestGrafo {
    public static void main(String[] args) {
        Grafo unGrafo= new Grafo();
        
        unGrafo.insertarVertice(1);
        unGrafo.insertarVertice(2);
        unGrafo.insertarVertice(3);
        System.out.println("");
        
        System.out.println("existe vertice 1:" + unGrafo.existeVertice(1));
        System.out.println("eliminar vertice 5: "+ unGrafo.eliminarVertice(5));
        System.out.println("eliminar vertice 1: "+ unGrafo.eliminarVertice(1));
        System.out.println("existe vertice 1:" + unGrafo.existeVertice(1));
        System.out.println("inserto vertice 1 de nuevo: " + unGrafo.insertarVertice(1));
        System.out.println("insertar vertice 4: " + unGrafo.insertarVertice(4));
        System.out.println("inserto arco entre 1 y 4: " + unGrafo.insertarArco(1, 4, 700));
        System.out.println("insertar Arco entre 1 y 3: " + unGrafo.insertarArco(1, 3, 300));
        System.out.println("insertar Arco entre 1 y 2: " + unGrafo.insertarArco(1, 2, 50));
        System.out.println("insertar Arco entre 2 y 3: " + unGrafo.insertarArco(2, 3, 50));
        System.out.println("insertar Arco entre 2 y 3: " + unGrafo.insertarArco(2, 3, 50));
        System.out.println("existe Arco entre 1 y 2: "+ unGrafo.existeArco(1, 2));
        System.out.println("existe Arco entre 1 y 3: "+ unGrafo.existeArco(1, 3));
        System.out.println("existe Arco entre 2 y 3: "+ unGrafo.existeArco(2, 3));
        System.out.println("existe Arco entre 1 y 4: "+ unGrafo.existeArco(1, 4));
        /*
        System.out.println("toString grafo: "+ unGrafo.toString());
        System.out.println("eliminar arco entre 1 y 3: "+ unGrafo.eliminarArco(1, 3));
        System.out.println("existe Arco entre 1 y 3: "+ unGrafo.existeArco(1, 3));
        System.out.println("toString grafo: "+ unGrafo.toString());
        System.out.println("elimino arco entre 2 y 1: "+ unGrafo.eliminarArco(1, 2));
        System.out.println("toString grafo: "+ unGrafo.toString());
        */
        
        System.out.println("inserto arco entre 3 y 4: " + unGrafo.insertarArco(3, 4, 500));
        /************/
        System.out.println("insertar vertice 11: " + unGrafo.insertarVertice(11));
        System.out.println("insertar vertice 11: " + unGrafo.insertarVertice(12));
        System.out.println("inserto arco entre 11 y 4: " + unGrafo.insertarArco(11, 4, 150));
        System.out.println("inserto arco entre 11 y 3: " + unGrafo.insertarArco(11, 3, 50));
        System.out.println("inserto arco entre 2 y 11: " + unGrafo.insertarArco(11, 2, 200));
        System.out.println("inserto arco entre 12 y 11: " + unGrafo.insertarArco(12, 11, 50));
        System.out.println("inserto arco entre 12 y 4: " + unGrafo.insertarArco(12, 4, 50));
        
        
        
        /*
        System.out.println("existe camino 1 y 4: " + unGrafo.existeCamino(1, 4));
        System.out.println("insertar arco entre 1 y 4: " + unGrafo.insertarArco(1, 4));
        System.out.println("existe camino 1 y 4: " + unGrafo.existeCamino(1, 4));
        */
        System.out.println("toString grafo: "+ unGrafo.toString());
        System.out.println("camino mas corto entre 1 y 4: " + unGrafo.caminoMasCorto(1, 4).toString());
        System.out.println("camino mas corto por etiqueta entre 1 y 4: " + unGrafo.caminoMasCortoPorEtiqueta(1, 4).toString());
        System.out.println("camino mas largo entre 1 y 4: " + unGrafo.caminoMasLargo(1, 4).toString());
        System.out.println("Listar de caminos entre 1 y 4 sin pasar por 11: "+ unGrafo.listarCaminoSinPasarPor(1, 4, 11, 700).toString());
        
        
        System.out.println("inserto vertice 5: " + unGrafo.insertarVertice(5));
        System.out.println("insertar vertice 6: " + unGrafo.insertarVertice(6));
        System.out.println("insertar vertice 7: " + unGrafo.insertarVertice(7));
        System.out.println("insertar vertice 8: " + unGrafo.insertarVertice(8));
        System.out.println("insertar vertice 9: " + unGrafo.insertarVertice(9));
        System.out.println("inserto arco entre 8 y 9: " + unGrafo.insertarArco(8, 9, 50));
        System.out.println("inserto arco entre 6 y 7: " + unGrafo.insertarArco(6, 7, 50));
        System.out.println("inserto arco entre 7 y 8: " + unGrafo.insertarArco(7, 8, 50));
        System.out.println("inserto arco entre 1 y 6: " + unGrafo.insertarArco(1, 6, 50));
        System.out.println("inserto arco entre 4  y 5: "+ unGrafo.insertarArco(4, 5, 50));
        System.out.println("inserto arco entre 1  y 5: "+ unGrafo.insertarArco(1, 5, 50));
        System.out.println("toString grafo: "+ unGrafo.toString());
        System.out.println("camino mas corto de 1 a 5: " + unGrafo.caminoMasCorto(1, 5).toString());
        System.out.println("camino mas largo de 1 a 5: " + unGrafo.caminoMasLargo(1, 5).toString());
        System.out.println("Listar de caminos entre 1 y 4 sin pasar por 11: "+ unGrafo.listarCaminoSinPasarPor(1, 12, 3, 200).toString());
        
        System.out.println("listar en anchura: " + unGrafo.listarEnAnchura().toString());
        System.out.println("listar en profundidad: " + unGrafo.listarEnProfundidad().toString());
        
        System.out.println("toString grafo: "+ unGrafo.toString());
       
    }
}
