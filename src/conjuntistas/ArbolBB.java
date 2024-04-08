/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import jerarquicas.NodoABB;
import lineales.dinamicas.Lista;



/**
 *
 * @author Leonel LLancaqueo
 */
public class ArbolBB {
    private NodoABB raiz;
    
    public ArbolBB(){
        this.raiz= null;
    }
    public boolean insertar(Comparable e){
        boolean exito= true;
        if(this.raiz != null){
            insertarAux(this.raiz, e);
        }else{
            this.raiz= new NodoABB(e);
        }
        
        return exito;
    }
    private boolean insertarAux(NodoABB n, Comparable e){
        boolean exito= true;
        if(e.compareTo(n.getElemento()) == 0){ //Compara si el elemento es igual 
            exito= false;
        }else{
            if(e.compareTo(n.getElemento()) < 0){
                if(n.getIzquierdo() != null){ // si el nodo tiene al menos un hijo izquierdo
                    exito= insertarAux(n.getIzquierdo(), e);
                }else{
                    n.setIzquierdo(new NodoABB(e));
                }
            }else{
                // si sigue por aca es pq e es mayor que el elemento que contiene n
                if(n.getDerecho() != null){
                    exito= insertarAux(n.getDerecho(), e);
                }else{
                    n.setDerecho( new NodoABB(e));
                }
            }
        }
        return exito;
    }
    public boolean vacio(){
        return this.raiz == null;
    }
    public boolean pertenece(Comparable e){
        boolean seEncuentra= false;
        if(this.raiz != null){
            seEncuentra= perteneceAux(this.raiz, e);
        }
        return seEncuentra;
    }
    private boolean perteneceAux(NodoABB n, Comparable e){
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
    private void listarAux(NodoABB n, Lista lis){
        if(n != null){
            listarAux(n.getIzquierdo(), lis); //bajamos recursivamente por los hijosIzquierdos hasta el ultimo
            
            lis.insertar((int) n.getElemento() , lis.longitud()+1); // insertamos el elemento en la lista

            listarAux(n.getDerecho(), lis); // repetimos el procedimiento con los hijos derechos

        }
    }
    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo){
        //metodo que devuelve una lista de los elementos que esten dentro del rango de los elementos min y max ingresados por parametro
        Lista unaLista= new Lista();
        if(this.raiz != null){
            listarRangoAux(this.raiz, unaLista, elemMinimo, elemMaximo);
        }
        return unaLista;
    }
    private void listarRangoAux(NodoABB n, Lista lis, Comparable min, Comparable max){
        if(n != null){
            Comparable nElem= n.getElemento();
            System.out.println("entra con: "+ nElem);
            if(nElem.compareTo(max) > 0 || nElem.compareTo(min) > 0 || nElem.compareTo(max) == 0 && nElem.compareTo(min) != 0){ // si el maximo es menor al elemento del nodo.
                
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
    public Comparable minimoElem(){
        return minimoElemAux(this.raiz);
    }
    private Comparable minimoElemAux(NodoABB n){
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
    private Comparable maximoElemAux(NodoABB n){
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
    
    private boolean eliminarAux(NodoABB n, NodoABB padre, Comparable e){
        boolean exito= false;
        if(n != null){
            Comparable nElem= n.getElemento();
            if(nElem.compareTo(e) == 0){
                if(n.getIzquierdo()== null && n.getDerecho() == null){ //  CUANDO EL NODO NO TIENE HIJOS
                    if(padre.getElemento().compareTo(n.getElemento()) > 0){ // NOS FIJAMOS SI EL NODO ES EL HERMANO IZQ
                        padre.setIzquierdo(null);
                    }else{
                        padre.setDerecho(null);
                    }
                }else{
                    // CUANDO N TIENE AL MENOS 1 HIJO
                    
                    if(n.getIzquierdo() != null && n.getDerecho() == null){  // SI EL HIJO ES EL IZQ
                        if(nElem.compareTo(padre) < 0 ){ // si n es el hijo izq del padre
                            padre.setIzquierdo(n.getIzquierdo());
                        }else{
                            padre.setDerecho(n.getIzquierdo()); // si n es el hijo der del padre
                        }
                    }
                    if(n.getDerecho() != null && n.getIzquierdo() == null){ // SI ES EL HIJO DER
                        if(nElem.compareTo(padre) < 0 ){ // si n es el hijo izq de padre
                            padre.setIzquierdo(n.getDerecho());
                        }else{  // sino n es el hijo derecho
                            padre.setDerecho(n.getDerecho());
                        }
                    }
                    
                    //CUANDO N TIENE 2 HIJOS
                    if(n.getIzquierdo() != null && n.getDerecho() != null){
                        NodoABB nCandidato= n.getIzquierdo().getDerecho();// obtenemos el nodo con el elemento candidato
                        NodoABB padreCandidato= n.getIzquierdo(); // obtenemos el nodo del padre del nodo con el elemento candidato
                        NodoABB nAux= n.getIzquierdo().getDerecho();
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
            }
        }
        return exito;
    }
    public boolean eliminarMinimo(){
        boolean exito= false;
        if(this.raiz != null){
            exito= eliminarMinimoAux(this.raiz, null);
        }
        return exito;
    }
    private boolean eliminarMinimoAux(NodoABB n, NodoABB nPadre){
        boolean exito= false;
        if(n != null){
            if(n.getIzquierdo() == null){
                if(n.getDerecho()!= null){
                    nPadre.setIzquierdo(n.getDerecho());
                }else{
                    nPadre.setIzquierdo(null);
                }
                exito= true;
            }else{
                exito= eliminarMinimoAux(n.getIzquierdo(), n);
            }
        }
        return exito;
    }
    public boolean insertarInvertido(Comparable e){
        boolean exito= true;
        if(this.raiz != null){
            insertarInvertidoAux(this.raiz, e);
        }else{
            this.raiz= new NodoABB(e);
        }
        
        return exito;
    }
    private boolean insertarInvertidoAux(NodoABB n, Comparable e){
        boolean exito= true;
        if(e.compareTo(n.getElemento()) == 0){ //Compara si el elemento es igual 
            exito= false;
        }else{
            if(e.compareTo(n.getElemento()) > 0){
                if(n.getIzquierdo() != null){ // si el nodo tiene al menos un hijo izquierdo
                    exito= insertarInvertidoAux(n.getIzquierdo(), e);
                }else{
                    n.setIzquierdo(new NodoABB(e));
                }
            }else{
                // si sigue por aca es pq e es mayor que el elemento que contiene n
                if(n.getDerecho() != null){
                    exito= insertarInvertidoAux(n.getDerecho(), e);
                }else{
                    n.setDerecho(new NodoABB(e));
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
    public String toStringAux(NodoABB unNodoArbol, String unString){
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
    public ArbolBB clone(){
        ArbolBB otroArbolBin= new ArbolBB();
        if(this.raiz != null){ //verificamos que el arbol a clonar no este vacio.
            otroArbolBin.raiz= new NodoABB(this.raiz.getElemento());
            cloneAux(this.raiz, otroArbolBin.raiz);
        }
        return otroArbolBin;
    }
    private void cloneAux(NodoABB NodoArbolAux, NodoABB unNodoArbol){
        if(NodoArbolAux != null){ // condicion de corte
            if(NodoArbolAux.getIzquierdo() != null){ //verificamos que el nodoArbolAux tenga hijoIzquierdo
                unNodoArbol.setIzquierdo(new NodoABB(NodoArbolAux.getIzquierdo().getElemento())); //lo enlazamos
            }
            if(NodoArbolAux.getDerecho()!= null){ //verificamos que el nodoArbolAux tenga hijoDerecho
                unNodoArbol.setDerecho(new NodoABB(NodoArbolAux.getDerecho().getElemento())); //Lo enlazamos 
            }
            cloneAux(NodoArbolAux.getIzquierdo(),unNodoArbol.getIzquierdo()); //Repetimos el procedimiento con el subArbol izq
            cloneAux(NodoArbolAux.getDerecho(), unNodoArbol.getDerecho()); //Repetimos el procedimiento con el subArbol der
        }
    }
    /* CLON INVERTIDO*/
    public ArbolBB clonarParteInvertida(Comparable e){
        ArbolBB otroABB= new ArbolBB();
        boolean exito= false;
        if(this.raiz != null){
            otroABB.raiz= new NodoABB(e);
            exito= clonarParteInvertidaAux(this.raiz, otroABB.raiz, e);
        }
        if(!exito){
            otroABB.raiz= null;
        }
        return otroABB;
    }
    private boolean clonarParteInvertidaAux(NodoABB n, NodoABB nClon, Comparable e){
        /*ESTE METODO BUSCA EL ELEMENTO INGRESADO POR PARAMETRO EN EL ARBOL ORIGINAL Y CUANDO LO ENCUENTRA CLONA EL SUBARBOL DE MANERA INVERTIDA*/
        boolean exito= false;
        if(n != null){
            if(n.getElemento().compareTo(e) == 0){
                cloneInvertidoAux(n, nClon);
                exito= true;
            }else{
                if(e.compareTo(n.getElemento()) < 0){
                    exito= clonarParteInvertidaAux(n.getIzquierdo(), nClon, e);
                }else{
                    exito= clonarParteInvertidaAux(n.getDerecho(), nClon, e);
                }
            }
        }
        return exito;
    }
    
    public ArbolBB cloneInvertido(){
        ArbolBB otroArbolBin= new ArbolBB();
        if(this.raiz != null){ //verificamos que el arbol a clonar no este vacio.
            otroArbolBin.raiz= new NodoABB(this.raiz.getElemento());
            cloneAux(this.raiz, otroArbolBin.raiz);
        }
        return otroArbolBin;
    }
    private void cloneInvertidoAux(NodoABB NodoArbolAux, NodoABB unNodoArbol){
        if(NodoArbolAux != null){ // condicion de corte
            if(NodoArbolAux.getIzquierdo() != null){ //verificamos que el nodoArbolAux tenga hijoIzquierdo
                unNodoArbol.setDerecho(new NodoABB(NodoArbolAux.getIzquierdo().getElemento())); //lo enlazamos
            }
            if(NodoArbolAux.getDerecho()!= null){ //verificamos que el nodoArbolAux tenga hijoDerecho
                unNodoArbol.setIzquierdo(new NodoABB(NodoArbolAux.getDerecho().getElemento())); //Lo enlazamos 
            }
            cloneInvertidoAux(NodoArbolAux.getIzquierdo(),unNodoArbol.getDerecho()); //Repetimos el procedimiento con el subArbol izq y mandamos el subArbol der del clon
            cloneInvertidoAux(NodoArbolAux.getDerecho(), unNodoArbol.getIzquierdo()); //Repetimos el procedimiento con el subArbol der
        }
    }
    public Lista listarMayores(Comparable valor, Comparable elem){
        Lista lis= new Lista ();
        if(this.raiz!= null){
            buscarYListar(this.raiz, valor, elem, lis);
        }
        return lis;
    }
    private void buscarYListar(NodoABB n, Comparable valor, Comparable e, Lista lis){
        if(n != null){
            if(n.getElemento().compareTo(e) == 0){
                System.out.println(" pasa por aca?");
                listarMayoresAux(n, valor, lis);
            }else{
                if(e.compareTo(n.getElemento()) > 0){
                    buscarYListar(n.getDerecho(), valor, e, lis);
                }else{
                    buscarYListar(n.getIzquierdo(), valor, e, lis);
                }
            }
        }
    }
    private void listarMayoresAux(NodoABB n, Comparable valor, Lista lis){
        if(n != null){
            if(n.getElemento().compareTo(valor) > 0 || n.getElemento().compareTo(valor) == 0){
                System.out.println("pasa por aca 2");
                lis.insertar(n.getElemento(), lis.longitud()+1);
                if(n.getIzquierdo() != null){
                    listarMayoresAux(n.getIzquierdo(), valor, lis);
                }
                if(n.getDerecho()!= null){
                    listarMayoresAux(n.getDerecho(), valor, lis);
                }
            }else{
                listarMayoresAux(n.getDerecho(), valor, lis);
            }
        }
    }
    public int sumarPosordenDesde(int dato, int z){
        int suma=0;
        if(this.raiz != null){
            NodoABB nDato= buscar(this.raiz, dato);
            if(nDato != null){
                suma= sumarPosordenDesdeAux(nDato, z ,0);
            }
            if(suma < z){
                suma= -suma;
            }
        }
        return suma;
    }
    private NodoABB buscar(NodoABB n, int dato){
        NodoABB buscado= null;
        if(n != null){
            if(n.getElemento().equals(dato)){
                buscado= n;
            }else{
                if((int)n.getElemento() > dato){
                    buscado= buscar(n.getIzquierdo(), dato);
                }else{
                    buscado= buscar(n.getDerecho(), dato);
                }
            }
        }
        return buscado;
    }
    private int sumarPosordenDesdeAux(NodoABB n, int z, int s){
        int suma=s;
        if(n != null){
            if(suma < z && n.getIzquierdo() != null){
                suma= sumarPosordenDesdeAux(n.getIzquierdo(), z, suma);
            }
            if(suma < z && n.getDerecho() != null){
                suma= sumarPosordenDesdeAux(n.getDerecho(), z, suma);
            }
            if(suma < z){
                System.out.println("suma: "+ (int)n.getElemento());
                suma += (int) n.getElemento();
            }
        }
        return suma;
    }
}
