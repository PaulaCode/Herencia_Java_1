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
        ArrayList <Estudiantes> lista_estudiantes = new ArrayList(); 
        ArrayList <Profesores> profesores = new ArrayList();
    
       InOut inOut = new InOut();


       
    public void agregarPersona(){
        
        boolean verificar;
        int cedula;
        String nombre;
        do{
         nombre = inOut.solicitarNombre("\nDigite su nombre");
         cedula = inOut.solicitarEntero("\nDigite la cédula");
        
        verificar = Verificarcc(cedula);
        
        if(verificar == false);
            inOut.mostrarResultado("\nLa cédula está repetida ");
        
        } while(verificar == false);

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
                    int codigo_estudiante = inOut.solicitarEntero("Digite el código del estudiante");
                    while (verificarCarnet(codigo_estudiante))
                   {
                      codigo_estudiante = inOut.solicitarEntero("Digite el código del estudiante \n Ese código ya existe ");  
                   }
                    Estudiantes obj_estudiante = new Estudiantes(cedula,nombre,codigo_estudiante);
                    lista_estudiantes.add(obj_estudiante);
                    personas.add(obj_estudiante);
                    break;   
                }
   
                case 2:
                {
                  break;   
                }
                            

                case 3:{
                    
                    int tarjeta=inOut.solicitarEntero("Ingrese su Numero de Tarjeta profesional");
                    while(VerificarTarjetadeProfesor(tarjeta) == true ){
                      tarjeta=inOut.solicitarEntero("Ingrese su Numero de Tarjeta profesional");
                    }
                    Profesores profes = new Profesores(cedula,nombre,tarjeta);
                    profesores.add(profes);
                    personas.add(profes);

                    }
                     

 
                     

                case 5:{
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
    public boolean Verificarcc(int c){
          boolean flag=false;
          for(int i =0;i<personas.size();i++){
              if(personas.get(i).getIdentificacion_persona()==c){
                  flag=true;
              }
          }
          return flag;
      }

    public boolean verificarCarnet(int codigo_estudiantil)
    {
         for(int i =0;i<lista_estudiantes.size();i++){
              if(lista_estudiantes.get(i).getCodigoEstudiantil()==codigo_estudiantil){
                 return true;
              }
          }
          return false;
    }

      public boolean VerificarTarjetadeProfesor(int c){
          boolean flag=false;
          for(int i =0;i<personas.size();i++){
              if(profesores.get(i).getIdentificacion_persona()==c){
                  flag=true;
              }
          }
          return flag;
      }

}
