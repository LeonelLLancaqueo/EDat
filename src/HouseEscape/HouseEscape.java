/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HouseEscape;
import interrelacionistas.Grafo;
import TDA.Diccionario;
import TDA.TablaBusquedaHash;
import TDA.MapeoAMuchos;

import java.io.BufferedReader;
/* opcional */
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import lineales.dinamicas.Lista;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *
 * @author Leonel LLancaqueo
 */
public class HouseEscape {
    private Grafo mapa;
    private Diccionario habitaciones;
    private  Diccionario desafio;
    private TablaBusquedaHash equipos;
    private MapeoAMuchos equipoDesafios;
    private Scanner sc;
            
    public HouseEscape(){
        this.mapa= new Grafo();
        this.habitaciones= new Diccionario();
        this.desafio= new Diccionario();
        this.equipos= new TablaBusquedaHash();
        this.equipoDesafios= new MapeoAMuchos();  
        this.sc = new Scanner(System.in);

    }
    
    private void cargaInicial(){
        /*METODO Q PERMITE REALIZAR LA CARGA INICIAL DEL JUEGO A TRAVES DE LA LECTURA DE UN ARCHIVO DE DATOS*/
        
        try {
            BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\Leonel LLancaqueo\\Desktop\\Materias\\Segundo Año\\PrimerCuatrimestre\\Estructuras de Datos\\cargaInicialDefinitiva.txt"));

            String lineas;
            while((lineas = br.readLine()) != null){
                StringTokenizer tokens= new StringTokenizer(lineas,";");
                switch(tokens.nextToken().charAt(0)){
                    case 'H': System.out.println("Habitacion cargada: "+ this.insertarHabitacion(new Habitacion(Integer.parseInt(tokens.nextToken()), tokens.nextToken(),Integer.parseInt(tokens.nextToken()) , Integer.parseInt(tokens.nextToken()), Boolean.parseBoolean(tokens.nextToken()))));break;
                    case 'E': System.out.println("Equipo cargado: "+this.insertarEquipo(new Equipo(tokens.nextToken(), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()))));break;
                    case 'D': System.out.println("Desafio cargado: "+this.insertarDesafio(new Desafio(Integer.parseInt(tokens.nextToken()), tokens.nextToken(), tokens.nextToken())));break;
                    case 'P': System.out.println("Puerta cargada: "+ this.insertarPuerta(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));break;
                    case 'A': System.out.println("Desafio cargado a equipo: "+ this.insertarDesafioAEquipo(tokens.nextToken(), Integer.parseInt(tokens.nextToken())));break;
                }
            }
        } catch (IOException e) {
            System.out.println("Direccion invalida");
        }
    }
    
    private void escribirLog(String texto){
         try {
            BufferedWriter cambios= new BufferedWriter(new FileWriter("C:\\Users\\Leonel LLancaqueo\\Desktop\\Materias\\Segundo Año\\PrimerCuatrimestre\\Estructuras de Datos\\cambios.txt"));
            cambios.write(texto);
            cambios.newLine();
            cambios.flush();
         } catch (IOException e) {
            System.out.println("Direccion invalida");
        }
        
    }   
    
    public void menu(){
        boolean salir= true;
        while(salir){
            System.out.println("BIENVENIDO A HOUSE ESCAPE");
            System.out.println("Opciones de Menu: ");
            System.out.println("1 - Carga Inicial del Sistema");
            System.out.println("2 - Altas, Bajas y Modificaciones");
            System.out.println("3 - Consulta sobre Habitaciones");
            System.out.println("4 - Consulta sobre Desafios");
            System.out.println("5 - Consulta sobre equipos participantes");
            System.out.println("6 - Mostrar Sistema");
            System.out.println("7 - Salir Programa");
            System.out.println("Ingrese el numero de la opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: this.cargaInicial();break;
                case 2: this.altasBajasYModificaciones();break;
                case 3: this.consultaSobreHabitaciones();break;
                case 4: this.consultaSobreDesafios();break;
                case 5: this.consultaSobreEquiposParticipantes();break;
                case 6: System.out.println(this.mostrarSistema());break;      
                case 7: System.exit(0);break;      
                default: System.out.println("Error"); break;  
            }
        }
        
    }
    
    private void altasBajasYModificaciones(){
        boolean continuar= true;
        while(continuar){
            System.out.println("Opciones de Menu: ");
            System.out.println("1 - Insertar");
            System.out.println("2 - Eliminar");
            System.out.println("3 - Modificar");
            System.out.println("4 - Volver atras");
            System.out.println("Ingrese el numero de la opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: this.insertarDesdeMenu();break;
                case 2: this.eliminarDesdeMenu();break;
                case 3: this.modificarDesdeMenu();break;
                case 4: continuar= false;break;
                default: System.out.println("Error"); break;  
            }
        }
        
    }
    
    private void modificarDesdeMenu(){
        boolean continuar = true;
        while (continuar) {
            System.out.println("Opciones de Menu: ");
            System.out.println("1 - Habitacion");
            System.out.println("2 - Equipo");
            System.out.println("3 - Desafio");
            System.out.println("4 - Puerta");
            System.out.println("5 - Volver atras");
            System.out.println("Ingrese el numero de la opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: this.modificarHabitacionMenu();break;
                case 2: this.modificarEquipoMenu();;break;
                case 3: this.modificarDesafioMenu();break;
                case 4: this.modificarPuertaMenu();break;
                case 5: continuar = false;break;

                default: System.out.println("Error"); break;  
            }
        }
    }
    
    private void insertarDesdeMenu(){
        boolean continuar = true;
        while (continuar) {
            System.out.println("Opciones de Menu: ");
            System.out.println("1 - Habitacion");
            System.out.println("2 - Equipo");
            System.out.println("3 - Desafio");
            System.out.println("4 - Puerta");
            System.out.println("5 - Volver atras");
            System.out.println("Ingrese el numero de la opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: this.insertarHabitacionMenu();break;
                case 2: this.insertarEquipoMenu();break;
                case 3: this.insertarDesafioMenu();break;
                case 4: this.insertarPuertaMenu();break;
                case 5: continuar = false;break;

                default: System.out.println("Error"); break;  
            }
        }
        
        
    }
    
    private void eliminarDesdeMenu(){
        
        boolean continuar= true;
        while(continuar){
            System.out.println("Opciones de Menu: ");
            System.out.println("1 - Habitacion");
            System.out.println("2 - Equipo");
            System.out.println("3 - Desafio");
            System.out.println("4 - Puerta");
            System.out.println("5 - Volver atras");
            System.out.println("Ingrese el numero de la opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: this.eliminarHabitacionMenu();break;
                case 2: this.eliminarEquipoMenu();break;
                case 3: this.eliminarDesafioMenu();break;
                case 4: this.eliminarPuertaMenu();break;
                case 5: continuar= false;break;
                default: System.out.println("Error"); break;  

            }
        }
    }
    
    private void consultaSobreHabitaciones(){

        int codigoA, codigoB, codigoC, puntos;
        boolean continuar= true;
        while(continuar){
            System.out.println("CONSULTA SOBRE HABITACIONES: ");
            System.out.println("1 - Mostrar Habitacion ");
            System.out.println("2 - Habitaciones Contiguas");
            System.out.println("3 - Es Posible llegar");
            System.out.println("4 - Minimo Puntaje");
            System.out.println("5 - Mostrar camino sin pasar por una habitacion");
            System.out.println("6 - Volver");
            System.out.println("Ingrese el numero de la opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: System.out.println("Ingrese un codigo de habitacion: ");
                        codigoA= sc.nextInt();
                        System.out.println(this.mostrarHabitacion(codigoA));break;
                case 2: System.out.println("Ingrese un codigo de habitacion: ");
                        codigoB= sc.nextInt();
                        System.out.println(this.habitacionesContiguas(codigoB));break;
                case 3: System.out.println("Ingrese un codigo de habitacion A: ");
                        codigoA= sc.nextInt();
                        System.out.println("Ingrese un codigo de habitacion B: ");
                        codigoB= sc.nextInt();
                        System.out.println("Ingrese la cantidad de puntos: ");
                        puntos= sc.nextInt();
                        System.out.println(this.esPosibleLlegar(codigoA, codigoB, puntos));break;
                case 4: System.out.println("Ingrese un codigo de habitacion A: ");
                        codigoA= sc.nextInt();
                        System.out.println("Ingrese un codigo de habitacion B: ");
                        codigoB= sc.nextInt();
                        System.out.println(this.minimoPuntaje(codigoA, codigoB));break;
                case 5: System.out.println("Ingrese un codigo de habitacion A: ");
                        codigoA= sc.nextInt();
                        System.out.println("Ingrese un codigo de habitacion B: ");
                        codigoB= sc.nextInt();
                        System.out.println("Ingrese un codigo de habitacion C: ");
                        codigoC= sc.nextInt();
                        System.out.println("Ingrese la cantidad de puntos limite: ");
                        puntos= sc.nextInt();
                        System.out.println("Caminos de habA a habB sin pasar por habC sin ganar mas de "+ puntos+" : "+ this.sinPasarPor(codigoA, codigoB, codigoC, puntos));break;

                case 6: continuar= false; break;
                default: System.out.println("Opcion invalida");      
            }
        }

    }
    
    private void consultaSobreDesafios(){
        boolean continuar= true;
        int puntajeA, puntajeB;
        String nameTeam, nameDesafio;
        while(continuar){
            System.out.println("CONSULTA SOBRE DESAFIOS: ");
            System.out.println("1 - Mostrar Desafio ");
            System.out.println("2 - Mostrar Desafios Resueltos");
            System.out.println("3 - Verificar Desafio Resuelto");
            System.out.println("4 - Mostrar Desafio tipo");
            System.out.println("5 - Volver");
            System.out.println("Ingrese el numero de la opcion: ");

            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: System.out.println("Ingrese el puntaje de un desafio: ");
                        puntajeA= sc.nextInt();
                        System.out.println(this.mostrarDesafio(puntajeA));break;
                case 2: System.out.println("Ingrese nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println(this.mostrarDesafioResuelto(nameTeam));break;
                case 3: System.out.println("Ingrese nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println("Ingrese nombre de un desafio: ");
                        nameDesafio= sc.nextLine();
                        System.out.println("El desafio fue resuleto por el equipo: " + this.verificarDesafioResuelto(nameTeam, nameDesafio));break;
                case 4: System.out.println("Ingrese un puntaje A: ");
                        puntajeA= sc.nextInt();
                        System.out.println("Ingrese un puntaje B: ");
                        puntajeB= sc.nextInt();
                        System.out.println("Ingrese un tipo de desafio: ");
                        String tipoDesafio= sc.nextLine();
                        System.out.println("Lista de desafios: "+this.mostrarDesafiosTipo(puntajeA, puntajeB, tipoDesafio));break;
                case 5: continuar= false;

                default: System.out.println("opcion no valida");          
            }
        }
    }
    
    private void consultaSobreEquiposParticipantes(){
        boolean continuar= true;
        int  codigoA, puntajeA;
        String nameTeam;
        while(continuar){
            System.out.println("CONSULTA SOBRE EQUIPOS PARTICIPANTES: ");
            System.out.println("1 - Mostrar informacion de un equipo ");
            System.out.println("2 - Posibles desafios");
            System.out.println("3 - Jugar desafio");
            System.out.println("4 - Pasar a habitacion");
            System.out.println("5 - Puede salir");
            System.out.println("6 - Volver atras");
            System.out.println("Ingrese el numero de la opcion: ");

            int opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: System.out.println("Ingrese el nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println(this.mostrarInfoEquipo(nameTeam));break;
                case 2: System.out.println("Ingrese el nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println("Ingrese el codigo de una hab: ");
                        codigoA= sc.nextInt();
                        System.out.println(this.posiblesDesafios(nameTeam, codigoA));break;
                case 3: System.out.println("Ingrese nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println("Ingrese el puntaje de un desafio: ");
                        puntajeA= sc.nextInt();
                        System.out.println(this.jugarDesafio(nameTeam, puntajeA));break;
                case 4: System.out.println("Ingrese el nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println("Ingrese el codigo de una hab: ");
                        codigoA= sc.nextInt();
                        System.out.println("El equipo puede pasar a la habitacion: "+this.pasarAHabitacion(nameTeam, codigoA));break;
                        
                case 5: System.out.println("Ingrese el nombre de un equipo: ");
                        nameTeam= sc.nextLine();
                        System.out.println("El equipo puede salir de la casa: " + this.puedeSalir(nameTeam));
                        
                case 6: continuar= false;

                default: System.out.println("opcion no valida");          
            }
        }
    }
    
    /************************* METODOS UTILIZADOS PARA LA CARGA INICIAL DEL JUEGO ************************/
    
    private boolean insertarHabitacion(Habitacion n){               
        //METODO QUE PERMITE INSERTAR UNA HABITACION EN LA CASA A LA HORA DE HACER LA CARGA DEL ESTADO INICIAL DEL JUEGO
        boolean exito= false;
        if(n != null){
            //por eficiencia preguntamos primero en el diccionario
            //Tambien la insertamos en el diccionario.
            exito= habitaciones.insertar(n.getCodigo(), n);
            // insertamos la habitacion en un nodoVertice del grafo.
            if(exito){
                mapa.insertarVertice(n.getCodigo());
                escribirLog("Se inserto la habitacion: "+ n.getCodigo());      
            }
        }
        return exito;
    }
    
    private boolean insertarDesafio(Desafio d){
        boolean exito= false;
        if(d != null){
            //insertamos el desafio en el diccionario desafio
            exito= desafio.insertar(d.getPuntaje(), d);          
            if(exito){
                escribirLog("se inserto desafio: "+ d.getPuntaje());
            }
        }
        return exito;
    }
    
    private boolean insertarEquipo(Equipo e){
        boolean exito= false;
        if(e != null){
            exito= equipos.insertar(e.getNombre(), e);
            if(exito){
                escribirLog("se inserto el equipo: "+ e.getNombre());
            }
        }
        return exito;
    }
    
    private boolean insertarPuerta(int habA, int habB, int puntaje){
        /* METODO QUE  PERMITE INSERTAR UNA PUERTA(ARCO) ENTRE DOS HABITACIONES. UTILIZADO PARA LA CARGA INICIAL DEL JUEGO */
        boolean exito= mapa.insertarArco(habA ,habB , puntaje);
        if(exito){
            escribirLog("se inserto el una puerta entre la hab: "+ habA +" y la hab: "+ habB +" con un puntaje de " + puntaje);
        }
        return exito;
        
    }
    
    private boolean insertarDesafioAEquipo(String nomEquipo, int desafio){
        boolean exito= false;
        if(equipos.existeClave(nomEquipo) && this.desafio.existeClave(desafio)){
            exito= equipoDesafios.asociar(nomEquipo, desafio);
            if(exito){
                escribirLog("se inserto desafio: "+ desafio +" a equipo: "+ nomEquipo);
            }
        }
        return exito;
    }
    
    
    //************************ OPCIONES DEL MENU  ***************************
    //***********************************************************************
    
    /********* OPCIONES DE CARGA DESDE EL MENU **********/
    
    /*  METODOS PARA INSERTAR */
    private boolean insertarHabitacionMenu(){
        // METODO QUE PERMITE AL USUARIO INSERTAR UNA HABITACION AL MAPA DEL JUEGO DESDE EL MENU
        boolean exito= false;
        System.out.println("Ingrese un codigo de habitacion: ");
        int codigo= sc.nextInt();
        sc.nextLine();
        if(!habitaciones.existeClave(codigo)){
            System.out.println("Ingrese el nombre de la habitacion: ");
            String nombre= sc.nextLine();
            System.out.println("Ingrese la planta de la habitacion: ");
            int planta= sc.nextInt();
            System.out.println("Ingrese los metros cuadrados de la habitacion: ");
            double mtsCuadrados= sc.nextDouble();
            System.out.println("la habitaicon tiene salida al exterior? s/n ");
            System.out.println("1 - Si");
            System.out.println("2 - No");
            int opcion= sc.nextInt();
            boolean salida= false;
            if(opcion == 1){
                salida= true;
            }
            Habitacion h= new Habitacion(codigo, nombre, planta, mtsCuadrados, salida);
            exito= habitaciones.insertar(codigo, h);
            if(exito){
                mapa.insertarVertice(h);
                escribirLog("Se inserto hab: "+ codigo);
            }
        }
        
        return exito;
    }
    
    private boolean insertarDesafioMenu(){
        // METODO QUE PERMITE AL USUARIO INSERTAR UN DESAFIO DESDE EL MENU
        boolean exito= false;

        System.out.println("Ingrese el puntaje del desafio: ");
        int puntaje= sc.nextInt();
        sc.nextLine(); /// <<<------------
        if(!desafio.existeClave(puntaje)){
            System.out.println("Ingrese el nombre del desafio: ");
            String nombre= sc.nextLine();
            System.out.println("Ingrese el tipo del desafio: ");
            String tipo= sc.nextLine();
            
            Desafio h= new Desafio(puntaje, nombre, tipo);
            exito= desafio.insertar(puntaje, h);
            if(exito){
                escribirLog("Se inserto desafio: "+ puntaje);
            }
        }
        return exito;
    }
    
    private boolean insertarEquipoMenu(){
        // METODO QUE PERMITE AL USUARIO INSERTAR UN EQUIPO AL MAPA DEL JUEGO DESDE EL MENU    
        
        boolean exito= false;
        System.out.println("Ingrese el nombre del equipo: ");
        String nombre= sc.nextLine();
        
        if(!equipos.existeClave(nombre)){
            System.out.println("Ingrese el puntaje total exigido para poder salir de la casa: ");
            int puntajeExigido= sc.nextInt();
            System.out.println("Ingrese el codigo de habitacion en el que se encuentren inicialmente: ");
            int codigoHabitacion= sc.nextInt();
            if(habitaciones.existeClave(codigoHabitacion)){
                Equipo e= new Equipo(nombre, puntajeExigido, 0, codigoHabitacion, 0); // PREGUNTARRR!!!!!!!!!!!11
                exito= equipos.insertar(nombre, e);
                if(exito){
                    escribirLog("Se inserto equipo: "+ nombre);
                }
            }
        }
        return exito;
    }
    
    private boolean insertarPuertaMenu(){
        // ESTE METODO PERMITE INSERTAR UNA PUERTA DESDE UNA HABITACION 
        boolean exito= false;
        System.out.println("Ingrese el codigo de la habitacion A: ");
        int codigoA= sc.nextInt();
        System.out.println("Ingrese el codigo de la habitacion B: ");
        int codigoB= sc.nextInt();
        System.out.println("Ingrese el puntaje necesario para pasar de la habitaicon A  a la habitacion B: ");
        int puntaje= sc.nextInt();
        exito= mapa.insertarArco(codigoA, codigoB, puntaje);
        if(exito){
            escribirLog("Se inserto puerta entre hab: "+ codigoA+" y hab: "+ codigoB+ " con puntaje: "+ puntaje);
        }
        return exito;
    }
    
    /* METODOS PARA ELIMINAR */
    
    private boolean eliminarHabitacionMenu(){
        /*ESTE METODO PERMITE ELIMINAR, SI EXISTE, UNA HABITACION*/
        System.out.println("Ingrese un codigo de habitacion: ");
        int codigo= sc.nextInt();
        return habitaciones.eliminar(codigo);
    }
    
    private boolean eliminarDesafioMenu(){
        System.out.println("Ingrese el puntaje del desafio: ");
        int puntaje= sc.nextInt();
        
        return desafio.eliminar(puntaje);
    }
    
    private boolean eliminarEquipoMenu(){
    System.out.println("Ingrese el nombre del equipo: ");
        String nombre= sc.nextLine();
        boolean exito= equipos.eliminar(nombre); //eliminamos al equipo de la estructura 
        if(exito){
            equipoDesafios.desasociar(nombre); //eliminamos al equipo de la estructura 
        }
        return exito;}
    
    private boolean eliminarPuertaMenu(){
        /*e*/
        System.out.println("Ingrese un codigo de la habitacion A: ");
        int codigoA= sc.nextInt();
        System.out.println("Ingrese un codigo de la habitacion B: ");
        int codigoB= sc.nextInt();
        
        boolean exito= mapa.eliminarArco(codigoA, codigoB);

        return exito;}
    
    /********** METODOS PARA MODIFICAR ****************/
    private void modificarHabitacionMenu(){
        // METODO QUE PERMITE AL USUARIO MODIFICAR UNA HABITACION DEL JUEGO DESDE EL MENU

        System.out.println("Ingrese un codigo de habitacion: ");
        int codigo= sc.nextInt();
        if(!habitaciones.existeClave(codigo)){
            //código, nombre, planta, metros cuadrados, tiene salida al exterior
            Habitacion hab= (Habitacion)habitaciones.obtenerDato(codigo);
            boolean continuar= true;
            while(continuar){
                System.out.println("Opciones de Menu: ");
                System.out.println("1 - Nombre");
                System.out.println("2 - Planta");
                System.out.println("3 - Metros Cuadrados");
                System.out.println("4 - Salida al exterior");
                System.out.println("5 - Volver atras");
                System.out.println("Ingrese el numero de la opcion: ");
                int opcion= sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1: System.out.println("Ingrese el nombre de la habitacion: ");
                            String nombre= sc.nextLine(); 
                            hab.setNombre(nombre);break;
                    case 2: System.out.println("Ingrese la planta de la habitaicon: ");
                            int planta= sc.nextInt();
                            hab.setPlanta(planta);break;
                    case 3: System.out.println("Ingrese los metros cuadrados de la habitacion: ");
                            double mtsCuadrados= sc.nextDouble();
                            hab.setMtsCuadrados(mtsCuadrados);break;
                    case 4: System.out.println("la habitaicon tiene salida al exterior? s/n ");
                            System.out.println("1 - Si");
                            System.out.println("2 - No");
                            int opcionSalida= sc.nextInt();
                            boolean salida= false;
                            if(opcionSalida == 1){
                                salida= true;
                            }
                            hab.setSalida(salida);
                    case 5: continuar = false;break;

                    default: System.out.println("Error"); break;  
                }
            }        
        }
    }
    
    private void modificarDesafioMenu(){
        // METODO QUE PERMITE AL USUARIO MODIFICAR UNA DESAFIO DEL JUEGO DESDE EL MENU

        System.out.println("Ingrese el puntaje del desafio: ");
        int puntaje= sc.nextInt();
        sc.nextLine();
        if(!desafio.existeClave(puntaje)){
            Desafio des= (Desafio)desafio.obtenerDato(puntaje);
            boolean continuar= true;
            while(continuar){
                System.out.println("Opciones de Menu: ");
                System.out.println("1 - Nombre");
                System.out.println("2 - Tipo de desafio");
                System.out.println("3 - Volver atras");
                System.out.println("Ingrese el numero de la opcion: ");
                int opcion= sc.nextInt();
                switch(opcion){
                    case 1: System.out.println("Ingrese el nombre del desafio: ");
                            String nombre= sc.nextLine();
                            des.setNombre(nombre);break;
                    case 2: System.out.println("Ingrese el tipo del desafio: ");
                            String tipo= sc.nextLine();
                            des.setTipo(tipo);break;
                    case 3: continuar= false;break;
                    default: System.out.println("Error"); break;  
                }
            }
        }
    }
    
    private void modificarEquipoMenu(){
        // METODO QUE PERMITE AL USUARIO INSERTAR UNA EQUIPO AL MAPA DEL JUEGO DESDE EL MENU    
        

        System.out.println("Ingrese el nombre del equipo: ");
        String nombre= sc.nextLine();
        if(!equipos.existeClave(nombre)){
            Equipo eq= (Equipo)equipos.obtenerDato(nombre);
            boolean continuar= true;
            while(continuar){
                //String nombre, int puntajeSalida, int puntajeTotal, int habitacionActual, int puntajeActual
                System.out.println("Opciones de Menu: ");
                System.out.println("1 - Puntaje de salida");
                System.out.println("2 - Punatje total");
                System.out.println("3 - Habitacion actual");
                System.out.println("4 - Puntaje Actual");
                System.out.println("5 - Volver atras");
                System.out.println("Ingrese el numero de la opcion: ");
                int opcion= sc.nextInt();
                switch(opcion){
                    case 1: System.out.println("Ingrese el puntaje total exigido para poder salir de la casa: ");
                            int puntajeExigido= sc.nextInt();
                            eq.setPuntajeSalida(puntajeExigido);break;
                    case 2: System.out.println("Ingrese el puntaje total del equipo: ");
                            int puntajeTotal= sc.nextInt();
                            eq.setPuntajeTotal(puntajeTotal);break;
                    case 3: System.out.println("Ingrese el codigo de habitacion en el que se encuentren inicialmente: ");
                            int codigoHabitacion= sc.nextInt();
                            if(habitaciones.existeClave(codigoHabitacion)){
                                eq.setHabitacionActual(codigoHabitacion);
                            }else{
                                System.out.println("No existe la habitacion");
                            }break;
                            
                    case 4: System.out.println("Ingrese el puntaje actual del equipo: ");
                            int puntajeActual= sc.nextInt();
                            eq.setPuntajeSalida(puntajeActual);break;
                    case 5: continuar= false;break;
                    default: System.out.println("Error"); break;  
                }
            }            
        }
    }
    /***/
    private void modificarPuertaMenu(){
        // ESTE METODO PERMITE INSERTAR UNA PUERTA DESDE UNA HABITACION 

        System.out.println("Ingrese el codigo de la habitacion A: ");
        int codigoA= sc.nextInt();
        System.out.println("Ingrese el codigo de la habitacion B: ");
        int codigoB= sc.nextInt();
        System.out.println("Ingrese el puntaje necesario para pasar de la habitaicon A  a la habitacion B: ");
        int puntaje= sc.nextInt();
        if(mapa.modificarArco(codigoA, codigoB, puntaje)){
            System.out.println("Modificacion exitosa");
        }else{
            System.out.println("No existe puerta entre las habitaciones");
        }
    }
    
    
    
    
    /********** CONSULTA SOBRE HABITACIONES ********/
    
    public String mostrarHabitacion(int codigo){
        /*METODO QUE DADO UN CODIGO DE HABITACION BUSCA DENTRO DEL DICCIONARIO Y SI EXISTE DEVUELVE TODA LA INFORMACION SOBRE LA MISMA */   
        String habitacion= "";
        //hacer una sola consulta 
        Object h= habitaciones.obtenerDato(codigo);
        if(h!= null){
            habitacion= h.toString();
        }
        return habitacion;
    }
    
    public String habitacionesContiguas(int codigo){
        
        /*TESTEAR*/
        String s= "";
        if(mapa.existeVertice(codigo)){
            Lista habContiguas= mapa.listarNodosVerticeAdyacentes(codigo); //Listamos el codigo de las habitaciones contiguas
            Lista EtiquetaHab= mapa.listarEtiquetaNodosVertAdy(codigo); //listamos los puntajes necesarios que haya entre las habitaciones contiguas
            int i=1;
            while(i <= habContiguas.longitud()){             
                s+= "habitacion: " +habContiguas.recuperar(i) + " Puntaje necesario para pasar a la habitacion: "+ EtiquetaHab.recuperar(i)+"\n"; 
                i++;
            }
        }
        return s;
    } 
    
    public boolean esPosibleLlegar(int codigoA, int codigoB, int puntos){
    /*Dados los códigos de hab1 y hab2, y un valor k, muestra si es o no posible llegar de hab1 a hab2, acumulando k puntos*/

    /*RECORRER LOS CAMINOS BUSCANDO EL CAMINO CON EL PESO MAS LIVIANO, ESTE ESTE CASO PUNTAJE, PESO MAS LIVIANO, PESOACTUAL, EN LA LLAMDA RECURSIVA PESO ACTUAL + ETIQUETA*/
    /*SI LLEGA AL DESTINO, EL PUNTAJE DEBE SUPERAR A K, SINO NO LO TOMA */
        return mapa.esPosibleLlegar(codigoA, codigoB, puntos);
    }
    
    private int obtenerPuntajeNecesario(Lista camino){
        // DADO UN CAMINO ENTRE HABITACIONES DEVUELVE EL PUNTAJE TOTAL NECESARIO PARA REALIZAR DICHO CAAMINO
        int puntos= 0;
        for(int i=1; i <= camino.longitud(); i++){
            Habitacion auxA= (Habitacion)habitaciones.obtenerDato((Comparable)camino.recuperar(i-1));
            Habitacion auxB= (Habitacion)habitaciones.obtenerDato((Comparable)camino.recuperar(i));
            if(auxA != null){
                    //obtenemos el puntaje necesario para pasar entre las habitaciones y lo vamos sumando a una variable acumuladora
                    puntos += (int) mapa.getEtiquetaArco(auxA.getCodigo(), auxB.getCodigo());
            }
        }
        return puntos;
    }
    
    private String punteajeNecesarioCamino(Lista camino){
        // DADO UN CAMINO ENTRE HABITACIONES DEVUELVE EL PUNTAJE TOTAL NECESARIO PARA REALIZAR DICHO CAAMINO Y EL NOMBRE DE LAS HABITACIONES POR 
        // DONDE PASA
        String s="camino: ";
        int puntos= 0;
        for(int i=1; i <= camino.longitud(); i++){
            Habitacion auxA= (Habitacion)habitaciones.obtenerDato((Comparable)camino.recuperar(i-1));
            Habitacion auxB= (Habitacion)habitaciones.obtenerDato((Comparable)camino.recuperar(i));
            if(auxA != null){
                    //obtenemos el puntaje necesario para pasar entre las habitaciones y lo vamos sumando a una variable acumuladora
                    puntos += (int) mapa.getEtiquetaArco(auxA.getCodigo(), auxB.getCodigo());
                    s += auxB.getNombre()+" ";
            }
            
        }
        s+= "puntaje necesario: "+ puntos;
        return s;   
    }
    
    public String minimoPuntaje(int codigoA, int codigoB){
    /* Dados dos códigos de habitación, mostrar el mínimo puntaje que debería acumular para ir de hab1 a hab2 y cuál es el camino que deben hacer */    
        /*BUSCAR EL CAMINO CON MENOR PUNTAJE*/
        /*CASTEAR LA ETIQUETA A INT O CAMBIAR NODOADYINT*/
        String s="";
        Lista camino= mapa.caminoMasCorto(codigoA, codigoB);
        if(!camino.esVacia()){
            s = this.punteajeNecesarioCamino(camino);
            
        }
        return s;
    }
    
    public String sinPasarPor(int codigoA, int codigoB, int codigoC, int cotaSuperior){
        /*Dados tres códigos de habitación y un valor numérico P, mostrar todas las formas de llegar desde hab1 a hab2 
        sin pasar por la tercera habitación (hab3) que no requieran ganar más de P puntos.*/
        String s= "";
        Lista caminos= mapa.listarCaminoSinPasarPor(codigoA, codigoB, codigoC, cotaSuperior);
        if(!caminos.esVacia()){
            for(int i=1; i <= caminos.longitud(); i++){
                s+= caminos.recuperar(i).toString()+" \n"; // vamos listando en un string todos los caminos dentro de la lista
            }
            
        }   
        return s;
    }
    
    
    /**************** CONSULTA SOBRE DESAFIOS *********************/
    
    public String mostrarDesafio(int puntaje){
        /*METODO QUE DADO UN PUNTAJE DE DESAFIO BUSCA DENTRO DEL DICCIONARIO, Y SI EXISTE, DEVUELVE TODA LA INFORMACION SOBRE LA MISMA */   
        String desafio= "";
        //hacer una sola consulta 
        Object d= this.desafio.obtenerDato(puntaje);
        if(d!= null){
            desafio= d.toString();
        }
        return desafio;
    }
    
    public String mostrarDesafioResuelto(String nombEquipo){
    //Dado un equipo eq, mostrar todos los desafíos que ya resolvieron
        Lista listaDesafios= equipoDesafios.obtenerValor(nombEquipo);
        for(int i=0; i<= listaDesafios.longitud(); i++){
            if(!desafio.existeClave((Comparable)listaDesafios.recuperar(i))){
                listaDesafios.eliminar(i);
                listaDesafios.insertar("desafio eliminado", i);
            
            }
        }
        return listaDesafios.toString();
    }
    
    public boolean verificarDesafioResuelto(String equipo, String nomDesafio){
        //Dado un equipo y un nombre de desafío, indicar si el equipo ya lo resolvió
        boolean exito= false;
        Desafio desafioAux;
        Lista listaDesafios= equipoDesafios.obtenerValor(equipo); //lista de desafios realizados por el equipo
        
        if(!listaDesafios.esVacia()){
            int i=1;
            while(!exito && i <= listaDesafios.longitud()){
                desafioAux= (Desafio)desafio.obtenerDato((int)listaDesafios.recuperar(i)); //obtenemos el desafio de cada posicion
                exito= desafioAux.getNombre().equals(nomDesafio); //comparamos los nombres de los desafios
            }
        }
        return exito; 
    }
    
    public Lista mostrarDesafiosTipo(int puntajeA, int puntajeB, String tipoDesafio){
        /*Dados dos puntajes a y b y un tipo X, mostrar todos los desafíos de tipo X con puntaje en el rango [a, b] 
        (por ejemplo, listar todos los desafíos de tipo lógico con puntaje entre 30 y 55) */
        Lista listaDesafiosFiltrada= new Lista();
        Lista listaDesafiosAux = desafio.listarDatosRango(puntajeA, puntajeB); // OBTENEMOS LA LISTA DE DESAFIOS DONDE CON EL RANGO DE PUNTAJE DESEADO
        
        for(int i=1 ; i <= listaDesafiosAux.longitud(); i++){ // RECORREMOS TODOS LOS DESAFIOS
            Desafio d= (Desafio)listaDesafiosAux.recuperar(i); 
            if(d.getTipo().equals(tipoDesafio)){ // PREGUNTAMOS SI EL DESAFIO ES IGUAL AL DESEADO
                listaDesafiosFiltrada.insertar(d.toString() , listaDesafiosFiltrada.longitud()+1 ); //LO INSERTAMOS EN LA LISTA DEFINITIVA
            }
        }
        return listaDesafiosFiltrada;
    }
    
    /**************** CONSULTA SOBRE EQUIPOS *********************/
    
    public String mostrarInfoEquipo(String nombre){
        /*METODO QUE DADO UN NOMBRE DE EQUIPO BUSCA DENTRO DEL DICCIONARIO, Y SI EXISTE, DEVUELVE TODA LA INFORMACION SOBRE LA MISMA */   
        String equipo= "";
        //hacer una sola consulta 
        Object e= this.equipos.obtenerDato(nombre);
        if(e!= null){
            Equipo eq= (Equipo)e;
            if(habitaciones.existeClave(eq.getHabitacionActual())){
                equipo= e.toString();
           }else{
                equipo= e.toString()+" (hab actual fue eliminada.)";
            }
            
        }
        return equipo;
    }   
    
    public boolean jugarDesafio(String nombreEquipo, int puntajeDesafio){
        // ESTE METODO PERMITE MARCAR QUE UN EQUIPO HA RESUELTO UN DESAFIO Y ACTUALIZA LOS DATOS DEL EQUIPO 
        
        boolean exito= false;
        Object e= equipos.obtenerDato(nombreEquipo);
        Object d= desafio.obtenerDato(puntajeDesafio);
        if(e != null && d != null){
            
            Equipo equipo= (Equipo) e;
            Desafio desafio= (Desafio) d;
            exito= equipoDesafios.asociar(nombreEquipo, puntajeDesafio);
            if(exito){
                equipo.sumarPuntos(puntajeDesafio);
                escribirLog("El equipo: "+ nombreEquipo+ " jugo el desafio: "+ puntajeDesafio);
            }
            
        }
        
        return exito;
    }
    
    public String posiblesDesafios(String e, int h){
    /*Dado un equipo y una habitación hab, en caso en que hab sea adyacente al lugar donde esté ubicado el equipo, 
    mostrar todos los desafíos que podría resolver el equipo para pasar a hab resolviendo un solo desafío. 
    En caso en que hab no sea adyacente, mostrar un mensaje aclaratorio*/
    //encontrar al equipo
    // encontrar a la habitacion
    // preguntar si la habitacion es adyacente a la habitacion donde se encuentra el equipo
        String s="";
        Object b= equipos.obtenerDato(e); // creo una variable b para poder despues castearla si el resultado de la operacion no es null
        if(habitaciones.existeClave(h) && b != null){
            Equipo equipo= (Equipo) b;
            Object p= mapa.getEtiquetaArco(equipo.getHabitacionActual(), h);
            if(p != null){
                int puntos= (int) p;
                Lista desafiosFiltrados= desafio.listarMayoresQue(puntos); // LISTA CON LOS DESAFIOS QUE TENGAN UN PUNTAJE MAYOR O IGUAL AL REQUERIDO PARA PARA ENTRE LAS HABITACIONES
                for(int i=1; i <= desafiosFiltrados.longitud(); i++ ){
                    Object d= desafiosFiltrados.recuperar(i);
                    if(equipoDesafios.obtenerValor(e).localizar(d) < 0){
                        s+= "desafio: "+ d.toString()+ "\n";
                    }
                }
            }else{
                s="la habitacion del equipo no es adyacente a la ingresada por parametro";
            }


        }
        return s;
    }
    
    public boolean pasarAHabitacion(String e, int h ){
        /*Dado un equipo eq y una habitación hab, verificar si es posible que el equipo eq pase a la habitación hab 
        (considerando si es contigua a la actual y el puntaje acumulado es suficiente) y en caso afirmativo actualizar 
        los datos del equipo apropiadamente.*/
        //  verificar si la hab y el equipo existen
        //  verificar q la habitacion es adyacente a la habitacion del equipo
        //obtener el puntaje necesario para pasar a la habitacion
        //verificar si el puntaje actual del equipo es suficiente para pasar a la habitacion
        //actualizar la habitacion donde se encuentra el equipo, restar los puntos actuales ....
        
        boolean exito=false;
        Object b= equipos.obtenerDato(e); // creo una variable b para poder despues castearla si el resultado de la operacion no es null
        if(habitaciones.existeClave(h) && b != null){ //verificamos que la habitacion exista
            Equipo equipo= (Equipo) b;
            Object p= mapa.getEtiquetaArco(equipo.getHabitacionActual(), h); //obtenemos la etiqueta del arco que une a la habitacion del equipo con la pasada por parametro, si es que existe.
            String s="";
            if(p != null){
                int puntos= (int) p;
                if(equipo.getPuntajeActual() >= puntos){
                    exito= true;
                    /*actualizamos los atributos de equipo*/    
                    equipo.setHabitacionActual(h);
                    equipo.restarPuntos(puntos);
                    
                    escribirLog("El equipo: "+ e + " paso a la hab: "+ h);
                }           
            }else{
                s="la habitacion del equipo no es adyacente a la ingresada por parametro";
            }       
        }
       return exito;   
    }
    
    public String puedeSalir(String nomEquipo){
        //
        String s="";
        Object e= this.equipos.obtenerDato(nomEquipo);
        if(e!= null){
            Equipo equipo= (Equipo)e;
            //primero verificamos el puntaje
            int puntajeTotal= equipo.getPuntajeTotal();
            int puntajeParaSalir= equipo.getPuntajeSalida();
            Habitacion hab= (Habitacion)habitaciones.obtenerDato(equipo.getHabitacionActual());
            boolean tieneSalida= hab.getSalida();
            if( puntajeTotal >=  puntajeParaSalir && tieneSalida ){
                s= "El equipo puede salir, tiene "+puntajeTotal+" puntos y necesita "+puntajeParaSalir+" puntos para salir y su habitacion tiene salida al exterior: "+ tieneSalida; 
            }else{
                s= "El equipo no puede salir, tiene "+puntajeTotal+" puntos y necesita "+puntajeParaSalir+" puntos para salir y su habitacion tiene salida al exterior: "+ tieneSalida;
            }
        }
        return s;
    }
    
    /******************CONSULTA GENERAL***************************/
    
    public String mostrarSistema(){
        String s="";
        if(!mapa.esVacio()){
            s+= "MAPA DEL JUEGO \n " + mapa.toString() +" \n Habitaciones del juego : "+ habitaciones.toString()+ "\n Desafios del juego: "+ desafio.toString() + "\n Equipos del juego: " + equipos.toString()+"\n desafios resueltos por equipo: "+ equipoDesafios.toString();
        }
        return s;
    }

}
