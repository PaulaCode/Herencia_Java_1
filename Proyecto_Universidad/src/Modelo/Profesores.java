
package Modelo;

import Vista.InOut;

public class Profesores extends Empleados {
    
    private int numero_tarjeta;
    private InOut ioData = new InOut();
    public Profesores(int identificacion_profesor,String nombre_profesor,int numero_tarjeta)
    {
        super(identificacion_profesor,nombre_profesor);
        this.numero_tarjeta=numero_tarjeta;
    }
    
    public void dictarClase()
    {
        ioData.mostrarResultado(super.getNombre_persona()+" dicta clase");
    }
       public void digitarNotas()
    {
        ioData.mostrarResultado(super.getNombre_persona()+" digita notas");
    } 
    
}
