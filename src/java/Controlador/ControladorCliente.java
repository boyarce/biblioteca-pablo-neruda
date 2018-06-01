/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DDBB.Conexion;
import Modelo.Cliente;
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
public class ControladorCliente {

    /**
     * Metodo para la creacion de registros en la tabla cliente
     * @param cliente
     */
    public void IngresarCliente(Cliente cliente) {
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "INSERT INTO medipet.cliente (C_RUT, C_NOMBRE, "
                    + "C_DIRECCION, C_FECHANACIMIENTO, C_CORREO, C_SEXO)VALUES ('"
                    + cliente.getRut() + "','" + cliente.getNombre() + "','"
                    + cliente.getDireccion() + "','" + simple.format(cliente.getFechanacimiento())
                    + "','" + cliente.getCorreo() + "','" + cliente.getSexo() + "')";

            stms.executeUpdate(consulta);

            System.out.println("CLIENTE ALMACENADO OK");
        } catch (Exception e) {
            System.out.println("ERROR AL ALMACENAR CLIENTE");
            e.printStackTrace();

        }
    }
 /**
     * Metodo que retorna una Lista de registros de la tabla Cliente
     * @return 
     */
    public List<Cliente> getListaCliente() {
        List<Cliente> lista = new ArrayList<>();

        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT c.C_RUT AS C_RUT, c.C_NOMBRE AS C_NOMBRE,"
                    + "c.C_DIRECCION AS C_DIRECCION, "
                    + "c.C_FECHANACIMIENTO AS C_FECHANACIMIENTO, "
                    + "c.C_CORREO AS C_CORREO, c.C_SEXO AS C_SEXO "
                    + "FROM medipet.cliente c";

            ResultSet rs = stms.executeQuery(consulta);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                String cRut = rs.getString("C_RUT");
                String cNombre1 = rs.getString("C_NOMBRE");
                String cDireccion1 = rs.getString("C_DIRECCION");
                Date cFechanacimiento1 = rs.getDate("C_FECHANACIMIENTO");
                String cCorreo1 = rs.getString("C_CORREO");
                String cSexo1 = rs.getString("C_SEXO");

                cliente.setRut(cRut);
                cliente.setNombre(cNombre1);
                cliente.setDireccion(cDireccion1);
                cliente.setFechanacimiento(cFechanacimiento1);
                cliente.setCorreo(cCorreo1);
                cliente.setSexo(cSexo1);

                lista.add(cliente);
            }
            return lista;
        } catch (Exception e) {

            System.out.println("ERROR en query LISTA CLIENTE");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para la actualizacion de registros en la tabla: 'medipet.cliente'.
     * @param cliente
     */
    public void ModificarCliente(Cliente cliente) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "UPDATE medipet.cliente c SET c.C_RUT = '"
                    + cliente.getRut() + "' ,c.C_NOMBRE = '"
                    + cliente.getNombre() + "' ,c.C_DIRECCION = '"
                    + cliente.getDireccion() + "' ,c.C_FECHANACIMIENTO = "
                    + cliente.getFechanacimiento() + " ,c.C_CORREO = '"
                    + cliente.getCorreo() + "' ,c.C_SEXO = '"
                    + cliente.getSexo() + "' WHERE c.C_RUT = '"
                    + cliente.getRut() + "' ";
            stms.executeUpdate(consulta);
            System.out.println("CLIENTE ACTUALIZADO OK");
        } catch (Exception e) {

            System.out.println("ERROR AL ACTUALIZAR CLIENTE");
            e.printStackTrace();

        }

    }

    /**
     * Metodo para la eliminacion de un registro en la tabla: 'medipet.cliente'
     */
    public void BorrarCliente(String rut) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "DELETE FROM medipet.cliente WHERE C_RUT = '" + rut + "'";
            stms.executeUpdate(consulta);
            System.out.println("CLIENTE BORRADO OK");
        } catch (Exception e) {

            System.out.println("ERROR AL BORRAR CLIENTE");
            e.printStackTrace();

        }
    }
    
    /*Metodo para validar si el cliente ya existe en la base de datos 
    y asi no tener dobles registros
    retorna true si existe el resgitro
    retorna false si no existe*/
    
    public boolean ValidarClienteAgregar(String rut)
    {
        try {
              Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "SELECT c.C_RUT AS C_RUT, c.C_NOMBRE AS C_NOMBRE,"
                    + "c.C_DIRECCION AS C_DIRECCION, "
                    + "c.C_FECHANACIMIENTO AS C_FECHANACIMIENTO, "
                    + "c.C_CORREO AS C_CORREO, c.C_SEXO AS C_SEXO "
                    + "FROM medipet.cliente c WHERE C_RUT = '"+rut+"';";

            ResultSet rs = stms.executeQuery(consulta);
              
            if(rs.first())        // si es valido el primer reg. hay una fila, 
               return true;        //cliente validado correctamente
            else
               return false;    
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
