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
public class Terreno {
    private int codigo, manzana;
    private double altura, base;
    public Terreno(int cod){
        codigo= cod;
    }
    public Terreno(int cod, double alt, double bas, int manz){
        base= bas;
        altura= alt;
        codigo= cod;
        manzana= manz;
    }
    /*METODOS DE ACCESO*/
    public int getCodigo(){
        return codigo;
    }
    public int getManzana(){
        return manzana;
    }
    public double getBase(){
        return base;
    }
    public double getAltura(){
        return altura;
    }
    public String toString(){
        return "Codigo: "+codigo +"\n Manzana: "+manzana+ "\n Altura: "+ altura+ "\n Base: "+base;
    }
    public boolean equals(Terreno otroTerreno){
        return codigo==otroTerreno.getCodigo() && manzana==otroTerreno.getManzana() &&base== otroTerreno.getBase()&& altura==otroTerreno.getAltura();
    }
    /*METODOS MODIFICADORES*/
    public void setManzana(int nuevaManzana){
        manzana= nuevaManzana;
    }
    public void setArea(double nuevaArea){
        altura= nuevaArea;
    }
    public void setBase(double nuevaBase){
        base= nuevaBase;
    }
    /*METODOS PROPIOS DEL OBJETO*/
    public double Perminetro(){
        return base*2+altura*2;
    }
    public double Superficie(){
        return base*altura;
    }
    public double Precio(double precioMetroCuadrado){
        return precioMetroCuadrado * Superficie();
    }
    
}
