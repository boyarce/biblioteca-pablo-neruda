/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Daniela
 */
/*Clase donde se define a la Mascota del Cliente a tratar y los datos relevantes de la mascota*/
public class Mascota implements Serializable{

    /**
     * atributos
     */
    
    private int idMascota;
    private int idTipo;
    private String rutCliente;
    private String nombre;
    private Date fechaNacimiento;

    /*constructor sin parametros*/
    
    public Mascota() {
        this.idMascota = 0;
        this.idTipo = 0;
        this.rutCliente = "";
        this.nombre = "";
        this.fechaNacimiento = null;
    }

    /*constructor con parametros*/

    public Mascota(int idMascota, int idTipo, String rutCliente, String nombre, Date fechaNacimiento) {
        this.idMascota = idMascota;
        this.idTipo = idTipo;
        this.rutCliente = rutCliente;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }


    /*Getters y Setters*/
    
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int IdMascota) {
        this.idMascota = IdMascota;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int IdTipo) {
        this.idTipo = IdTipo;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String RutCliente) {
        this.rutCliente = RutCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.fechaNacimiento = FechaNacimiento;
    }

}
