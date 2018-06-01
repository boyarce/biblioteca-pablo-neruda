/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniela
 */
public class Util {

    public static void dispatcher(HttpServletRequest request, HttpServletResponse response, String name) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(name);
        dispatcher.forward(request, response);
    }

    /*Metodo que formatea una fecha Date y retorna un String con formato Dia-Mes-Año*/
    public static String getFechaFormateada(Date date) {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        return fecha.format(date);
    }
    public static String getFechaFormateadaSalida(Date date) {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        return fecha.format(date);
    }
    /*Metodo que formatea un String y retorna un Date con formato AñoMesDia*/

    public static Date stringADate(String string) {
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        try {
            data = simple.parse(string);
            return data;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static Date stringADateFromHtml(String string) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        try {
            data = simple.parse(string);
            return data;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    /*Metodo que formatea una fecha Date y retorna un String con formato Dia-Mes-Año*/
    public static String dateaString(Date date) {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        return fecha.format(date);
    }

}
