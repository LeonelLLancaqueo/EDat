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
public class Diccionario {
    private NodoAVLDicc raiz;
    
    public Diccionario(){
        this.raiz= null;
    }
    public Object obtenerDato(Comparable e){
        Object dato= null;
        if(this.raiz != null && e != null){
            dato= obtenerDatoAux(this.raiz, e);
        }
        
        return dato;
    }
    
    private Object obtenerDatoAux(NodoAVLDicc n, Comparable e){
        Object dato= null;
        if(n != null){
            if(e.compareTo(n.getClave()) == 0){
            dato= n.getDato();
            }else{
                if(e.compareTo(n.getClave()) < 0){
                    dato= obtenerDatoAux(n.getIzquierdo(), e);
                }else{
                    dato= obtenerDatoAux(n.getDerecho(), e);
                }
            }
        }
        return dato;
    }
    
    public boolean existeClave(Comparable e){
        boolean seEncuentra= false;
        if(this.raiz != null && e != null){
            seEncuentra= existeClaveAux(this.raiz, e);
        }
        return seEncuentra;
    }
    
    private boolean existeClaveAux(NodoAVLDicc n, Comparable e){
        boolean exito= false;
        if(n != null){
            if(e.compareTo(n.getClave()) == 0){
            exito= true;
            }else{
                if(e.compareTo(n.getClave()) < 0){
                    exito= existeClaveAux(n.getIzquierdo(), e);
                }else{
                    exito= existeClaveAux(n.getDerecho(), e);
                }
            }
        }
        return exito;
    }
    
    public Lista listarClaves(){
        //metodo que devuelve una lista de menor a mayor del arbol
        Lista unaLista= new Lista();
        if(this.raiz != null){
            listarClavesAux(this.raiz, unaLista);
        }
        return unaLista;
    }
    
    private void listarClavesAux(NodoAVLDicc n, Lista lis){
        if(n != null){
            listarClavesAux(n.getIzquierdo(), lis); //bajamos recursivamente por los hijosIzquierdos hasta el ultimo
            
            lis.insertar(n.getClave() , lis.longitud()+1); // insertamos el elemento en la lista

            listarClavesAux(n.getDerecho(), lis); // repetimos el procedimiento con los hijos derechos

        }
    }
    
    public Lista listarDatos(){
        //metodo que devuelve una lista de menor a mayor del arbol
        Lista unaLista= new Lista();
        if(this.raiz != null){
            listarDatosAux(this.raiz, unaLista);
        }
        return unaLista;
    }
    
    private void listarDatosAux(NodoAVLDicc n, Lista lis){
        if(n != null){
            listarDatosAux(n.getIzquierdo(), lis); //bajamos recursivamente por los hijosIzquierdos hasta el ultimo
            
            lis.insertar((String) n.getDato() , lis.longitud()+1); // insertamos el elemento en la lista

            listarDatosAux(n.getDerecho(), lis); // repetimos el procedimiento con los hijos derechos

        }
    }
    
    //FUNCIONES DE ARBOL AVL
    
    public Comparable minimoElem(){
        return minimoElemAux(this.raiz);
    }
    
    private Comparable minimoElemAux(NodoAVLDicc n){
        Comparable elemt= null;
        while(n != null){
            elemt= n.getClave();
            n= n.getIzquierdo();
        }
        return elemt;
    }
    
    public Comparable maximoElem(){
        return maximoElemAux(this.raiz);
    }
    
    private Comparable maximoElemAux(NodoAVLDicc n){
        Comparable elemt= null;
        while(n != null){
            elemt= n.getClave();
            n= n.getDerecho();
        }
        return elemt;
    }
    
    public void vaciar(){
        this.raiz= null;
    }
    
