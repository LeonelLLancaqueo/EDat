/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaPersonal;

import Utiles.TecladoIn;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int opcion, cantMaterias, numeroObjeto, opcionMateria, opcionNota ;
        char objeto;
        boolean continuar;
        String materia, profesor, dia;
        ArrayList <PrimerObjeto> listaMaterias = new ArrayList();
        continuar= true;
        do{
            System.out.println("********* Programa Materias *****************");
            System.out.println("");
            System.out.println("Opciones: ");
            System.out.println("1- Agregar materia");
            System.out.println("2- Agregar nota a una materia");
            System.out.println("3- Ver notas de las materias");
            System.out.println("4- Eliminiar Materia");    
            System.out.println("5- Eliminar Nota");    
            System.out.println("6- cerrar programa");
            System.out.println("Ingrese una opcion: ");
            opcion= TecladoIn.readInt();
            if(opcion == 1){
                String nombreMateria, nombreProfesor, nombreDia;
                System.out.println("Ingrese el nombre de la materia: ");
                nombreMateria= TecladoIn.readLine();
                System.out.println("Ingrese el nombre del profesor de la materia: ");
                nombreProfesor= TecladoIn.readLine();
                System.out.println("Ingrese el dia que se cursa la materia: ");
                nombreDia= TecladoIn.readLine();
                listaMaterias.add(new PrimerObjeto(nombreMateria, nombreProfesor, nombreDia));
                System.out.println("Materia regristrada");
            }else{
                if(opcion == 2){
                    System.out.println("Listado de Materias: ");
                    int contadorMateria= 0;
                    for(PrimerObjeto e: listaMaterias ){
                        System.out.println(contadorMateria+"- "+e.getMateria());
                        contadorMateria++;
                    }
                    System.out.println("Elija una materia: ");
                    opcionMateria= TecladoIn.readInt();
                    System.out.println("Ingrese nombre del trabajo: ");
                    String nombreTrabajo= TecladoIn.readLine();
                    System.out.println("Ingrese nombre del tema del trabajo: ");
                    String nombreTema= TecladoIn.readLine();
                    System.out.println("Ingrese la calificaion obtenida: ");
                    int notaTrabajo= TecladoIn.readInt();
                    listaMaterias.get(opcionMateria).setNota(nombreTrabajo, nombreTema, notaTrabajo);
                    System.out.println("Nota registrada");
                
                }else{
                    if(opcion == 3){
                        for(PrimerObjeto e: listaMaterias){
                            System.out.println(e.getNotas());
                        }
                    }else{
                        if(opcion == 4){
                            int contadorMateria= 0;
                            for(PrimerObjeto e: listaMaterias ){                               
                                System.out.println(contadorMateria+"- "+e.getMateria());
                                contadorMateria++;
                            }
                            System.out.println("Ingrese la posicion de la materia a eliminar: ");
                            opcionMateria= TecladoIn.readInt();
                            listaMaterias.remove(opcionMateria);
                            System.out.println("Materia eliminada");
                            
                        }else{
                            if(opcion == 5){
                                int contadorNota= 0;
                                for(PrimerObjeto e: listaMaterias ){                                    
                                    System.out.println(contadorNota+"- "+e.getMateria());
                                    contadorNota++;
                                }
                                System.out.println("Elija una materia: ");
                                opcionMateria= TecladoIn.readInt();
                                System.out.println(listaMaterias.get(opcionMateria).getNotas());
                                System.out.println("Ingrese la posicion de la nota a eliminar: ");
                                opcionNota= TecladoIn.readLineInt();
                                listaMaterias.get(opcionMateria).listaNotas.remove(opcionNota);
                                System.out.println("Nota eliminada");
                            }else{
                                if(opcion == 6){
                                    System.exit(0);
                                }else{
                                    System.out.println("Error");
                                }
                            }
                        }
                    }
                }
            }                       
        }while(continuar == true);
        
    }
}
