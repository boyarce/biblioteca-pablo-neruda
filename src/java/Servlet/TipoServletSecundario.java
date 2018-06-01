/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorTipoAnimal;
import Modelo.Animal;
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
@WebServlet(name = "TipoServletSecundario", urlPatterns = {"/TipoServletSecundario"})
public class TipoServletSecundario extends HttpServlet {

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
            //recupero la sesion
            HttpSession session = request.getSession(true);

            //traigo los valores del JSP Mostrar
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_Eliminar = request.getParameter("btn_Eliminar");
            String btn_Modificar = request.getParameter("btn_Modificar");
            //creo la instancia controladorTipo
            ControladorTipoAnimal animal = new ControladorTipoAnimal();
            //si quiere agregar
            if (btn_agregar != null) {

                try {
                    //traigo los valores del JSP Agregar
                    String idtipo = request.getParameter("txt_IdTipo");
                    String nombre = request.getParameter("txt_animal_nombre");
                    int id = Integer.parseInt(idtipo);
                    //creo el objeto animal
                    Animal a = new Animal(id, nombre);
                    //llama al metodo insertar en la DDBB
                    animal.Insertar(a);
                    //llama al metodo listar
                    List<Animal> listaTipo = animal.getListaTipoAnimal();
                    //guarda la lista en la sesion
                    session.setAttribute("Lista_Tipo", listaTipo);
                    //redirije al JSP MOSTRAR
                    Util.Util.dispatcher(request, response, "/tipoAnimal/MostrarTipoAnimal.jsp");

                } catch (Exception w) {
                    w.printStackTrace();
                }
            } else if (btn_Eliminar != null) {
                try {
                    //trae los parametros del JSP
                    String idtipo = request.getParameter("cmb_tipoMascota");                    
                    int id = Integer.parseInt(idtipo);
                    //llama al metodo eliminar de la DDBB
                    animal.BorrarTipoAnimal(id);
                    //llama al metodo listar
                    List<Animal> listaTipo = animal.getListaTipoAnimal();
                    //guarda la lista en la sesion
                    session.setAttribute("Lista_Tipo", listaTipo);
                    //redirije al JSP mostrar
                    Util.Util.dispatcher(request, response, "/tipoAnimal/MostrarTipoAnimal.jsp");

                } catch (Exception w) {
                    w.printStackTrace();
                }
            } else if (btn_Modificar != null) {
                try {
                    String idtipo = request.getParameter("txt_id");
                    String nombre = request.getParameter("txt_nombre");
                    int id = Integer.parseInt(idtipo);

                    Animal a = new Animal(id, nombre);
                    animal.ModificarTipoAnimal(a);
                    List<Animal> listaTipo = animal.getListaTipoAnimal();
                    session.setAttribute("Lista_Tipo", listaTipo);
                    Util.Util.dispatcher(request, response, "/tipoAnimal/MostrarTipoAnimal.jsp");

                } catch (Exception w) {
                    w.printStackTrace();
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TipoServletSecundario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoServletSecundario at " + request.getContextPath() + "</h1>");
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
