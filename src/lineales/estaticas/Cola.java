/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Cola {
    private int  TAMANIO;
    private int frente;
    private int fin;
    private Object []arr;
    
    public Cola(int tamanio){
        this.TAMANIO= tamanio;
        this.arr= new Object[TAMANIO];
        this.fin=0;
        this.frente=0;
    }
    public boolean poner(Object elemento){
        /*REVISAR*/
        boolean puesto;
        if((modTamanio(this.fin+1)) == this.frente ){
            puesto= false;
        }else{
            puesto= true;
            arr[this.fin]= elemento;
            this.fin= modTamanio(this.fin+1);
        }    
        return puesto;
    }
    public void vaciar(){
        while((this.frente%this.TAMANIO)-1 != this.fin){
            arr[this.frente]= null;
            this.frente= modTamanio(this.frente+1);
        }
        this.frente= this.fin;
        
    }
    public boolean sacar(){
        boolean sacado;
        if(esVacia()){
            sacado= false;
        }else{
            arr[this.frente]= null;
            this.frente= modTamanio(this.frente+1);
            sacado= true;
        }
        return sacado;
    }
    public boolean esLleno(){
        return modTamanio(this.fin+1) == this.frente;
    }
    public boolean esVacia(){
        return this.fin==this.frente;
    }
    public Object obtenerFrente(){
        return arr[this.frente];
    }
    public Cola clone(){
        Cola otraCola = new Cola(this.TAMANIO);
        otraCola.arr= this.arr.clone();
        otraCola.frente= this.frente;
        otraCola.fin= this.fin;
        return otraCola;
    }
    public String toString(){
        String stringCola="[";
        int cont= this.frente;
        while(cont != this.fin){
            stringCola+= arr[cont];
            if(cont != this.fin){
                stringCola+= " " ;
            }
            cont= modTamanio(cont+1);
        }
        stringCola+="]";
        return stringCola;
    }
    private int modTamanio(int unNumero){
        return unNumero%this.TAMANIO;
    }
    
}
