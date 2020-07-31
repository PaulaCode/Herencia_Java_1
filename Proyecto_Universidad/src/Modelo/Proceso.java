/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.InOut;
import java.util.ArrayList;

public class Proceso {
    
    ArrayList <Personas> personas = new ArrayList();
    
       InOut inOut = new InOut();

       
    public void agregarPersona(){
        
        
        inOut.mostrarResultado("\nQué persona desea agregar?");
        
        
    }
      
    public void buscarPersona(){
        
        int cedula = inOut.solicitarEntero("\nDigite el número de cédula de la persona que desee buscar: ");
        
        for(int i=0 ; i<personas.size(); i++){
            
            if(personas.get(i).getIdentificacion_persona() == cedula){
      
                inOut.mostrarResultado("\nLa persona es");
                
            }
                
        }
        
        
    }
}
