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
public class ArbolGen {
    private NodoGen raiz;
    public ArbolGen(){
        this.raiz= null;
    }
    public boolean eliminar(Object e){
        boolean exito= false;
        if(this.raiz != null){
            exito= eliminarAux(this.raiz, e);
        }
        return exito;
    }
    public boolean eliminarAux(NodoGen n, Object e){
        boolean exito= false;
        if(n != null){
            if(n.getElemento().equals(e)){
                
            }
        }
        return exito;
    }
    public boolean esVacio(){
        return this.raiz == null;
    }
    public void vaciar(){
        this.raiz= null;
    }

    public int altura(){
       int altura= -1;
       if(this.raiz != null){
           altura= alturaAux(this.raiz);
       }
       return altura;
    }
    private int alturaAux(NodoGen n){
        //metodo que retorna la altura del arbol
        int res= -1;
        int alturaAux= -1;
        if(n != null){
            NodoGen nodoAux= n.getHijoIzquierdo();
            while(nodoAux != null){
                alturaAux = alturaAux(nodoAux);
                if(alturaAux > res){
                    res= alturaAux;
                }
                nodoAux= nodoAux.getHermanoDerecho();
            }
            res++;
        }
        return res;
    }
    public int nivel(Object elemt){
        int nivel= -1;
        if(this.raiz != null){
            nivel= nivelAux(this.raiz, elemt) ;
        }
        return nivel;
    }
    private int nivelAux(NodoGen n, Object e){
        int nivel= -1;
        if(n != null){
            if(n.getElemento().equals(e)){
                nivel++;
            }else{
                NodoGen hijo= n.getHijoIzquierdo();
                while(hijo != null){
                    nivel= nivelAux(hijo, e);
                    if(nivel != -1){
                    nivel++;
                    hijo= null;
                    }else{
                        hijo= hijo.getHermanoDerecho();
                    }
                }
            }
            
        }
        return nivel;
    }
    /*
    private int nivelAux(NodoGen n,Object elemt){
        int nivel= -1;
        if(n != null ){
            if(n.getElemento().equals(elemt)){
                nivel=0;
            }else{
                NodoGen nodoAux= n.getHijoIzquierdo();
                while(nodoAux != null ){
                    nivel= nivelAux(nodoAux, elemt) + 1 ;
                    if(nivel == 0){// si retorna 0 es pq el elemento no fue encontrado.
                        nivel= -1; // se asigna -1 para denotarlo.
                    }
                    nodoAux= nodoAux.getHermanoDerecho();
                }
            }
        }
        return nivel;
    } */
    
