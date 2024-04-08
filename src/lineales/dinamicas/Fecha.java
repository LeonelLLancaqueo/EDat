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
public class Fecha {
    private int dia, mes, anio;
    /*METODO CONSTRUCTOR*/
    public Fecha(){
        dia=0;
        mes=0;
        anio=0;
    }
    public Fecha(int d, int m, int a){
         dia= d;
         mes= m;
         anio= a;
    }
    /*METODOS MODIFICADORES*/
    public void setDia(int newDia){
        if(newDia >0 && newDia <31){
            dia= newDia;
        }       
    }
    public void setMes(int newMes){
        if(newMes > 0 && newMes <=12){
            mes= newMes;
        }     
    }
    public void setAño(int newAnio){
        anio= newAnio;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAnio(){
        return anio;
    }
    public String toString(){
        return dia+"/"+mes+"/"+anio;
    }
    public boolean equals(Fecha otraFecha){
        return dia == otraFecha.getDia() && mes == otraFecha.getMes() && anio == otraFecha.getAnio();
    }
    /*METODOS PROPIOS*/
    public int DiasTransucrridos(){
        return  dia + (mes-1)*31;
    }
    public boolean esFechaAnterior(Fecha otraFecha){
        return mes== otraFecha.getMes() && anio == otraFecha.getAnio() && dia+1==otraFecha.getDia();
    }
    public String calculaFecha(int dias){
            
        diasToFecha(fechaToDias(dias));
        
        return dia +"/"+mes+"/"+anio;
    }
    public boolean esBisiesto(){
        boolean esBisiesto = false;
        if(anio % 4 == 0 && anio % 100 != 0 || anio % 100 == 0){
            esBisiesto = false;
        }
        return esBisiesto;
    }
    private int fechaToDias(int dias){
        int totalDias= anio*360 + mes*31+ dia + dias;
        return totalDias;
    }
    private void diasToFecha(int dias){
        anio= dias/360;
        int resto= dias%360;
        mes= resto/31;
        dia= resto%31;
        if(mes==0){
            mes=12;
            anio--;
        }
        if(dias==0){
            dia=31;
            mes--;
        }
    }
}
