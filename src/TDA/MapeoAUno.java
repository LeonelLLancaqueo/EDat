/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class MapeoAUno {
    private int TAMANIO;
    private int cant=0;
    private NodoHashMapeo hash[];
    
    public MapeoAUno(){
        this.TAMANIO= 30;
        this.hash= new NodoHashMapeo[this.TAMANIO];
    }
    
    public boolean asociar(Object valorDominio, Object valorRango){
        boolean exito= false;
        boolean encontrado= false;
        int pos= Math.abs(valorDominio.hashCode() % this.TAMANIO);
        NodoHashMapeo aux= this.hash[pos];
        while(!encontrado && aux != null){
            encontrado= aux.getDominio().equals(valorDominio);
            aux= aux.getEnlace();
        }
        if(!encontrado){
            this.hash[pos]=new NodoHashMapeo(valorDominio, valorRango);
            this.cant++;
            exito= true;
        }
        return exito;
    }
    
    public boolean desasociar(Object elemDominio){
        boolean encontrado= false;
        if(this.cant != 0){
            int pos= Math.abs(elemDominio.hashCode() % this.TAMANIO);
            NodoHashMapeo aux= this.hash[pos];
            NodoHashMapeo aux2= null;
            while(!encontrado && aux!= null){
                encontrado= aux.getDominio().equals(elemDominio);
                if(!encontrado){
                    aux2= aux;
                    aux= aux.getEnlace(); 
                }
            }
            if(encontrado){
                if(aux2!= null){
                    aux2.setEnlace(aux.getEnlace());
                    aux2.setEnlace(null);
                }else{
                    this.hash[pos]= null;
                }
                this.cant--;
            }

            
        }
        return encontrado;
    }
    
    
    public Object obtenerValor(Object elemDominio){
        
        boolean encontrado= false;
        Object valorRango= null;
        if(this.cant != 0){
            int pos= Math.abs(elemDominio.hashCode() % this.TAMANIO);
            NodoHashMapeo aux= this.hash[pos];

            while(!encontrado && aux!= null){
                encontrado= aux.getDominio().equals(elemDominio);
                if(!encontrado){
                    aux= aux.getEnlace();
                }
            }
            if(encontrado){
                valorRango= aux.getRango();
            }
        }
        return valorRango;
    }
    /*
    public Object buscarValor(Object elem){
        /*ESTE METODO PERMITE BUSCAR UN VALOR PERTENECIENTE AL RANGO Y SI LO ENCUENTRA DEVUELVE EL ELEMENTO DEL DOMINIO CON EL QUE ESTA ASOCIADO
        boolean encontrado= false;
        Object valorDominio= null;
        
        
        if(this.cant != 0){
            int pos= Math.abs(elemDo.hashCode() % this.TAMANIO);
            NodoHashMapeo aux= this.hash[pos];

            while(!encontrado && aux!= null){
                encontrado= aux.getDominio().equals(elemDominio);
                if(!encontrado){
                    aux= aux.getEnlace();
                }
            }
            if(encontrado){
                valorRango= aux.getRango();
            }
        }
        return valorRango;
    }
    */
    
    public Lista obtenerConjuntoDominio(){
        Lista lis= new Lista();
        if(this.cant != 0){
            int cont=0, i=0;
            while(i<= (this.TAMANIO-1) && cont <= this.cant){
                NodoHashMapeo aux= this.hash[i];
                while(aux!= null){
                    lis.insertar(aux.getDominio(), lis.longitud()+1);
                    aux= aux.getEnlace();
                    cont++;
                }
                i++;
            }
        }
        return lis;
    }
    
    public Lista obtenerConjuntoRango(){
        Lista lis= new Lista();
        if(this.cant != 0){
            int cont=0, i=0;
            while(i<= (this.TAMANIO-1) && cont <= this.cant){
                NodoHashMapeo aux= this.hash[i];
                while(aux!= null){
                    lis.insertar(aux.getRango(), lis.longitud()+1);
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
                NodoHashMapeo aux= this.hash[i];
                while(aux!= null){
                    s+= aux.toString();
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