    public boolean insertar(Object unElemento, Object elemPadre){
        //inserta un elemento como hijo de un elemento padre ingresado por parametro 
        boolean exito= false;
        if(this.raiz != null){ // si el arbol esta vacio se inserta el nodo en la raiz 
            //buscamos al nodo padre
            NodoGen nodoPadre= obtenerNodo(this.raiz, elemPadre);
            if(nodoPadre != null){
                NodoGen nodoHijo= nodoPadre.getHijoIzquierdo();//obtenemos el hijo izquierdo del nodoPadre
                nodoPadre.setHijoIzquierdo(new NodoGen(unElemento, null, nodoHijo)); //creamos un nuevo nodo como hijoIzq y le enlazamos el anteriorhijo Izq
                exito= true;
            }
        }else{
            this.raiz= new NodoGen(unElemento,null, null);
            exito= true;
        }
        
        return exito;
    }
        public Lista ancestro(Object elemento){
            Lista unaLista= new Lista();
            if(this.raiz != null){
                ancestroAux(elemento, unaLista, this.raiz);
            }
            return unaLista;
        }
        public Object padre(Object element){
            Object padre= null;
            if(this.raiz != null){
                if(!this.raiz.getElemento().equals(element)){
                    padre= padreAux(this.raiz, element);
                }
            }
            return padre;
        }
        private Object padreAux(NodoGen n, Object e){
            /**/
            Object p= null;
            if(n!= null){
                NodoGen nAux= n.getHijoIzquierdo();
                while(nAux != null && p == null){
                    if(nAux.getElemento().equals(e)){
                        p= n.getElemento();
                    }
                    nAux= nAux.getHermanoDerecho();
                }
                /*
                if(n.getHijoIzquierdo().getElemento().equals(e)){
                    p= n.getElemento();
                }**/
                if(p == null){
                    nAux= n.getHijoIzquierdo();
                    while(nAux != null){
                        p= padreAux(nAux, e);
                        if(p != null){
                            nAux= null;
                        }else{
                            nAux= nAux.getHermanoDerecho();
                        }
                    }
                } 
            }
            return p;
        }
        private boolean ancestroAux(Object elemento, Lista unaLista, NodoGen unNodo){
            boolean encontrado= false;
            if(unNodo != null){               
                if(unNodo.getElemento().equals(elemento)){
                    encontrado= true;
                }else{
                   NodoGen nodoAux= unNodo.getHijoIzquierdo();
                   while(nodoAux != null && !encontrado){
                       encontrado= ancestroAux(elemento, unaLista, nodoAux);
                       nodoAux= nodoAux.getHermanoDerecho();
                   }
                   if(encontrado){
                       unaLista.insertar(unNodo.getElemento(), unaLista.longitud()+1);
                   }
                }
            }
            return encontrado;
        }
        
        private NodoGen obtenerNodo(NodoGen unNodo, Object buscado){
            /*ESTE METODO PERMITE OBTENER EL NODOARBOL DONDE SE ENCUENTRA UN ELEMENTO BUSCADO, INGRESADO POR PARAMETRO. SI 
            EL ELEMENTO NO SE ENCUENTRA EN EL ARBOL ENTONCES SE RETORNA NULL*/
            NodoGen resultado= null;
            if(unNodo != null){ //verifica que el nodo ingresado no sea null(condicion de corte)
                if(unNodo.getElemento().equals(buscado)){   //verifica si el elemento encontrado se encuentra en el nodo pasado por parametro 
                    resultado= unNodo;
                }else{
                    //si no se encontro el elemento en el nodo pasado por parametro buscamos los nodos hermanos
                    resultado = obtenerNodo(unNodo.getHermanoDerecho(), buscado);  
                    if(resultado == null){ //si el resultado de la busqueda del nodo en hermanos derechos es null entonces se busca en el nodoHijoIzquierdo y sus hermanos.
                        resultado = obtenerNodo(unNodo.getHijoIzquierdo(), buscado);
                    } 
                }
            }
            return resultado;
        }
        public boolean pertenece(Object buscado){
                return obtenerNodo(this.raiz, buscado) != null;
                
        }

        public int grado(){
            int grado= -1;
            if(this.raiz != null){
                grado= gradoAux(this.raiz);
            }
            return grado;
        }
        private int gradoAux(NodoGen n){
            int grado=0;
            int gradoAux=0;
            if(n!= null){
                NodoGen nAux= n.getHijoIzquierdo();
                while(nAux != null){
                    gradoAux++;
                    grado= gradoAux(nAux);
                    nAux= nAux.getHermanoDerecho();
                }
                if(gradoAux > grado){
                    grado= gradoAux;
                }
            }
            return grado;
        }
        
        public int gradoSubarbol(Object n){
            int grado= -1;
            if(this.raiz != null){
                NodoGen nAux= this.obtenerNodo(this.raiz, n);
                if(nAux != null){
                    grado= gradoAux(nAux);
                }
            }
            return grado;
        }

