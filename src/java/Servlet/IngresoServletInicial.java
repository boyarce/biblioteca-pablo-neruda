/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorCliente;
import Controlador.ControladorPerfil;
import Controlador.ControladorMascota;
import Controlador.ControladorUsuario;

import Modelo.Cliente;
import Modelo.Ingreso;
import Modelo.Mascota;
import Modelo.Perfil;
import Modelo.Usuario;
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
@WebServlet(name = "IngresoServletInicial", urlPatterns = {"/IngresoServletInicial"})
public class IngresoServletInicial extends HttpServlet {

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
            //trae los valores del jsp MostrarAtenciones
            String accion = request.getParameter("ACCION");
            
            //setea la session
            HttpSession session = request.getSession();
            //Crea las Instanciaas controladoras necesarias para realizar el 
            //listado que se necesita en los JSP de CRUD
            ControladorUsuario usuario = new ControladorUsuario();
            ControladorPerfil perfil = new ControladorPerfil();
            ControladorCliente cliente = new ControladorCliente();
            ControladorMascota mascota = new ControladorMascota();
            // si quiere agregar
            if ("AGREGAR".equals(accion)) {
                List<Usuario> listaUsuario = usuario.getListaUsuario();
                session.setAttribute("Lista_Usuario", listaUsuario);
                List<Usuario> listaRutMedico = usuario.getRutMedico();
                session.setAttribute("Lista_RutMedico", listaRutMedico);
                List<Cliente> listaCliente = cliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                List<Perfil> listaPerfil = perfil.getListaPerfil();
                session.setAttribute("Lista_Perfil", listaPerfil);
                List<Mascota> listaTipo = mascota.getListaMascota();
                session.setAttribute("Lista_Mascota", listaTipo);
                //redirije al JSP AgregarClientes
                Util.Util.dispatcher(request, response, "/paciente/AgregarIngreso.jsp");
            } // si quiere Eliminar
            else if ("ELIMINAR".equals(accion)) {
                //redirije al JSP Eliminar CLiente
                Util.Util.dispatcher(request, response, "/paciente/EliminarIngreso.jsp");
            } else if ("MODIFICAR".equals(accion)) {
                List<Usuario> listaUsuario = usuario.getListaUsuario();
                session.setAttribute("Lista_Usuario", listaUsuario);
                List<Usuario> listaRutMedico = usuario.getRutMedico();
                session.setAttribute("Lista_RutMedico", listaRutMedico);
                List<Cliente> listaCliente = cliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                List<Perfil> listaPerfil = perfil.getListaPerfil();
                session.setAttribute("Lista_Perfil", listaPerfil);
                List<Mascota> listaTipo = mascota.getListaMascota();
                session.setAttribute("Lista_Mascota", listaTipo);
                //traigo los valores del JSP 
                String ID = request.getParameter("idAtencionMod");
                int id = Integer.parseInt(ID);
                String fecha = request.getParameter("fechaMod");
                String rutUsuario = request.getParameter("rutUsuarioMod");
                String rutMedico = request.getParameter("rutMedicoMod");
                String rutCliente = request.getParameter("rutClienteMod");
                String TipoMascota = request.getParameter("idMascotaMod");
                String descripcion = request.getParameter("descripcionMod");
                String diagnostico = request.getParameter("diagnnosticoMod");
                String procedimiento = request.getParameter("procedimientoMod");
                String valor = request.getParameter("valorMod");
                Date f = Util.Util.stringADate(fecha);
                int t = Integer.parseInt(TipoMascota);
                int v = Integer.parseInt(valor);
                //creo el objeto 
                Ingreso i = new Ingreso(id, f, t, rutUsuario, rutMedico, rutCliente, descripcion, diagnostico, procedimiento, v);
                //guardo el objeto en la session
                session.setAttribute("Ingreso", i);
                Util.Util.dispatcher(request, response, "/paciente/ModificarIngreso.jsp");
            } //vuelve a la pagina INicial
            else if ("VOLVER".equals(accion)) {

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
            out.println("<title>Servlet IngresoServletInicial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IngresoServletInicial at " + request.getContextPath() + "</h1>");
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
