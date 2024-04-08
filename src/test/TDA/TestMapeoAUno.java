/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.TDA;
import TDA.MapeoAMuchos;
/**
 *
 * @author Leonel LLancaqueo
 */
public class TestMapeoAUno {
    public static void main(String[] args) {
        MapeoAMuchos unMapa= new MapeoAMuchos();
        unMapa.asociar(43684498, "leonel");
        unMapa.asociar(45869745, "daniela");
        unMapa.asociar(35684789, "juan");
        unMapa.asociar(63425898, "sofia");
        
        System.out.println("Conjunto dominio del mapeo: " + unMapa.obtenerConjuntoDominio().toString());
        System.out.println("Conjunto rango del mapeo: " + unMapa.obtenerConjuntoRango().toString());
        System.out.println("get rango de  43684498: " + unMapa.obtenerValor(43684498));
        
        System.out.println("asociar de nuevo el elemento 43684498: " + unMapa.asociar(43684498, " llancaqueo"));
        //System.out.println("desasociar el elemeno 43684498: " + unMapa.desasociar(43684498));
        System.out.println("obtener valor 43684498: "+ unMapa.obtenerValor(43684498));
        
        
    }
}
