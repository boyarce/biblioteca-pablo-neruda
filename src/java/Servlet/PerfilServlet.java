/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.Perfil;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletPerfil", urlPatterns = {"/ServletPerfil"})
public class PerfilServlet extends HttpServlet {

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
            //traigo los valores del JSP Mostrar
            String accion = request.getParameter("ACCION");
            HttpSession session = request.getSession();

            //si quiere agregar
            if ("AGREGAR".equals(accion)) {
                //redijiro al JSP Agregar
                Util.Util.dispatcher(request, response, "/perfil/AgregarPerfil.jsp");
                return;
            } else if ("ELIMINAR".equals(accion)) {
                //redijiro al JSP eliminar
                Util.Util.dispatcher(request, response, "/perfil/EliminarPerfil.jsp");
                return;
            } else if ("MODIFICAR".equals(accion)) {

                String idPerfil = request.getParameter("idperfilmod");
                String nombre = request.getParameter("nombremod");
                System.out.println("" + idPerfil);
                int id = Integer.parseInt(idPerfil);
                //creo el objeto perfil
                Perfil p = new Perfil(id, nombre);
                session.setAttribute("Perfil", p);
                Util.Util.dispatcher(request, response, "/perfil/ModificarPerfil.jsp");
                return;
            } // si quiere eliminar
            // si quiere volver a la pagina inicial
            else if ("VOLVER".equals(accion)) {
                //redijiro al JSP INdex

                String tipoUsuario = (String) session.getAttribute("TIPO_USUARIO");
                if ("adm".equals(tipoUsuario)) {
                    Util.Util.dispatcher(request, response, "/administrador/MenuAdmin.jsp");
                } else {
                    Util.Util.dispatcher(request, response, "/usuario/MenuUsuario.jsp");
                }
                return;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPerfil</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPerfil at " + request.getContextPath() + "</h1>");
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
