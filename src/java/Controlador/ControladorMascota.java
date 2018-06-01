/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DDBB.Conexion;
import Modelo.Mascota;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniela
 */
public class ControladorMascota {

    /**
     * Metodo para la creacion de registros en la tabla
     *
     * @param mascota
     */
    public void ingresarMascota(Mascota mascota) {
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "INSERT INTO medipet.mascota(M_IDMASCOTA,M_IDTIPO, "
                    + "M_CLIENTERUT, M_NOMBRE, M_FECHANACIMIENTO)VALUES (" + mascota.getIdMascota() + ","
                    + mascota.getIdTipo() + ", '" + mascota.getRutCliente()
                    + "','" + mascota.getNombre() + "',"
                    + simple.format(mascota.getFechaNacimiento()) + ")";

            stms.executeUpdate(consulta);
            System.out.println("MASCOTA ALMACENADA OK");
        } catch (Exception e) {

            System.out.println("ERROR AL ALMACENAR MASCOTA");
            e.printStackTrace();

        }
    }

    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Mascota'
     *
     * @return
     */
    public ArrayList<Mascota> getListaMascota() {
        ArrayList<Mascota> lista = new ArrayList<>();

        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "SELECT m.M_IDMASCOTA AS M_IDMASCOTA, "
                    + "m.M_IDTIPO AS M_IDTIPO, m.M_CLIENTERUT AS M_CLIENTERUT, "
                    + "m.M_NOMBRE AS M_NOMBRE, m.M_FECHANACIMIENTO AS M_FECHANACIMIENTO "
                    + "FROM medipet.mascota m";
            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            while (rs.next()) {
                Mascota mascota = new Mascota();
                int idmascota = rs.getInt("M_IDMASCOTA");
                int mIdtipo1 = rs.getInt("M_IDTIPO");
                String mClienterut1 = rs.getString("M_CLIENTERUT");
                String mNombre1 = rs.getString("M_NOMBRE");
                Date mFechanacimiento1 = rs.getDate("M_FECHANACIMIENTO");

                mascota.setIdMascota(idmascota);
                mascota.setIdTipo(mIdtipo1);
                mascota.setRutCliente(mClienterut1);
                mascota.setNombre(mNombre1);
                mascota.setFechaNacimiento(mFechanacimiento1);

                lista.add(mascota);
            }
            return lista;
        } catch (Exception e) {

            System.out.println("ERROR en query lista MASCOTAS");
            e.printStackTrace();
            return lista;
        }
    }

    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Mascota'
     *
     * @return
     */
    public ArrayList<Mascota> getListaMascotaXCliente(String rut) {
        ArrayList<Mascota> lista = new ArrayList<>();

        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "SELECT m.M_IDMASCOTA AS M_IDMASCOTA, "
                    + "m.M_IDTIPO AS M_IDTIPO, m.M_CLIENTERUT AS M_CLIENTERUT, "
                    + "m.M_NOMBRE AS M_NOMBRE, m.M_FECHANACIMIENTO AS M_FECHANACIMIENTO "
                    + "FROM medipet.mascota m where m.M_CLIENTERUT ='" + rut + "'";
            ResultSet rs = (ResultSet) stms.executeQuery(consulta);
            while (rs.next()) {
                Mascota mascota = new Mascota();
                int idmascota = rs.getInt("M_IDMASCOTA");
                int mIdtipo1 = rs.getInt("M_IDTIPO");
                String mClienterut1 = rs.getString("M_CLIENTERUT");
                String mNombre1 = rs.getString("M_NOMBRE");
                Date mFechanacimiento1 = rs.getDate("M_FECHANACIMIENTO");

                mascota.setIdMascota(idmascota);
                mascota.setIdTipo(mIdtipo1);
                mascota.setRutCliente(mClienterut1);
                mascota.setNombre(mNombre1);
                mascota.setFechaNacimiento(mFechanacimiento1);

                lista.add(mascota);
            }
            return lista;
        } catch (Exception e) {

            System.out.println("ERROR en query lista MASCOTAS");
            e.printStackTrace();
            return lista;
        }
    }

    /**
     * Metodo para la actualizacion de registros en la tabla
     *
     * @param mascota
     */
    public void modificarMascota(Mascota mascota) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "UPDATE medipet.mascota m SET m.M_IDMASCOTA = "
                    + mascota.getIdMascota() + " ,m.M_IDTIPO  ="
                    + mascota.getIdTipo() + ",m.M_CLIENTERUT = '"
                    + mascota.getRutCliente() + "' ,m.M_NOMBRE  = '"
                    + mascota.getNombre() + "' ,m.M_FECHANACIMIENTO = "
                    + mascota.getFechaNacimiento() + " WHERE m.M_IDMASCOTA = "
                    + mascota.getIdMascota() + ";";

            stms.executeUpdate(consulta);
            System.out.println("MASCOTA ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR AL ACTUALIZAR MASCOTA");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para la eliminacion de un registro en la tabla
     *
     * @param idmMascota
     */
    public void borrarMascota(String rut) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "DELETE FROM medipet.mascota WHERE M_CLIENTERUT = " + rut + ";";
            stms.executeUpdate(consulta);
            System.out.println(" MASCOTA BORRADO OK");
        } catch (Exception e) {

            System.out.println("ERROR AL BORRAR MASCOTA");
            e.printStackTrace();
        }
    }
}
