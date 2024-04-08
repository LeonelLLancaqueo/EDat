/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Paciente {
    private int dni, añosAtendiendose;
    private String obraSocial;
    private boolean esMayorEdad;
    private char tipoAtencion;
    
    /******METODOS CONTRUCTORES*******/
    public Paciente(int dni){
        this.dni= dni;
        obraSocial="";
        añosAtendiendose=0;
        esMayorEdad= false;
        tipoAtencion=' ';
    }
    public Paciente(int dni, String obraSocial, int añosAtendiendose, boolean esMayorEdad, char tipoAtencion){
        this.dni= dni;
        this.obraSocial= obraSocial;
        this.añosAtendiendose= añosAtendiendose;
        this.esMayorEdad= esMayorEdad;
        this.tipoAtencion= tipoAtencion;
    }
    /*******METODOS OBSERVADORES*******/
    public int getDni(){
        return dni;
    }
    public int getAñosAtendiendose(){
        return añosAtendiendose;
    }
    public String getObraSocial(){
        return obraSocial;
    }
    public char getTipoAtencion(){
        return tipoAtencion;
    }
    public boolean getEsMayorEdad(){
        return esMayorEdad;
    }
    public boolean equals(Paciente otroPaciente){
        return this.dni== otroPaciente.getDni();
    }
    public String toString(){
        return "Dni: "+ dni+ "- Obra Social: "+ obraSocial+ "- Años atendiendose: "+ añosAtendiendose+ "- Tipo de atencion: "+ tipoAtencion+ "- Es mayor de edad: "+ esMayorEdad;
    }
    
    /*******METODOS MODIFICADORES****/
    public void setObraSocial(String obraSocial){
        this.obraSocial= obraSocial;
    }
    public void setAñosAtendiendose(int añosAtendiendose){
        this.añosAtendiendose= añosAtendiendose;
    }
    public void setTipoAtencion(char tipoAtencion){
        this.tipoAtencion= tipoAtencion;
    }
    public void setEsMayorEdad(boolean esMayorEdad){
        this.esMayorEdad= esMayorEdad;
    }
    
    
    
}
