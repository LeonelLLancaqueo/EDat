/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.TDA;
import TDA.MapeoAUno;
/**
 *
 * @author Leonel LLancaqueo
 */
public class TestMapeoAMuchos {
    public static void main(String[] args) {
        MapeoAUno unMapa= new MapeoAUno();
        
        unMapa.asociar(43684498, "Leonel");
        unMapa.asociar(43665254, "Juan Cruz");
        unMapa.asociar(69854125, "Daniela");
        unMapa.asociar(23569874, "Sofia");
        unMapa.asociar(36547812, "Pedro");
        
        System.out.println("Conjunto dominio del mapeo: " + unMapa.obtenerConjuntoDominio().toString());
        System.out.println("Conjunto rango del mapeo: " + unMapa.obtenerConjuntoRango().toString());
        System.out.println("get rango de  43684498: " + unMapa.obtenerValor(43684498));
        
        System.out.println("asociar de nuevo el elemento 43684498: " + unMapa.asociar(43684498, " llancaqueo"));
        System.out.println("desasociar el elemeno 43684498: " + unMapa.desasociar(43684498));
        System.out.println("asociar de nuevo el elemento 43684498: " + unMapa.asociar(43684498, " llancaqueo"));
    }
}
