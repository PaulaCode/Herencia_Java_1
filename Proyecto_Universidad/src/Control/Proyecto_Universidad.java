
package Control;

import Vista.InOut;

public class Proyecto_Universidad {

    public static void main(String[] args) {
       
        menu();
    }
    public static void menu()
    {
                
        InOut inOut = new InOut();


        
        String mensaje = "Universidad Distrital \n"
                         +"1. Agregar persona \n"
                         +"2. Mostrar personas \n"+
                         "3. Salir\n\n"+"Digite una opción"
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
    
}
