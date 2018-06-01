/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorCliente;
import Controlador.ControladorTipoAnimal;
import Modelo.Animal;
import Modelo.Cliente;
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
@WebServlet(name = "MascotaServletInicial", urlPatterns = {"/MascotaServletInicial"})
public class MascotaServletInicial extends HttpServlet {

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
            //trae los valores del JSP MOSTRAR
            String accion = request.getParameter("ACCION");
            //recupera la sesion
            HttpSession session = request.getSession();
            //crea la instancias controladoras para las acciones de
            //listado que se necesita en los JSP de CRUD
            ControladorCliente cliente = new ControladorCliente();
            ControladorTipoAnimal tipo = new ControladorTipoAnimal();
            //si quiere agregar nueva mascota
            if ("AGREGAR".equals(accion)) {
                List<Cliente> listaCliente = cliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                List<Animal> listaTipo = tipo.getListaTipoAnimal();
                session.setAttribute("Lista_TipoAnimal", listaTipo);
                //redijire al JSP AGREGAR
                Util.Util.dispatcher(request, response, "/mascota/AgregarMascota.jsp");
                return;
            } else if ("MODIFICAR".equals(accion)) {
                List<Cliente> listaCliente = cliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                List<Animal> listaTipo = tipo.getListaTipoAnimal();
                session.setAttribute("Lista_TipoAnimal", listaTipo);

                String idmascota = request.getParameter("idmascotamod");
                String tipomascota = request.getParameter("tipomascotamod");
                String rutcliente = request.getParameter("rutclientemod");
                String nombre = request.getParameter("nombremod");
                String fecha = request.getParameter("fechamod");
                Date f = Util.Util.stringADate(fecha);
                int id = Integer.parseInt(idmascota);
                int tipomasc = Integer.parseInt(tipomascota);
                //creo el objeto mascota
                Mascota m = new Mascota(id, tipomasc, rutcliente, nombre, f);
                session.setAttribute("Mascota", m);
                Util.Util.dispatcher(request, response, "/mascota/ModificarMascota.jsp");
                return;
            } //vuelve a la pagina Inicial
            else if ("VOLVER".equals(accion)) {

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
            out.println("<title>Servlet MascotaServletInicial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MascotaServletInicial at " + request.getContextPath() + "</h1>");
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
