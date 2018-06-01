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
/*Clase donde se define el Ingreso de la Atencion de la Veterinaria
y recoje la informacion relevante para realizar dicha accion*/
public class Ingreso  implements Serializable{

    /**
     * atributos
     */
    private int idAtencion;
    private Date fechaAtencion;
    private int idMascota;
    private String rutUsuario;
    private String rutMedico;
    private String rutCliente;
    private String descripcionSintomas;
    private String diagnostico;
    private String procedimiento;
    private int valorConsulta;

    /*constructor sin parametros*/
    public Ingreso() {
        this.idAtencion = 0;
        this.fechaAtencion = null;
        this.idMascota = 0;
        this.rutUsuario = "";
        this.rutMedico = "";
        this.rutCliente = "";
        this.descripcionSintomas = "";
        this.diagnostico = "";
        this.procedimiento = "";
        this.valorConsulta = 0;
    }

    /*constructor con parametros*/

    public Ingreso(int idAtencion, Date fechaAtencion, int idMascota, String rutUsuario, String rutMedico, String rutCliente, String descripcionSintomas, String diagnostico, String procedimiento, int valorConsulta) {
        this.idAtencion = idAtencion;
        this.fechaAtencion = fechaAtencion;
        this.idMascota = idMascota;
        this.rutUsuario = rutUsuario;
        this.rutMedico = rutMedico;
        this.rutCliente = rutCliente;
        this.descripcionSintomas = descripcionSintomas;
        this.diagnostico = diagnostico;
        this.procedimiento = procedimiento;
        this.valorConsulta = valorConsulta;
    }


    /*Getters y Setters*/
    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int IdAtencion) {
        this.idAtencion = IdAtencion;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date FechaAtencion) {
        this.fechaAtencion = FechaAtencion;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int IdMascota) {
        this.idMascota = IdMascota;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String RutUsuario) {
        this.rutUsuario = RutUsuario;
    }

    public String getRutMedico() {
        return rutMedico;
    }

    public void setRutMedico(String RutMedico) {
        this.rutMedico = RutMedico;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String RutCliente) {
        this.rutCliente = RutCliente;
    }

    public String getDescripcionSintomas() {
        return descripcionSintomas;
    }

    public void setDescripcionSintomas(String DescripcionSintomas) {
        this.descripcionSintomas = DescripcionSintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.diagnostico = Diagnostico;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String Procedimiento) {
        this.procedimiento = Procedimiento;
    }

    public int getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(int ValorConsulta) {
        this.valorConsulta = ValorConsulta;
    }

}
