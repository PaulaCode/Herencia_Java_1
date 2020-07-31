
package Control;

import Vista.InOut;

public class Proyecto_Universidad {

    public static void main(String[] args) {
       
        
        InOut inOut = new InOut();
       
        System.out.println("\nMetodo Static y Final");

        String opcion = "";
        do {
         
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("2. Buscar persona");
            System.out.println("0. Salir");
            
            opcion = inOut.solicitarNombre("Digite la opcion: ");
            switch (opcion) {
                case "1":
                   
                    break;
                case "2":
                   
                    break;
                    
                case "3":
                    
                    
                    
                case "0": break;
                default: System.out.println("\nNinguna opción válida fue elegida");
            }
        } while (!opcion.equals("0"));                              // Mientras sea diferente de 0

        
    }
    
}
