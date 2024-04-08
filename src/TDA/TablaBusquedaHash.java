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
public class TablaBusquedaHash {
    private static int TAM=30;
    private NodoHashDicc tabla[];
    private int cant;
    
    public TablaBusquedaHash(){
        this.cant=0;
        this.tabla= new NodoHashDicc[TAM];
    }
    public Object obtenerDato(Object elem){
        //DADA UN ELEMENTO DE TIPO CLAVE PASADO POR PARAMETRO DEVUELVE EL DATO ASOCIADO, SI ES QUE EXISTE LA CLAVE EN LA TABLA
        Object dato= null;
        if(this.cant != 0){
            int pos= Math.abs(elem.hashCode() % this.TAM);
            NodoHashDicc aux= this.tabla[pos];
            while(dato == null && aux!= null){
                if(aux.getClave().equals(elem)){
                    dato= aux.getDato();
                }
                aux= aux.getEnlace();
            }
        }
        return dato;
    }
    
    public boolean insertar(Object nuevoElem, Object dato){
        boolean encontrado= false;
        int pos= Math.abs(nuevoElem.hashCode() % this.TAM);
        NodoHashDicc aux= this.tabla[pos];
        while(!encontrado && aux != null){
            encontrado= aux.getClave().equals(nuevoElem);
            aux= aux.getEnlace();
        }
        if(!encontrado){
            NodoHashDicc nAux= this.tabla[pos];
            this.tabla[pos]=new NodoHashDicc(nuevoElem, dato);
            this.tabla[pos].setEnlace(nAux);
            this.cant++;
        }
        
        return !encontrado;
    }
    
    public boolean eliminar(Object elem){
        boolean encontrado= false;
        if(this.cant != 0){
            int pos= Math.abs(elem.hashCode() % this.TAM);
            NodoHashDicc aux= this.tabla[pos];
            NodoHashDicc aux2= null;
            while(!encontrado && aux!= null){
                encontrado= aux.getClave().equals(elem);
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
    
    public boolean existeClave(Object elem){
        boolean encontrado= false;
        if(this.cant != 0){
            int pos= Math.abs(elem.hashCode() % this.TAM);
            NodoHashDicc aux= this.tabla[pos];

            while(!encontrado && aux!= null){
                encontrado= aux.getClave().equals(elem);
                aux= aux.getEnlace();
            }
        }
        return encontrado;
    }
    
    public Lista listarClaves(){
        Lista lis= new Lista();
        if(this.cant != 0){
            int cont=0, i=0;
            while(i<= (this.TAM-1) && cont <= this.cant){
                NodoHashDicc aux= this.tabla[i];
                while(aux!= null){
                    lis.insertar(aux.getClave(), lis.longitud()+1);
                    aux= aux.getEnlace();
                    cont++;
                }
                i++;
            }
        }
        return lis;
    }
    
    public Lista listarDatos(){
        Lista lis= new Lista();
        if(this.cant != 0){
            int cont=0, i=0;
            while(i<= (this.TAM-1) && cont <= this.cant){
                NodoHashDicc aux= this.tabla[i];
                while(aux!= null){
                    lis.insertar(aux.getDato(), lis.longitud()+1);
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
            while(i<= (this.TAM-1) && cont <= this.cant){
                NodoHashDicc aux= this.tabla[i];
                while(aux!= null){
                    s+= aux.toString();
                    aux= aux.getEnlace();
                    if(aux!= null){
                        s+=", ";
                    }
                    cont++;
                    s+= "\n";
                }
                i++;
            }
        }
        return s;
    }
    
    public boolean esVacia(){
        return this.cant==0;
    } 
    
}
