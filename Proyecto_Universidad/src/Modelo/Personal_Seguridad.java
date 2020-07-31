/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Personal_Seguridad extends Empleados{
    

    public final String arma;
    public final int numBalas;

    public Personal_Seguridad(int numCertificacion,String nombre, String arma, int numBalas) {
        super(numCertificacion,nombre);
        this.arma = arma;
        this.numBalas = numBalas;
    }
    
    
    
    
    
    
}
