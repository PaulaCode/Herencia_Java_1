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
    public Decanos(int id,String nombre,int NumerodeTarjeta,String NombreU){
        super(id,nombre,NumerodeTarjeta);
        UniversidadRepresentando=NombreU;
    }
    public void Reportes(){
       
        ioData.mostrarResultado("El Decano:"+super.getNombre_persona()+"esta generando reportes");
    }
    public void dictarClase()
    {
        ioData.mostrarResultado(super.getNombre_persona()+" dicta clase");
    }
        public void digitarNotas()
    {
        ioData.mostrarResultado(super.getNombre_persona()+" digita notas");
    } 
   
}
