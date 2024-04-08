/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;
import lineales.dinamicas.Nodo;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class TablaHash {
    private int TAMANIO;
    private int cant=0;
    private Nodo hash[];
    
    public TablaHash(){
        this.TAMANIO= 30;
        this.hash= new Nodo[this.TAMANIO];
    }
    public boolean insertar(Object nuevoElem){
        boolean encontrado= false;
        int pos= nuevoElem.hashCode() % this.TAMANIO;
        Nodo aux= this.hash[pos];
        while(!encontrado && aux != null){
            encontrado= aux.getElemento().equals(nuevoElem);
            aux= aux.getEnlace();
        }
        if(!encontrado){
            Nodo nAux= this.hash[pos]; 
            this.hash[pos]=new Nodo(nuevoElem);
            this.hash[pos].setEnlace(nAux);
            this.cant++;
        }
        
        return !encontrado;
    }
    
    public boolean eliminar(Object elem){
        boolean encontrado= false;
        if(this.cant != 0){
            int pos= elem.hashCode() % this.TAMANIO;
            Nodo aux= this.hash[pos];
            Nodo aux2= null;
            while(!encontrado && aux!= null){
                encontrado= aux.getElemento().equals(elem);
                aux2= aux;
                aux= aux.getEnlace(); 
            }
            if(encontrado){
                aux2.setEnlace(aux.getEnlace());
                this.cant--;
            }
        }
        return encontrado;
    }
    
    public boolean pertenece(Object elem){
        boolean encontrado= false;
        if(this.cant != 0){
            int pos= elem.hashCode() % this.TAMANIO;
            Nodo aux= this.hash[pos];

            while(!encontrado && aux!= null){
                encontrado= aux.getElemento().equals(elem);
                aux= aux.getEnlace();
            }
        }
        return encontrado;
    }
    
    public Lista listar(){
        Lista lis= new Lista();
        if(this.cant != 0){
            int cont=0, i=0;
            while(i<= (this.TAMANIO-1) && cont <= this.cant){
                Nodo aux= this.hash[i];
                while(aux!= null){
                    lis.insertar(aux.getElemento(), lis.longitud()+1);
                    aux= aux.getEnlace();
                    cont++;
                }
                i++;
            }
        }
        return lis;
    }
    
    public String toString(){
        String s= "";
        if(this.cant != 0 ){
            int cont=0, i=0;
            while(i<= (this.TAMANIO-1) && cont <= this.cant){
                Nodo aux= this.hash[i];
                while(aux!= null){
                    s+= aux.getElemento();
                    aux= aux.getEnlace();
                    if(aux!= null){
                        s+=", ";
                    }
                    cont++;
                }
                s+= "\n";
                i++;
            }
        }
        return s;
    }
    
    public boolean esVacia(){
        return this.cant==0;
    }
    
    
    
}
