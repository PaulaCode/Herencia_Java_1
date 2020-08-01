
package Modelo;

public class Personas {
    private int identificacion_persona;
    private String nombre_persona;

    public Personas(int identificacion_persona, String nombre_persona) {
        this.identificacion_persona = identificacion_persona;
        this.nombre_persona = nombre_persona;
    }
    
    public int getIdentificacion_persona() {
        return identificacion_persona;
    }

    public void setIdentificacion_persona(int identificacion_persona) {
        this.identificacion_persona = identificacion_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }
    
   
    
}
