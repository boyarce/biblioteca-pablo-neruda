<%-- 
    Document   : EliminarIngreso
    Created on : 18-10-2017, 10:43:06
    Author     : Daniela
--%>
<%@page import="Modelo.Ingreso"%>
<%@page import="java.util.List"%>
<% List<Ingreso> lista = (List<Ingreso>)session.getAttribute("Lista_Ingreso");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>MEDIPET</title>
    </head>
    <body>
        <h1>Eliminar Ingreso</h1>
        <form name="frm_EliminarIngreso" action="./IngresoServletSecundario" method="POST">
            <table>
                <tr>
                    <td>
                        INGRESE NUMERO DE ATENCION A ELIMINAR: 
                    </td>
                    <td>
                        <select name="txt_numeroAEliminar">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Ingreso x : lista) {%>
                            <option value="<%=x.getIdAtencion()%>">
                                <%=x.getRutCliente()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_Eliminar" value="ELIMINAR"/>
                    </td>
                   
                </tr>
            </table>
            
        </form>
    </body>
</html>
