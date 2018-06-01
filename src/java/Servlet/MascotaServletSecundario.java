/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorMascota;
import Modelo.Mascota;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniela
 */
@WebServlet(name = "MascotaServletSecundario", urlPatterns = {"/MascotaServletSecundario"})
public class MascotaServletSecundario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //recupero la sesion
            HttpSession session = request.getSession(true);
            //traigo los valores del JSP mostrar
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_modificar = request.getParameter("btn_modificar");
            //creo la instancia del controlador
            ControladorMascota crtlMascota = new ControladorMascota();

            // si agrega
            if (btn_agregar != null) {
                //traigo los valores del JSP
                String idMascota = request.getParameter("txt_idMascota");
                String rutCliente = request.getParameter("cmb_rutCliente_mascota");
                String tipoMascota = request.getParameter("cmb_tipoMascota");
                String nombre = request.getParameter("txt_mascota_nombre");
                String fecha = request.getParameter("fecha_nacimiento_mascota");
                int id = Integer.parseInt(tipoMascota);
                int idmasc = Integer.parseInt(idMascota);
                Date f = Util.Util.stringADate(fecha);
                //creo el Objeto mascota
                Mascota m = new Mascota(idmasc,id, rutCliente, nombre, f);
                //llamo al metodo ingresar a la DDBB
                crtlMascota.ingresarMascota(m);
                //llamo al metodo listar
                List<Mascota> listaMascota = crtlMascota.getListaMascota();
                // guardo la lista en la sesion
                session.setAttribute("Lista_Mascota", listaMascota);
                //redijiro al JSP mostrar
                Util.Util.dispatcher(request, response, "/mascota/MostrarMascota.jsp");
            } else if (btn_modificar != null) {
                String idMascota = request.getParameter("txt_idMascota");
                String rutCliente = request.getParameter("cmb_rutCliente_mascota");
                String tipoMascota = request.getParameter("cmb_tipoMascota");
                String nombre = request.getParameter("txt_mascota_nombre");
                String fecha = request.getParameter("fecha_nacimiento_mascota");
                int id = Integer.parseInt(tipoMascota);
                int idmasc = Integer.parseInt(idMascota);
                Date f = Util.Util.stringADate(fecha);

                Mascota m = new Mascota(idmasc,id, rutCliente, nombre, f);

                crtlMascota.modificarMascota(m);
                List<Mascota> listaMascota = crtlMascota.getListaMascota();
                session.setAttribute("Lista_Mascota", listaMascota);
                Util.Util.dispatcher(request, response, "/mascota/MostrarMascota.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MascotaServletSecundario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MascotaServletSecundario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
