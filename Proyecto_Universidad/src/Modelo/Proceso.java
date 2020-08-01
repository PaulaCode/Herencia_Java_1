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

    ArrayList<Personas> personas = new ArrayList();
    ArrayList<Personas> Adentro = new ArrayList();
    ArrayList<Estudiantes> lista_estudiantes = new ArrayList();
    ArrayList<Profesores> profesores = new ArrayList();
    ArrayList<Personal_Seguridad> lista_seguridad = new ArrayList();
    ArrayList<Decanos> decanos = new ArrayList();

    InOut inOut = new InOut();

    public void agregarPersona(int numFacult) {

        boolean verificar;
        int cedula;

        String nombre;

        cedula = inOut.solicitarEntero("\nDigite la cédula");
        while (Verificarcc(cedula)) {
            cedula = inOut.solicitarEntero("\nDigite la cédula");
        }
        nombre = inOut.solicitarNombre("\nDigite su nombre");

        String mensaje = "¿Qué tipo de persona desea agregar? \n"
                + "1. Estudiante \n"
                + "2. Decanos \n"
                + "3. Profesor \n"
                + "4. Personal de seguridad \n"
                + "5. Salir\n\n" + "Digite una opción";

        int opcion = inOut.solicitarEntero(mensaje);
        switch (opcion) {
            case 1: {
                int codigo_estudiante = inOut.solicitarEntero("Digite el código del estudiante");
                while (verificarCarnet(codigo_estudiante)) {
                    codigo_estudiante = inOut.solicitarEntero("Digite el código del estudiante \n Ese código ya existe ");
                }
                Estudiantes obj_estudiante = new Estudiantes(cedula, nombre, codigo_estudiante);
                lista_estudiantes.add(obj_estudiante);
                personas.add(obj_estudiante);

                break;
            }

            case 2: {
                if (decanos.size()<numFacult) {
                    int tarjeta = inOut.solicitarEntero("Ingrese su Numero de Tarjeta profesional");
                    String nombreFacultad = inOut.solicitarNombre("\nDigite el nombre de la facultad que representa");
                    while (VerificarTarjetadeProfesor(tarjeta) == true || verificarFacultad(nombreFacultad) == true || VerificarTarjetadeDecano(tarjeta) ==true) {
                        tarjeta = inOut.solicitarEntero("\nEl número de tarjeta o el nombre de la facultad ya existen \nIngrese su Numero de Tarjeta profesional");
                        nombreFacultad = inOut.solicitarNombre("\nDigite el nombre de la facultad que representa");
                    }
                    Decanos decano = new Decanos(cedula, nombre, tarjeta, nombreFacultad);
                    personas.add(decano);
                    decanos.add(decano);
                } else {
                    inOut.mostrarResultado("\nNo pueden registrarse más decanos.");
                }
                break;

            }

            case 3: {

                int tarjeta = inOut.solicitarEntero("Ingrese su Numero de Tarjeta profesional");
                while (VerificarTarjetadeProfesor(tarjeta) == true || VerificarTarjetadeDecano(tarjeta) ==true) {
                    tarjeta = inOut.solicitarEntero("\nEse número de tarjeta ya existe \nIngrese su Numero de Tarjeta profesional");
                }
                Profesores profes = new Profesores(cedula, nombre, tarjeta);
                profesores.add(profes);
                personas.add(profes);

                break;
            }
            case 4: {
                int numero_certificacion = inOut.solicitarEntero("Ingrese el número de matrícula de vigilante");
                while (validarMatriculaVigilante(numero_certificacion)) {
                    numero_certificacion = inOut.solicitarEntero("Ingrese el número de matrícula de vigilante  \n Esa matrícula ya se encuentra registrada");
                }

                String arma = inOut.solicitarNombre("Digite el modelo de la arma");
                int numero_balas = inOut.solicitarEntero("Digite el número de balas");
                Personal_Seguridad obj_seguridad = new Personal_Seguridad(numero_certificacion, arma, numero_balas, cedula, nombre);
                lista_seguridad.add(obj_seguridad);
                personas.add(obj_seguridad);

            }

            case 5: {

                break;
            }
            default: {

                inOut.mostrarResultado("\nNinguna opción válida fue elegida.");

            }

        }
    }

    public void buscarPersona() {

        int cedula = inOut.solicitarEntero("\nDigite el número de cédula de la persona que desee buscar: ");

        for (int i = 0; i < lista_estudiantes.size(); i++) {

            if (lista_estudiantes.get(i).getIdentificacion_persona() == cedula) {

                inOut.mostrarResultado("\n"+lista_estudiantes.get(i).toString()
                        + "\nFunciones: \n" + lista_estudiantes.get(i).AsistiendoaClase() + " \n" + lista_estudiantes.get(i).Leer()
                        + "\n" + lista_estudiantes.get(i).Pagarmatricula()
                        + "\n" + lista_estudiantes.get(i).entregarTrabajo()
                );

            }
        }
        for (int i = 0; i < profesores.size(); i++) {

            if (profesores.get(i).getIdentificacion_persona() == cedula) {

                inOut.mostrarResultado("\n"+profesores.get(i).toString()
                        + "\nFunciones: \n" + profesores.get(i).dictarClase()
                        + "\n" + profesores.get(i).digitarNotas()
                );

            }
        }

        for (int i = 0; i < lista_seguridad.size(); i++) {

            if (lista_seguridad.get(i).getIdentificacion_persona() == cedula) {

                inOut.mostrarResultado("\n"+lista_seguridad.get(i).toString()
                        + "\nY su arma es" + lista_seguridad.get(i).getArma()
                        + "\nY tiene una cantidad de balas de " + lista_seguridad.get(i).getNumBalas()
                        + "\nFunciones: \n"
                        + lista_seguridad.get(i).dispararArma()
                );

            }

        }

        for (int i = 0; i < decanos.size(); i++) {

            if (decanos.get(i).getIdentificacion_persona() == cedula) {

                inOut.mostrarResultado(decanos.get(i).toString()
                        + "\nY representa a la facultad" + decanos.get(i).getUniversidadRepresentando()
                        + "\nFunciones: \n" + decanos.get(i).dictarClase()
                        + "\n" + decanos.get(i).digitarNotas()
                );

            }
        }
    }

    public boolean Verificarcc(int c) {
        boolean flag = false;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getIdentificacion_persona() == c) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean verificarCarnet(int codigo_estudiantil) {
        for (int i = 0; i < lista_estudiantes.size(); i++) {
            if (lista_estudiantes.get(i).getCodigoEstudiantil() == codigo_estudiantil) {
                return true;
            }
        }
        return false;
    }

    public boolean VerificarTarjetadeProfesor(int c) {
        boolean flag = false;
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getNumeroTarjeta() == c) {
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean VerificarTarjetadeDecano(int c) {
        boolean flag = false;
        for (int i = 0; i < decanos.size(); i++) {
            if (decanos.get(i).getNumTarjeta() == c) {
                flag = true;
            }
        }
        return flag;
    }

    public void EntrarenlaU() {

        int cel = inOut.solicitarEntero("Ingrese la cedula para entrar en la universidad");
        if (!validarEstancia(cel)) {
            if (Verificarcc(cel) == true) {
                inOut.mostrarResultado("La persona " + VerificarEntrada(cel).getNombre_persona() + " Está dentro de la universidad");
                Adentro.add(VerificarEntrada(cel));
            }
        } else {
            inOut.mostrarResultado("Usted ya se encuentra en la universidad");
        }
<<<<<<< HEAD
        
      }
      public void salirUniversidad()
      {
         int cedula = inOut.solicitarEntero("Ingrese la cédula: ");

         if(validarEstancia(cedula))
         {
             inOut.mostrarResultado("Vuelva pronto");
             Adentro.remove(retornaSalida(cedula));
         }
         else
         {
             inOut.mostrarResultado("Usted no se encuentra dentro de la universidad");
         }
      }
      public int retornaSalida(int cedula)
      {
          for(int i =0;i<Adentro.size();i++){
              if(Adentro.get(i).getIdentificacion_persona()==cedula){
                  return i;
              }     
          } 
          return -1;
      }
      public boolean  validarEstancia(int cedula)
      {
          for(int i =0;i<Adentro.size();i++){
              if(Adentro.get(i).getIdentificacion_persona()==cedula){
                  return true;
              }     
          }
           return false;  
      }
       public Personas VerificarEntrada(int c){
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
=======

    }

    public void salirUniversidad() {
        int cedula = inOut.solicitarEntero("Ingrese la cédula: ");

        if (validarEstancia(cedula)) {
            inOut.mostrarResultado("Vuelva pronto");
            Adentro.remove(retornaSalida(cedula));
        } else {
            inOut.mostrarResultado("Usted no se encuentra dentro de la universidad");
        }
    }

    public int retornaSalida(int cedula) {
        for (int i = 0; i < Adentro.size(); i++) {
            if (Adentro.get(i).getIdentificacion_persona() == cedula) {
                return i;
            }
        }
        return -1;
    }

    public boolean validarEstancia(int cedula) {
        for (int i = 0; i < Adentro.size(); i++) {
            if (Adentro.get(i).getIdentificacion_persona() == cedula) {
                return true;
            }
        }
        return false;
    }

    public Personas VerificarEntrada(int c) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getIdentificacion_persona() == c) {
                return personas.get(i);
            }

        }
        return null;
    }

    public boolean validarMatriculaVigilante(int matricula_vigilante) {
        for (int i = 0; i < lista_seguridad.size(); i++) {
            if (lista_seguridad.get(i).getnumCertificacion() == matricula_vigilante) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarFacultad(String facultad) {

        for (int i = 0; i < decanos.size(); i++) {

            if (facultad.equalsIgnoreCase(decanos.get(i).getUniversidadRepresentando())) {
                return true;
            }
        }

        return false;
    }

    public void mostrarPersonas() {

        if (!lista_estudiantes.isEmpty()) {
            String acumulador = " ";
           acumulador += ("Los estudiantes son:\n");
            for (int i = 0; i < lista_estudiantes.size(); i++) {
                acumulador+=("Estudiante " + (i+1)
                        + ": \nNombre:" + lista_estudiantes.get(i).getNombre()
                        + "\nCédula:" + lista_estudiantes.get(i).getCedula()
                        + "\nCódigo:" + lista_estudiantes.get(i).getCodigoEstudiantil()
                );
                inOut.mostrarResultado(acumulador);
            }
        }
        if (!profesores.isEmpty()) {
             String acumulador = " ";
            acumulador +=("Los profesores son:\n");
            for (int i = 0; i < profesores.size(); i++) {
                acumulador+=("Profesor " + (i+1)
                        + ": \nNombre:" + profesores.get(i).getNombre()
                        + "\nCédula:" + profesores.get(i).getCedula()
                        + "\nNúmero de tarjeta:" + profesores.get(i).getNumeroTarjeta()
                );
            }
             inOut.mostrarResultado(acumulador);
        }
        if (!lista_seguridad.isEmpty()) {
             String acumulador = " ";
             acumulador +=("Las personas de seguridad son:\n");
            for (int i = 0; i < lista_seguridad.size(); i++) {
>>>>>>> f1f7fccca74859650532627e5d9caaa4c0309245
              
                acumulador +=("Estudiante " + (i+1)
                        + ": \nNombre:" + lista_seguridad.get(i).getNombre()
                        + "\nCédula:" + lista_seguridad.get(i).getCedula()
                        + "\nNúmero de certificación:" + lista_seguridad.get(i).getnumCertificacion()
                        + "\nTiene una arma:" + lista_seguridad.get(i).getArma()
                        + "\nCon número de balas: " + lista_seguridad.get(i).getNumBalas()
                );
            }
             inOut.mostrarResultado(acumulador);
        }
        if (!decanos.isEmpty()) {
             String acumulador = " ";
             acumulador +=("Los decanos son: \n");
            for (int i = 0; i < decanos.size(); i++) {
             
                acumulador +=("Decano " + (i+1)
                        + ": \nNombre:" + decanos.get(i).getNombre()
                        + "\nCédula:" + decanos.get(i).getCedula()
                        + "\nNúmero de tarjeta:" + decanos.get(i).getNumTarjeta()
                        + "\nY representa la facultad:" + decanos.get(i).getUniversidadRepresentando()
                );
            }
             inOut.mostrarResultado(acumulador);
        }
    
    }

    public void mostrarPersonasAdentro() {

        String mensaje = "";
        for (int i = 0; i < Adentro.size(); i++) {
            mensaje += Adentro.get(i).toString();
        }
        inOut.mostrarResultado(mensaje);

    }

    public boolean verificarListas() {

        if (personas.isEmpty()) {
            return true;
        }

        return false;
    }

}
