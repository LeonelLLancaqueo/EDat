/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaPersonal;

import Utiles.TecladoIn;
import java.util.*;

/**
 *
 * @author Leonel LLancaqueo
 */
public class PrimerObjeto {
    String materia, profesor, dia, nota;
    ArrayList <Notas> listaNotas= new ArrayList();
    public PrimerObjeto(String nombreMateria, String nombreProfesor, String nombreDia){
        this.materia= nombreMateria;
        this.profesor= nombreProfesor;
        this.dia= nombreDia;   
    }
    public String getMateria(){
        return this.materia;
    }
    public void setNota(String trabajo, String tema, int nota ){  
        String nombreTrabajo= trabajo;
        String nombreTema= tema;
        int calificacion= nota;        
        listaNotas.add(new Notas(nombreTrabajo, nombreTema, calificacion));
    }
    public String getNotas(){
        String descripcionNotas;
        descripcionNotas= "";
        int contador= 0;
        for(Notas e: listaNotas){    
            descripcionNotas = descripcionNotas +"\n"+contador+"- "+ e.descripcion();
            contador++;
        }
        return descripcionNotas; 
    }
    public String description(){
        return "Materia: "+ this.materia+" profesor: "+ this.profesor+" Dia de cursado: "+ this.dia;
    }
}
