/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorCliente;
import Controlador.ControladorIngreso;
import Controlador.ControladorMascota;
import Modelo.Cliente;
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
@WebServlet(name = "IndexUsuarios", urlPatterns = {"/IndexUsuarios"})
public class IndexUsuarios extends HttpServlet {

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
            //traigo los valores del  JSP menu ususario            

            String accion = request.getParameter("ACCION");
            //recupero la sesion
            HttpSession session = request.getSession(true);
            session.setAttribute("TIPO_USUARIO", "usuario");
            //Muestra una lista de Cliente que se encuentran en la DDBB
            if ("MOSTRAR_CLIENTE".equals(accion)) {
                ControladorCliente cliente = new ControladorCliente();
                List<Cliente> listaCliente = cliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                Util.Util.dispatcher(request, response, "/cliente/MostrarCliente.jsp");
                //Muestra una lista de Atenciones que se encuentran en la DDBB
            } else if ("MOSTRAR_ATENCIONES".equals(accion)) {
                ControladorIngreso ingreso = new ControladorIngreso();
                List<Ingreso> listaIngreso = ingreso.getListaIngreso();
                session.setAttribute("Lista_Ingreso", listaIngreso);
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngreso.jsp");
            } //Muestra una lista de MAscotas que se encuentran en la DDBB
            else if ("MOSTRAR_MASCOTAS".equals(accion)) {
                ControladorMascota mascota = new ControladorMascota();
                List<Mascota> listaMascota = mascota.getListaMascota();
                session.setAttribute("Lista_Mascota", listaMascota);
                Util.Util.dispatcher(request, response, "/mascota/MostrarMascota.jsp");
            }else if("BUSCAR_MAS_X_CLI".equals(accion)){
                Util.Util.dispatcher(request, response, "/busquedas/buscarMascotaXCliente.jsp");
            }else if("BUSCAR_AT_X_CLI".equals(accion)){
                Util.Util.dispatcher(request, response, "/busquedas/buscarAtencionXCliente.jsp");
            }else if("BUSCAR_AT_X_MAS".equals(accion)){
                Util.Util.dispatcher(request, response, "/busquedas/buscarAtencionXMascota.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IndexUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IndexUsuarios at " + request.getContextPath() + "</h1>");
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
