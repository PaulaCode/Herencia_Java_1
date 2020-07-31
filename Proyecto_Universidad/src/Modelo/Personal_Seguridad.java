/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Personal_Seguridad extends Empleados{
    
    public final int numCertificacion;
    public String arma;
    public int numBalas;

    public Personal_Seguridad(int numCertificacion, String arma, int numBalas) {
        this.numCertificacion = numCertificacion;
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
