/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class ArbolAVL {
    private NodoAVL raiz;
    
    public ArbolAVL(){
        this.raiz= null;
    }
    public boolean pertenece(Comparable e){
        boolean seEncuentra= false;
        if(this.raiz != null){
            seEncuentra= perteneceAux(this.raiz, e);
        }
        return seEncuentra;
    }
    private boolean perteneceAux(NodoAVL n, Comparable e){
        boolean exito= false;
        if(n != null){
            if(e.compareTo(n.getElemento()) == 0){
            exito= true;
            }else{
                if(e.compareTo(n.getElemento()) < 0){
                    exito= perteneceAux(n.getIzquierdo(), e);
                }else{
                    exito= perteneceAux(n.getDerecho(), e);
                }
            }
        }
        return exito;
    }
    public Lista listar(){
        //metodo que devuelve una lista de menor a mayor del arbol
        Lista unaLista= new Lista();
        if(this.raiz != null){
            listarAux(this.raiz, unaLista);
        }
        return unaLista;
    }
    private void listarAux(NodoAVL n, Lista lis){
        if(n != null){
            listarAux(n.getIzquierdo(), lis); //bajamos recursivamente por los hijosIzquierdos hasta el ultimo
            
            lis.insertar((int) n.getElemento() , lis.longitud()+1); // insertamos el elemento en la lista

            listarAux(n.getDerecho(), lis); // repetimos el procedimiento con los hijos derechos

        }
    }
    
    public Comparable minimoElem(){
        return minimoElemAux(this.raiz);
    }
    private Comparable minimoElemAux(NodoAVL n){
        Comparable elemt= null;
        while(n != null){
            elemt= n.getElemento();
            n= n.getIzquierdo();
        }
        return elemt;
    }
    public Comparable maximoElem(){
        return maximoElemAux(this.raiz);
    }
    private Comparable maximoElemAux(NodoAVL n){
        Comparable elemt= null;
        while(n != null){
            elemt= n.getElemento();
            n= n.getDerecho();
        }
        return elemt;
    }
    public void vaciar(){
        this.raiz= null;
    }
    private int balance(NodoAVL n){
        int alturaHI= -1;
        int alturaHD= -1;
        if(n.getIzquierdo() != null){
            alturaHI= n.getIzquierdo().getAltura();
        }
        if(n.getDerecho()!= null){
            alturaHD= n.getDerecho().getAltura(); 
        }
        return alturaHI - alturaHD;
    }
    private NodoAVL rotarDerecha(NodoAVL n){
        NodoAVL h= n.getIzquierdo();
        NodoAVL temp= h.getDerecho();
        h.setDerecho(n);
        n.setIzquierdo(temp);
        n.recalcularAltura();
        h.recalcularAltura();
        return h;
    }
    private NodoAVL rotarIzquierda(NodoAVL n){
        NodoAVL h= n.getDerecho();
        NodoAVL temp= h.getIzquierdo();
        h.setIzquierdo(n);
        n.setDerecho(temp);
        n.recalcularAltura();
        h.recalcularAltura();
        return h;
    }
    private void verificarBalance(NodoAVL n, NodoAVL nPadre){
        System.out.println("n: "+ n.getElemento());
        boolean esRaiz= false;
        if(n.getElemento().compareTo(this.raiz.getElemento()) == 0){ // verificamos si n es la raiz del arbol
            esRaiz= true;
        }
        if(balance(n) == 2){ // SI EL BALANCE ES 2 ENTONCES NOS FIJAMOS EN EL BALANCE DEL NODO HIJOIZQUIERDO
            int balanceHI= balance(n.getIzquierdo()); 
            if( balanceHI == 1 || balanceHI == 0 ){
                if(esRaiz){ 
                    this.raiz=rotarDerecha(n);//si n es la raiz entonces al rotar a la derecha se le asigna la nueva raiz del subArbol al arbol
                }else{
                    if(n.getElemento().compareTo(nPadre.getElemento())> 0){ //nos fijamos si n es el HI de nPadre
                        nPadre.setDerecho(rotarDerecha(n)); // 
                    }else{ // sino es el HI de nPadre
                        nPadre.setIzquierdo(rotarDerecha(n));
                    }
                }
            }else{
                if(esRaiz){
                    rotarIzquierda(n);
                    this.raiz=rotarDerecha(nPadre);
                }else{
                    rotarIzquierda(n);
                    rotarDerecha(nPadre);
                }
            }
        }
        if(balance(n) == -2){
            int balanceHD= balance(n.getDerecho()); 
            if( balanceHD == -1 || balanceHD == 0  ){
                if(esRaiz){
                    this.raiz=rotarIzquierda(n);
                }else{
                    if(n.getElemento().compareTo(nPadre.getElemento())> 0){
                        nPadre.setDerecho(rotarIzquierda(n));
                    }else{
                        nPadre.setIzquierdo(rotarIzquierda(n));
                    }
                }
                
            }
            if(balanceHD == 1 ){
                
                if(esRaiz){
                    rotarDerecha(n);
                    this.raiz=rotarIzquierda(nPadre);
                }else{
                    rotarDerecha(n);
                    rotarIzquierda(nPadre);
                }
            }
        }
    }
    public boolean insertar(Comparable e){
        boolean exito= true;
        if(this.raiz != null){
            exito= insertarAux(this.raiz, null, e);
        }else{
            this.raiz= new NodoAVL(e, null, null);
        }
        
        return exito;
    }
    private boolean insertarAux(NodoAVL n, NodoAVL nPadre, Comparable e){
        boolean exito= true;
        if(e.compareTo(n.getElemento()) == 0){ //Compara si el elemento es igual 
            exito= false;
        }else{
            if(e.compareTo(n.getElemento()) < 0){
                if(n.getIzquierdo() != null){ // si el nodo tiene al menos un hijo izquierdo
                    exito= insertarAux(n.getIzquierdo(), n, e);
                }else{
                    n.setIzquierdo(new NodoAVL(e, null, null));
                }
            }else{
                // si sigue por aca es pq e es mayor que el elemento que contiene n
                if(n.getDerecho() != null){
                    exito= insertarAux(n.getDerecho(),n, e);
                }else{
                    n.setDerecho( new NodoAVL(e,null, null));
                }
            }
            if(exito){
                
                
                verificarBalance(n, nPadre);
                n.recalcularAltura();
            }
        }
        return exito;
    }
    
    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo){
        //metodo que devuelve una lista de los elementos que esten dentro del rango de los elementos min y max ingresados por parametro
        Lista unaLista= new Lista();
        if(this.raiz != null){
            listarRangoAux(this.raiz, unaLista, elemMinimo, elemMaximo);
        }
        return unaLista;
    }
    private void listarRangoAux(NodoAVL n, Lista lis, Comparable min, Comparable max){
        if(n != null){
            Comparable nElem= n.getElemento();
            if(nElem.compareTo(max) > 0 || nElem.compareTo(min) > 0 || nElem.compareTo(max) == 0 ){ // si el maximo es menor al elemento del nodo.
                
                listarRangoAux(n.getIzquierdo(), lis, min, max); //bajamos recursivamente por los hijosIzquierdos 
            }
            if((nElem.compareTo(min) > 0 && nElem.compareTo(max) < 0) || nElem.compareTo(min) == 0 || nElem.compareTo(max) == 0 ){ //si el elemento minimo es menor que el elemento del nodo 
                    lis.insertar(nElem, lis.longitud()+1); // listamos el elemento del nodo
                }
            if(nElem.compareTo(max) < 0 ){
                //si el maximo es mayor al elemento del nodo.
                listarRangoAux(n.getDerecho(), lis, min, max); // repetimos el procedimiento con los hijos derechos
            }
        }
    }
    
    public int alturaArbolAVL(){
        return alturaArbolAVLAux(this.raiz)-1;
    }
    private int alturaArbolAVLAux(NodoAVL unNodoArbol){
        int contDer=0, contIzq=0, altura;
        if(unNodoArbol != null){
            contIzq= alturaArbolAVLAux(unNodoArbol.getIzquierdo()) + 1;
            contDer= alturaArbolAVLAux(unNodoArbol.getDerecho()) + 1;
        }
        if(contDer >= contIzq){
            altura= contDer;
        }else{
            altura= contIzq;
        }
        return altura;
    }
    public boolean eliminar(Comparable e){
        boolean exito= false;
        if(this.raiz != null){
            if(this.raiz.getElemento().compareTo(e) == 0 && this.raiz.getDerecho() == null && this.raiz.getIzquierdo()== null ){
                this.raiz= null;
            }else{
                exito= eliminarAux(this.raiz, null, e);
            }
        }
        return exito;
    }
    
    private boolean eliminarAux(NodoAVL n, NodoAVL nPadre, Comparable e){
        boolean exito= false;
        if(n != null){
            Comparable nElem= n.getElemento();
            if(nElem.compareTo(e) == 0){
                if(n.getIzquierdo()== null && n.getDerecho() == null){ //  CUANDO EL NODO NO TIENE HIJOS
                    if(nPadre.getElemento().compareTo(n.getElemento()) > 0){ // NOS FIJAMOS SI EL NODO ES EL HERMANO IZQ
                        nPadre.setIzquierdo(null);
                    }else{
                        nPadre.setDerecho(null);
                    }
                }else{
                    // CUANDO N TIENE AL MENOS 1 HIJO
                    // MODULARIZAR
                    //ARREGLAR LOS IF ELSE
                    if(n.getIzquierdo() != null && n.getDerecho() == null){  // SI EL HIJO ES EL IZQ
                        if(nElem.compareTo(nPadre) < 0 ){ // si n es el hijo izq del padre
                            nPadre.setIzquierdo(n.getIzquierdo());
                        }else{
                            nPadre.setDerecho(n.getIzquierdo()); // si n es el hijo der del padre
                        }
                    }
                    if(n.getDerecho() != null && n.getIzquierdo() == null){ // SI ES EL HIJO DER
                        if(nElem.compareTo(nPadre) < 0 ){ // si n es el hijo izq de padre
                            nPadre.setIzquierdo(n.getDerecho());
                        }else{  // sino n es el hijo derecho
                            nPadre.setDerecho(n.getDerecho());
                        }
                    }
                    
                    
                    //CUANDO N TIENE 2 HIJOS
                    if(n.getIzquierdo() != null && n.getDerecho() != null){
                        NodoAVL nCandidato= n.getIzquierdo().getDerecho();// obtenemos el nodo con el elemento candidato
                        NodoAVL padreCandidato= n.getIzquierdo(); // obtenemos el nodo del padre del nodo con el elemento candidato
                        NodoAVL nAux= n.getIzquierdo().getDerecho();
                        while(nAux != null){ 
                            nAux= nAux.getDerecho();
                            if(nAux != null){
                                nCandidato= nCandidato.getDerecho();
                                padreCandidato= padreCandidato.getDerecho();
                            }
                        }
                        if(nCandidato != null){
                            n.setElemento(nCandidato.getElemento()); //settamos el elemento candidato al nodo con el elemento a eliminar
                            padreCandidato.setDerecho(null); // eliminamos el nodo del elemento candidato
                        }else{
                            n.setElemento(padreCandidato.getElemento());
                            n.setIzquierdo(null);
                        }
                    }
                }
                exito= true;
            }else{ // PASO RECURSIVO
                if(n.getElemento().compareTo(e) > 0 ){
                    exito=eliminarAux(n.getIzquierdo(), n, e);
                }else{
                    exito=eliminarAux(n.getDerecho(), n, e);
                }
                if(exito){
                    n.recalcularAltura();
                    verificarBalance(n, nPadre);
                }
            }
        }
        return exito;
    }
    public String toString(){
        String unString= "";
        if(this.raiz != null){
            unString= toStringAux(this.raiz, unString);
        }
        return unString;
    }
    public String toStringAux(NodoAVL unNodoArbol, String unString){
        String stringAux= unString; 
        if(unNodoArbol != null){
            stringAux= stringAux + "Nodo: "+ unNodoArbol.getElemento()+" ";
            if(unNodoArbol.getIzquierdo() != null){
                stringAux+= "HI: "+ unNodoArbol.getIzquierdo().getElemento()+" ";
            }else{
                stringAux+= "HI: null ";
            }
            if(unNodoArbol.getDerecho() != null){
                stringAux+= "HD: "+ unNodoArbol.getDerecho().getElemento()+"\n";
            }else{
                stringAux+= "HD: null\n";
            }
            stringAux= toStringAux(unNodoArbol.getIzquierdo(), stringAux);
            stringAux= toStringAux(unNodoArbol.getDerecho(), stringAux);
        }
        return stringAux;
    }
    // el balance es diferente a la altura, 
}
