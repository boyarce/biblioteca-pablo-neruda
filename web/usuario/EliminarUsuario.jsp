<%-- 
    Document   : EliminarUsuario
    Created on : 18-10-2017, 10:43:37
    Author     : Daniela
--%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<% List<Usuario> lista = (List<Usuario>)session.getAttribute("Lista_Usuario");
    String mensaje =(String)session.getAttribute("Errores");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>MEDIPET</title>
    </head>
    <body>
        <h1>Eliminar Usuario</h1>
        <form name="frm_EliminarUsuario" action="./UsuarioServletSecundario" method="POST">
            <table>
                <tr>
                    <td>
                        INGRESE RUT DEL USUARIO A ELIMINAR: 
                    </td>
                    <td>
                        <select name="txt_RutUsuarioEliminar">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Usuario x : lista) {%>
                            <option value="<%=x.getRut()%>">
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                <label><%= mensaje%></label>
                </tr>
               
            </table>
                        
                        <input type="submit" name="btn_Eliminar" value="ELIMINAR"/>
                   
        </form>
    </body>
</html>
