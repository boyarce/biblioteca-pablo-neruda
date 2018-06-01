/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDBB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Daniela
 */
public class Conexion {
    
    private final static String serverName = "localhost:3306";
    private final static String user = "medipet";
    private final static String pass = "123456";
    
    //metodo que realiza la conexion
    
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Connection x = null;
        Properties connectionProps = new Properties();
        String dbName = "medipet";
        connectionProps.put("user",user);
        connectionProps.put("password", pass);
        
        Class.forName("com.mysql.jdbc.Driver");
        
        x = DriverManager.getConnection("jdbc:mysql://"+serverName+"/"+dbName,connectionProps);
        System.out.println("CONEXION EXISTOSA!");
        return x;
    }
    /*Metodo que destruye la conexion*/
    public static void destroy(Connection cnx, Statement csmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
        }
        try {
            if (csmt != null) {
                csmt.close();
            }
        } catch (Exception e) {
        }
        try {
            if (cnx != null) {
                cnx.close();
                System.out.println("Conexion Cerrada!!");
            }
        } catch (Exception e) {
        }
    }
}
