<%-- 
    Document   : EliminarCliente
    Created on : 18-10-2017, 10:42:49
    Author     : Daniela
--%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
<% List<Cliente> listaCliente = (List<Cliente>) session.getAttribute("Lista_Cliente");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Eliminar Cliente</h1>
        <form name="frm_EliminarCliente" action="./ClienteServletSecundario" method="POST">


            <table>
                <tr>
                    <td>
                        INGRESE RUT DEL CLIENTE A ELIMINAR: 
                    </td>
                    <td>
                        <select name="cmb_RutEliminar">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Cliente x : listaCliente) {%>
                            <option value="<%=x.getRut()%>">
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="btn_Eliminar" value="ELIMINAR"/>

        </form>
    </body>
</html>
