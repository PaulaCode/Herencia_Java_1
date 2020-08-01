
package Modelo;
import Vista.InOut;
public class Estudiantes extends Personas{
    private int codigoEstudiantil;

    Estudiantes(int Cedula,String Nombre,int codigo){
        super(Cedula,Nombre);
        codigoEstudiantil=codigo;
    } 

    public int getCodigoEstudiantil() {
        return codigoEstudiantil;
    }

    public void setCodigoEstudiantil(int codigoEstudiantil) {
        this.codigoEstudiantil = codigoEstudiantil;
    }
    
    public String Pagarmatricula(){
        return (" paga la matricula ");
        
    }
    public String AsistiendoaClase(){
        return (" asiste a clase");
    }
      public String Leer(){
        return (" lee");
    }
     public String entregarTrabajo(){
        return (" entrega trabajos");
    }
     
     public String getNombre(){
         
         return super.getNombre_persona();
     }
     
     public int getCedula(){
         
         return super.getIdentificacion_persona();
     }

    @Override
    public String toString() {
        return "La persona con cédula: "+super.getIdentificacion_persona()+" es un estudiante con \nCódigo: "+codigoEstudiantil+" y su nombre es "+super.getNombre_persona();
    }
     
}
