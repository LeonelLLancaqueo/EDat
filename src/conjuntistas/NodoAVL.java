/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class NodoAVL {
    private Comparable elem;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura;
    
    public NodoAVL(Comparable e, NodoAVL i, NodoAVL d){
        this.elem= e;
        this.izquierdo= i;
        this.derecho= d;
        this.altura= 0;
    }
    public Comparable getElemento(){
        return this.elem;
    }
    public int getAltura(){
        return this.altura;
    }
    public NodoAVL getIzquierdo(){
        return this.izquierdo;
    }
    public NodoAVL getDerecho(){
        return this.derecho;
    }
    public void setElemento(Comparable unElemento){
        this.elem= unElemento;
    }
    public void setIzquierdo(NodoAVL unNodoArbol){
        this.izquierdo= unNodoArbol;
    }
    public void setDerecho(NodoAVL unNodoArbol){
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
 