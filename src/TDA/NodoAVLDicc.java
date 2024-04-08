/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoAVLDicc {
    private Comparable clave;
    private Object dato;
    private NodoAVLDicc izquierdo;
    private NodoAVLDicc derecho;
    private int altura;
    
    public NodoAVLDicc(Comparable clave, Object dato){
        this.clave= clave;
        this.dato= dato;
        this.izquierdo= null;
        this.derecho= null;
        this.altura= 0;
    }
    public Comparable getClave(){
        return this.clave;
    }
   
    public Object getDato(){
        return this.dato;
    }
    public void setDato(Object dato){
        this.dato= dato;
    }
    public int getAltura(){
        return this.altura;
    }
    public NodoAVLDicc getIzquierdo(){
        return this.izquierdo;
    }
    public NodoAVLDicc getDerecho(){
        return this.derecho;
    }
    
    public void setClave(Comparable clave){
        this.clave= clave;
    }
    public void setIzquierdo(NodoAVLDicc unNodoArbol){
        this.izquierdo= unNodoArbol;
    }
    public void setDerecho(NodoAVLDicc unNodoArbol){
        this.derecho= unNodoArbol;
    }
    
    public void recalcularAltura(){
        int alturaIzq=-1, alturaDer=-1;
        if(this.izquierdo != null){
            alturaIzq= this.izquierdo.altura;
        }
        if(this.derecho != null){
            alturaDer= this.derecho.altura;
        }
        if(alturaIzq >= alturaDer){
            this.altura= alturaIzq+1 ;
        }else{
            this.altura= alturaDer+1;
        }
    }
}