        public ArbolGen clone(){
            ArbolGen unArbolGen= new ArbolGen();
            if(this.raiz != null){
                unArbolGen.raiz= new NodoGen(this.raiz.getElemento(), null, null);
                cloneAux(unArbolGen.raiz, this.raiz);
            }
            return unArbolGen;
        }
        public Lista listarInorden(){
            Lista salida= new Lista();
            listarInordenAux(this.raiz, salida);
            return salida;
        }
        private void listarInordenAux(NodoGen n, Lista ls){
                if(n != null){
                    //llamado recursivo con el primer hijo de n
                    if(n.getHijoIzquierdo() != null){
                        listarInordenAux(n.getHijoIzquierdo(), ls);
                    }
                    ls.insertar(n.getElemento(), ls.longitud()+1);
                    
                    //llamado recursivo con los otros hijos de n
                    if(n.getHijoIzquierdo() != null){
                        NodoGen hijo= n.getHijoIzquierdo().getHermanoDerecho();
                        while(hijo != null ){// recorremos los hermanos derechos del nodoActual y llamamos recursivamente al metodo
                            listarInordenAux(hijo, ls);
                            hijo= hijo.getHermanoDerecho();
                        }
                    }
                }
        }
        public Lista listarPosorden(){
            Lista salida= new Lista();
            listarPosordenAux(this.raiz, salida);
            return salida;
        }
        private void listarPosordenAux(NodoGen n, Lista ls){
            if(n != null){
                NodoGen hijo= n.getHijoIzquierdo();
                while(hijo != null){
                    listarPosordenAux(hijo, ls);
                    hijo= hijo.getHermanoDerecho();
                }
                ls.insertar(n.getElemento(), ls.longitud()+1);
            }
        }
        public Lista listarPreorden(){
            Lista salida= new Lista();
            listarPreordenAux(this.raiz, salida);
            return salida;
        }
        private void listarPreordenAux(NodoGen n, Lista ls){
            if(n != null){
                ls.insertar(n.getElemento(), ls.longitud()+1);
                NodoGen hijo= n.getHijoIzquierdo();
                while(hijo != null){
                    //ls.insertar(hijo.getElemento(), ls.longitud()+1);
                    listarPreordenAux(hijo, ls);
                    hijo= hijo.getHermanoDerecho();
                }
            }
        }
        
        private void cloneAux(NodoGen nClon, NodoGen nOriginal){
            if(nOriginal != null){
                NodoGen hijoOrignial= nOriginal.getHijoIzquierdo(); // Hijo:  izquierdo nodo original
                if( hijoOrignial!= null){
                    nClon.setHijoIzquierdo(new NodoGen(hijoOrignial.getElemento(), null, null));// enlazo al hijoIzq del nodoOrig al NodoClon
                    NodoGen nAux= nClon.getHijoIzquierdo();// nodoHijoIzq
                    while(hijoOrignial != null){
                            cloneAux(nAux, hijoOrignial);
                            hijoOrignial= hijoOrignial.getHermanoDerecho();
                            if(hijoOrignial != null){
                                nAux.setHermanoDerecho(new NodoGen(hijoOrignial.getElemento(), null, null));
                            }
                            nAux= nAux.getHermanoDerecho();
                            
                            
                        }            
                    }else{
                        
                    }
                }
        }
        public String toString(){
            return toStringAux(this.raiz);
        }
        private String toStringAux(NodoGen n){
            String s="";
            if(n != null){
                s+= n.getElemento().toString()+"-> ";
                NodoGen nodoHijo= n.getHijoIzquierdo();//Pregunta en su nodoHijoIzq
                while(nodoHijo != null){
                    s+= nodoHijo.getElemento().toString() + ", ";//
                    nodoHijo= nodoHijo.getHermanoDerecho();
                }
                nodoHijo= n.getHijoIzquierdo();
                while(nodoHijo != null){
                    s+= "\n "+ toStringAux(nodoHijo);
                    nodoHijo= nodoHijo.getHermanoDerecho();
                }
            }
            return s;
        }
        public boolean verificarCamino(Lista lis){
            /*METODO QUE VERIFICA SI LA SECUENCIA DE ELEMENTOS DE LA LISTA SE CORRESPONDE CON ALGUN CAMINO DE LA RAIZ DEL AHORA HACIA ALGUNA DE SUS NODOS*/
            boolean exito= false;
            if(this.raiz != null){
               exito=verificarCaminoAux(this.raiz, lis, 1);
            }
            return exito;
        }
        private boolean verificarCaminoAux(NodoGen n, Lista lis, int pos){
            boolean exito= false;
            boolean encontrado= false;
            System.out.println("pos antes de entrar: "+ pos);
            if(n!= null && pos <= lis.longitud()){
               if(n.getElemento().equals(lis.recuperar(pos))){
                   if(lis.longitud() == pos){
                       encontrado= true;
                   }else{
                        NodoGen nHijo= n.getHijoIzquierdo();
                        while(nHijo != null && !encontrado){
                            //System.out.println("entra con: " + nHijo.getElemento());
                            //if(nHijo.getElemento().equals(lis.recuperar(pos+1))){
                                encontrado= verificarCaminoAux(nHijo, lis, pos+1);
                                nHijo = nHijo.getHermanoDerecho();
                        }
                    }                 
                    if(encontrado){
                        exito=true;
                    }
                }
            }
            return exito;
        }
        
