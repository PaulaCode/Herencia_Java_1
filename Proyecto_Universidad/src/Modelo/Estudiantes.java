
package Modelo;

public class Estudiantes extends Personas{
    private int codigoEstudiantil;
    
    Estudiantes(int Cedula,String Nombre,int codigo){
        super(Cedula,Nombre);
        codigoEstudiantil=codigo;
    } 
    
}