    private int balance(NodoAVLDicc n){
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
    
    private NodoAVLDicc rotarDerecha(NodoAVLDicc n){
        NodoAVLDicc h= n.getIzquierdo();
        NodoAVLDicc temp= h.getDerecho();
        h.setDerecho(n);
        n.setIzquierdo(temp);
        n.recalcularAltura();
        h.recalcularAltura();
        return h;
    }
    
    private NodoAVLDicc rotarIzquierda(NodoAVLDicc n){
        NodoAVLDicc h= n.getDerecho();
        NodoAVLDicc temp= h.getIzquierdo();
        h.setIzquierdo(n);
        n.setDerecho(temp);
        n.recalcularAltura();
        h.recalcularAltura();
        return h;
    }
    public void rotarSimpleDerecha(NodoAVLDicc n, NodoAVLDicc nPadre, boolean esRaiz){
        if(esRaiz){ 
            this.raiz=rotarDerecha(n);//si n es la raiz entonces al rotar a la derecha se le asigna la nueva raiz del subArbol al arbol
     
        }else{
            if(n.getClave().compareTo(nPadre.getClave())> 0){ //nos fijamos si n es el HI de nPadre
                nPadre.setDerecho(rotarDerecha(n)); // 
            }else{ // sino es el HI de nPadre
                nPadre.setIzquierdo(rotarDerecha(n));
            }
           
        }
        
    }
    public void rotarSimpleIzquierda(NodoAVLDicc n, NodoAVLDicc nPadre, boolean esRaiz){
        if(esRaiz){
            this.raiz=rotarIzquierda(n);
            
        }else{
            if(n.getClave().compareTo(nPadre.getClave())> 0){
                nPadre.setDerecho(rotarIzquierda(n));
            }else{
                nPadre.setIzquierdo(rotarIzquierda(n));
            }
           
        }
    }
    public void rotarDobleIzquierdaDerecha(NodoAVLDicc n, NodoAVLDicc nPadre, boolean esRaiz){
        n.setIzquierdo(rotarIzquierda(n.getIzquierdo()));
        if(esRaiz){
            this.raiz=rotarDerecha(this.raiz);
        }else{
            if(n.getClave().compareTo(nPadre.getClave())> 0){ //nos fijamos si n es el HI de nPadre
                nPadre.setDerecho(rotarDerecha(n)); // 
            }else{ // sino es el HI de nPadre
                nPadre.setIzquierdo(rotarDerecha(n));
            }
        }
      
    }
    
    public void rotarDobleDerechaIzquierda(NodoAVLDicc n, NodoAVLDicc nPadre, boolean esRaiz){
        n.setDerecho(rotarDerecha(n.getDerecho()));
        if(esRaiz){
            this.raiz=rotarIzquierda(n);
        }else{

            if(n.getClave().compareTo(nPadre.getClave())> 0){
                nPadre.setDerecho(rotarIzquierda(n));
            }else{
                nPadre.setIzquierdo(rotarIzquierda(n));
            }

        }
        
    }
    
    private void verificarBalance(NodoAVLDicc n, NodoAVLDicc nPadre){
        boolean esRaiz= false;
        if(n.getClave().compareTo(this.raiz.getClave()) == 0){ // verificamos si n es la raiz del arbol
            esRaiz= true;
        }
        if(balance(n) == 2){ // SI EL BALANCE ES 2 ENTONCES NOS FIJAMOS EN EL BALANCE DEL NODO HIJOIZQUIERDO
            int balanceHI= balance(n.getIzquierdo()); 
            if( balanceHI == 1 || balanceHI == 0 ){
                rotarSimpleDerecha(n, nPadre, esRaiz);
            }else{
                rotarDobleIzquierdaDerecha(n, nPadre, esRaiz);
            }
        }else{
        
        }
        if(balance(n) == -2){
            int balanceHD= balance(n.getDerecho()); 
            if( balanceHD == -1 || balanceHD == 0  ){
                rotarSimpleIzquierda(n, nPadre, esRaiz);
            }else{
                rotarDobleDerechaIzquierda(n, nPadre, esRaiz);
            }
            
        }
    }
    
    public boolean insertar(Comparable clave, Object dato){
        boolean exito= true;
        if(this.raiz != null && clave != null && dato != null){
            exito= insertarAux(this.raiz, null, clave, dato);
        }else{
            this.raiz= new NodoAVLDicc(clave, dato);
        }
        
        return exito;
    }
    
    private boolean insertarAux(NodoAVLDicc n, NodoAVLDicc nPadre, Comparable e, Object d){
        boolean exito= true;
        if(e.compareTo(n.getClave()) == 0){ //Compara si el elemento es igual 
            exito= false;
        }else{
            if(e.compareTo(n.getClave()) < 0){
                if(n.getIzquierdo() != null){ // si el nodo tiene al menos un hijo izquierdo
                    exito= insertarAux(n.getIzquierdo(), n, e, d);
                }else{
                    n.setIzquierdo(new NodoAVLDicc(e, d));
                }
            }else{
                // si sigue por aca es pq e es mayor que el elemento que contiene n
                if(n.getDerecho() != null){
                    exito= insertarAux(n.getDerecho(),n, e, d);
                }else{
                    n.setDerecho( new NodoAVLDicc(e, d));
                }
            }
            if(exito){
                n.recalcularAltura();
                verificarBalance(n, nPadre);

            }
        }
        return exito;
    }
    
    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo){
        //metodo que devuelve una lista de los elementos que esten dentro del rango de los elementos min y max ingresados por parametro
        Lista unaLista= new Lista();
        if(this.raiz != null && elemMinimo != null && elemMaximo != null) {
            listarRangoAux(this.raiz, unaLista, elemMinimo, elemMaximo);
        }
        return unaLista;
    }
    