        public Lista listarEntreNiveles(int nivelA, int nivelB){
            Lista unaLista= new Lista();
            if(this.raiz != null){
                listarEntreNivelesAux(this.raiz, nivelA, nivelB, 0 , unaLista);
            }
            return unaLista;
        }
        private void listarEntreNivelesAux(NodoGen n, int nivelA, int nivelB,int contNivel, Lista lis){
            System.out.println("cont: " + contNivel);
            if(n != null && contNivel<= nivelB){
                    //llamado recursivo con el primer hijo de n
                    if(n.getHijoIzquierdo() != null && contNivel< nivelB){
                        listarEntreNivelesAux(n.getHijoIzquierdo(), nivelA, nivelB, contNivel+1, lis);
                    }
                    if(contNivel >= nivelA && contNivel <= nivelB){
                        lis.insertar(n.getElemento(), lis.longitud()+1);
                    }
                    //llamado recursivo con los otros hijos de n
                    if(n.getHijoIzquierdo() != null){
                        NodoGen hijo= n.getHijoIzquierdo().getHermanoDerecho();
                        while(hijo != null ){// recorremos los hermanos derechos del nodoActual y llamamos recursivamente al metodo
                            listarEntreNivelesAux(hijo, nivelA, nivelB, contNivel+1, lis);
                            hijo= hijo.getHermanoDerecho();
                        }
                    }
                }
        }
        public boolean eliminarConDecendientes(Object e){
            boolean exito= false;
            if(this.raiz != null){
                exito= eliminarConDecendientesAux(this.raiz, null, null, e);
            }
            return  exito;
        }
        private boolean eliminarConDecendientesAux(NodoGen n, NodoGen nPadre, NodoGen nHI, Object e){
            boolean exito= false;
            if(n != null){
                if(n.getElemento().equals(e)){
                    if(nHI != null){ // si el HI es distinto de nulo entonces al nodo se le settea el HD de n. 
                        nHI.setHermanoDerecho(n.getHermanoDerecho());
                    }else{
                        /*el nodo es hijoIzq */
                        if(nPadre != null){ // si el padre es distinto de null
                            nPadre.setHijoIzquierdo(n.getHermanoDerecho()); // se le settea el HD de n como HI
                        }else{
                            // el nodo es la raiz
                            this.raiz= null; //se le settea null
                        }
                    }
                    exito= true;
                }else{
                    /*Recorremos los hijos*/
                    if(n.getHijoIzquierdo() != null){
                        NodoGen nAux= n.getHijoIzquierdo();
                        NodoGen nHIAux= null;
                        while(nAux != null && !exito){
                            exito= eliminarConDecendientesAux(nAux, n, nHIAux, e);
                            nHIAux= nAux;
                            nAux= nAux.getHermanoDerecho();
                        }
                    }
                }
            }
            return exito;
        }
        public boolean insertarEnPosicion(Object elem, Object padre, int pos){
            boolean exito= false;
            if(this.raiz != null){
                exito= insertarEnPosicionAux(this.raiz, elem, padre, pos);
            }
            return exito;
        }
        public boolean verificarPatron(Lista lisPatron){
            boolean exito= false;
            if(this.raiz != null){
                exito= verificarPatronAux(this.raiz, lisPatron, 1);
            }
            return exito;
        }
        private boolean verificarPatronAux(NodoGen n, Lista lis, int pos){
            boolean exito= false;
            if(n != null){
                if(lis.recuperar(pos).equals(n.getElemento())){
                    if(lis.longitud() == pos){
                        exito= true;
                    }else{
                        NodoGen nHijo= n.getHijoIzquierdo();
                        while(nHijo != null && !exito){
                            exito= verificarPatronAux(nHijo, lis, pos+1);
                            nHijo= nHijo.getHermanoDerecho();
                        }
                    }
                }
            }
            return exito;
        }

        
        private boolean insertarEnPosicionAux(NodoGen n, Object e, Object padre, int pos){
            boolean exito= false;
            if(n != null){
                if(n.getElemento().equals(padre)){
                    NodoGen hijoAux= n.getHijoIzquierdo();
                    NodoGen hermanoIzq= null;
                    int posAux=1;
                    while(hijoAux != null && posAux < pos && pos > 0 ){
                        hermanoIzq= hijoAux;
                        hijoAux= hijoAux.getHermanoDerecho();
                        posAux++;
                    }
                    NodoGen otroHijo= new NodoGen(e, null, null);
                    if(hermanoIzq != null){
                        otroHijo.setHermanoDerecho(hijoAux);
                        hermanoIzq.setHermanoDerecho(otroHijo);
                    }else{
                        n.setHijoIzquierdo(otroHijo);
                        if(hijoAux != null){
                            otroHijo.setHermanoDerecho(hijoAux);
                        }
                    }
                }else{
                    if(n.getHijoIzquierdo() != null){
                        exito= insertarEnPosicionAux(n.getHijoIzquierdo(), e, padre, pos);
                    }
                    if(n.getHijoIzquierdo()!= null){
                        NodoGen hijoAux= n.getHijoIzquierdo().getHermanoDerecho();
                        while(hijoAux != null){
                            exito= insertarEnPosicionAux(hijoAux, e, padre, pos);
                            hijoAux= hijoAux.getHermanoDerecho();
                        }
                    }
                }
            }
            return exito;
        }
        public boolean esHermanoPosterior(Object a, Object b){
            boolean exito= false;
            if(this.raiz != null){
                exito= esHermanoPosteriorAux(this.raiz, a , b);
            }
            return exito;
        }
        private boolean esHermanoPosteriorAux(NodoGen n, Object a, Object b){
            boolean exito= false, seguir=true;
            int posA= -1, posB= -1;
            if(n != null){
                if(n.getHijoIzquierdo() != null){
                    NodoGen nAux= n.getHijoIzquierdo();
                    int cont= 1;
                    while(nAux != null && seguir){
                        if(nAux.getElemento().equals(a)){
                            posA= cont;
                        }
                        if(nAux.getElemento().equals(b) ){
                            posB= cont;
                        }
                        cont++;
                        if(posA > posB && posB == -1){
                            seguir= false;
                        }
                        if(posA > posB && posB != -1){
                            seguir= false;
                            exito= true;
                        }
                        nAux= nAux.getHermanoDerecho();
                    }
                }
                if(!exito && n.getHijoIzquierdo()!= null && seguir){
                    NodoGen nAux= n.getHijoIzquierdo();
                    while(nAux != null && !exito){
                        exito= esHermanoPosteriorAux(nAux, a, b);
                        nAux= nAux.getHermanoDerecho();
                    }
                }
            }
            return exito;
        }
        
