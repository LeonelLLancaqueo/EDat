/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class ArbolHeap {
    private int TAMANIO;
    private Comparable heap[];
    private int ultimo;
    
    public ArbolHeap(int unTamanio){
        this.heap= new Comparable[unTamanio - 1];
        this.TAMANIO= unTamanio; 
        this.ultimo= 0;
    }
    public boolean insertar(Comparable e){
        boolean exito= false;
        if(this.ultimo+1 <= this.heap.length){
            this.ultimo++;
            this.heap[this.ultimo]= e;
            hacerSubir();
        }
        return exito;
    }
    public Comparable recuperarCima(){
        return this.heap[1];
    }
    
    public boolean eliminarCima(){
        boolean exito;
        if(this.ultimo == 0){
            //estructura vacia
            exito=false;
        }else{
            //saca la raiz y pone la ultima hoja en su lugar
            this.heap[1]= this.heap[ultimo];
            this.ultimo--;
            //restablece la propiedad del heap minimo
            hacerBajar(1);
            exito= true;
        }
    return exito;
    }
    private void hacerSubir(){
        int posH= this.ultimo;
        Comparable temp= this.heap[this.ultimo];
        boolean salir= false;
        
        while(!salir && posH > 1){
            int posPadre= posH / 2;
            if(temp.compareTo(this.heap[posPadre]) < 0){ //si el hijo es menor que el padre los intercambia
                this.heap[posH]= this.heap[posPadre];
                this.heap[posPadre]= temp;
                posH= posPadre;
            }else{
                salir= true; // el padre es menor que el hijo entonces el hijo esta bien colocado
            }
        }
    }
    
    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp= this.heap[1]; // guarda el valor del arreglo en la posPadre
        boolean salir= false;
        
        while(!salir){
            posH = posPadre*2; // obtenemos la posicion de el hijoIzquierdo de  posPadre (si es q tiene)
            if(posH <= this.ultimo){ //verificamos que exista un hijoIzquierdo
                if(posH < this.ultimo){ // verificamos si existe un hermano derecho de hijoIzquierdo
                    if(this.heap[posH+1].compareTo(this.heap[posH]) < 0){ //compara si el hijoDerecho es menor que el hijoIzquierdo
                        posH++;
                    }
                }
                //compara al hijoMenor con el padre
                if(this.heap[posH].compareTo(temp) < 0){
                    //si el hijo es menor que el padre, los intercambia.
                    this.heap[posPadre]= this.heap[posH];
                    this.heap[posH]= temp;
                    posPadre= posH;
                }else{
                    //el padre es menor que sus hojas esta bien ubicado
                    salir= true;
                }
            }else{
                //el temp es hoja, esta bien ubicado.
                salir= true;
            }
        }
    }
    public ArbolHeap clone(){
        ArbolHeap unArbolHeap= new ArbolHeap(this.TAMANIO);
        unArbolHeap.heap= this.heap.clone();
        return unArbolHeap;
    }
    public String toString(){
        String s= "[ ";
        int i, cont=0;
        for(i=1; i<= this.ultimo; i++){
            s+=  this.heap[i];
            if(i <this.ultimo){
                s+= ", " ;
            }
        }
        s+= " ]";
        return s;
    }
    
}
