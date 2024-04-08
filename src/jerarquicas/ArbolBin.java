/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leonel LLancaqueo
 */
public class ArbolBin {
    private NodoArbol raiz;
    
    public ArbolBin(){
        this.raiz= null;
    }
    public Object Padre(Object elemento){
        /**/
        NodoArbol nodoPadre= obtenerNodoPadre(this.raiz, elemento);
        Object elementoPadre= null;
        if(nodoPadre != null){
            elementoPadre= nodoPadre.getElemento();
        }
        return elementoPadre;
    }
    private NodoArbol obtenerNodoPadre(NodoArbol unNodo, Object buscado){
        /*ESTE METODO PERMITE OBTENER EL NODOARBOL DONDE SE ENCUENTRA UN ELEMENTO BUSCADO, INGRESADO POR PARAMETRO. SI 
        EL ELEMENTO NO SE ENCUENTRA EN EL ARBOL ENTONCES SE RETORNA NULL*/
        NodoArbol resultado= null;
        if(unNodo != null){ //verifica que el nodo ingresado no sea null(condicion de corte)
            if(unNodo.getIzquierdo() != null){   // verifica si tiene hijoIzquierdo
                if(unNodo.getIzquierdo().getElemento().equals(buscado)){ //verifica si el elemento del hijoIzquierdo contiene al elemento buscado
                    resultado= unNodo;
                }
            }
            if(resultado == null){ //verifica si el elemento fue encontrado, si no prueba de la misma manera con el hijoDerecho
                if(unNodo.getDerecho() != null){   
                    if(unNodo.getDerecho().getElemento().equals(buscado)){
                        resultado= unNodo;
                    }
                }
            }
            // si no se encontraban en ninguno de los dos hijos del nodo actual repite el procedimiento con el hijoIzquierdo
            if(resultado == null){
                resultado= obtenerNodoPadre(unNodo.getIzquierdo(), buscado);
            }
            // si no se encuentra por el lado del nodo izquierdo se prueba de la misma manera por el lado del hijoDerecho
            if(resultado == null){
                resultado= obtenerNodoPadre(unNodo.getDerecho(), buscado);
            }
        }
        return resultado;
    }
    