        public Lista caminoJustificaAltura(){
            Lista res= new Lista();
            if(this.raiz != null){
                Lista actual= new Lista();
                res= caminoJustificaAlturaAux(this.raiz, actual, res);
            }
            return res;
        }
        private Lista caminoJustificaAlturaAux(NodoGen n, Lista actual, Lista res){
            actual.insertar(n.getElemento(), actual.longitud()+1);
            if(n.getHijoIzquierdo() == null){
                if(actual.longitud() > res.longitud()){
                    res= actual.clone();
                }
            }else{
                NodoGen hijo= n.getHijoIzquierdo();
                while(hijo != null){
                    res= caminoJustificaAlturaAux(hijo, actual, res);
                    actual.eliminar(actual.longitud());
                    hijo= hijo.getHermanoDerecho();
                }
            }
            return res;
        }
        public Lista caminoAHojaMasCercana(){
            Lista camino= new Lista();
            if(this.raiz != null ){
                Lista caminoActual = new Lista();
                Lista caminoMasCorto = new Lista();
                camino= caminoAHojaMasCercanaAux(this.raiz, caminoActual, caminoMasCorto);
                
            }
            return camino;
        }
        private Lista caminoAHojaMasCercanaAux(NodoGen n, Lista caminoActual, Lista caminoMasCercano){
          
            if(n != null){
                caminoActual.insertar(n.getElemento(), caminoActual.longitud()+1);
                if(n.getHijoIzquierdo() == null){
                    if(caminoActual.longitud() < caminoMasCercano.longitud() || caminoMasCercano.esVacia()){
                        caminoMasCercano= caminoActual.clone();
                        
                    }
                }else{
                    NodoGen hijo= n.getHijoIzquierdo();
                    while(hijo != null){
                        caminoMasCercano= caminoAHojaMasCercanaAux(hijo, caminoActual, caminoMasCercano);
                        hijo= hijo.getHermanoDerecho();
                        caminoActual.eliminar(caminoActual.longitud());
                        
                    }
                }
            }
            return caminoMasCercano;
        }
        
