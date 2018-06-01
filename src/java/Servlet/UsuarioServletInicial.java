/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorPerfil;
import Modelo.Perfil;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "UsuarioServletInicial", urlPatterns = {"/UsuarioServletInicial"})
public class UsuarioServletInicial extends HttpServlet {

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
            // recupero la session
            HttpSession session = request.getSession(true);
            //traigo los valores del JSp mostrar
            String accion = request.getParameter("ACCION");
            //si quiere agregar
            if ("AGREGAR".equals(accion)) {
                // llamo al metodo listar
                List<Perfil> lista = perfilListar();
                //lo guardo en la sesion
                session.setAttribute("Lista_Perfil", lista);
                //redirije al JSP Agregar
                Util.Util.dispatcher(request, response, "/usuario/AgregarUsuario.jsp");
            } else if ("ELIMINAR".equals(accion)) {
                //redirije al JSP eliminar
                Util.Util.dispatcher(request, response, "/usuario/EliminarUsuario.jsp");
            } else if ("MODIFICAR".equals(accion)) {
                //traigo los valores a modificar
                String rut = request.getParameter("rutmod");
                String nombre = request.getParameter("nombremod");
                String apellidoPaterno = request.getParameter("apPatMod");
                String apellidoMaterno = request.getParameter("apMatMod");
                String fechaNacimiento = request.getParameter("fecha");
                String correo = request.getParameter("correoMod");
                String password = request.getParameter("passwordMod");
                String idPerfil = request.getParameter("perfilMod");

                Date f = Util.Util.stringADate(fechaNacimiento);
                int i = Integer.parseInt(idPerfil);
                //creo el objeto usuario
                Usuario u = new Usuario(rut, nombre, apellidoPaterno, apellidoMaterno, f, correo, password, i);
                //lo guardo en la sesion
                session.setAttribute("Usuario", u);
                //llamo al metodo listar perfiles
                List<Perfil> lista = perfilListar();
                //lo guardo en la sesion
                session.setAttribute("Lista_Perfil", lista);
                Util.Util.dispatcher(request, response, "/usuario/ModificarUsuario.jsp");
                // si quiere eliminar
            } //si quiere volver al menu
            else if ("VOLVER".equals(accion)) {
                //redirije al JSP del menu

                String tipoUsuario = (String) session.getAttribute("TIPO_USUARIO");
                if ("adm".equals(tipoUsuario)) {
                    Util.Util.dispatcher(request, response, "/administrador/MenuAdmin.jsp");
                } else {
                    Util.Util.dispatcher(request, response, "/usuario/MenuUsuario.jsp");
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServletInicial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServletInicial at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    //Arraylist que obtiene la lista de perfiles
    public List<Perfil> perfilListar() {

        try {
            ControladorPerfil ctrlperfil = new ControladorPerfil();
            return ctrlperfil.getListaPerfil();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
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
