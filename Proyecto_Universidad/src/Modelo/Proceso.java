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
        
        String nombre = inOut.solicitarNombre("\nDigite su nombre");
        int cedula = inOut.solicitarEntero("\nDigite la cédula");
         
     
         String mensaje = "¿Qué tipo de persona desea agregar? \n"
                         +"1. Estudiante \n"
                         +"2. Decanos \n"+
                         "3. Profesor \n"+
                         "4. Personal de seguridad \n"+
                         "5. Salir\n\n"+"Digite una opción"
                 ;
 
       
            int opcion = inOut.solicitarEntero(mensaje);
            switch (opcion) {
                case 1:
                {
                    
                    
                     break;   
                }
   
                case 2:
                {
                  break;   
                }
                            
                case 3:{
                     System.exit(0);
                    break;
                }
                default:{
                   
                }    
     }
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
