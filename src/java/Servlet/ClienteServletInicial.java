/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "ClienteServletInicial", urlPatterns = {"/ClienteServletInicial"})
public class ClienteServletInicial extends HttpServlet {

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
            //trae los valores del jsp MostrarClientes
            String accion = request.getParameter("ACCION");
            //setea la session
            HttpSession session = request.getSession();
            //si el boton agregar Cliente es clickeado va al JSP que tiene el 
            //formulario para agregar al cliente
            if ("AGREGAR".equals(accion)) {
                Util.Util.dispatcher(request, response, "/cliente/AgregarCliente.jsp");
                return;
            } //si el boton eliminar es clickeado va al JSP que permite realizar la 
            //accion de eliminar filtrando por rut de Cliente
            else if ("ELIMINAR".equals(accion)) {
                Util.Util.dispatcher(request, response, "/cliente/EliminarCliente.jsp");
                return;
            } else if ("MODIFICAR".equals(accion)) {
                String rut = request.getParameter("rutmod");
                String nombre = request.getParameter("nombremod");
                String direccion = request.getParameter("direccionMod");
                String fecha = request.getParameter("fechaMod");
                String correo = request.getParameter("correoMod");
                String sexo = request.getParameter("sexoMod");
                Date f = Util.Util.stringADate(fecha);
                //creo el objeto perfil
                String f1 = Util.Util.getFechaFormateadaSalida(f);
                Cliente c = new Cliente(rut, nombre, direccion, f, f1,correo, sexo);
                
                session.setAttribute("Cliente", c);
                Util.Util.dispatcher(request, response, "/cliente/ModificarCliente.jsp");
                return;
            } //Vuelve a la Pagina Inicial
            else if ("VOLVER".equals(accion)) {
                
                String tipoUsuario = (String) session.getAttribute("TIPO_USUARIO");
                if ("adm".equals(tipoUsuario)) {
                    Util.Util.dispatcher(request, response, "/administrador/MenuAdmin.jsp");
                }else{
                    Util.Util.dispatcher(request, response, "/usuario/MenuUsuario.jsp");
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteServletInicial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteServletInicial at " + request.getContextPath() + "</h1>");
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
