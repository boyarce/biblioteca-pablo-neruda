/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorUsuario;
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
@WebServlet(name = "UsuarioServletSecundario", urlPatterns = {"/UsuarioServletSecundario"})
public class UsuarioServletSecundario extends HttpServlet {

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
            //traigo los valores del JSP mostrar
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_Eliminar = request.getParameter("btn_Eliminar");
            String btn_Modificar = request.getParameter("btn_Modificar");
            String btn_agregarAdmin = request.getParameter("btn_agregarAdmin");
            //inicializo el controlador
            ControladorUsuario ctrlUsuario = new ControladorUsuario();
            //recupero la sesion
            HttpSession session = request.getSession(true);
            // si quiere agregar
            if (btn_agregar != null) {
                // traigo los datos del JSP Agregar
                String rut = request.getParameter("txt_usuario_rut");
                String nombre = request.getParameter("txt_usuario_nombre");
                String apellidoPaterno = request.getParameter("txt_usuario_apellidoPat");
                String apellidoMaterno = request.getParameter("txt_usuario_apellidoMat");
                String fechaNacimiento = request.getParameter("fechaNacUsuario");
                String correo = request.getParameter("txt_usuario_email");
                String password = request.getParameter("txt_usuario_password");
                String idPerfil = request.getParameter("cmb_perfilUsuario");

                Date f = Util.Util.stringADateFromHtml(fechaNacimiento);
                int i = Integer.parseInt(idPerfil);
                //llamo al metodo insertar en la DDBB
                insertaUsuario(rut, nombre, apellidoPaterno, apellidoMaterno, f, correo, password, i);
                //llamo al metodo listar
                List<Usuario> listaUsuario = ctrlUsuario.getListaUsuario();
                // guardo la lista en la sesion
                session.setAttribute("Lista_Usuario", listaUsuario);
                //redirijo al JSP mostrar
                Util.Util.dispatcher(request, response,"/usuario/MostrarUsuario.jsp");
                //si quiere eliminar
            } else if (btn_Eliminar != null) {
                try {
                    // traigo los valores del JSP eliminar
                    String rutEliminar = request.getParameter("txt_RutUsuarioEliminar");

                    //hay que validar que el usuario no tenga una atencion 
                    if (!ctrlUsuario.validarUsuarioParaEliminar(rutEliminar)) {
                        //llamo al metodo borrar usuario
                        ctrlUsuario.BorrarUsuario(rutEliminar);
                        //llamo al metodo listar
                        List<Usuario> listaUsuario = ctrlUsuario.getListaUsuario();
                        // guardo la lista en la session
                        session.setAttribute("Lista_Usuario", listaUsuario);
                        // redirijo al JSP mostrar
                        Util.Util.dispatcher(request, response,"/usuario/MostrarUsuario.jsp");
                    } // si el usuario tiene atenciones en la DDBB no se puede eliminar
                    else {
                        // creo el mensaje de error
                        String msErrorBorrarUsuario = "No se puede borrar Usuario";
                        //lo guardo en la session
                        session.setAttribute("Errores", msErrorBorrarUsuario);
                        // redirijo al JSP mostrar
                        Util.Util.dispatcher(request, response,"/usuario/MostrarUsuario.jsp");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (btn_Modificar != null) {
                String rut = request.getParameter("txt_usuario_rut");
                String nombre = request.getParameter("txt_usuario_nombre");
                String apellidoPaterno = request.getParameter("txt_usuario_apellidoPat");
                String apellidoMaterno = request.getParameter("txt_usuario_apellidoMat");
                String fechaNacimiento = request.getParameter("fechaNacUsuario");
                String correo = request.getParameter("txt_usuario_email");
                String password = request.getParameter("txt_usuario_password");
                String idPerfil = request.getParameter("cmb_perfilUsuario");

                Date f = Util.Util.stringADate(fechaNacimiento);
                int i = Integer.parseInt(idPerfil);

                ModificarUsuario(rut, nombre, apellidoPaterno, apellidoMaterno, f, correo, password, i);
                List<Usuario> lista = ctrlUsuario.getListaUsuario();
                session.setAttribute("Lista_Usuario", lista);
                Util.Util.dispatcher(request, response,"/usuario/MostrarUsuario.jsp");
                //si el usuario administrador no existe
            } else if (btn_agregarAdmin != null) {
                //traigo los valores del JSP
                String rut = request.getParameter("txt_usuario_rut");
                String nombre = request.getParameter("txt_usuario_nombre");
                String apellidoPaterno = request.getParameter("txt_usuario_apellidoPat");
                String apellidoMaterno = request.getParameter("txt_usuario_apellidoMat");
                String fechaNacimiento = request.getParameter("fechaNacUsuario");
                String correo = request.getParameter("txt_usuario_email");
                String password = request.getParameter("txt_usuario_password");
                Date f = Util.Util.stringADate(fechaNacimiento);
                int i = 1;
                // llamo al metodo insertar para ingresarlo a la DDBB
                insertaUsuario(rut, nombre, apellidoPaterno, apellidoMaterno, f, correo, password, i);
                //redirijo al menu
                Util.Util.dispatcher(request, response,"/index.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServletSecundario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServletSecundario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
// metodo que inserta un usuario a la DDBB

    public void insertaUsuario(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String correo, String password, int idPerfil) {
        //inicializo el controlador
        ControladorUsuario ctrlUsuario = new ControladorUsuario();
        //creo el objeto usuario
        Usuario usuario = new Usuario();

        try {
            // seteo los datos
            usuario.setRut(rut);
            usuario.setNombre(nombre);
            usuario.setApellidoPaterno(apellidoPaterno);
            usuario.setApellidoMaterno(apellidoMaterno);
            usuario.setFechaNacimiento(fechaNacimiento);
            usuario.setCorreo(correo);
            usuario.setPassword(password);
            usuario.setIdPerfil(idPerfil);
            // y los inserto en la DDBB
            ctrlUsuario.InsertaUsuario(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void ModificarUsuario(String Rut, String Nombre, String ApellidoPaterno, String ApellidoMaterno, Date FechaNacimiento, String Correo, String Password, int IdPerfil) {

        ControladorUsuario ctrlUsuario = new ControladorUsuario();
        Usuario usuario = new Usuario();

        try {
            usuario.setRut(Rut);
            usuario.setNombre(Nombre);
            usuario.setApellidoPaterno(ApellidoPaterno);
            usuario.setApellidoMaterno(ApellidoMaterno);
            usuario.setFechaNacimiento(FechaNacimiento);
            usuario.setCorreo(Correo);
            usuario.setPassword(Password);
            usuario.setIdPerfil(IdPerfil);
            ctrlUsuario.ModificarUsuario(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
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
