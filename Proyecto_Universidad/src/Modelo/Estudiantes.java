
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
    
    public void Pagarmatricula(){
        InOut IoData = new InOut();
        IoData.mostrarResultado("El estudiante "+super.getNombre_persona()+" esta pagando la matricula ");
        
    }
    public void AsistiendoaClase(){
         InOut IoData = new InOut();
        IoData.mostrarResultado("El estudiante "+super.getNombre_persona()+" esta en clase");
    }
      public void Leer(){
         InOut IoData = new InOut();
        IoData.mostrarResultado("El estudiante "+super.getNombre_persona()+" esta leyendo");
    }
     public void entregarTrabajo(String materia){
         InOut IoData = new InOut();
        IoData.mostrarResultado("El estudiante "+super.getNombre_persona()+" esta haciendo un trabajo de"+materia);
    }

    @Override
    public String toString() {
        return "Cédula: "+super.getIdentificacion_persona()+" Código: "+codigoEstudiantil+" Nombre: "+super.getNombre_persona();
    }
     
}
