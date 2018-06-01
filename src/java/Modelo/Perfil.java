/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Daniela
 */
/*Clase donde se define el Perfil del Usuarui 
con un identificador y el nombre ej (Identificador, Nombre) (1,Administrador)*/
public class Perfil  implements Serializable{

    /**
     * atributos
     */
    private int idPerfil;
    private String nombre;

    /*constructor con parametros*/
    public Perfil(int IdPerfil, String nombre) {
        this.idPerfil = IdPerfil;
        this.nombre = nombre;
    }

    /*constructor sin parametros*/
    public Perfil() {
        this.idPerfil = 0;
        this.nombre = "";
    }

    /*Getters y Setters*/
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.idPerfil = IdPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
