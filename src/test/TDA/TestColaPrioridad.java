/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.TDA;
import TDA.ColaPrioridad;
/**
 *
 * @author Leonel LLancaqueo
 */
public class TestColaPrioridad {
    public static void main(String[] args) {
        ColaPrioridad n= new ColaPrioridad();
        
        n.insertar("leonel", 1);
        n.insertar("juan", 2);
        n.insertar("Pablo", 4);
        n.insertar("messi", 1);
        n.insertar("ronaldo", 1);
        n.insertar("guille", 2);
        n.insertar("rodrigo", 4);
        n.insertar("dani", 4);
        System.out.println("toString colaPrioridad: " + n.toString() );
        
        System.out.println("frente de la cola: "+ n.obtenerFrente());
        n.eliminarFrente();
        System.out.println("frente de la cola: "+ n.obtenerFrente());
        n.insertar("sandri", 3);
        System.out.println("toString colaPrioridad: " + n.toString() );
        
        n.eliminarFrente();
        n.eliminarFrente();
        System.out.println("toString colaPrioridad: " + n.toString() );
        System.out.println("frente de la cola: "+ n.obtenerFrente());
        n.insertar("leonel", 1);
        n.insertar("samuel", 1);
        
        System.out.println("toString colaPrioridad: " + n.toString() );
        System.out.println("frente de la cola: "+ n.obtenerFrente());
    }
}
