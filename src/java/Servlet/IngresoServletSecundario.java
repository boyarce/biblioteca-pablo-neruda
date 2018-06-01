/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorIngreso;
import Modelo.Ingreso;
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
@WebServlet(name = "IngresoServletSecundario", urlPatterns = {"/IngresoServletSecundario"})
public class IngresoServletSecundario extends HttpServlet {

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
            //recupera la sesion
            HttpSession session = request.getSession(true);
            // trae los botones del JSP MostrarAtenaciones
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_Eliminar = request.getParameter("btn_Eliminar");
            String btn_modificar = request.getParameter("btn_modificar");
            //instancia al COntroladorIngreso
            ControladorIngreso crtlIngreso = new ControladorIngreso();

            if (btn_agregar != null) {
                //trae los valores del JSP Agregar
                String ID = request.getParameter("txt_IDAtencion");
                int id = Integer.parseInt(ID);
                String fecha = request.getParameter("fecha_atencion");
                String RutUsuario = request.getParameter("cmb_RutUsuarioIngreso");
                String RutMedico = request.getParameter("cmb_RutMedicoIngreso");
                String RutCliente = request.getParameter("cmb_RutClienteIngreso");
                String TipoMascota = request.getParameter("cmb_TipoMascotaIngreso");
                String Descripcion = request.getParameter("txt_DescripcionIngreso");
                String diagnostico = request.getParameter("txt_DIAGNOSTICOIngreso");
                String procedimiento = request.getParameter("txt_PROCEDIMIENTOIngreso");
                String valor = request.getParameter("txt_VALORCONSULTAIngreso");
                Date f = Util.Util.stringADate(fecha);
                int t = Integer.parseInt(TipoMascota);
                int v = Integer.parseInt(valor);
                //Crea el Objeto Ingreso
                Ingreso i = new Ingreso(id,f, t, RutUsuario, RutMedico, RutCliente, Descripcion, diagnostico, procedimiento, v);
                //Llama al metodo agregar a la DDBB
                crtlIngreso.AgregarIngreso(i);
                //llama al metodo listar
                List<Ingreso> lista = crtlIngreso.getListaIngreso();
                //setea la lista en la sesion
                session.setAttribute("Lista_Ingreso", lista);
                //redirije al JSP mostrar
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngreso.jsp");

            } else if (btn_Eliminar != null) {
                //trae los valores del JSP eliminar
                String idEliminar = request.getParameter("txt_numeroAEliminar");
                int id = Integer.parseInt(idEliminar);
                // llama al metodo borrar
                crtlIngreso.BorrarIngreso(id);
                //llama al metodo listar
                List<Ingreso> lista = crtlIngreso.getListaIngreso();
                //setea la lista en la seison
                session.setAttribute("Lista_Ingreso", lista);
                //redirije al JSP MOSTRAR
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngreso.jsp");

            } else if (btn_modificar != null) {
                String ID = request.getParameter("txt_IDAtencion");
                int id = Integer.parseInt(ID);
                String fecha = request.getParameter("fecha_atencion");
                String RutUsuario = request.getParameter("cmb_RutUsuarioIngreso");
                String RutMedico = request.getParameter("cmb_RutMedicoIngreso");
                String RutCliente = request.getParameter("cmb_RutClienteIngreso");
                String TipoMascota = request.getParameter("cmb_TipoMascotaIngreso");
                String Descripcion = request.getParameter("txt_DescripcionIngreso");
                String diagnostico = request.getParameter("txt_DIAGNOSTICOIngreso");
                String procedimiento = request.getParameter("txt_PROCEDIMIENTOIngreso");
                String valor = request.getParameter("txt_VALORCONSULTAIngreso");
                Date f = Util.Util.stringADate(fecha);
                int t = Integer.parseInt(TipoMascota);
                int v = Integer.parseInt(valor);
                Ingreso i = new Ingreso(id,f, t, RutUsuario, RutMedico, RutCliente, Descripcion, diagnostico, procedimiento, v);
                crtlIngreso.ModificarIngreso(i);
                List<Ingreso> lista = crtlIngreso.getListaIngreso();
                session.setAttribute("Lista_Ingreso", lista);
                Util.Util.dispatcher(request, response, "/paciente/MostrarIngreso.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IngresoServletSecundario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IngresoServletSecundario at " + request.getContextPath() + "</h1>");
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
