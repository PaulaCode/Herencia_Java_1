/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Personal_Seguridad extends Empleados{
    
<<<<<<< HEAD
    public final int numCertificacion;
    public String arma;
    public int numBalas;
=======

    public final String arma;
    public final int numBalas;
>>>>>>> 0320f2c30202083eb0794232fec64a333d514ba1

    public Personal_Seguridad(int numCertificacion,String nombre, String arma, int numBalas) {
        super(numCertificacion,nombre);
        this.arma = arma;
        this.numBalas = numBalas;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public int getNumBalas() {
        return numBalas;
    }

    public void setNumBalas(int numBalas) {
        this.numBalas = numBalas;
    }
    
    
    
}
