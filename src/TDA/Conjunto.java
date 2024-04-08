/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;
import conjuntistas.TablaHash;
/**
 *
 * @author Leonel LLancaqueo
 */
public class Conjunto {
    private TablaHash conjunto;
    
    public Conjunto(int tamanio){
        this.conjunto= new TablaHash();
    }
    public boolean agregar(Object elem){
        return this.conjunto.insertar(elem);
    }
    public boolean quitar(Object elem){
        return this.conjunto.eliminar(elem);
    }
    public boolean pertenece(Object elem){
        return this.conjunto.pertenece(elem);   
    }
    public boolean esVacio(){
        return this.conjunto.esVacia();
    }
    
    
}
