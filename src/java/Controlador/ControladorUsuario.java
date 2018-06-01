/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DDBB.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class ControladorUsuario {

    /**
     * Metodo para la creacion de registros en la tabla
     *
     * @param usuario
     */
    public void InsertaUsuario(Usuario usuario) {
        try {
             SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "INSERT INTO medipet.usuario(U_RUT, U_NOMBRE,"
                    + " U_APELLIDOPATERNO, U_APELLIDOMATERNO, U_FECHANACIMIENTO,"
                    + " U_CORREO, U_PASSWORD, U_IDPERFIL)VALUES ('"
                    + usuario.getRut() + "','" + usuario.getNombre() + "','"
                    + usuario.getApellidoPaterno() + "','" + usuario.getApellidoMaterno()
                    + "','" + simple.format(usuario.getFechaNacimiento()) + "','" + usuario.getCorreo()
                    + "','" + usuario.getPassword() + "'," + usuario.getIdPerfil() + ")";

            stms.executeUpdate(consulta);
            System.out.println("USUARIO ALMACENADO");
        } catch (Exception e) {

            System.out.println("ERROR AL ALMACENAR USUARIO");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Usuario'
     *
     * @return
     */
    public List<Usuario> getListaUsuario() {

        List<Usuario> lista = new ArrayList<>();

        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT u.U_RUT AS U_RUT, u.U_NOMBRE AS U_NOMBRE,"
                    + " u.U_APELLIDOPATERNO AS U_APELLIDOPATERNO, "
                    + "u.U_APELLIDOMATERNO AS U_APELLIDOMATERNO, "
                    + "u.U_FECHANACIMIENTO AS U_FECHANACIMIENTO,"
                    + " u.U_CORREO AS U_CORREO, u.U_PASSWORD AS U_PASSWORD, "
                    + "u.U_IDPERFIL AS U_IDPERFIL FROM medipet.usuario u";

            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                String uRut1 = rs.getString("U_RUT");
                String uNombre1 = rs.getString("U_NOMBRE");
                String uApellidopaterno1 = rs.getString("U_APELLIDOPATERNO");
                String uApellidomaterno1 = rs.getString("U_APELLIDOMATERNO");
                Date uFechanacimiento1 = rs.getDate("U_FECHANACIMIENTO");
                String correo = rs.getString("U_CORREO");
                String uPassword1 = rs.getString("U_PASSWORD");
                int uIdperfil1 = rs.getInt("U_IDPERFIL");

                usuario.setRut(uRut1);
                usuario.setNombre(uNombre1);
                usuario.setApellidoPaterno(uApellidopaterno1);
                usuario.setApellidoMaterno(uApellidomaterno1);
                usuario.setFechaNacimiento(uFechanacimiento1);
                usuario.setPassword(uPassword1);
                usuario.setCorreo(correo);
                usuario.setIdPerfil(uIdperfil1);

                lista.add(usuario);
            }

            return lista;
        } catch (Exception e) {

            System.out.println("ERROR en query lista USUARIO");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Metodo para la actualizacion de registros en la tabla
     *
     * @param usuario
     */
    public void ModificarUsuario(Usuario usuario) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "UPDATE medipet.usuario u SET u.U_RUT = '"
                    + usuario.getRut() + "',u.U_NOMBRE = '" + usuario.getNombre()
                    + "',u.U_APELLIDOPATERNO = '" + usuario.getApellidoPaterno()
                    + "' ,u.U_APELLIDOMATERNO = '" + usuario.getApellidoMaterno()
                    + "' ,u.U_FECHANACIMIENTO = '" + usuario.getFechaNacimiento()
                    + "' ,u.U_CORREO = '" + usuario.getCorreo()
                    + "' ,u.U_PASSWORD = '" + usuario.getPassword()
                    + "' ,u.U_IDPERFIL = '" + usuario.getIdPerfil()
                    + "' WHERE u.U_RUT = '" + usuario.getRut() + "'";

            stms.executeUpdate(consulta);
            System.out.println("USUARIO ACTUALIZADO");
        } catch (Exception e) {

            System.out.println("ERROR AL ACTUALIZAR USUARIO");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para la eliminacion de un registro en la tabla
     *
     * @param rutUsuario
     */
    public void BorrarUsuario(String rutUsuario) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "DELETE FROM medipet.usuario WHERE U_RUT = '"
                    + rutUsuario + "'";

            stms.executeUpdate(consulta);
            System.out.println("USUARIO BORRADP");
        } catch (Exception e) {

            System.out.println("ERROR AL BORRAR USUARIO");
            e.printStackTrace();

        }
    }
/* Metodo para retornar una lista de Usuarios que tienen perfil de Medico*/
    
    public List<Usuario> getRutMedico() {
        List<Usuario> lista = new ArrayList<>();

        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT u.U_RUT AS U_RUT, u.U_NOMBRE AS U_NOMBRE,"
                    + " u.U_APELLIDOPATERNO AS U_APELLIDOPATERNO, "
                    + "u.U_APELLIDOMATERNO AS U_APELLIDOMATERNO, "
                    + "u.U_FECHANACIMIENTO AS U_FECHANACIMIENTO,"
                    + " u.U_CORREO AS U_CORREO, u.U_PASSWORD AS U_PASSWORD, "
                    + "u.U_IDPERFIL AS U_IDPERFIL FROM medipet.usuario u WHERE u.U_IDPERFIL = 2";

            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                String uRut1 = rs.getString("U_RUT");
                String uNombre1 = rs.getString("U_NOMBRE");
                String uApellidopaterno1 = rs.getString("U_APELLIDOPATERNO");
                String uApellidomaterno1 = rs.getString("U_APELLIDOMATERNO");
                Date uFechanacimiento1 = rs.getDate("U_FECHANACIMIENTO");
                String correo = rs.getString("U_CORREO");
                String uPassword1 = rs.getString("U_PASSWORD");
                int uIdperfil1 = rs.getInt("U_IDPERFIL");

                usuario.setRut(uRut1);
                usuario.setNombre(uNombre1);
                usuario.setApellidoPaterno(uApellidopaterno1);
                usuario.setApellidoMaterno(uApellidomaterno1);
                usuario.setFechaNacimiento(uFechanacimiento1);
                usuario.setCorreo(correo);
                usuario.setPassword(uPassword1);
                usuario.setIdPerfil(uIdperfil1);

                lista.add(usuario);
            }

            return lista;
        } catch (Exception e) {

            System.out.println("ERROR en query lista USUARIO get lista medico");
            e.printStackTrace();
            return null;
        }

    }
    /*Metodo para validar si el Usuario es Valido al logearse a la Aplicacion
    retorna true si existe el resgitro
    retorna false si no existe*/
    public boolean ValidarUsuarioLogin (String nombre, String password){
        try{
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT u.U_RUT AS U_RUT, u.U_NOMBRE AS U_NOMBRE,"
                    + " u.U_APELLIDOPATERNO AS U_APELLIDOPATERNO, "
                    + "u.U_APELLIDOMATERNO AS U_APELLIDOMATERNO, "
                    + "u.U_FECHANACIMIENTO AS U_FECHANACIMIENTO,"
                    + " u.U_CORREO AS U_CORREO, u.U_PASSWORD AS U_PASSWORD, "
                    + "u.U_IDPERFIL AS U_IDPERFIL FROM medipet.usuario u "
                    + "WHERE U_CORREO = '"+nombre+"' AND U_PASSWORD = '"+password+"';";

            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            
            if(rs.first())        // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
               return true;        //usuario validado correctamente
            else
               return false;        //usuario validado incorrectamente
 
        }
        catch(Exception e)
        {
            System.out.println("Error al validar usuario en el login");
            e.printStackTrace();
            return false;
        }
    }
    
    /*Metodo para validar si el Usuario posee registros en la tabla Atenciones, 
    para poder eliminarlo sin problemas sin que la informacion anterior se pierda
    retorna true si existe el resgitro
    retorna false si no existe*/
    
    public boolean validarUsuarioParaEliminar (String rut)
    {
        try {
             Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT i.AT_U_RUT AS U_RUT FROM medipet.ingreso i "
                    + "WHERE U_RUT = '"+rut+"';";

            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            
            if(rs.first())        // si es valido el primer reg. hay una fila, 
               return true;        //usuario validado correctamente
            else
               return false;        //usuario validado incorrectamente
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*Metodo para validar si el Usuario con perfil administrador existe en la DDBB
    
    retorna true si existe el resgitro
    retorna false si no existe*/
    
    public boolean validaExisteAdmin ()
    {
        try {
             Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT u.U_RUT AS U_RUT, u.U_NOMBRE AS U_NOMBRE,"
                    + " u.U_APELLIDOPATERNO AS U_APELLIDOPATERNO, "
                    + "u.U_APELLIDOMATERNO AS U_APELLIDOMATERNO, "
                    + "u.U_FECHANACIMIENTO AS U_FECHANACIMIENTO,"
                    + " u.U_CORREO AS U_CORREO, u.U_PASSWORD AS U_PASSWORD, "
                    + "u.U_IDPERFIL AS U_IDPERFIL FROM medipet.usuario u "
                    + "WHERE U_IDPERFIL = 1";

            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            
            if(rs.first())        // si es valido el primer reg. hay una fila, 
               return true;        //usuario validado correctamente
            else
               return false;        //usuario validado incorrectamente
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     /*Metodo para validar si el Usuario con perfil administrador existe en la DDBB
    
    retorna true si existe el resgitro
    retorna false si no existe*/
    
    public boolean validaMenu (String correo)
    {
        try {
             Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT u.U_RUT AS U_RUT, u.U_NOMBRE AS U_NOMBRE,"
                    + " u.U_APELLIDOPATERNO AS U_APELLIDOPATERNO, "
                    + "u.U_APELLIDOMATERNO AS U_APELLIDOMATERNO, "
                    + "u.U_FECHANACIMIENTO AS U_FECHANACIMIENTO,"
                    + " u.U_CORREO AS U_CORREO, u.U_PASSWORD AS U_PASSWORD, "
                    + "u.U_IDPERFIL AS U_IDPERFIL FROM medipet.usuario u "
                    + "WHERE U_IDPERFIL = 1 AND U_CORREO ='"+correo+"';";

            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            
            if(rs.first())        // si es valido el primer reg. hay una fila, 
               return true;        //usuario validado correctamente
            else
               return false;        //usuario validado incorrectamente
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}

