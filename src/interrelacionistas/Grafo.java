/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrelacionistas;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Grafo {
    private NodoVert inicio;
    
    public Grafo(){
        this.inicio= null;
    }
    public boolean esVacio(){
        return this.inicio == null;
    }
    
    private NodoVert ubicarVertice(Object e){
        NodoVert nAux= this.inicio;
        while(nAux != null && !nAux.getElem().equals(e)){
            nAux= nAux.getSigVertice();
        }
        return nAux;
    }
    
    public boolean insertarVertice(Object e){
        boolean exito= false;
        NodoVert nAux= this.ubicarVertice(e);
        if(nAux == null){
            this.inicio= new NodoVert(e, this.inicio);
            exito= true;
        }
        return exito;
    }
    
    public boolean existeVertice(Object e){
        /*ESTE METODO VERIFICA SI EXISTE UN VERTICE EN LA LISTA DE ADYACENCIA */
        boolean encontrado= false;
        NodoVert nAux= this.inicio;
        while(nAux != null && !encontrado){
            if(nAux.getElem().equals(e)){
                encontrado= true;
            }
            nAux= nAux.getSigVertice();
        }
        return encontrado;
    }
    
    public boolean insertarVertAdy(Object elemO, Object elemD){
        /*ESTE METODO INSERTA UN ARCO ENTRE DOS NODOS VERTICES SI EXISTEN Y SI NO EXISTE YA UN ARCO ENTRE AMBOS*/
        boolean exito= false;
        NodoVert nAuxO= this.inicio;
        NodoVert nAuxD= this.inicio;
        NodoVert nO= null;
        NodoVert nD= null;
        while(nAuxO != null && nAuxD != null && (nD == null || nO == null)){
            if(nAuxO.getElem().equals(elemO)){
                nO = nAuxO;
            }else{
                nAuxO = nAuxO.getSigVertice();
            }
            if(nAuxD.getElem().equals(elemD)){
                nD = nAuxD;
            }else{
                nAuxD= nAuxD.getSigVertice();
            }
        }
        if(nO != null && nD != null){
            insertarVertAdyAux(nO, nD);
            exito= true;
        }
        return exito;
    }
    
    private void insertarVertAdyAux(NodoVert nO, NodoVert nD){
        /*MENSAJE POLIMORFICO*/
        /* EN ESTE MENSAJE SE INSERTA UN ARCO DE UN DIGRAFO PARA QUE LA CLASE GRAFO PUEDA SOBREESCRIBIRLO*/
        if(nO.getPrimerAdy() != null){
            boolean repetido= false;
            NodoAdyEtiquetado nAux= nO.getPrimerAdy();
            while(nAux.getSigAdyacente() != null && !repetido){
                if(nAux.getVertice() == nD){
                    repetido= true;
                }
                nAux= nAux.getSigAdyacente();
            }
            if(!repetido){
                nAux.setSigAdyacente(new NodoAdyEtiquetado(nD));
            }
            
        }else{
            nO.setPrimerAdy(new NodoAdyEtiquetado(nD));
        }
    }
    
    public boolean eliminarVertice(Object elem){
        boolean exito= false;
        /*cambios*/
        NodoVert n = this.inicio;
        /*********/
        if(n != null){
            if(n.getElem().equals(elem)){ //VERIFICAMOS SI EL VERTICE INICIO ES EL VERTICE A ELIMINAR
                eliminarArcos(this.inicio, elem); //eliminamos el arco q tenga con los demas nodos vertices que estan en su lista de adyacencia
                this.inicio= this.inicio.getSigVertice(); //lo quitamos de la lista de nodosVertices
                exito=true;
            }else{ 
                /* BUSCAMOS EN LOS DEMAS NODOS VERTICES DE LA LISTA DE NODOS VERTICES*/
                NodoVert nAnt= this.inicio;
                n= this.inicio.getSigVertice();
                while(n != null && !exito){
                    if(n.getElem().equals(elem)){
                        eliminarArcos(this.inicio, elem); //eliminamos el arco q tenga con los demas nodos vertices
                        nAnt.setSigVertice(n.getSigVertice()); //lo quitamos de la lista de nodosVertices
                        exito=true;
                    }
                    nAnt= nAnt.getSigVertice();
                    n= n.getSigVertice();
                }
                
                /*REALICE CAMBIOS
                    exito= eliminarVerticeAux(elem, this.inicio.getSigVertice(), this.inicio);
                ELIMINE ESTO 
                    exito= eliminarVerticeAux(elem, this.inicio, this.inicio.getSigVertice());
                */
            }
        }
        return exito;
    }
    
    /*
    private boolean eliminarVerticeAux(Object elem, NodoVert nAnt, NodoVert n){
        //este metodo recorre verifica si un elemento de un nodo vertice pasado por parametro 
        boolean exito= false;
        if(n != null){
            if(n.getElem().equals(elem)){
                eliminarArcos(n, elem);
                nAnt.setSigVertice(n.getSigVertice());
                exito= true;
            }
            if(!exito){
                exito= eliminarVerticeAux(elem, n, n.getSigVertice());
            }
        }
        return exito;
        
    }*/
    
    private void eliminarArcos(NodoVert n, Object elem){
        /*ESTE METODO ELIMINA LOS ARCOS QUE HAYA DE UN DETERMINADO ELEMENTO VERTICE, PASADO POR PARAMETRO, PASANDO POR TODOS
        LOS NODOSVERTICES QUE SE ENCUENTREN EN SU LISTA DE ADYCENCIA*/
        NodoAdyEtiquetado nAdy= n.getPrimerAdy();
        while(nAdy != null){
            eliminarArcoEnVertice(nAdy.getVertice(), elem);
            nAdy= nAdy.getSigAdyacente();
        }
    }
    
    public boolean eliminarArco(Object v1, Object v2){
        /*ESTE METODO PERMITE ELIMINAR, SI EXISTE, EL ARCO ENTRE V1 Y V2, SI EXISTEN*/
        boolean exito=false;
        boolean encontrado1= false, encontrado2= false;
        NodoVert n1= null, n2= null;
        NodoVert n= this.inicio;
        while(n != null && (!encontrado1 || !encontrado2) ){
            if(n.getElem().equals(v1)){
                n1= n;
                encontrado1= true;
            }
            if(n.getElem().equals(v2)){
                n2= n;
                encontrado2= true;
            }
            n= n.getSigVertice();
        }
        if(encontrado1 && encontrado2){
            exito= eliminarArcoEnVertice(n1, v2);
            if(exito){
                exito= eliminarArcoEnVertice(n2, v1);
            }
        }
        return exito;
    }
    
    private boolean eliminarArcoEnVertice(NodoVert n, Object elem){
        /*ESTE METODO ELIMINA EL ARCO QUE TENGA CON UN NODO*/
        boolean exito= false;
        NodoAdyEtiquetado nAdy= n.getPrimerAdy();
        if(nAdy != null){
            if(nAdy.getVertice().getElem().equals(elem)){ // si el primer adyacente es igual al nodo del arco a eliminar
                n.setPrimerAdy(nAdy.getSigAdyacente()); // lo quitamos de la lista de adyacencia
                exito= true;
            }else{
                
                NodoAdyEtiquetado nAdyAnt= n.getPrimerAdy();
                nAdy= nAdy.getSigAdyacente();
                while(nAdy != null && !exito){
                    if(nAdy.getVertice().getElem().equals(elem)){ // si el primer adyacente es igual al nodo del arco a eliminar
                        nAdyAnt.setSigAdyacente(nAdy.getSigAdyacente()); // lo quitamos de la lista de adyacencia
                        exito= true;
                    }    
                
                }
                
                /*
                ELIMINAMOS ESTO
                exito= eliminarArcoEnVerticeAux(nAdy,nAdy.getSigAdyacente(),elem);
                */
            }
        }
        return exito;
    }
    /*
    private boolean eliminarArcoEnVerticeAux(NodoAdyEtiquetado nAnt, NodoAdyEtiquetado n, Object elem){
        //REVISARRRR!!!!!!!1
        boolean exito= false;
        if(n != null){
            if(n.getVertice().getElem().equals(elem)){
                nAnt.setSigAdyacente(n.getSigAdyacente());
                exito= true;
            }
            if(!exito){
                exito= eliminarArcoEnVerticeAux(n, n.getSigAdyacente(), elem);
            }
        }
        return exito;
    }
    */
    
    public boolean existeArco(Object elemVert1, Object elemVert2){
        boolean exito= false;
        if(this.inicio != null){
            exito= existeArcoAux(this.inicio, elemVert1, elemVert2);
        }
        return exito;
        
    }
    
    private boolean existeArcoAux(NodoVert n, Object v1, Object v2){
        /*ESTE METODO COMPRUEBA SI HAY UN ARCO UNIENDO A DOS VERTICES BUSCANDO EN EL PRIMER NODOVERTICE QUE ENCUENTRE SI EXISTE UN ARCO CON
        EL OTRO NODOVERTICE, AMBOS ELEMENTOSVERTICES PASADOS POR PARAMETRO*/
        boolean exito= false;
        if(n != null){
            if(n.getElem().equals(v1)){
                NodoAdyEtiquetado nAux= n.getPrimerAdy();
                exito= verificarArco(nAux, v2);
            }
            if(n.getElem().equals(v2)){
                NodoAdyEtiquetado nAux= n.getPrimerAdy();
                exito= verificarArco(nAux, v1);
            }
            if(!exito){
                exito= existeArcoAux(n.getSigVertice(), v1, v2);
            }
        }
        return exito;
    }
    
    private boolean verificarArco(NodoAdyEtiquetado nAdy,Object nVert){
        /*ESTE METODO VERIFICA SI EXISTE UN ARCO DE UN ELEMENTO DE TIPO VERTICE INGRESADO POR PARAMETRO EN UNA LISTA DE NODOS ADYACENTES
        PASADOS POR PARAMETRO*/
        boolean existe= false;
        while(nAdy != null && !existe){
            if(nAdy.getVertice().getElem().equals(nVert)){
                existe= true;
            }else{
                nAdy= nAdy.getSigAdyacente();
            }
        }
        return existe;
    }
    
    public boolean insertarArco(Object elemVert1, Object elemVert2, Object etiqueta){
        boolean exito= false;
        if(this.inicio != null){
            exito= insertarArcoAux(this.inicio, elemVert1, elemVert2, etiqueta);
        }
        return exito;
    }
    
    private boolean insertarArcoAux(NodoVert n, Object e1, Object e2, Object e){
        boolean exito=false;
        boolean encontrado1= false, encontrado2= false;
        NodoVert n1= null, n2= null;
        while(n != null && (!encontrado1 || !encontrado2) ){
            if(n.getElem().equals(e1)){
                n1= n;
                encontrado1= true;
            }
            if(n.getElem().equals(e2)){
                n2= n;
                encontrado2= true;
            }
            n= n.getSigVertice();
        }
        if(encontrado1 && encontrado2){
            if(!verificarArco(n1.getPrimerAdy(), e2)){
                NodoAdyEtiquetado nAux= n1.getPrimerAdy();
                n1.setPrimerAdy(new NodoAdyEtiquetado(n2, e));
                n1.getPrimerAdy().setSigAdyacente(nAux);
                nAux= n2.getPrimerAdy();
                n2.setPrimerAdy(new NodoAdyEtiquetado(n1,e));
                n2.getPrimerAdy().setSigAdyacente(nAux);
                exito= true;
            }
        }
        return exito;
    }
    
    public String toString(){
        String s= "";
        NodoVert n= this.inicio;
        while( n != null){
            s += "NodoVertice: "+ n.getElem() + " NodoAdyacentes: " + this.listarNodosAdyacentesYEtiqueta(n)+ "\n";
            n= n.getSigVertice();
        }
        return s;
    }

    
    
    private String listarNodosAdyacentesYEtiqueta(NodoVert n){
        //METODO QUE LISTA LOS NODOS ADYACENTES DE UN NODO VERTICE PASADO POR PARAMETRO
        
        String s="[";
        NodoAdyEtiquetado nAux= n.getPrimerAdy();
        while(nAux != null){
            s += nAux.toString();
            if(nAux.getSigAdyacente() != null){
                s += ", ";
            }
            nAux= nAux.getSigAdyacente();
        }
        s += "]";
        return s;
    }
    public Lista listaDeNodosAdyacentes(Object codigo){
        /* DADO UN CODIGO PASADO POR PARAMETRO UBICA AL VERTICE EN EL GRADO Y SI EXISTE LISTA LOS NODOS ADTACENTES DEL MISMO*/
        Lista lis= new Lista();
        NodoVert n= ubicarVertice(codigo); // UBCIAMOS AL VERICE EN EL GRAFO
        if(n != null){
            listarNodosAdyacentesAux(n, lis); 
        }
        return lis;
    }
    
    
    
    private void listarNodosAdyacentesAux(NodoVert n, Lista lis){
        //METODO QUE LISTA LOS NODOS ADYACENTES DE UN NODO VERTICE PASADO POR PARAMETRO
        NodoAdyEtiquetado nAux= n.getPrimerAdy();
        while(nAux != null){
            lis.insertar( nAux, lis.longitud()+1);
            nAux= nAux.getSigAdyacente();
        }
        
    }
    
    public Lista listarNodosVerticeAdyacentes(Object codigo){
        /* DADO UN CODIGO PASADO POR PARAMETRO UBICA AL VERTICE EN EL GRAFO, Y SI EXISTE, LISTA LOS 3LEMENTOS DE LOS NODOS VERTICES DE su lista de NODOS ADTACENTES*/
        Lista lis= new Lista();
        NodoVert n= ubicarVertice(codigo); // UBCIAMOS AL VERICE EN EL GRAFO
        if(n != null){
            listarNodosVerticeAdyacentesAux(n, lis); 
        }
        return lis;
    }
    
    private void listarNodosVerticeAdyacentesAux(NodoVert n, Lista lis){
        //METODO QUE LISTA LOS ELEMENTOS DE LOS NODOS VERTICES DE LOS NODOS ADYACENTES DE UN NODO VERTICE PASADO POR PARAMETRO
        
        NodoAdyEtiquetado nAux= n.getPrimerAdy();
        while(nAux != null){
            lis.insertar( nAux.getVertice().getElem(), lis.longitud()+1);
            nAux= nAux.getSigAdyacente();
        }
        
    }
    
    public Lista listarEtiquetaNodosVertAdy(Object codigo){
        /* DADO UN CODIGO PASADO POR PARAMETRO UBICA AL VERTICE EN EL GRAFO Y SI EXISTE LISTA LAS ETIQUETAS DE LOS NODOS ADYACENTES*/
        Lista lis= new Lista();
        NodoVert n= ubicarVertice(codigo); // UBCIAMOS AL VERICE EN EL GRAFO
        if(n != null){
            listarEtiquetaNodosVertAdyAux(n, lis);
        }
        return lis;
    }
    
    private void listarEtiquetaNodosVertAdyAux(NodoVert n, Lista lis){
        //METODO QUE LISTA LAS ETIQUETAS DE LOS NODOS ADYACENTES DE UN NODO VERTICE PASADO POR PARAMETRO
        NodoAdyEtiquetado nAux= n.getPrimerAdy();
        while(nAux != null){
            lis.insertar( nAux.getEtiqueta(), lis.longitud()+1);
            nAux= nAux.getSigAdyacente();
        }
    }
    
    public Object getEtiquetaArco(Object elemVert1, Object elemVert2){
       /* DADO DOS ELEMENTOS DE TIPO OBJECT DEVUELVE EL LA ETIQUETA DEL ARCO QUE LOS UNE A AMBOS, SI ES QUE EXISTE*/
        Object etiqueta= null;
        if(this.inicio != null){
            etiqueta= getEtiquetaArcoAux(this.inicio, elemVert1, elemVert2);
        }
        return etiqueta;
    }
     
    private Object getEtiquetaArcoAux(NodoVert n, Object v1, Object v2){
   //DADO DOS ELEMENTOS BUSCA EL ARCO QUE LOS UNE Y DEVUELVE LA ETIQUETA.
        Object etiqueta= null;
        NodoAdyEtiquetado nAux2= null;
        if(n != null){
            if(n.getElem().equals(v1)){
                NodoAdyEtiquetado nAux= n.getPrimerAdy();
                nAux2= obtenerArcoEtiquetado(nAux, v2);
            }
            if(n.getElem().equals(v2)){
                NodoAdyEtiquetado nAux= n.getPrimerAdy();
                nAux2= obtenerArcoEtiquetado(nAux, v1);
            }
            if(nAux2 == null){
                etiqueta= getEtiquetaArcoAux(n.getSigVertice(), v1, v2);
            }else{
                etiqueta= nAux2.getEtiqueta(); //obtenemos la etiqueta 
            }
        }
        return etiqueta;
   
   }
   
    private NodoAdyEtiquetado obtenerArcoEtiquetado(NodoAdyEtiquetado nAdy, Object nVert){
        /*ESTE METODO VERIFICA SI EXISTE UN ARCO DE UN ELEMENTO DE TIPO VERTICE INGRESADO POR PARAMETRO EN UNA LISTA DE NODOS ADYACENTES
        PASADOS POR PARAMETRO, SI EXISTE DEVUELVE EL NODO ADYACENTE*/
        NodoAdyEtiquetado n= null;
        boolean existe= false;
        while(nAdy != null && !existe){
            if(nAdy.getVertice().getElem().equals(nVert)){
                n= nAdy; //SI ENCONTRAMOS AL NODO ADYACENTE LO ASIGNAMOS A LA VARIABLE A RETORNAR
                existe= true;
            }else{
                nAdy= nAdy.getSigAdyacente();
            }
        }
        return n;
               
   }
    
    public boolean existeCamino(Object origen, Object destino){
        boolean exito= false;
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista visitados= new Lista();
            exito= existeCaminoAux(auxO, destino, visitados);
        }
        return exito;
    }
    private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis){
        boolean exito= false;
        if(n != null){
            //si vertice n es el destino: hay camino!
            if(n.getElem().equals(dest)){
                exito= true;
            }else{
                //sino es el destino verifica si hay camino entre n y el destino
                vis.insertar(n.getElem(), vis.longitud()+1);
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                while(!exito && ady != null){
                    if(vis.localizar(ady.getVertice().getElem()) < 0){
                        exito= existeCaminoAux(ady.getVertice(), dest, vis);
                    }
                    ady= ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }
    public Lista caminoMasCorto(Object origen, Object destino){
        Lista caminoMasCorto= new Lista();
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista caminoActual= new Lista();
            caminoMasCorto= caminoMasCortoAux(auxO, destino, caminoActual, caminoMasCorto);
        }
        return caminoMasCorto;
    }
    
    private Lista caminoMasCortoAux(NodoVert n, Object dest, Lista caminoActual, Lista caminoMasCorto){
        Lista camino= new Lista();
        if(n != null){
            //si vertice n es el destino: hay camino!
            caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
            if(n.getElem().equals(dest)){
                camino= caminoActual.clone(); // clonamos el camino actual y lo asigamos a la variable a retornar
            }else{
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                if(caminoMasCorto.esVacia() || caminoActual.longitud()+1 < caminoMasCorto.longitud() ){
                    while(ady != null){
                        if(caminoActual.localizar(ady.getVertice().getElem()) < 0 ){
                            camino= caminoMasCortoAux(ady.getVertice(), dest,caminoActual, caminoMasCorto);
                            caminoActual.eliminar(caminoActual.longitud());//eliminamos del camino actual para seguir buscando otro camino
                            
                            if(!camino.esVacia() && (camino.longitud() < caminoMasCorto.longitud() || caminoMasCorto.esVacia())){
                                caminoMasCorto= camino.clone();
                            }else{
                                camino= caminoMasCorto;
                            }

                        }    
                        ady= ady.getSigAdyacente();
                    }
                }else{
                    System.out.println("El camino se pasa de longitud");
                }
                                
            }
        }
        return camino;
    }
    public Lista primerCaminoMenorPesoYLong(Object origen, Object destino, int pesoMax, int longMax){
        Lista camino= new Lista();
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux = aux.getSigVertice();
            
        }
        
        if(auxO != null && auxD != null){
            Lista caminoActual= new Lista();
            camino= primerCaminoMenorPesoYLongAux(auxO, destino, pesoMax, 0,longMax, caminoActual);
        }
        return camino;
    }
    private Lista primerCaminoMenorPesoYLongAux(NodoVert n, Object destino, int pesoMax, int pesoActual, int longMax, Lista caminoActual){
        Lista camino= new Lista();
        int peso= pesoActual;
        if(n != null){
            if(caminoActual.longitud()+1 <= longMax){
                caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
                if(n.getElem().equals(destino)){
                    camino= caminoActual.clone();
                }else{
                    NodoAdyEtiquetado ady= n.getPrimerAdy();
                    while(ady != null){
                        if(peso+(int)ady.getEtiqueta() <= pesoMax && caminoActual.localizar(ady.getVertice().getElem()) < 0){
                            camino= primerCaminoMenorPesoYLongAux(ady.getVertice(), destino, pesoMax, pesoActual, longMax, caminoActual);
                            caminoActual.eliminar(caminoActual.longitud());
                            pesoActual-= (int)ady.getEtiqueta();
                        }
                        ady= ady.getSigAdyacente();
                    }
                }
            }
        }
        return camino;
    }
    
    
    public boolean esPosibleLlegar(Object origen, Object destino, int puntajeMinimo){
        boolean exito= false;
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista caminoActual= new Lista();
            exito= esPosibleLlegarAux(auxO, destino, caminoActual, 0, puntajeMinimo);
        }
        return exito;
    }
    private boolean esPosibleLlegarAux(NodoVert n, Object dest, Lista caminoActual, int puntajeTotal, int puntajeMinimo){
        boolean exito= false;
        if(n != null){
            //si vertice n es el destino: hay camino!
            
            if(n.getElem().equals(dest)){
                System.out.println("LLego "+ caminoActual.toString());
                exito= true;
            }else{
                caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                    while(ady != null && !exito){
                        System.out.println(caminoActual.toString());//ESTARIA CONTROLANDO EL CAMINO POR CADA ADYACENTE
                        
                        if(caminoActual.localizar(ady.getVertice().getElem()) < 0 && puntajeTotal+(int)ady.getEtiqueta() <= puntajeMinimo){
                            puntajeTotal+= (int)ady.getEtiqueta();
                            exito= esPosibleLlegarAux(ady.getVertice(), dest,caminoActual, puntajeTotal, puntajeMinimo);
                            //System.out.println("Elimina: " + caminoActual.recuperar(caminoActual.longitud()));
                            if(!exito){
                                caminoActual.eliminar(caminoActual.longitud());  
                                puntajeTotal-= (int)ady.getEtiqueta();
                            }
                            
                           
                        }

                        ady= ady.getSigAdyacente();
                    }
                }
                       
            }
        return exito;
    }
    
    public Lista caminoMasCortoPorEtiqueta(Object origen, Object destino){
        Lista caminoMasCorto= new Lista();
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista caminoActual= new Lista();
            int []puntajes= new int[2]; // puntajes[0] (puntaje total) -- puntajes[1] (puntaje minimo)
            caminoMasCorto= caminoMasCortoPorEtiquetaAux(auxO, destino, caminoActual, caminoMasCorto, puntajes);

        }
        return caminoMasCorto;
    }
    private Lista caminoMasCortoPorEtiquetaAux(NodoVert n, Object dest, Lista caminoActual, Lista caminoMasCorto, int[] puntaje ){
        Lista camino= new Lista();
        if(n != null){
            //si vertice n es el destino: hay camino!
            
            if(n.getElem().equals(dest)){
                caminoActual.insertar( n.getElem(), caminoActual.longitud()+1);
                System.out.println("LLego "+ caminoActual.toString() + " puntaje: "+ puntaje[0]);
                camino= caminoActual.clone();
                puntaje[1]= puntaje[0];
                
            }else{
                caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                
                    while(ady != null){

                        //si el nodo ya no se encuentra en el camino actual y  suma de la etiqueta entre el vertice y el nodo ady no es mayor al puntajeMinimo
                        System.out.println((int)ady.getEtiqueta());
                        if(caminoActual.localizar(ady.getVertice().getElem()) < 0 && (puntaje[0]+(int)ady.getEtiqueta() < puntaje[1] || puntaje[1] == 0  )){ 
                            puntaje[0]+= (int)ady.getEtiqueta();//sumamos la etiqueta
                            camino= caminoMasCortoPorEtiquetaAux(ady.getVertice(), dest,caminoActual, caminoMasCorto, puntaje);

                           
                            
                            caminoActual.eliminar(caminoActual.longitud());  //quitamos el elemento del camino para buscar otros
                            puntaje[0]-= (int)ady.getEtiqueta(); //tambien el valor de la etiqueta
                        }
                        ady= ady.getSigAdyacente();
                    }
                
                                
            }
        }
        return camino;
    }
    
    public Lista caminoMasLargo(Object origen, Object destino){
        Lista caminoMasLargo= new Lista();
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista caminoActual= new Lista();
            caminoMasLargo= caminoMasLargoAux(auxO, destino, caminoActual, caminoMasLargo);
        }
        return caminoMasLargo;
    }
    
    private Lista caminoMasLargoAux(NodoVert n, Object dest, Lista caminoActual, Lista caminoMasLargo){
        Lista camino= new Lista();
        if(n != null){
            //si vertice n es el destino: hay camino!
            
            if(n.getElem().equals(dest)){
                caminoActual.insertar( n.getElem(), caminoActual.longitud()+1);
                camino= caminoActual.clone();
            }else{
                //sino es el destino verifica si hay camino entre n y el destino
                caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                while(ady != null){
                    if(caminoActual.localizar(ady.getVertice().getElem()) < 0){
                        camino= caminoMasLargoAux(ady.getVertice(), dest,caminoActual, caminoMasLargo); 
                        caminoActual.eliminar(caminoActual.longitud());
                   }
                    if(!camino.esVacia() && (camino.longitud() > caminoMasLargo.longitud() || caminoMasLargo.esVacia())){
                        caminoMasLargo= camino.clone();
                    }else{
                        camino= caminoMasLargo;
                    }
                    ady= ady.getSigAdyacente();
                }                
            }
        }
        return camino;
    }
    public Lista listarCaminoSinPasarPor(Object origen, Object destino, Object elem, int puntaje){
        Lista listaCaminos= new Lista();
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert auxE= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null || auxE == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            if(aux.getElem().equals(elem)) auxE= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null && auxE != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista caminoActual= new Lista();
            listarCaminoSinPasarPorAux(auxO, destino, caminoActual, listaCaminos, elem, 0, puntaje);
        }
        return listaCaminos;
    }
    
    private void listarCaminoSinPasarPorAux(NodoVert n, Object dest, Lista caminoActual, Lista listaCaminos,Object elem, int puntajeActual, int puntajeTope){
        if(n != null){
            //si vertice n es el destino: hay camino!
            
            if(n.getElem().equals(dest)){
                caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
                listaCaminos.insertar(caminoActual.clone(), listaCaminos.longitud()+1);
            }else{
                //sino es el destino verifica si hay camino entre n y el destino
                caminoActual.insertar(n.getElem(), caminoActual.longitud()+1);
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                while(ady != null){
                    if(caminoActual.localizar(ady.getVertice().getElem()) < 0 && !ady.getVertice().getElem().equals(elem) && puntajeActual+(int)ady.getEtiqueta() <= puntajeTope){
                        listarCaminoSinPasarPorAux(ady.getVertice(), dest,caminoActual, listaCaminos, elem,(puntajeActual+(int)ady.getEtiqueta()), puntajeTope ); 
                        caminoActual.eliminar(caminoActual.longitud());
                    }
                    ady= ady.getSigAdyacente();
                }                
            }
        }
    }
    
    
    public Lista listarEnProfundidad(){
        Lista visitados= new Lista();
        NodoVert aux= this.inicio;
        while(aux != null){
            if(visitados.localizar(aux.getElem()) < 0){
                listarEnProfundidadAux(aux, visitados);
            }
            aux= aux.getSigVertice();
        }
        return visitados;
    }
    
    public void listarEnProfundidadAux(NodoVert n, Lista vis){
        if(n != null){
            vis.insertar(n.getElem(), vis.longitud()+1);
            NodoAdyEtiquetado ady= n.getPrimerAdy();
            while(ady != null){
                if(vis.localizar(ady.getVertice().getElem()) < 0){
                    listarEnProfundidadAux(ady.getVertice(), vis);
                }
                ady= ady.getSigAdyacente();
            }
        }
    }
   
    private boolean listarCamino(NodoVert n, Object dest, Lista vis){
        boolean exito= false;
        if(n != null){
            //si vertice n es el destino: hay camino!
            if(n.getElem().equals(dest)){
                vis.insertar(n.getElem(), vis.longitud()+1);
                exito= true;
                
            }else{
                //sino es el destino verifica si hay camino entre n y el destino
                vis.insertar(n.getElem(), vis.longitud()+1);
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                while(!exito && ady != null){
                    if(vis.localizar(ady.getVertice().getElem()) < 0){
                        exito= listarCamino(ady.getVertice(), dest, vis);
                    }
                    ady= ady.getSigAdyacente();
                }
            }
        }
        return exito;   
    }
    
    public Lista listarEnAnchura(){
        Lista vis= new Lista();
        NodoVert nAux= this.inicio;
        while(nAux != null){
            if(vis.localizar(nAux.getElem()) < 0){
                listarEnAnchuraAux(nAux, vis);
            }
            nAux= nAux.getSigVertice();
        }
        return vis;
    }
    
    private void listarEnAnchuraAux(NodoVert n, Lista vis){
        Cola q= new Cola();
        vis.insertar(n.getElem(), vis.longitud()+1);
        q.poner(n);
        while(!q.esVacia()){
            NodoVert u= (NodoVert)q.obtenerFrente();
            q.sacar();
            NodoAdyEtiquetado ady= u.getPrimerAdy();
            while(ady != null){
                if(vis.localizar(ady.getVertice().getElem()) < 0){
                    vis.insertar(ady.getVertice().getElem(), vis.longitud()+1);
                    q.poner(ady.getVertice());
                }
                ady= ady.getSigAdyacente();
            }
            
        }
    }
    public boolean modificarArco(Object elemVert1, Object elemVert2, int etiqueta){
        boolean exito= false;
        if(this.inicio != null){
            exito= modificarArcoAux(this.inicio, elemVert1, elemVert2, etiqueta);
        }
        return exito;
        
    }
    
    private boolean modificarArcoAux(NodoVert n, Object v1, Object v2, int etiqueta){
        /*ESTE METODO PERMITE MODIFICAR LA ETIQUETA DE UN ARCO ENTRE DOS NODOS VERTICES, SI ES QUE EXISTE*/
        boolean exito= false;
        NodoAdyEtiquetado nAux2= null;
        if(n != null){
            if(n.getElem().equals(v1)){
                NodoAdyEtiquetado nAux= n.getPrimerAdy();
                nAux2= obtenerArcoEtiquetado(nAux, v2);
            }
            if(n.getElem().equals(v2)){
                NodoAdyEtiquetado nAux= n.getPrimerAdy();
                nAux2= obtenerArcoEtiquetado(nAux, v1);
            }
            if(nAux2 == null){
                modificarArcoAux(n.getSigVertice(), v1, v2, etiqueta);
            }else{
                nAux2.setEtiqueta(etiqueta); //modificamos la etiqueta
                exito= true;
            }
        }
        return exito;
    }
    
     public Lista caminoDePesoEntre(Object origen, Object destino, int pesMin, int pesoMax){
        Lista camino= new Lista();
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista vis= new Lista();
            Lista caminoAux= new Lista();
            camino= caminoDePesoEntreAux(auxO, destino, pesMin, pesoMax, vis, 0, caminoAux);
        }
        return camino;
    }
     
    private Lista caminoDePesoEntreAux(NodoVert n, Object destino, int pesoMin, int pesoMax, Lista vis, int pesoAcum, Lista camino){
        if(n != null){
            vis.insertar(n.getElem(), vis.longitud()+1);
            if(n.getElem().equals(destino)){
                camino= vis.clone();
            }else{
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                while(ady != null && camino.esVacia()){
                    if( vis.localizar(ady.getVertice().getElem()) < 0&&((int)ady.getEtiqueta() + pesoAcum <= pesoMin || (int)ady.getEtiqueta() + pesoAcum <= pesoMax)){
                        pesoAcum += (int)ady.getEtiqueta();
                        camino= caminoDePesoEntreAux(ady.getVertice(), destino, pesoMin, pesoMax, vis, pesoAcum, camino);
                        vis.eliminar(vis.longitud());
                        pesoAcum-= (int)ady.getEtiqueta();
                    }
                    ady= ady.getSigAdyacente();
                }
            }
        }
        return camino;
    }
     public Lista caminoDePesoEntre2(Object origen, Object destino, int pesMin, int pesoMax){
        Lista camino= new Lista();
        //verificar si ambos vertices existen
        NodoVert auxO= null;
        NodoVert auxD= null;
        NodoVert aux= this.inicio;
        
        while((auxO == null || auxD == null) && aux != null){
            if(aux.getElem().equals(origen)) auxO= aux;
            if(aux.getElem().equals(destino)) auxD= aux;
            aux= aux.getSigVertice();
        }
        if(auxO != null && auxD != null){
            // si ambos vertices existen se busca un camino entre ambos
            Lista vis= new Lista();
            Lista listaAux= new Lista();
            camino= caminoDePesoEntreAux2(auxO, destino, pesMin, pesoMax, vis, 0, listaAux);
        }
        return camino;
    }
     
    private Lista caminoDePesoEntreAux2(NodoVert n, Object destino, int pesoMin, int pesoMax, Lista vis, int pesoAcum, Lista camino){

        if(n != null){
            vis.insertar(n.getElem(), vis.longitud()+1);
            if(n.getElem().equals(destino) && pesoAcum >= pesoMin ){
                camino= vis.clone();
            }else{
                NodoAdyEtiquetado ady= n.getPrimerAdy();
                while(ady != null && camino.esVacia()){
                    if( vis.localizar(ady.getVertice().getElem()) < 0 && (int)ady.getEtiqueta() + pesoAcum <= pesoMax){
                        camino= caminoDePesoEntreAux2(ady.getVertice(), destino, pesoMin, pesoMax, vis, pesoAcum + (int)ady.getEtiqueta(), camino);
                        vis.eliminar(vis.longitud());
                    }
                    ady= ady.getSigAdyacente();
                }
            }
        }
        return camino;
    }
     public Lista caminoDeLongitudMenorA(Object origen, Object destino, int longMax  ){
         Lista camino= new Lista();
         NodoVert nAux= this.inicio;
         NodoVert nO= null;
         NodoVert nD= null;
         while((nO == null || nD == null ) && nAux != null){
             if(nAux.getElem().equals(origen))nO = nAux;
             if(nAux.getElem().equals(destino))nD = nAux;
             nAux= nAux.getSigVertice();
         }
         
         if(nO != null && nD != null && longMax > 0){
             Lista vis= new Lista();
             camino= caminoDeLongitudMenorAAux(nO, destino, longMax, camino, vis);
         }
         return camino;
     }
     private Lista caminoDeLongitudMenorAAux(NodoVert n, Object destino, int longMax, Lista camino, Lista vis  ){
         if( n != null){
             vis.insertar(n.getElem(), vis.longitud()+1);
             if(n.getElem().equals(destino)){
                 camino= vis.clone();
             }else{
                 if(vis.longitud() <= longMax){
                        NodoAdyEtiquetado nAdy= n.getPrimerAdy();
                        while(nAdy != null && camino.esVacia()){
                            if(vis.localizar(nAdy.getVertice().getElem()) < 0){
                                camino= caminoDeLongitudMenorAAux(nAdy.getVertice(), destino, longMax, camino, vis);    
                                vis.eliminar(vis.longitud());
                            }
                            
                            nAdy= nAdy.getSigAdyacente();
                        }
                 }
             }
         }
         return camino;
     }
     
    
}
