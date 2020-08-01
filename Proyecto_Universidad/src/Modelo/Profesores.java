
package Modelo;

import Vista.InOut;

public class Profesores extends Empleados {
    
    public int numero_tarjeta;
    public InOut ioData = new InOut();
    public Profesores(int identificacion_profesor,String nombre_profesor,int numero_tarjeta)
    {
        super(identificacion_profesor,nombre_profesor);
        this.numero_tarjeta=numero_tarjeta;
    }
    
    public String dictarClase()
    {
       return (" dicta clase");
    }
       public String digitarNotas()
    {
        return (" digita notas");
    } 
       
        public String getNombre(){
         
         return super.getNombre_persona();
     }
     
     public int getCedula(){
         
         return super.getIdentificacion_persona();
     }
     
     public int getNumeroTarjeta(){
         
         return numero_tarjeta;
     }
       
       public String toString() {
        return "La persona con cédula: "+super.getIdentificacion_persona()+" es un profesor con \nNúmero de tarjeta: "+numero_tarjeta+" y su nombre es "+super.getNombre_persona();
    }
    
}
