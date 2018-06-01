/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.Animal;
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
@WebServlet(name = "TipoAnimalServlet", urlPatterns = {"/TipoAnimalServlet"})
public class TipoAnimalServlet extends HttpServlet {

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
            //Trae los valores del JSP Mostrar
            HttpSession session = request.getSession();
            String accion = request.getParameter("ACCION");
            //si quiere agregar
            if ("AGREGAR".equals(accion)) {
                //redirije al JSP Agregar
                Util.Util.dispatcher(request, response, "/tipoAnimal/AgregarTipoAnimal.jsp");
                return;
            } // si quiere eliminar 
            else if ("ELIMINAR".equals(accion)) {
                //redirije al JSP Eliminar
                Util.Util.dispatcher(request, response, "/tipoAnimal/EliminarTipoAnimal.jsp");
                return;
            } else if ("MODIFICAR".equals(accion)) {
                String idtipo = request.getParameter("idtipomod");
                String nombre = request.getParameter("nombremod");
                int id = Integer.parseInt(idtipo);
                //creo el objeto perfil
                Animal a = new Animal(id, nombre);
                session.setAttribute("Animal", a);
                Util.Util.dispatcher(request, response, "/tipoAnimal/ModificarTipoAnimal.jsp");
                return;
            } //si quiere volver al menu
            else if ("VOLVER".equals(accion)) {
                //redirije al menu

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
            out.println("<title>Servlet TipoAnimalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoAnimalServlet at " + request.getContextPath() + "</h1>");
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
