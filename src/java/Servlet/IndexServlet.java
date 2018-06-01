/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorCliente;
import Controlador.ControladorIngreso;
import Controlador.ControladorMascota;
import Controlador.ControladorPerfil;
import Controlador.ControladorTipoAnimal;
import Controlador.ControladorUsuario;
import Modelo.Animal;
import Modelo.Cliente;
import Modelo.Ingreso;
import Modelo.Mascota;
import Modelo.Perfil;
import Modelo.Usuario;
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
@WebServlet(name = "IndexServlet", urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {

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
            //traigo los valores del JSP index
            String ok = request.getParameter("inicio");
            //traigo los valores del JSP login
            String btnLogin = request.getParameter("btnLogin");
            //traigo los valores del JSP menu Admin          
            String btn_mostrarPerfil = request.getParameter("btn_mostrarPerfil");
            String btn_mostrarUsuario = request.getParameter("btn_mostrarUsuario");
            String btn_mostrarCliente = request.getParameter("btn_mostrarCliente");
            String btn_mostrarAtenciones = request.getParameter("btn_mostrarAtenciones");
            String btn_mostrarMascotas = request.getParameter("btn_mostrarMascotas");
            String btn_mostrarTipo = request.getParameter("btn_mostrarTipo");
            //recupero la sesion
            HttpSession session = request.getSession(true);
            
            session.setAttribute("TIPO_USUARIO", "adm");
            //inicializo al controlador de usuario
            ControladorUsuario usuario = new ControladorUsuario();
            //cuando el usuario entra por primera vez al sistema, debe 
            // validar si existe un usuario administrador, 
            //si existe debe redijir al login, si no al JSP agregar admin
            if (ok != null) {

                if (!usuario.validaExisteAdmin()) {
                    Util.Util.dispatcher(request, response, "/administrador/Administrador.jsp");
                } else {
                    Util.Util.dispatcher(request, response, "/login.jsp");
                }
            }
            //Cuando se logea, se debe validar si el usuario es administrador u otro perfil
            //si es otro perfil debe entrar al menu usuario
            //si es perfil adminstrador debe entrar al menu administrador
            else if(btnLogin != null){
                String correo = request.getParameter("txtUsuario");
                if (!usuario.validaMenu(correo)) {
                    Util.Util.dispatcher(request, response, "/usuario/MenuUsuario.jsp");
                } else {
                    Util.Util.dispatcher(request, response, "/administrador/MenuAdmin.jsp");
                }                
            }          
            //Muestra una lista de perfiles que se encuentran en la DDBB
            else if (btn_mostrarPerfil != null) {
                ControladorPerfil perfil = new ControladorPerfil();
                List<Perfil> listaPerfil = perfil.getListaPerfil();
                session.setAttribute("Lista_Perfil", listaPerfil);
                Util.Util.dispatcher(request, response, "/perfil/MostrarPerfil.jsp");
                //Muestra una lista de Usuarios que se encuentran en la DDBB
            } else if (btn_mostrarUsuario != null) {
                List<Usuario> listaUsuario = usuario.getListaUsuario();
                session.setAttribute("Lista_Usuario", listaUsuario);
                Util.Util.dispatcher(request, response, "/usuario/MostrarUsuario.jsp");
                //Muestra una lista de Clientes que se encuentran en la DDBB
            } else if (btn_mostrarCliente != null) {
                ControladorCliente cliente = new ControladorCliente();
                List<Cliente> listaCliente = cliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                Util.Util.dispatcher(request, response, "/cliente/MostrarCliente.jsp");
                //Muestra una lista de Atenciones que se encuentran en la DDBB
            } else if (btn_mostrarAtenciones != null) {
                ControladorIngreso ingreso = new ControladorIngreso();
                List<Ingreso> listaIngreso = ingreso.getListaIngreso();
                session.setAttribute("Lista_Ingreso", listaIngreso);
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngreso.jsp");
            } //Muestra una lista de MAscotas que se encuentran en la DDBB
            else if (btn_mostrarMascotas != null) {
                ControladorMascota mascota = new ControladorMascota();
                List<Mascota> listaMascota = mascota.getListaMascota();
                session.setAttribute("Lista_Mascota", listaMascota);
                Util.Util.dispatcher(request, response, "/mascota/MostrarMascota.jsp");
            } //Muestra una lista de los tipos de animales que se atienden que se encuentran en la DDBB
            else if (btn_mostrarTipo != null) {
                ControladorTipoAnimal tipo = new ControladorTipoAnimal();
                List<Animal> listaTipo = tipo.getListaTipoAnimal();
                session.setAttribute("Lista_Tipo", listaTipo);
                Util.Util.dispatcher(request, response, "/tipoAnimal/MostrarTipoAnimal.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IndexServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IndexServlet at " + request.getContextPath() + "</h1>");
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
