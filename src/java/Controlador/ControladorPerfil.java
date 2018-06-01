/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DDBB.Conexion;
import Modelo.Perfil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Daniela
 */
public class ControladorPerfil {
    /*
     * Metodo para la creacion de registros en la tabla
     * @param perfil
     */
    public void insertar(Perfil perfil)
    {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();            
            System.out.println("Se crea la conexion");            
            System.out.println("se crea el statement");
            String consulta = "INSERT INTO medipet.perfil(P_IDPERFIL,P_NOMBRE) "
                    + "VALUES("+perfil.getIdPerfil()+",'"
                    +perfil.getNombre()+"');";
            System.out.println("esta la consulta en string");
            stms.executeUpdate(consulta);
            System.out.println("PERFIL ALMACENADO OK");
        }  catch (Exception e) {
            System.out.println("ERROR AL ALMACENAR PERFIL");
            e.printStackTrace();
        } 
    }
    
    
    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Perfil'    
     * @return 
     */
    public ArrayList<Perfil> getListaPerfil(){
        ArrayList<Perfil> lista = new ArrayList<>();
        try{
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement(); 
            String consulta = "SELECT p.P_IDPERFIL AS P_IDPERFIL, "
                    + "p.P_NOMBRE AS P_NOMBRE FROM medipet.perfil p";
           ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            while (rs.next()) {
                Perfil perfil = new Perfil();
                int idperfil = rs.getInt("P_IDPERFIL");
                String pNombre1 = rs.getString("P_NOMBRE");

                perfil.setIdPerfil(idperfil);
                perfil.setNombre(pNombre1);

                lista.add(perfil);
            }
            return lista;
            
        }catch(Exception e){
            System.out.println("ERROR en query lista perfil");
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     *Metodo para la actualizacion de registros en la tabla
     * @param perfil
     */
    
    public void modificarPerfil(Perfil perfil)
    {
         try{
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement(); 
            
            String consulta = "UPDATE medipet.perfil p SET p.P_IDPERFIL ="+perfil.getIdPerfil()+", p.P_NOMBRE = '" 
                    + perfil.getNombre() + "' WHERE p.P_IDPERFIL = " 
                    + perfil.getIdPerfil() + "; ";
            
            stms.executeUpdate(consulta);
            System.out.println("PERFIL ACTUALIZADO");
        } catch (Exception e) {
           
            System.out.println("ERROR AL ACTUALIZAR PERFIL");
            e.printStackTrace();
           
        } 
    }
    
    /**
     *Metodo para la eliminacion de un registro en la tabla
     * @param idPerfil
     */
    public void borrarPerfil(int idPerfil)
    {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement(); 
            
            String consulta = "DELETE FROM medipet.perfil WHERE P_IDPERFIL = " + idPerfil + ";";
            stms.executeUpdate(consulta);
             System.out.println("PERFIL BORRADO OK");
        } catch (Exception e) {
            System.out.println("ERROR AL BORRAR PERFIL");
            e.printStackTrace();
           
        } 
            
    }
}
