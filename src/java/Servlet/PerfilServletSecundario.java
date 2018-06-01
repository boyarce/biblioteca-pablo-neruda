/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorPerfil;
import Modelo.Perfil;
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
@WebServlet(name = "PerfilServletSecundario", urlPatterns = {"/PerfilServletSecundario"})
public class PerfilServletSecundario extends HttpServlet {

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
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_eliminar = request.getParameter("btn_eliminar");
            String btn_modificar = request.getParameter("btn_modificar");
            //creo la instancia del ControladorPerfil
            ControladorPerfil perfil = new ControladorPerfil();
            //recupero la session
            HttpSession session = request.getSession(true);
            //si quiere agregar
            if (btn_agregar != null) {

                try {
                    //traigo los valores del JSP Agregar
                    String idPerfil = request.getParameter("txt_IdPerfil");
                    String nombre = request.getParameter("txt_perfil_nombre");
                    int id = Integer.parseInt(idPerfil);
                    //creo el objeto perfil
                    Perfil p = new Perfil(id, nombre);
                    //llamo al metodo insertar en la DDBB
                    perfil.insertar(p);
                    //llamo al metodo listar
                    List<Perfil> lista = perfil.getListaPerfil();
                    //guardo la lista en la sesion
                    session.setAttribute("Lista_Perfil", lista);
                    //redirijo al JSP Mostrar
                    Util.Util.dispatcher(request, response, "/perfil/MostrarPerfil.jsp");

                } catch (Exception w) {
                    w.printStackTrace();
                }
            } else if (btn_eliminar != null) {
                //traigo los valores del JSP eliminar
                String id = request.getParameter("cmb_perfilUsuario");
                int i = Integer.parseInt(id);
                //llamo al metodo eliminar de la DDBB
                perfil.borrarPerfil(i);
                //llamo al metodo listar
                List<Perfil> lista = perfil.getListaPerfil();
                //guardo la lista en la sesion
                session.setAttribute("Lista_Perfil", lista);
                //redirijo al JSP Mostrar
                Util.Util.dispatcher(request, response, "/perfil/MostrarPerfil.jsp");

            } else if (btn_modificar != null) {

                String i = request.getParameter("txt_perfil_id");
                String nombre = request.getParameter("txt_perfil_nombre");
                int id = Integer.parseInt(i);
                Perfil p = new Perfil(id, nombre);
                perfil.modificarPerfil(p);
                List<Perfil> lista = perfil.getListaPerfil();
                session.setAttribute("Lista_Perfil", lista);
                Util.Util.dispatcher(request, response, "/perfil/MostrarPerfil.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PerfilServletSecundario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PerfilServletSecundario at " + request.getContextPath() + "</h1>");
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