    private void listarRangoAux(NodoAVLDicc n, Lista lis, Comparable min, Comparable max){
        if(n != null){
            Comparable nElem= n.getClave();
            if(nElem.compareTo(max) >= 0 || nElem.compareTo(min) > 0 ){ // si el maximo es menor al elemento del nodo.
                
                listarRangoAux(n.getIzquierdo(), lis, min, max); //bajamos recursivamente por los hijosIzquierdos 
            }
            if((nElem.compareTo(min) >= 0 && nElem.compareTo(max) <= 0)){ //si el elemento minimo es menor que el elemento del nodo 
                    lis.insertar(nElem, lis.longitud()+1); // listamos el elemento del nodo
                }
            if(nElem.compareTo(max) < 0 ){
                //si el maximo es mayor al elemento del nodo.
                listarRangoAux(n.getDerecho(), lis, min, max); // repetimos el procedimiento con los hijos derechos
            }
        }
    }
    public Lista listarDatosRango(Comparable elemMinimo, Comparable elemMaximo){
        //metodo que devuelve una lista de los elementos que esten dentro del rango de los elementos min y max ingresados por parametro
        Lista unaLista= new Lista();
        if(this.raiz != null && elemMinimo != null && elemMaximo != null) {
            listarDatosRangoAux(this.raiz, unaLista, elemMinimo, elemMaximo);
        }
        return unaLista;
    }
    
    private void listarDatosRangoAux(NodoAVLDicc n, Lista lis, Comparable min, Comparable max){
        if(n != null){
            Comparable nElem= n.getClave();
            if(nElem.compareTo(max) >= 0 || nElem.compareTo(min) > 0 ){ // si el maximo es menor al elemento del nodo.
                
                listarDatosRangoAux(n.getIzquierdo(), lis, min, max); //bajamos recursivamente por los hijosIzquierdos 
            }
            if((nElem.compareTo(min) >= 0 && nElem.compareTo(max) <= 0)){ //si el elemento minimo es menor que el elemento del nodo 
                    lis.insertar(n.getDato(), lis.longitud()+1); // listamos el elemento del nodo
                }
            if(nElem.compareTo(max) < 0 ){
                //si el maximo es mayor al elemento del nodo.
                listarDatosRangoAux(n.getDerecho(), lis, min, max); // repetimos el procedimiento con los hijos derechos
            }
        }
    }
    
    public Lista listarMayoresQue(Comparable elemMinimo){
        //metodo que devuelve una lista de los elementos que esten dentro del rango de los elementos min y max ingresados por parametro
        Lista unaLista= new Lista();
        if(this.raiz != null && elemMinimo != null){
            listarMayoresQueAux(this.raiz, unaLista, elemMinimo);
        }
        return unaLista;
    }
    
    private void listarMayoresQueAux(NodoAVLDicc n, Lista lis, Comparable min){
        /*ESTE METODO RETORNA UNA LISTA CON LOS ELEMENTOS QUE SEAN MAYORES COMPARABLEMTE QUE ELEMENTO INGRESADO POR PARAMETRO*/
        if(n != null){
            Comparable nElem= n.getClave();
            if(nElem.compareTo(min) >= 0  ){ // si el elem del nodo es mayor o igual al elemento minimo 
                listarMayoresQueAux(n.getIzquierdo(), lis, min); //bajamos recursivamente por los hijosIzquierdos 
                listarMayoresQueAux(n.getDerecho(), lis, min);
            }
            if(nElem.compareTo(min) >= 0 ){ //si el elemento minimo es menor que el elemento del nodo 
                    lis.insertar(nElem, lis.longitud()+1); // listamos el elemento del nodo
                }
            if(nElem.compareTo(min) < 0 ){
                //el elemento del nodo es meonor que min
                listarMayoresQueAux(n.getDerecho(), lis, min); // repetimos el procedimiento con los hijos derechos
            }
        }
    }
    
    
    public int alturaArbolAVL(){
        return alturaArbolAVLAux(this.raiz)-1;
    }
    
    private int alturaArbolAVLAux(NodoAVLDicc unNodoArbol){
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
        if(this.raiz != null && e != null){
            if(this.raiz.getClave().compareTo(e) == 0 && this.raiz.getDerecho() == null && this.raiz.getIzquierdo()== null){
                this.raiz= null;
            }else{
                exito= eliminarAux(this.raiz, null, e);
            }
        }
        return exito;
    }
    private void eliminarConDosHijos(NodoAVLDicc padreCandidato,NodoAVLDicc nCandidato, NodoAVLDicc n, NodoAVLDicc nPadre){
        /* metodo utilizado para eliminar un nodo que tiene dos hijos 
        el nodo padre candidato es el nodo hijo izquierdo del nodo a eliminar
        el nodo nCandidato es el hijo derecho de nodo padreCandidato
        y n es el nodo a eliminar
        nPadre es el padre de n, utilizado para verificar el balance
        */
        if(nCandidato != null){
            eliminarConDosHijosAux(padreCandidato, nCandidato, n);
        }else{// si el nodo nCandidato es nulo entonces reemplazamos al nodo izq del nodo a eliminar como nuevo nodo 
            
            /*seteamos la clave y los atributos*/
            n.setClave(padreCandidato.getClave());
            n.setDato(padreCandidato.getDato());
            if(padreCandidato.getIzquierdo() != null){ // si nPadre tenia un hijo izq
                n.setIzquierdo(padreCandidato.getIzquierdo()); //lo seteamos como hijo izq de n
            }else{
                n.setIzquierdo(null);
            } 
        }
        n.recalcularAltura();
        verificarBalance(padreCandidato, n);//para ambos casos finalizamos verificando el balance de la raiz 

    }
    
