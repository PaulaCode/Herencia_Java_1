/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.InOut;


public class Decanos extends Profesores{
    private String UniversidadRepresentando;

     private InOut ioData = new InOut();
    public Decanos(int id,String nombre,int NumerodeTarjeta,String NombreFacultad){
        super(id,nombre,NumerodeTarjeta);
        UniversidadRepresentando=NombreFacultad;
    }
    public void Reportes(){
       
        ioData.mostrarResultado("El Decano:"+super.getNombre_persona()+"esta generando reportes");
    }
   
  
    @Override
    public String dictarClase()
    {
        return (" dicta clase");
    }
    @Override
        public String digitarNotas()
    {
        return (" digita notas");
    } 

    public String getUniversidadRepresentando() {
        return UniversidadRepresentando;
    }
    
     public String getNombre(){
         
         return super.getNombre_persona();
     }
     
     public int getCedula(){
         
         return super.getIdentificacion_persona();
     }
     
     public int getNumTarjeta(){
         
         return super.numero_tarjeta;
     }
    
    @Override
    public String toString() {
        return "La persona con cédula: "+super.getIdentificacion_persona()+" es un decano con \nNúmero de tarjeta: "+super.numero_tarjeta+" y su nombre es "+super.getNombre_persona();
    }
    
   
}
