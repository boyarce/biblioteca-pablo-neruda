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

/*Clase donde se define al Usuario con sus datos personales relevantes para la compañia  */
public class Usuario  implements Serializable{
    
    /**
     * atributos
     */
    
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String correo;
    private String password;
    private int idPerfil;

    /* constructor sin parametros*/
    public Usuario() {
        this.rut = "";
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.fechaNacimiento = null;
        this.correo = "";
        this.password = "";
        this.idPerfil = 0;
    }
    
    /* constructor con parametros*/

    public Usuario(String Rut, String Nombre, String ApellidoPaterno, String ApellidoMaterno, Date FechaNacimiento, String Correo, String Password, int IdPerfil) {
        this.rut = Rut;
        this.nombre = Nombre;
        this.apellidoPaterno = ApellidoPaterno;
        this.apellidoMaterno = ApellidoMaterno;
        this.fechaNacimiento = FechaNacimiento;
        this.correo = Correo;
        this.password = Password;
        this.idPerfil = IdPerfil;
    }
//get y set
    
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.apellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.apellidoMaterno = ApellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.fechaNacimiento = FechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.idPerfil = IdPerfil;
    }
    
    
}