    private void eliminarConDosHijosAux(NodoAVLDicc padreCandidato,NodoAVLDicc nCandidato, NodoAVLDicc n){
        if(nCandidato.getDerecho() == null ){

            n.setClave(nCandidato.getClave()); //settamos el elemento candidato al nodo con el elemento a eliminar
            n.setDato(nCandidato.getDato());
            if(nCandidato.getIzquierdo() != null){
                padreCandidato.setDerecho(nCandidato.getIzquierdo()); // eliminamos el nodo del elemento candidato
            }else{
                
                padreCandidato.setDerecho(null); // eliminamos el nodo del elemento candidato
            }
            padreCandidato.recalcularAltura();
            System.out.println("Encontro candidato "+ nCandidato);

        }else{
            eliminarConDosHijosAux(padreCandidato.getDerecho(), nCandidato.getDerecho(), n);
            padreCandidato.recalcularAltura();
            verificarBalance(nCandidato, padreCandidato );
        }       
    }
    
    private boolean eliminarAux(NodoAVLDicc n, NodoAVLDicc nPadre, Comparable e){
        boolean exito= false;
        if(n != null){
            Comparable nElem= n.getClave();
            if(nElem.compareTo(e) == 0){
                if(n.getIzquierdo()== null && n.getDerecho() == null){ //  CUANDO EL NODO NO TIENE HIJOS
                    if(nPadre.getClave().compareTo(n.getClave()) > 0){ // NOS FIJAMOS SI EL NODO ES EL HERMANO IZQ
                        nPadre.setIzquierdo(null);
                    }else{
                        nPadre.setDerecho(null);
                    }
                }else{                    
                    //CUANDO N TIENE 2 HIJOS
                    if(n.getIzquierdo() != null && n.getDerecho() != null){
                        NodoAVLDicc padreCandidato= n.getIzquierdo(); // obtenemos el nodo del padre del nodo con el elemento candidato
                        NodoAVLDicc nCandidato= n.getIzquierdo().getDerecho();// obtenemos el nodo con el elemento candidato
                        eliminarConDosHijos(padreCandidato, nCandidato, n, nPadre );
                    }else{
                        // CUANDO N TIENE AL MENOS 1 HIJO
                        if(n.getIzquierdo() != null && n.getDerecho() == null){  // SI EL HIJO ES EL IZQ
                            if(nElem.compareTo(nPadre.getClave()) < 0 ){ // si n es el hijo izq del padre
                                nPadre.setIzquierdo(n.getIzquierdo());
                            }else{
                                nPadre.setDerecho(n.getIzquierdo()); // si n es el hijo der del padre
                            }
                        }else{ // SI ES EL HIJO DER
                            if(nElem.compareTo(nPadre.getClave()) < 0 ){ // si n es el hijo izq de padre
                                nPadre.setIzquierdo(n.getDerecho());
                            }else{  // sino n es el hijo derecho
                                nPadre.setDerecho(n.getDerecho());
                            }
                        }
                    }
                    verificarBalance(n, nPadre);
                }
                exito= true;
            }else{ // PASO RECURSIVO
                if(n.getClave().compareTo(e) > 0 ){
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
    
    private String toStringAux(NodoAVLDicc unNodoArbol, String unString){
        String stringAux= unString; 
        if(unNodoArbol != null){
            stringAux= stringAux + "Nodo: "+ unNodoArbol.getClave()+" dato: " + unNodoArbol.getDato();
            if(unNodoArbol.getIzquierdo() != null){
                stringAux+= "HI: clave: "+ unNodoArbol.getIzquierdo().getClave();
            }else{
                stringAux+= "HI: null ";
            }
            if(unNodoArbol.getDerecho() != null){
                stringAux+= " HD: clave: "+ unNodoArbol.getDerecho().getClave()+ "\n";
            }else{
                stringAux+= " HD: null\n ";
            }
            stringAux= toStringAux(unNodoArbol.getIzquierdo(), stringAux);
            stringAux= toStringAux(unNodoArbol.getDerecho(), stringAux);
        }
        return stringAux;
    }
}