    private NodoArbol obtenerNodo(NodoArbol unNodo, Object buscado){
        /*ESTE METODO PERMITE OBTENER EL NODOARBOL DONDE SE ENCUENTRA UN ELEMENTO BUSCADO, INGRESADO POR PARAMETRO. SI 
        EL ELEMENTO NO SE ENCUENTRA EN EL ARBOL ENTONCES SE RETORNA NULL*/
        NodoArbol resultado= null;
        if(unNodo != null){ //verifica que el nodo ingresado no sea null(condicion de corte)
            if(unNodo.getElemento().equals(buscado)){   //verifica si el elemento encontrado se encuentra en el nodo pasado por parametro 
                resultado= unNodo;
            }else{
                //si no se encontro el elemento en el nodo pasado por parametro buscamos primero en el nodo hijoIzquierdo
                resultado = obtenerNodo(unNodo.getIzquierdo(), buscado);  
                if(resultado == null){ //si el resultado de la busqueda del nodo en el hijo izq es null entonces se busca en el nodoHijoDerecho
                    resultado = obtenerNodo(unNodo.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
    public int nivel(Object elemento){
        int nivel= -1;
        if(this.raiz != null){
            nivel= nivelAux(this.raiz, elemento);
        }
        return nivel;
    }
    private int nivelAux(NodoArbol unNodoArbol, Object elemento){
        /*revisar*/
        int cont= -1;
        if(unNodoArbol != null){
            if(unNodoArbol.getElemento().equals(elemento)){
                cont= 0;
            }
            else{
                
                cont= nivelAux(unNodoArbol.getIzquierdo(), elemento) +1;
                if(cont == -1){
                    cont= nivelAux(unNodoArbol.getDerecho(), elemento) +1;
                }
            }
        }
        return cont;
    }
    public ArbolBin(NodoArbol raiz) {
        this.raiz = raiz; 
    }
    public int alturaArbolBinario(){
        return alturaArbolBinarioAux(this.raiz)-1;
    }
    private int alturaArbolBinarioAux(NodoArbol unNodoArbol){
        int contDer=0, contIzq=0, altura;
        if(unNodoArbol != null){
            contIzq= alturaArbolBinarioAux(unNodoArbol.getIzquierdo()) + 1;
            contDer= alturaArbolBinarioAux(unNodoArbol.getDerecho()) + 1;
        }
        if(contDer >= contIzq){
            altura= contDer;
        }else{
            altura= contIzq;
        }
        return altura;
    }
    public ArbolBin clone(){
        ArbolBin otroArbolBin= new ArbolBin();
        if(this.raiz != null){ //verificamos que el arbol a clonar no este vacio.
            otroArbolBin.raiz= new NodoArbol(this.raiz.getElemento());
            cloneAux(this.raiz, otroArbolBin.raiz);
        }
        return otroArbolBin;
    }
    private void cloneAux(NodoArbol NodoArbolAux, NodoArbol unNodoArbol){
        if(NodoArbolAux != null){ // condicion de corte
            if(NodoArbolAux.getIzquierdo() != null){ //verificamos que el nodoArbolAux tenga hijoIzquierdo
                unNodoArbol.setIzquierdo(new NodoArbol(NodoArbolAux.getIzquierdo().getElemento())); //lo enlazamos
            }
            if(NodoArbolAux.getDerecho()!= null){ //verificamos que el nodoArbolAux tenga hijoDerecho
                unNodoArbol.setDerecho(new NodoArbol(NodoArbolAux.getDerecho().getElemento())); //Lo enlazamos 
            }
            cloneAux(NodoArbolAux.getIzquierdo(),unNodoArbol.getIzquierdo()); //Repetimos el procedimiento con el subArbol izq
            cloneAux(NodoArbolAux.getDerecho(), unNodoArbol.getDerecho()); //Repetimos el procedimiento con el subArbol der
        }
    }
    public void alterarPadre(Object hi,Object hd,Object pp){
        if(this.raiz != null){
            alterarPadreAux(hi, hd, pp, this.raiz);
        }
    }
    private void alterarPadreAux(Object hi,Object hd,Object pp, NodoArbol nodoAux){
        if(nodoAux != null){
            if(nodoAux.getElemento().equals(pp)){
                if(nodoAux.getIzquierdo() != null){
                    nodoAux.getIzquierdo().setElemento(hi);
                }else{
                    nodoAux.setIzquierdo(new NodoArbol(hi));
                }
                if(nodoAux.getDerecho() != null){
                    nodoAux.getDerecho().setElemento(hd);
                }else{
                    nodoAux.setDerecho(new NodoArbol(hd));
                }   
                nodoAux= null;
            }else{
                alterarPadreAux(hi, hd, pp, nodoAux.getIzquierdo());
                alterarPadreAux(hi, hd, pp, nodoAux.getDerecho());
            }   
        }
    }
    
    public boolean insertar(Object elemInsertar, Object elemPadre, char ubicacion){
        boolean insertado= true;
        if(this.raiz == null){
            this.raiz= new NodoArbol(elemInsertar);
        }else{
            //si el arbol no esta vacio se busca al nodo padre
            NodoArbol nodoPadre= obtenerNodo(this.raiz, elemPadre);
            if(nodoPadre != null){
                //se comprueba si el nodo padre tiene hijo izquierdo, se inserta el nodo.
                if(nodoPadre.getIzquierdo()== null && ubicacion == 'I'){
                    nodoPadre.setIzquierdo(new NodoArbol(elemInsertar));
                }else{
                    //se comprueba si el nodo padre tiene hijo derecho, se inserta el nodo.
                    if(nodoPadre.getDerecho()== null && ubicacion == 'D'){
                        nodoPadre.setDerecho(new NodoArbol(elemInsertar));
                    }else{
                        insertado= false;
                    }
                }
            }else{
                insertado= false;
            }
        }
        return insertado;
    }
    public boolean esVacio(){
        return this.raiz == null;
    }
    public void vaciar(){
        this.raiz = null;
    }
    public Lista listarPreorden(){
        Lista unaLista= new Lista();
        listarPreordenAux(this.raiz, unaLista);
        return unaLista;
    }
    private void listarPreordenAux(NodoArbol nodoRaiz, Lista unaLista){
        /*ESTE METODO PERMITE RECORRER A UN ARBOL EN POSORDEN(SE RECORRE VISITANDO LA RAIZ DEL ARBOL Y LUEGO LOS
        SUBARBOLES IZQ Y DERECHO CON EL MISMO METODO)*/
        
        if(nodoRaiz != null){
                //insertamos la raiz del arbol en la lista
            unaLista.insertar(nodoRaiz.getElemento(), unaLista.longitud()+1);
                //realizamos lo mismo con el subArbol del hijoIzquierdo
            listarPreordenAux(nodoRaiz.getIzquierdo(), unaLista);
                //realizamos lo mismo con el subArbol del hijoDerecho
            listarPreordenAux(nodoRaiz.getDerecho(), unaLista);
        }
    }
    public Lista listarInorden(){
        Lista unaLista= new Lista();
        listarInordenAux(this.raiz, unaLista);
        return unaLista;
    }
    private void listarInordenAux(NodoArbol unNodoArbol, Lista unaLista){
        //METODO AUX PARA LISTAR A LOS ELEMENTOS DEL ARBOL BIN, EN LA LISTA INGRESADA POR PARAMETRO, EN INORDEN 
        if(unNodoArbol != null){
                //realizamos lo mismo con los subArboles izquierdos
            listarInordenAux(unNodoArbol.getIzquierdo(), unaLista);
                //insertamos primero el elemento del nodo
            unaLista.insertar(unNodoArbol.getElemento(), unaLista.longitud()+1);
                //luego insertamos el elemento del nodo padre en la lista
            listarInordenAux(unNodoArbol.getDerecho(), unaLista);

        }  
    }
    public Lista listarPosorden(){
        Lista unaLista= new Lista();
        listarPosordenAux(this.raiz, unaLista);
        return unaLista;
    }
    private void listarPosordenAux(NodoArbol unNodoArbol, Lista unaLista){
        if(unNodoArbol != null){
            listarPosordenAux(unNodoArbol.getIzquierdo(), unaLista);
            if(unNodoArbol.getDerecho() != null){
                listarPosordenAux(unNodoArbol.getDerecho(), unaLista);
            }
            unaLista.insertar(unNodoArbol.getElemento(), unaLista.longitud()+1);
        }
    }
     public boolean verificarPatron(Lista lisPatron) {
        boolean exito = false;
        if (this.raiz != null && !lisPatron.esVacia()) {
            exito = verificarPatronRecursivo(lisPatron, this.raiz, 1);
        }
        return exito;
    }
    private boolean verificarPatronRecursivo(Lista lis, NodoArbol n, int p){
        boolean exito= true;
        if(n != null){
            if(p <= lis.longitud()){
                if(n.getElemento().equals(lis.recuperar(p))){
                    exito= verificarPatronRecursivo(lis, n.getIzquierdo(), p+1);
                    
                    if(!exito){
                        exito= verificarPatronRecursivo(lis, n.getDerecho(), p+1);
                    }
                }else{
                    exito= false;
                }
            }else{
                exito= false;
            }
        }
        return exito;
    }
     /*
    private boolean verificarPatronRecursivo(Lista lista, NodoArbol nodo, int pos) {
        boolean controlIzq = false, controlDer= false, control= true;

        if (pos <= lista.longitud()) {
            System.out.println("longitud check.");
            if(nodo != null){
                if (nodo.getElemento().equals(lista.recuperar(pos))) {
                    //System.out.println("Igualdad check, entre: " + nodo.getElemento()+ " y " + lista.recuperar(pos));
                    control = true;
                }else{
                    control = false;
                }
                if (control) {
                    //System.out.println("Recursivo Izq. entre: " + nodo.getIzquierdo().getElemento()+ " y " + lista.recuperar(pos + 1));
                    controlIzq = verificarPatronRecursivo(lista, nodo.getIzquierdo(), pos + 1);
                }
                if (!controlIzq && control) {
                    //System.out.println("Recursivo Der. entre: " + nodo.getDerecho().getElemento()+ " y " + lista.recuperar(pos));
                    control = verificarPatronRecursivo(lista, nodo.getDerecho(), pos + 1 );
                }
            }else{
                control= false;
            }
        }
        return control;
    }
    */
    public Lista obtenerDecendientes(Object elemento){
        Lista unaLista= new Lista();
        if(this.raiz != null){
            obtenerDecendientesAux(this.raiz, unaLista, elemento, false);
        }
        return unaLista;
    }
    private void obtenerDecendientesAux(NodoArbol unNodoArbol, Lista unaLista, Object elemento, boolean encontrado){
        boolean esEncontrado= encontrado;
        if(unNodoArbol != null){
            if(unNodoArbol.getElemento().equals(elemento)){
                esEncontrado= true;
            }
            if(esEncontrado && unNodoArbol.getIzquierdo() != null){
                unaLista.insertar(unNodoArbol.getIzquierdo().getElemento(), unaLista.longitud()+1);
            }
            if(esEncontrado && unNodoArbol.getDerecho()!= null){
                unaLista.insertar(unNodoArbol.getDerecho().getElemento(), unaLista.longitud()+1);
            }
            obtenerDecendientesAux(unNodoArbol.getIzquierdo(), unaLista, elemento, esEncontrado);
            obtenerDecendientesAux(unNodoArbol.getDerecho(), unaLista, elemento, esEncontrado);      
        }
    }
    public String toString(){
        String unString= "";
        if(this.raiz != null){
            unString= toStringAux(this.raiz, unString);
        }
        return unString;
    }
    public String toStringAux(NodoArbol unNodoArbol, String unString){
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
    public Lista frontera(){
        Lista lis= new Lista();
        if(this.raiz != null){
            fronteraAux(this.raiz , lis);
        }
        return lis;
    }
    private void fronteraAux(NodoArbol n, Lista lis){
        if(n != null){
            if(n.getIzquierdo() != null){
                fronteraAux(n.getIzquierdo(), lis);
            }
            if(n.getIzquierdo() == null && n.getDerecho()== null){
                lis.insertar(n.getElemento(), lis.longitud()+1);
            }
            if(n.getDerecho() != null){
                fronteraAux(n.getDerecho(), lis);
            }
        }
    }
    public ArbolBin clonarInvertido(){
        ArbolBin unArbol= new ArbolBin();
        if(this.raiz != null){
            unArbol.raiz= new NodoArbol(this.raiz.getElemento());
            clonarInvertidoAux(this.raiz, unArbol.raiz);
        }
        return unArbol;
    }
    private void clonarInvertidoAux(NodoArbol n , NodoArbol m){
        if(n != null){
            if(n.getIzquierdo() != null){
                m.setDerecho(new NodoArbol(n.getIzquierdo().getElemento()));
            }
            if(n.getDerecho()!= null){
                m.setIzquierdo(new NodoArbol(n.getDerecho().getElemento()));
            }
            clonarInvertidoAux(n.getIzquierdo(), m.getDerecho());
            clonarInvertidoAux(n.getDerecho(), m.getIzquierdo());
        }
    }
    public boolean verificarIguales(ArbolBin otro){
        boolean iguales= false;
        if(this.raiz != null && otro.raiz != null){
            iguales= verificarIgualesAux(this.raiz, otro.raiz);
        }else{
            if(this.raiz == null && otro.raiz == null){
                iguales= true;
            }
        }
        return iguales;
    }
    private boolean verificarIgualesAux(NodoArbol n, NodoArbol m){
        boolean iguales= true;
        
        if(n!= null || m!= null){
            if(n!= null && m!= null){
                if(n.getElemento().equals(m.getElemento())){
                    iguales= verificarIgualesAux(n.getIzquierdo(), m.getIzquierdo());
                    if(iguales){
                        iguales= verificarIgualesAux(n.getDerecho(), m.getDerecho());
                    }
                }else{
                    iguales = false;
                }
            }else{
                iguales= false;
            }
        }
        return iguales;
    }
}

