/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Proyecto_Universidad;
import Vista.InOut;
import java.util.ArrayList;

public class Proceso {
        ArrayList <Personas> personas = new ArrayList();
        ArrayList <Personas> Adentro = new ArrayList();
        ArrayList <Estudiantes> lista_estudiantes = new ArrayList(); 
        ArrayList <Profesores> profesores = new ArrayList();
        ArrayList <Personal_Seguridad> lista_seguridad = new ArrayList();
        ArrayList <Decanos> decanos = new ArrayList();
    
       InOut inOut = new InOut();

        

    public void agregarPersona(int numFacult){
        

        boolean verificar;
        int cedula,decanosCuenta=0;


        String nombre;
   
         cedula = inOut.solicitarEntero("\nDigite la cédula");
         while(Verificarcc(cedula))
         {
           cedula = inOut.solicitarEntero("\nDigite la cédula");   
         }
         nombre = inOut.solicitarNombre("\nDigite su nombre");
 
       
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
                    Proyecto_Universidad.menu();
                    break;   
                }
   
                case 2:
                {
                    if(decanosCuenta<numFacult){
                    int tarjeta=inOut.solicitarEntero("Ingrese su Numero de Tarjeta profesional");
                    String nombreFacultad = inOut.solicitarNombre("\nDigite el nombre de la facultad que representa");
                    while(VerificarTarjetadeProfesor(tarjeta) == true && verificarFacultad(nombreFacultad) == true ){
                      tarjeta=inOut.solicitarEntero("\nEl número de tarjeta o el nombre de la facultad ya existen \nIngrese su Numero de Tarjeta profesional");
                      nombreFacultad = inOut.solicitarNombre("\nDigite el nombre de la facultad que representa");
                    }
                    Decanos decano = new Decanos(cedula,nombre,tarjeta,nombreFacultad);
                    personas.add(decano);
                    decanos.add(decano);

                     Proyecto_Universidad.menu();
                     decanosCuenta++;
                    }else{
                        
                        inOut.mostrarResultado("\nNo pueden registrarse más decanos.");
                    }
                    break;
                    

                }
                            
                case 3:{
                    
                    int tarjeta=inOut.solicitarEntero("Ingrese su Numero de Tarjeta profesional");
                    while(VerificarTarjetadeProfesor(tarjeta) == true ){
                      tarjeta=inOut.solicitarEntero("\nEse número de tarjeta ya existe \nIngrese su Numero de Tarjeta profesional");
                    }
                    Profesores profes = new Profesores(cedula,nombre,tarjeta);
                    profesores.add(profes);
                    personas.add(profes);

                     Proyecto_Universidad.menu();
                    break;
                }
                case 4:{
                    int numero_certificacion= inOut.solicitarEntero("Ingrese el número de matrícula de vigilante");
                    while(validarMatriculaVigilante(numero_certificacion))
                    {
                        numero_certificacion= inOut.solicitarEntero("Ingrese el número de matrícula de vigilante  \n Esa matrícula ya se encuentra registrada");
                    }

                    String arma = inOut.solicitarNombre("Digite el modelo de la arma");
                    int numero_balas = inOut.solicitarEntero("Digite el número de balas");
                    Personal_Seguridad obj_seguridad = new Personal_Seguridad(numero_certificacion,arma,numero_balas,cedula,nombre);
                    lista_seguridad.add(obj_seguridad);
                    personas.add(obj_seguridad);
                    Proyecto_Universidad.menu();
                }
       case 5:{
                           System.exit(0);

                    break;
                }
                default:{
                   inOut.mostrarResultado("\nNinguna opción válida fue elegida.");
                }    
     
            }
    }
    
 
    public void buscarPersona(){
        
        int cedula = inOut.solicitarEntero("\nDigite el número de cédula de la persona que desee buscar: ");
        boolean estado=false;
        for(int i=0 ; i<personas.size(); i++){
            
            if(personas.get(i).getIdentificacion_persona() == cedula){
      
                inOut.mostrarResultado("\nLa persona es: ");
                estado=true;
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
          for(int i =0;i<profesores.size();i++){
              if(profesores.get(i).getIdentificacion_persona()==c){
                  flag=true;
              }
          }
          return flag;
      }

      public void EntrarenlaU(){
          
        int cel = inOut.solicitarEntero("Ingrese la cedula para entrar en la universidad");
        if(Verificarcc(cel)==true){
            inOut.mostrarResultado("La persona"+VerificarEntrada(cel).getNombre_persona()+"Esta dentro de la universidad");
            Adentro.add(VerificarEntrada(cel));
            
        }
      }
      
 public Personas VerificarEntrada(int c){
          boolean flag=false;
          for(int i =0;i<personas.size();i++){
              if(personas.get(i).getIdentificacion_persona()==c){
                  return personas.get(i);
              }
            
          }
          return null;
 }
 
      public boolean validarMatriculaVigilante(int matricula_vigilante)
      {
          for(int i=0;i<lista_seguridad.size();i++)
          {
              if(lista_seguridad.get(i).getnumCertificacion()==matricula_vigilante)
              {
                  return true;
              }
          }
          return false;

      }
      
      public boolean verificarFacultad(String facultad){
          
          for(int i=0 ; i<decanos.size(); i++){
              
              if(facultad.equalsIgnoreCase(decanos.get(i).getUniversidadRepresentando()))
                  return true;
          }
          
          return false;
      }
   
      
}