        public int descendienteMasLejano(Object d){
            int nivel= -1;
            if(this.raiz != null){
                nivel= descendienteMasLejanoAux(this.raiz, d, 0, -1);
            }
            return nivel;
        }
        private int descendienteMasLejanoAux(NodoGen n, Object d, int nivel, int nivelMayor){
            if(n!= null){
                if(n.getElemento().equals(d) && nivel > nivelMayor){
                    nivelMayor= nivel;
                }
                NodoGen nHijo= n.getHijoIzquierdo();
                while(nHijo != null){
                    nivelMayor= descendienteMasLejanoAux(nHijo, d, nivel+1, nivelMayor);
                    nHijo= nHijo.getHermanoDerecho();
                }
            }
            return nivelMayor;
        }
        
        public Lista caminoAHojaMasCercana2(){
            Lista camino= new Lista();
            if(this.raiz != null){
                caminoAHojaMasCercanaAux2(this.raiz, camino, camino);
            }
            return camino;
        }
        private Lista caminoAHojaMasCercanaAux2(NodoGen n, Lista caminoActual, Lista caminoMasCercano){
          
            if(n != null){
                caminoActual.insertar(n.getElemento(), caminoActual.longitud()+1);
                if(n.getHijoIzquierdo() == null){
                    caminoMasCercano= caminoActual.clone();
                }else{
                    NodoGen hijo= n.getHijoIzquierdo();
                    while(hijo != null){
                        if(caminoActual.longitud()+1 < caminoMasCercano.longitud() && !caminoMasCercano.esVacia() || caminoMasCercano.esVacia()){
                            caminoAHojaMasCercanaAux2(hijo, caminoActual, caminoMasCercano);
                            caminoActual.eliminar(caminoActual.longitud());
                        }
                        hijo= hijo.getHermanoDerecho();
                    }
                }
            }
            return caminoMasCercano;
        }
        
}
