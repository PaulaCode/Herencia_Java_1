
package Control;

import Modelo.Proceso;
import Vista.InOut;

public class Proyecto_Universidad {

    public static void main(String[] args) {
       
        menu();
    }
    public static void menu()
    {
                
        InOut inOut = new InOut();

        Proceso proceso = new Proceso();
        
        String universidad = inOut.solicitarNombre("\nDigite el nombre de la universidad: ");
        int numFacult = inOut.solicitarEntero("\nDigite el número de facultades de la universidad "+universidad);
        
        String mensaje = "Universidad"+ universidad + " \n"
                         +"1. Agregar persona \n"
                         +"2. Mostrar personas \n"+
                         "3. Salir\n\n"+"Digite una opción"
                 ;
        
       
            int opcion = inOut.solicitarEntero(mensaje);
            switch (opcion) {
                case 1:
                {
                    proceso.agregarPersona(numFacult);
                     break;   
                }
   
                case 2:
                {
                  break;   
                }
                            
                case 3:{
                     
                    break;
                }
                default:{
                   
                }    
            }
    }
    
}
