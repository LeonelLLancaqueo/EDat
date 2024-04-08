/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaPersonal;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Notas {
    String nombreTrabajo, tema;
    int nota;
    public Notas(String trabajo, String tema, int nota ){
        this.nombreTrabajo= trabajo;
        this.tema= tema;
        this.nota= nota;
    }
    public String descripcion(){
        return "Trabajo: "+ nombreTrabajo+ "\n tema: "+ tema+ "\n nota: "+ nota;
    }
}
