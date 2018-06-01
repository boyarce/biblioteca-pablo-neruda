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

/*Clase donde se define el tipo de animal 
con un identificador y el nombre ej (Identificador, Nombre) (1,Perro)*/
public class Animal  implements Serializable{
    
    /*Atributos de la Clase Animal*/
    private int idtipo;
    private String nombre;
    
    /*constructor sin parametros*/
    public Animal() {
        this.idtipo = 0;
        this.nombre = "";
    }
/*constructor con parametros*/
    public Animal(int Idtipo, String Nombre) {
        this.idtipo = Idtipo;
        this.nombre = Nombre;
    }
//get y set
    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int Idtipo) {
        this.idtipo = Idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
    
}
