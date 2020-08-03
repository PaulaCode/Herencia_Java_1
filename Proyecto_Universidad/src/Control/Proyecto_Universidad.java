package Control;

import Modelo.Proceso;
import Vista.InOut;

public class Proyecto_Universidad {
         private static final String clave ="hola123";
         
         
         
    public static void main(String[] args) {
   
        InOut inOut = new InOut();
        int opc=0;
        boolean band=false;
       String clavead="";
       String universidad=""; 
       int numFacult=0; 
       Proceso proceso = new Proceso();
  do {
      String mensaje=" ";
      mensaje+=" \n 1. Modo administrador"
                + "\n 2. Modo guardia "
                + "\n 3. Modo visitante"
                + "\n 4. Salir";
     opc= inOut.solicitarEntero(mensaje);
      
    switch (opc){
        case 1:{
           clavead= inOut.solicitarNombre("Ingrese la clave de administrador: ");
            if(clavead.equals(clave)){
                 
         universidad = inOut.solicitarNombre("Digite el nombre de la universidad: ");
         numFacult = inOut.solicitarEntero("Digite el número de facultades de la universidad " + universidad);
       band=true;
        menu(universidad, numFacult, inOut,proceso);
            }
            break;
        }
        case 2:{
            if(band ==true)
            menuVigilante(universidad,numFacult,inOut,proceso);
            break;
        }
        case 3:{
            if(band ==true)
                visitante(proceso);
            break;
        }
        case 4:{
            System.exit(0);
            break;
        }
         default: {
                    inOut.mostrarResultado("Ninguna opción válida fue elegida");
                }
    } 
      
      
  }while(opc!=4);
      
    }

    public static void menu(String universidad, int numFacult, InOut inOut,Proceso proceso) {
        int opcion;
       

        do {
            String mensaje = "Universidad " + universidad + " \n"
                    + "1. Agregar persona \n"
                    + "2. Mostrar personas \n"
                    + "3. Ver personas que están en la universidad \n"
                    + "4. Salir\n\n" + "Digite una opción";

            opcion = inOut.solicitarEntero(mensaje);
            switch (opcion) {
                case 1: {
                    proceso.agregarPersona(numFacult);
                    break;
                }

                case 2: {
                    if (!proceso.verificarListas()) {
                        proceso.mostrarPersonas();
                    } else {
                        inOut.mostrarResultado("\nNo hay personas registradas.");
                    }
                    break;
                }
                case 3: {
                    if (!proceso.verificarListas()) {
                        proceso.mostrarPersonas();
                    } else {
                        inOut.mostrarResultado("\nNo hay personas registradas.");
                    }
                    break;
                }
                case 4: {
                    
                    break;
                }
              
                default: {
                    inOut.mostrarResultado("Ninguna opción válida fue elegida");
                }
            }
        } while (opcion != 4);
    }
public static void menuVigilante(String universidad, int numFacult, InOut inOut,Proceso proceso){
     int opcion;
        
        
    do {
        
            String mensaje = "Universidad " + universidad + " \n"
                    + "1. Autorizar entrada \n"
                    + "2. Autorizar Salida \n"
                    + "3. Buscar persona \n"
                     +"4. Dejar el turno\n"+"\n\nElija una opcion";
                   

            opcion = inOut.solicitarEntero(mensaje);
            switch (opcion) {
                case 1: {
                      if (!proceso.verificarListas()) {
                        proceso.EntrarenlaU();
                    } else {
                        inOut.mostrarResultado("\nNo hay personas registradas.");
                    }
                    break;
                }

                case 2: {
                   if (!proceso.verificarListas()) {
                        proceso.salirUniversidad();
                    } else {
                        inOut.mostrarResultado("\nNo hay personas registradas.");
                    }
                    break;
                }
                case 3: {
                    if (!proceso.verificarListas()) {
                        proceso.buscarPersona();
                    } else {
                        inOut.mostrarResultado("\nNo hay personas registradas.");
                    }
                    break;
           }
                case 4:{
                    break;
                }
                
                
                    
                default: {
                    inOut.mostrarResultado("Ninguna opción válida fue elegida");
                }
            }
        } while (opcion != 4);
    

}
public static void visitante(Proceso pro){
    int opc=0;
    InOut ioData = new InOut();
 
    do{
        String mensaje="\n1.Mostrar decanos"+
                     "\n2.Salir "+"\n\nElija una opcion";
        opc=ioData.solicitarEntero(mensaje);
         switch (opc) {
             case 1:{
                 pro.mostrarDecanos();
                 break;
             }
             case 2:{
                 break; 
             }
             default: {
                    ioData.mostrarResultado("Ninguna opción válida fue elegida");
                }
         }
        
    }while(opc!=2);
    
}

}