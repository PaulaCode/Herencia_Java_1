
package Modelo;

import Vista.InOut;


public class Empleados extends Personas{

    private InOut ioData = new InOut();
    
    public void cobrarSueldo()
    {
        ioData.mostrarResultado(super.getNombre_persona()+ " cobra sueldo");
    }
   public void pagarImpuestos()
   {
        ioData.mostrarResultado(super.getNombre_persona()+ " paga impuestos"); 
   }
   public void asistirReuniones()
   {
        ioData.mostrarResultado(super.getNombre_persona()+ " asiste a reuniones");
   }
}
