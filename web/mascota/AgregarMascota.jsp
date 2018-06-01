<%-- 
    Document   : AgregarMascota
    Created on : 18-10-2017, 10:42:19
    Author     : Daniela
--%>
<%@page import="Modelo.Animal"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
<%
    HttpSession sesion = request.getSession();
    List<Cliente> listaCliente = (List<Cliente>) sesion.getAttribute("Lista_Cliente");
    List<Animal> listaTipo = (List<Animal>) session.getAttribute("Lista_TipoAnimal");
%>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>

        <h1>Agregar Mascota</h1>

        <form name="frm_AgregarMascota" action="./MascotaServletSecundario" method="POST">
            <table>
                <legend>Ingrese los siguientes datos:</legend>
                 <tr>
                    <td>
                       ID MASCOTA
                    </td>
                    <td>
                        <input type="text" name="txt_idMascota" />
                    </td>
                </tr>
                <tr>
                    
                    <td>
                        RUT CLIENTE
                    </td>
                    <td>
                        <select name="cmb_rutCliente_mascota">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Cliente x : listaCliente) {%>
                            <option value="<%=x.getRut()%>">
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        TIPO DE MASCOTA
                    </td>
                    <td>
                        <select name="cmb_tipoMascota">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Animal x : listaTipo) {%>
                            <option value="<%=x.getIdtipo()%>">
                                <%=x.getNombre()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_mascota_nombre" />
                    </td>
                </tr>

                <tr>
                    <td>
                        FECHA DE NACIMIENTO
                    </td>
                    <td>
                        <input type="date" name="fecha_nacimiento_mascota" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_agregar" value="Ingresar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
