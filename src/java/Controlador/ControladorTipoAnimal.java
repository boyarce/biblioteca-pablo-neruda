/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DDBB.Conexion;
import Modelo.Animal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniela
 */
public class ControladorTipoAnimal {
    
     /**
     * Metodo para la creacion de registros en la tabla:
     * 'medipet.animales'.
     * @param animal
     */
    public void Insertar (Animal animal){
     
         try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement(); 
            String consulta = "INSERT INTO medipet.animales(AN_IDTIPO,AN_NOMBRE)"
                    + " VALUES ('"+animal.getIdtipo()+"','"+animal.getNombre()+"')";
            System.out.println("ANIMALES ALMACENADO");
            stms.executeUpdate(consulta);
        } catch (Exception e) {
            System.out.println("ERROR AL ALMACENAR ANIMAL");
            e.printStackTrace();
        }
    }
    
    
    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Animales'
     * 
     * @return 
     */
    
    public ArrayList<Animal> getListaTipoAnimal(){
        
        ArrayList<Animal> lista = new ArrayList<>();
        try{
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement(); 
            String consulta = "SELECT a.AN_IDTIPO AS AN_IDTIPO, "
                    + "a.AN_NOMBRE AS AN_NOMBRE FROM medipet.animales a ";
            ResultSet rs = (ResultSet)stms.executeQuery(consulta);
            while (rs.next()) {
                Animal animal = new Animal();
                int idtipo = rs.getInt("AN_IDTIPO");
                String anNombre1 = rs.getString("AN_NOMBRE");
                animal.setIdtipo(idtipo);
                animal.setNombre(anNombre1);

                lista.add(animal);
            }
            return lista;
        } catch (Exception e) {
            
            System.out.println("ERROR en query lista ANIMAL");
            e.printStackTrace();
            return null;
        } 
    }
    
     /**
     * Metodo para la actualizacion de registros en la tabla:
     * 'medipet.animales'.
     * @param animal
     */
    
    public void ModificarTipoAnimal(Animal animal)
    {
         try{
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            
            String consulta = "UPDATE medipet.animales a SET a.AN_IDTIPO ="+animal.getIdtipo()+", a.AN_NOMBRE = '" 
                    + animal.getNombre() + "' WHERE a.AN_IDTIPO = '" 
                    + animal.getIdtipo() + "' ";
            stms.executeUpdate(consulta);
            System.out.println("ANIMALES ACTUALIZADO");
            
        } catch (Exception e) {
           
            System.out.println("ERROR AL ACTUALIZAR ANIMAL");
            e.printStackTrace();
            
        } 
    }
    
    /**
     * Metodo para la eliminacion de un registro en la tabla:
     * 'medipet.animales'
     * @param anIdtipo
     */
    
    public void BorrarTipoAnimal(int idTipoAnimal)
    {
         try{
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            
            String consulta = "DELETE FROM medipet.animales WHERE AN_IDTIPO = " + idTipoAnimal + ";";
            
            stms.executeUpdate(consulta);
            System.out.println("ANIMAL BORRADO OK");
        }  catch (Exception e) {
            System.out.println("ERROR AL BORRAR ANIMAL");
            e.printStackTrace();
        }
    }
}
