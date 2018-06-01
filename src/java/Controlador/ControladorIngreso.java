/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DDBB.Conexion;
import Modelo.Ingreso;
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
public class ControladorIngreso {

    /**
     * Metodo para la creacion de registros en la tabla
     *
     * @param ingreso
     */
    public void AgregarIngreso(Ingreso consulta) {
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String sql = "INSERT INTO medipet.ingreso(AT_ID_ATENCION, "
                    + "AT_FECHA_ATENCION, AT_IDMASCOTA, AT_U_RUT, AT_RUT_MEDICO, "
                    + "AT_C_RUT, AT_DESCRIPCION_SINTOMAS, CO_DIAGNOSTICO, "
                    + "CO_PROCEDIMIENTO, CO_VALORCONSULTA)VALUES (" + consulta.getIdAtencion() + ","
                    + simple.format(consulta.getFechaAtencion()) + ","
                    + consulta.getIdMascota() + ",'" + consulta.getRutUsuario()
                    + "','" + consulta.getRutMedico() + "','"
                    + consulta.getRutCliente() + "','"
                    + consulta.getDescripcionSintomas() + "','"
                    + consulta.getDiagnostico() + "','"
                    + consulta.getProcedimiento() + "',"
                    + consulta.getValorConsulta() + ")";

            stms.executeUpdate(sql);
            System.out.println("INGRESO ALMACENADO OK");
        } catch (Exception e) {
            System.out.println("ERROR AL ALMACENAR INGRESO");
            e.printStackTrace();

        }

    }

    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Ingreso'
     *
     *
     * @return
     */
    public ArrayList<Ingreso> getListaIngreso() {
        ArrayList<Ingreso> lista = new ArrayList<>();
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "SELECT i.AT_ID_ATENCION AS AT_ID_ATENCION, "
                    + "i.AT_FECHA_ATENCION AS AT_FECHA_ATENCION, "
                    + "i.AT_IDMASCOTA AS AT_IDMASCOTA, i.AT_U_RUT AS AT_U_RUT, "
                    + "i.AT_RUT_MEDICO AS AT_RUT_MEDICO, i.AT_C_RUT AS AT_C_RUT, "
                    + "i.AT_DESCRIPCION_SINTOMAS AS AT_DESCRIPCION_SINTOMAS, "
                    + "i.CO_DIAGNOSTICO AS CO_DIAGNOSTICO, "
                    + "i.CO_PROCEDIMIENTO AS CO_PROCEDIMIENTO, "
                    + "i.CO_VALORCONSULTA AS CO_VALORCONSULTA "
                    + "FROM medipet.ingreso i";

            ResultSet rs = stms.executeQuery(consulta);
            while (rs.next()) {
                Ingreso ingreso = new Ingreso();
                int IdAtencion = rs.getInt("AT_ID_ATENCION");
                Date FechaAtencion1 = rs.getDate("AT_FECHA_ATENCION");
                int atIdmascota1 = rs.getInt("AT_IDMASCOTA");
                String atURut1 = rs.getString("AT_U_RUT");
                String atRutMedico1 = rs.getString("AT_RUT_MEDICO");
                String atCRut1 = rs.getString("AT_C_RUT");
                String atDescripcionSintomas1 = rs.getString("AT_DESCRIPCION_SINTOMAS");
                String coDiagnostico1 = rs.getString("CO_DIAGNOSTICO");
                String coProcedimiento1 = rs.getString("CO_PROCEDIMIENTO");
                int coValorconsulta1 = rs.getInt("CO_VALORCONSULTA");

                ingreso.setIdAtencion(IdAtencion);
                ingreso.setFechaAtencion(FechaAtencion1);
                ingreso.setIdMascota(atIdmascota1);
                ingreso.setRutUsuario(atURut1);
                ingreso.setRutMedico(atRutMedico1);
                ingreso.setRutCliente(atCRut1);
                ingreso.setDescripcionSintomas(atDescripcionSintomas1);
                ingreso.setDiagnostico(coDiagnostico1);
                ingreso.setProcedimiento(coProcedimiento1);
                ingreso.setValorConsulta(coValorconsulta1);

                lista.add(ingreso);
            }
            return lista;
        } catch (Exception e) {

            System.out.println();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Ingreso'
     *
     *
     * @return
     */
    public ArrayList<Ingreso> getIngresoPorMascota(int idMascota) {
        ArrayList<Ingreso> lista = new ArrayList<>();
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "SELECT i.AT_ID_ATENCION AS AT_ID_ATENCION, "
                    + "i.AT_FECHA_ATENCION AS AT_FECHA_ATENCION, "
                    + "i.AT_IDMASCOTA AS AT_IDMASCOTA, i.AT_U_RUT AS AT_U_RUT, "
                    + "i.AT_RUT_MEDICO AS AT_RUT_MEDICO, i.AT_C_RUT AS AT_C_RUT, "
                    + "i.AT_DESCRIPCION_SINTOMAS AS AT_DESCRIPCION_SINTOMAS, "
                    + "i.CO_DIAGNOSTICO AS CO_DIAGNOSTICO, "
                    + "i.CO_PROCEDIMIENTO AS CO_PROCEDIMIENTO, "
                    + "i.CO_VALORCONSULTA AS CO_VALORCONSULTA "
                    + "FROM medipet.ingreso i WHERE i.AT_IDMASCOTA = " + idMascota;

            ResultSet rs = stms.executeQuery(consulta);
            while (rs.next()) {
                Ingreso ingreso = new Ingreso();
                int IdAtencion = rs.getInt("AT_ID_ATENCION");
                Date FechaAtencion1 = rs.getDate("AT_FECHA_ATENCION");
                int atIdmascota1 = rs.getInt("AT_IDMASCOTA");
                String atURut1 = rs.getString("AT_U_RUT");
                String atRutMedico1 = rs.getString("AT_RUT_MEDICO");
                String atCRut1 = rs.getString("AT_C_RUT");
                String atDescripcionSintomas1 = rs.getString("AT_DESCRIPCION_SINTOMAS");
                String coDiagnostico1 = rs.getString("CO_DIAGNOSTICO");
                String coProcedimiento1 = rs.getString("CO_PROCEDIMIENTO");
                int coValorconsulta1 = rs.getInt("CO_VALORCONSULTA");

                ingreso.setIdAtencion(IdAtencion);
                ingreso.setFechaAtencion(FechaAtencion1);
                ingreso.setIdMascota(atIdmascota1);
                ingreso.setRutUsuario(atURut1);
                ingreso.setRutMedico(atRutMedico1);
                ingreso.setRutCliente(atCRut1);
                ingreso.setDescripcionSintomas(atDescripcionSintomas1);
                ingreso.setDiagnostico(coDiagnostico1);
                ingreso.setProcedimiento(coProcedimiento1);
                ingreso.setValorConsulta(coValorconsulta1);

                lista.add(ingreso);
            }
            return lista;
        } catch (Exception e) {

            System.out.println();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para el retorno de un listado de objetos del tipo 'Ingreso'
     *
     *
     * @return
     */
    public ArrayList<Ingreso> getIngresoXCliente(String rut) {
        ArrayList<Ingreso> lista = new ArrayList<>();
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();

            String consulta = "SELECT i.AT_ID_ATENCION AS AT_ID_ATENCION, "
                    + "i.AT_FECHA_ATENCION AS AT_FECHA_ATENCION, "
                    + "i.AT_IDMASCOTA AS AT_IDMASCOTA, i.AT_U_RUT AS AT_U_RUT, "
                    + "i.AT_RUT_MEDICO AS AT_RUT_MEDICO, i.AT_C_RUT AS AT_C_RUT, "
                    + "i.AT_DESCRIPCION_SINTOMAS AS AT_DESCRIPCION_SINTOMAS, "
                    + "i.CO_DIAGNOSTICO AS CO_DIAGNOSTICO, "
                    + "i.CO_PROCEDIMIENTO AS CO_PROCEDIMIENTO, "
                    + "i.CO_VALORCONSULTA AS CO_VALORCONSULTA "
                    + "FROM medipet.ingreso i where i.AT_C_RUT = '" + rut + "'";

            ResultSet rs = stms.executeQuery(consulta);
            while (rs.next()) {
                Ingreso ingreso = new Ingreso();
                int IdAtencion = rs.getInt("AT_ID_ATENCION");
                Date FechaAtencion1 = rs.getDate("AT_FECHA_ATENCION");
                int atIdmascota1 = rs.getInt("AT_IDMASCOTA");
                String atURut1 = rs.getString("AT_U_RUT");
                String atRutMedico1 = rs.getString("AT_RUT_MEDICO");
                String atCRut1 = rs.getString("AT_C_RUT");
                String atDescripcionSintomas1 = rs.getString("AT_DESCRIPCION_SINTOMAS");
                String coDiagnostico1 = rs.getString("CO_DIAGNOSTICO");
                String coProcedimiento1 = rs.getString("CO_PROCEDIMIENTO");
                int coValorconsulta1 = rs.getInt("CO_VALORCONSULTA");

                ingreso.setIdAtencion(IdAtencion);
                ingreso.setFechaAtencion(FechaAtencion1);
                ingreso.setIdMascota(atIdmascota1);
                ingreso.setRutUsuario(atURut1);
                ingreso.setRutMedico(atRutMedico1);
                ingreso.setRutCliente(atCRut1);
                ingreso.setDescripcionSintomas(atDescripcionSintomas1);
                ingreso.setDiagnostico(coDiagnostico1);
                ingreso.setProcedimiento(coProcedimiento1);
                ingreso.setValorConsulta(coValorconsulta1);

                lista.add(ingreso);
            }
            return lista;
        } catch (Exception e) {

            System.out.println();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo para la actualizacion de registros en la tabla 'medipet.ingreso'.
     *
     * @param consulta
     */
    public void ModificarIngreso(Ingreso consulta) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String sql = "UPDATE medipet.ingreso i SET i.AT_ID_ATENCION = "
                    + consulta.getIdAtencion() + " ,i.AT_FECHA_ATENCION = "
                    + consulta.getFechaAtencion() + " ,i.AT_IDMASCOTA = "
                    + consulta.getIdMascota() + " ,i.AT_U_RUT = '"
                    + consulta.getRutUsuario() + "' ,i.AT_RUT_MEDICO = '"
                    + consulta.getRutMedico() + "' ,i.AT_C_RUT = '"
                    + consulta.getRutCliente() + "' ,i.AT_DESCRIPCION_SINTOMAS = '"
                    + consulta.getDescripcionSintomas() + "' ,i.CO_DIAGNOSTICO = '"
                    + consulta.getDiagnostico() + "' ,i.CO_PROCEDIMIENTO = '"
                    + consulta.getProcedimiento() + "' ,i.CO_VALORCONSULTA = "
                    + consulta.getValorConsulta() + " WHERE i.AT_ID_ATENCION = "
                    + consulta.getIdAtencion() + ";";

            stms.executeUpdate(sql);
            System.out.println("INGRESO ACTUALIZADO");
        } catch (Exception e) {

            System.out.println("ERROR AL ACTUALIZAR INGRESO");
            e.printStackTrace();

        }
    }

    /**
     * Metodo para la eliminacion de un registro en la tabla 'medipet.ingreso'
     *
     * @param idAtencion
     */
    public void BorrarIngreso(int idAtencion) {
        try {
            Conexion conn = new Conexion();
            Connection conexion;
            conexion = conn.getConnection();
            Statement stms = conexion.createStatement();
            String consulta = "DELETE FROM medipet.ingreso WHERE AT_ID_ATENCION = " + idAtencion + ";";

            stms.executeUpdate(consulta);
            System.out.println("INGRESO BORRADO OK");
        } catch (Exception e) {

            System.out.println("ERROR AL BORRAR INGRESO");
            e.printStackTrace();

        }
    }
}
