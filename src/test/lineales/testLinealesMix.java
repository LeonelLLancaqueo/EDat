/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
/**
 *
 * @author Leonel LLancaqueo
 */
public class testLinealesMix {
    public static boolean controlarPatron(Cola q){
        Pila p= new Pila();
        boolean respuesta = true, encontrado= false;
        Cola c= new Cola();
        
        while(!q.esVacia() && respuesta){
            while(!q.esVacia() && !(q.obtenerFrente().equals('&'))){
                p.apilar(q.obtenerFrente());
                c.poner(q.obtenerFrente());
                q.sacar();
            }
            if(q.esVacia()){
                respuesta= false;
            }else{
                q.sacar();
            }
            while(!q.esVacia() && !p.esVacia() && respuesta){
                if(q.obtenerFrente().equals(p.obtenerTope())){
                    q.sacar();
                    p.desapilar();
                }else{
                    respuesta= false;
                }
            }
            while(! q.esVacia() && !c.esVacia() && respuesta){
                if(q.obtenerFrente().equals(c.obtenerFrente())){
                    q.sacar();
                    c.sacar();
                }else{
                    respuesta= false;
                }
            }
        }
        return respuesta;
    }
    public static Lista formarLista(Pila p1){
        Lista lis= new Lista();
        int i=0;
        Pila pilaAux= new Pila();
        while(!p1.esVacia()){
            while(!p1.esVacia() && !(p1.obtenerTope().equals('@'))){
                lis.insertar(p1.obtenerTope(), lis.longitud()+1);
                pilaAux.apilar(p1.obtenerTope());
                p1.desapilar();
                i++;
            }
            if(i == 2){
                while(!pilaAux.esVacia()){
                    lis.insertar(pilaAux.obtenerTope(), lis.longitud()+1);
                    pilaAux.desapilar();
                }
            }else{
                pilaAux.vaciar();
            }
            if(!p1.esVacia()){
                lis.insertar(p1.obtenerTope(), lis.longitud()+1);
                p1.desapilar();
            }
            i=0;
        }
        return lis;
    }
    public static Lista intercalar(Lista a, Lista b){
        Lista lis= new Lista();
        if( !a.esVacia() && !b.esVacia()){
            intercalarAux(a, b, lis);
        }else{
            if(!a.esVacia()){
                lis= b.clone();
            }else{
                if(!b.esVacia()){
                    lis= a.clone();
                }
            }
        }
        return lis;
    }
    private static void intercalarAux(Lista a, Lista b, Lista lis){
        int i=1;
        while(i <= a.longitud() || i <= b.longitud()){
            if(i <= a.longitud()){
                lis.insertar(a.recuperar(i), lis.longitud()+1);
            }
            if(i <= b.longitud()){
                lis.insertar(b.recuperar(i), lis.longitud()+1);
            }
            i++;
        }
    }
    public static boolean verificarBalanceo(Cola q){
        Pila p= new Pila();
        boolean balanceado= true;
        
        while(!q.esVacia() && balanceado){
            Object elem= q.obtenerFrente();
            if((char)elem == '{'){
                p.apilar('}');
            }
            if((char)elem == '('){
                p.apilar(')');
            }
            if((char)elem == '['){
                p.apilar(']');
            }
            if((char)elem == '}' || (char)elem == ']' || (char)elem == ')'){
                if(!p.esVacia() && (char)elem == (char)p.obtenerTope()){
                    p.desapilar();
                }else{
                    balanceado=false;
                }
            }
            q.sacar();
        }
        if(!p.esVacia()){
            balanceado = false;
        }
        return balanceado;
    }
    public static boolean comprobar(Lista unaLista){
        Pila nPila= new Pila();
        Cola nCola= new Cola();
        int i=1;
        boolean seguir= true;
        while(i <= unaLista.longitud() && seguir){
            while((!((int)unaLista.recuperar(i) == 0))){
                System.out.println("elemento: "+ (int)unaLista.recuperar(i));
                nCola.poner(unaLista.recuperar(i));
                nPila.apilar(unaLista.recuperar(i));
                i++;
            }
            i++;
            while(seguir && !nCola.esVacia()){
                if((int)unaLista.recuperar(i) == (int) nCola.obtenerFrente()){
                    nCola.sacar();
                    i++;
                }else{
                    seguir= false;
                }
            }
            i++;
            while(seguir && !nPila.esVacia()){
                if((int)unaLista.recuperar(i) == (int) nPila.obtenerTope()){
                    nPila.desapilar();
                    i++;
                }else{
                    seguir= false;
                }
            }
        }
        return seguir;
    }
    public static Cola generarOtraCola(Cola nCola){
        Pila nPila= new Pila();
        Cola otraCola = new Cola();
        while(!nCola.esVacia()){
            while(!nCola.esVacia() && (char)nCola.obtenerFrente() != '$'){
                System.out.println(" que  apila: " + nCola.obtenerFrente().toString() );
                nPila.apilar(nCola.obtenerFrente());
                otraCola.poner(nCola.obtenerFrente());
                nCola.sacar();
            }
            while(!nPila.esVacia()){
                otraCola.poner(nPila.obtenerTope());
                nPila.desapilar();
            }
            if( nCola.obtenerFrente() !=  null){
                otraCola.poner('$');
                nCola.sacar();
            }
        }
        return otraCola;
    }
    public static void main(String[] args) {
        /*Cola nCola= new Cola();
        nCola.poner('A');
        nCola.poner('B');
        nCola.poner('$');
        nCola.poner('C');
        nCola.poner('$');
        nCola.poner('D');
        nCola.poner('E');
        nCola.poner('F');
        Cola aCola= new Cola();
        aCola.poner('A');
        aCola.poner('B');
        aCola.poner('$');
        Cola bCola= new Cola();
        bCola.poner('A');
        bCola.poner('B');
        bCola.poner('$');
        System.out.println("Cola original: " + nCola.toString());
        System.out.println("otra cola: "+ generarOtraCola(nCola).toString());*/
        /*
        Lista nLista= new Lista();
        nLista.insertar(9, nLista.longitud()+1);
        nLista.insertar(6, nLista.longitud()+1);
        nLista.insertar(5, nLista.longitud()+1);
        nLista.insertar(0, nLista.longitud()+1);
        nLista.insertar(9, nLista.longitud()+1);
        nLista.insertar(6, nLista.longitud()+1);
        nLista.insertar(5, nLista.longitud()+1);
        nLista.insertar(0, nLista.longitud()+1);
        nLista.insertar(5, nLista.longitud()+1);
        nLista.insertar(6, nLista.longitud()+1);
        nLista.insertar(9, nLista.longitud()+1);
        
        System.out.println("resultado de comprobar: "+ comprobar(nLista));
        */
       
        /*Lista aLista= new Lista();
        aLista.insertar(1, aLista.longitud()+1);
        aLista.insertar(1, aLista.longitud()+1);
        aLista.insertar(1, aLista.longitud()+1);
        aLista.insertar(4, aLista.longitud()+1);
        aLista.insertar(5, aLista.longitud()+1);
        aLista.insertar(1, aLista.longitud()+1);
        aLista.insertar(1, aLista.longitud()+1);
        aLista.insertar(6, aLista.longitud()+1);
        //aLista.invertir();
        //System.out.println("lista invertida: "+ aLista.toString());
        System.out.println("lista: " + aLista.toString());
        aLista.eliminarApariciones(1);
        System.out.println("lista: " + aLista.toString());
        */
    
        Cola nCola= new Cola();
        nCola.poner('[');
        nCola.poner(']');
        nCola.poner('(');
        nCola.poner('[');
        nCola.poner(']');
        nCola.poner('(');
        nCola.poner(')');
        nCola.poner(')');
        
        
        /*
        nCola.poner('[');
        nCola.poner('(');
        nCola.poner(')');
        nCola.poner(']');
        nCola.poner('}');*/
        /*
        System.out.println(" balanceo nCola: " + verificarBalanceo(nCola));
        
        Lista a= new Lista();
        a.insertar(1, 1);
        a.insertar(3, 2);
        a.insertar(5, 3);
        Lista b= new Lista();
        b.insertar(2, 1);
        b.insertar(4, 2);
        b.insertar(6, 3);
        b.insertar(7, 4);
        System.out.println("intercalar a y b: "+ intercalar(a, b).toString());
        */
        /*
        Pila p1= new Pila();
        p1.apilar('X');
        p1.apilar('Y');
        p1.apilar('W');
        p1.apilar('@');
        p1.apilar('R');
        p1.apilar('Z');
        p1.apilar('@');
        p1.apilar('Y');
        p1.apilar('T');
        p1.apilar('@');
        p1.apilar('Z');
        p1.apilar('T');
        p1.apilar('R');
        
        System.out.println("pila p1: "+ p1.toString());
        System.out.println("lista: "+ formarLista(p1).toString());
        
        Lista lis= new Lista();
        /*
        lis.insertar(1, 1);
        lis.insertar(3, 2);
        lis.insertar(5, 3);
        
        Lista lis2= new Lista();
        lis2.insertar(2, 1);
        lis2.insertar(4, 2);
        lis2.insertar(6, 3);
        lis2.insertar(7, 4);
        
        
        lis.intercalar(lis2);
        System.out.println(" lista intercalada: "+ lis.toString());
        System.out.println("long lista: " + lis.longitud());
        */
        
        Lista lis= new Lista();
        lis.insertar(1, 1);
        lis.insertar(2, 2);
        lis.insertar(3, 3);
        lis.insertar(1, 4);
        lis.insertar(4, 5);
        lis.insertar(7, 6);
        lis.insertar(1, 7);
        lis.insertar(1, 8);
        lis.insertar(8, 9);
        lis.insertar(1, 10);
        lis.insertar(3, 11);
        lis.insertar(1, 12);
        lis.insertar(1, 13);
        lis.insertar(1, 14);
        
        System.out.println("lis original: "+ lis.toString());
        System.out.println("lis: "+ lis.longitud());
        lis.eliminarSiguiente(1);
        System.out.println("lis despues: "+ lis.toString());
        System.out.println("lis: "+ lis.longitud());
        
        
        Cola q= new Cola(); //  Sea q  ← 8,9,6,&,6,9,8,8,9,6,&,1,7,&,7,1,1,7 ← debe retornar TRUE
        q.poner(8);
        q.poner(9);
        q.poner(6);
        q.poner('&');
        q.poner(6);
        q.poner(9);
        q.poner(8);
        q.poner(8);
        q.poner(9);
        q.poner(6);
        q.poner('&');
        q.poner(1);
        q.poner(7);
        q.poner('&');
        q.poner(7);
        q.poner(1);
        q.poner(1);
        q.poner(7);
        Cola q2= new Cola(); // Sea q  ← 8,9,6,&,6,9,8,8,9,6,3,&,1,7,&,7,1,1,7 ← debe retornar FALSE
        q2.poner(8);
        q2.poner(9);
        q2.poner(6);
        q2.poner('&');
        q2.poner(6);
        q2.poner(9);
        q2.poner(8);
        q2.poner(8);
        q2.poner(9);
        q2.poner(6);
        q2.poner(3);
        q2.poner('&');
        q2.poner(1);
        q2.poner(7);
        q2.poner('&');
        q2.poner(7);
        q2.poner(1);
        q2.poner(1);
        q2.poner(7);
        Cola q3= new Cola(); //Sea q  ← 8,9,6,&,6,9,8,8,9,6,&,1,7,&,7,1,5,1,7 ← debe retornar FALSE
        q3.poner(8);
        q3.poner(9);
        q3.poner(6);
        q3.poner('&');
        q3.poner(6);
        q3.poner(9);
        q3.poner(8);
        q3.poner(8);
        q3.poner(9);
        q3.poner(6);
        q3.poner('&');
        q3.poner(1);
        q3.poner(7);
        q3.poner('&');
        q3.poner(7);
        q3.poner(1);
        q3.poner(5);
        q3.poner(1);
        q3.poner(7);
        Cola q4= new Cola(); //Sea q  ← 8,9,6,6,9,8,8,9,6,1,7,7,1,1,7 ← debe retornar FALSE
        q4.poner(8);
        q4.poner(9);
        q4.poner(6);
        //q4.poner('&');
        q4.poner(6);
        q4.poner(9);
        q4.poner(8);
        q4.poner(8);
        q4.poner(9);
        q4.poner(6);
        //q4.poner('&');
        q4.poner(1);
        q4.poner(7);
        //q4.poner('&');
        q4.poner(7);
        q4.poner(1);
        q4.poner(1);
        q4.poner(7);
        
        System.out.println("controlar patron q: " + controlarPatron(q));
        System.out.println("controlar patron q2: " + controlarPatron(q2));
        System.out.println("controlar patron q3: " + controlarPatron(q3));
        System.out.println("controlar patron q4: " + controlarPatron(q4));
        
    }
}
