/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;
import TDA.NodoCP;
/**
 *
 * @author Leonel LLancaqueo
 */
public class ColaPrioridad {
    private NodoCP inicio;
    
    public ColaPrioridad(){
        this.inicio= null;
    }
    public boolean insertar(Object elem, int prioridad){
        boolean exito= false;
        if(this.inicio != null){
            NodoCP nAux= this.inicio;
            while(nAux != null && nAux.getPrioridad() != prioridad){
                nAux= nAux.getEnlace();
            }
            if(nAux != null){
                nAux.getItem().poner(elem);
            }else{
                NodoCP n= new NodoCP(prioridad);
                n.getItem().poner(elem);
                nAux= this.inicio;
                NodoCP nAux2= null;
                while(nAux != null && prioridad > nAux.getPrioridad()){
                    nAux2= nAux;
                    nAux= nAux.getEnlace();
                }
                if(nAux2 != null){
                    nAux2.setEnlace(n);
                    n.setEnlace(nAux);
                    exito= true;
                }else{
                    n.setEnlace(this.inicio);
                    this.inicio= n;
                }
                
            }
        }else{
            this.inicio= new NodoCP(prioridad);
            this.inicio.getItem().poner(elem);
            exito= true;
        }
        
        return exito;
            
    }
    public boolean eliminarFrente(){
        boolean exito= false;
        if(this.inicio != null){
            exito= this.inicio.getItem().sacar();
            if(this.inicio.getItem().esVacia()){
                this.inicio= this.inicio.getEnlace();
            }
        }
        return exito;
    }
    public Object obtenerFrente(){
        Object frente= null;
        if(this.inicio != null){
            frente= this.inicio.getItem().obtenerFrente();
        }
        return frente;
    }
    public boolean esVacia(){
        return this.inicio.getItem().esVacia();
    }
    public String toString(){
        String s= "";
        NodoCP nAux= this.inicio;
        while(nAux != null){
            s += nAux.getItem().toString()+"\n";
            nAux= nAux.getEnlace();
        }
        return s;
    }
}
