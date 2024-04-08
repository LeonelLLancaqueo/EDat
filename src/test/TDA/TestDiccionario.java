/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.TDA;
import TDA.Diccionario;
/**
 *
 * @author Leonel LLancaqueo
 */
public class TestDiccionario {
    public static void main(String[] args) {
        Diccionario n= new Diccionario();
        
        
        n.insertar(100, "leonel");
        n.insertar(50, "juan");
        n.insertar(150, "pedro");
        n.insertar(25, "samuel");
        n.insertar(75, "andres");
        n.insertar(125, "rafael");
        n.insertar(200, "adriano");
        n.insertar(15, "adriano");
        n.insertar(35, "adriano");
        n.insertar(60, "adriano");
        n.insertar(115, "adriano");
        n.insertar(135, "adriano");
        n.insertar(175, "adriano");
        n.insertar(250, "adriano");
        n.insertar(30, "adriano");
        n.insertar(110, "adriano");
        n.insertar(120, "adriano");
        n.insertar(140, "adriano");
        n.insertar(165, "adriano");
        n.insertar(185, "adriano");
        n.insertar(400, "adriano");
        n.insertar(122, "adriano");
        
        /*
        n.insertar(50, "adriano");
        n.insertar(25, "adriano");
        n.insertar(75, "adriano");
        n.insertar(65, "adriano");
        n.insertar(15, "adriano");
        n.insertar(35, "adriano");
        n.insertar(10, "adriano");
        //n.insertar(70, "adriano");
        
        
        
        
        n.eliminar(75);
        n.insertar(70, "adriano");
        */
        n.eliminar(150);
        
        System.out.println("toString : " + n.toString());
        
        

    }
}
