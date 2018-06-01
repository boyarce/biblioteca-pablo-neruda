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
/*Clase donde se define al Cliente con sus datos personales relevantes para la compañia  */
public class Cliente implements Serializable {

    /**
     * atributos
     */
    private String rut;
    private String nombre;
    private String direccion;
    private Date fechanacimiento;
    private String fechaNacimientoHTML;
    private String correo;
    private String sexo;

    /*constructor sin parametros*/
    public Cliente() {
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.fechanacimiento = null;
        this.fechaNacimientoHTML = null;
        this.correo = "";
        this.sexo = "";
    }

    /*constructor con parametros*/
    public Cliente(String rut, String nombre, String direccion, Date fechanacimiento, String fechaHtml, String correo, String sexo) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechanacimiento = fechanacimiento;
        this.fechaNacimientoHTML = fechaHtml;
        this.correo = correo;
        this.sexo = sexo;
    }

    /*Getters y Setters*/
    public String getRut() {
        return rut;
    }

    public void setRut(String Rut) {
        this.rut = Rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date Fechanacimiento) {
        this.fechanacimiento = Fechanacimiento;
    }

    public void setFechaNacimientoHTML(String fechaNacimientoHTML) {
        this.fechaNacimientoHTML = fechaNacimientoHTML;
    }

    public String getFechaNacimientoHTML() {
        return fechaNacimientoHTML;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

}
