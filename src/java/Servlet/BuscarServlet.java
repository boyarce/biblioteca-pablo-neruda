/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorIngreso;
import Controlador.ControladorMascota;
import Modelo.Ingreso;
import Modelo.Mascota;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BuscarServlet", urlPatterns = {"/BuscarServlet"})
public class BuscarServlet extends HttpServlet {

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
            String accion = request.getParameter("ACCION");
            //setea la session
            HttpSession session = request.getSession();
            //si el boton agregar Cliente es clickeado va al JSP que tiene el 
            //formulario para agregar al cliente
            if ("BUSCAR_MASCOTA_X_CLIENTE".equals(accion)) {
                String rutCliente = request.getParameter("rutCliente");
                ControladorMascota mascota = new ControladorMascota();
                List<Mascota> listaMascota = mascota.getListaMascotaXCliente(rutCliente);
                session.setAttribute("Lista_Mascota", listaMascota);
                Util.Util.dispatcher(request, response, "/mascota/MostrarMascotaXCliente.jsp");
                return;
            } else if ("BUSCAR_ATENCION_X_CLIENTE".equals(accion)) {
                String rutCliente = request.getParameter("rutCliente");
                ControladorIngreso ingreso = new ControladorIngreso();
                List<Ingreso> listaIngreso = ingreso.getIngresoXCliente(rutCliente);
                session.setAttribute("Lista_Ingreso", listaIngreso);
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngresoXBusqueda.jsp");
                return;
            } else if ("BUSCAR_ATENCION_X_MASCOTA".equals(accion)) {
                String idMascota = request.getParameter("idMascota");
                int idMascotaInt = Integer.parseInt(idMascota);
                ControladorIngreso ingreso = new ControladorIngreso();
                List<Ingreso> listaIngreso = ingreso.getIngresoPorMascota(idMascotaInt);
                session.setAttribute("Lista_Ingreso", listaIngreso);
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngresoXBusqueda.jsp");
                return;
            } else if ("VOLVER".equals(accion)) {
                String tipoUsuario = (String) session.getAttribute("TIPO_USUARIO");
                if ("adm".equals(tipoUsuario)) {
                    Util.Util.dispatcher(request, response, "/administrador/MenuAdmin.jsp");
                }else{
                    Util.Util.dispatcher(request, response, "/usuario/MenuUsuario.jsp");
                }
                return;
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarServlet at " + request.getContextPath() + "</h1>");
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
