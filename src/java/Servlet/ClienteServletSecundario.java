/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorCliente;
import Controlador.ControladorMascota;

import Modelo.Cliente;
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
@WebServlet(name = "ClienteServletSecundario", urlPatterns = {"/ClienteServletSecundario"})
public class ClienteServletSecundario extends HttpServlet {

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
            //Trae los parametros de los botones
            String btn_aceptar = request.getParameter("btn_aceptar");
            String btn_Eliminar = request.getParameter("btn_Eliminar");
            String btn_modificar = request.getParameter("btn_modificar");
            //se crea una instancia de la Clase ControladorCliente
            ControladorCliente ctrlCliente = new ControladorCliente();
            // Se crea la session
            HttpSession session = request.getSession(true);
            // si quiere agregar
            if (btn_aceptar != null) {
                // se trae los valores de jsp AgregarCliente
                String rut = request.getParameter("txt_cliente_rut");
                String nombre = request.getParameter("txt_cliente_nombre");
                String direccion = request.getParameter("txt_cliente_direccion");
                String fecha = request.getParameter("fechanacimiento_cliente");
                String correo = request.getParameter("txt_cliente_email");
                String sexo = request.getParameter("cmb_sexo");
                Date f = Util.Util.stringADate(fecha);
                // valido si el registro existe en la DDBB
                if (!ctrlCliente.ValidarClienteAgregar(rut)) {
                    //Inserta el Cliente en la DDBB
                    insertaCliente(rut, nombre, direccion, f, correo, sexo);
                    //Genero una instancia de List para Mostrarlos luego el JSP
                    List<Cliente> listaCliente = ctrlCliente.getListaCliente();
                    // seteo la lista en una sesion para poder mostrarla 
                    session.setAttribute("Lista_Cliente", listaCliente);
                    // voy a la pagina MostrarClientes para ver el cambio
                    Util.Util.dispatcher(request, response, "/cliente/MostrarCliente.jsp");
                } else {
                    // si el registro de Cliente ya existe muestro el error
                    String msErrorAgregar = "No se puede agregar cliente, ya existe en el sistema";
                    session.setAttribute("Error", msErrorAgregar);
                    Util.Util.dispatcher(request, response, "/cliente/MostrarCliente.jsp");
                }

                // si quiere Eliminar Cliente
            } else if (btn_Eliminar != null) {
                // traigo los valores del JSP
                String rutEliminar = request.getParameter("cmb_RutEliminar");
                //Creo instancia de COntroladorMascota para borrar las 
                //mascotas asociadas al Cliente y las borro
                ControladorMascota mascota = new ControladorMascota();
                mascota.borrarMascota(rutEliminar);
                //ahora borro al cliente de la DDBB
                ctrlCliente.BorrarCliente(rutEliminar);
                //Genero una instancia de List para Mostrarlos luego el JSP
                List<Cliente> listaCliente = ctrlCliente.getListaCliente();
                // seteo la lista en una sesion para poder mostrarla 
                session.setAttribute("Lista_Cliente", listaCliente);
                // voy a la pagina MostrarClientes para ver el cambio
                Util.Util.dispatcher(request, response, "/cliente/MostrarCliente.jsp");

            } else if (btn_modificar != null) {
                String rut = request.getParameter("txt_cliente_rut");
                String nombre = request.getParameter("txt_cliente_nombre");
                String direccion = request.getParameter("txt_cliente_direccion");
                String fecha = request.getParameter("fechanacimiento_cliente");
                String correo = request.getParameter("txt_cliente_email");
                String sexo = request.getParameter("txt_sexo");
                Date f = Util.Util.stringADate(fecha);
                if (sexo.equalsIgnoreCase("femenino")) {
                    sexo = "F";
                }
                sexo = "M";
                ControladorCliente cliente = new ControladorCliente();
                String f1 = Util.Util.getFechaFormateadaSalida(f);
                Cliente modificado = new Cliente(rut, nombre, direccion, f, f1, correo, sexo);
                cliente.ModificarCliente(modificado);
                List<Cliente> listaCliente = ctrlCliente.getListaCliente();
                session.setAttribute("Lista_Cliente", listaCliente);
                Util.Util.dispatcher(request, response, "/cliente/MostrarCliente.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteServletSecundario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteServletSecundario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    //METODO QUE ALMACENA UN Cliente
    public void insertaCliente(String Rut, String Nombre, String Direccion, Date Fechanacimiento, String Correo, String Sexo) {
        ControladorCliente ctrlCliente = new ControladorCliente();
        Cliente cliente = new Cliente();

        try {
            cliente.setRut(Rut);
            cliente.setNombre(Nombre);
            cliente.setFechanacimiento(Fechanacimiento);
            cliente.setDireccion(Direccion);
            cliente.setCorreo(Correo);
            cliente.setSexo(Sexo);
            ctrlCliente.IngresarCliente(cliente);

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
