
package Control;

import Modelo.Proceso;
import Vista.InOut;

public class Proyecto_Universidad {

    public static void main(String[] args) {
        
        InOut inOut = new InOut();
        
        String universidad = inOut.solicitarNombre("Digite el nombre de la universidad: ");
         int numFacult = inOut.solicitarEntero("\nDigite el número de facultades de la universidad "+universidad);
        
        menu(universidad,numFacult,inOut);
    }
    
    public static void menu(String universidad, int numFacult, InOut inOut)
    {
       int opcion;
        Proceso proceso = new Proceso();
        
        do{
        String mensaje = "Universidad"+ universidad + " \n"
                         +"1. Agregar persona \n"
                         +"2. Mostrar personas \n"
                         +"3. Buscar persona \n"
                         +"4. Autorizar entrada \n"
                         +"5. Autorizar salida \n"
                         +"6. Ver personas que están en la universidad \n"
                         +"7. Salir\n\n"+"Digite una opción"
                 ;
        
             opcion = inOut.solicitarEntero(mensaje);
            switch (opcion) {
                case 1:
                {
                    proceso.agregarPersona(numFacult);
                     break;   
                }
   
                case 2:
                {
                    proceso.mostrarPersonas();
                  break;   
                }       
                 case 3:
                {
                    proceso.mostrarPersonas();
                  break;   
                }   
                case 4:{
                    proceso.EntrarenlaU();
                    break;
                }
                case 5:{
                    proceso.salirUniversidad();
                    break;
                }
                case 6:{
                    proceso.salirUniversidad();
                    break;
                }
                case 7:
                    break;
                default:{
                   inOut.mostrarResultado("Ninguna opción válida fue elegida");
                }    
            }
        } while(opcion!=7);
    }
    
}

