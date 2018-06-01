<%-- 
    Document   : EliminarPerfil
    Created on : 17-10-2017, 15:39:05
    Author     : Daniela
--%>
<%@page import="Modelo.Perfil"%>
<%@page import="java.util.List"%>
<%
    List<Perfil> lista  = (List<Perfil>)session.getAttribute("Lista_Perfil");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
   <h1>Eliminar Perfil</h1>
        <form name="frm_EliminarPerfil" action="./PerfilServletSecundario" method="POST">
            <table>
                 <tr>
                    <td>
                        INGRESE PERFIL A ELIMINAR
                    </td>
                    <td>
                        <select name="cmb_perfilUsuario">
                            <option value="0">--SELECCIONE--</option>
                            <% for(Perfil x: lista){ %>
                                <option value="<%=x.getIdPerfil()%>">
                                    <%=x.getNombre()%>
                                </option>
                            <%}%>
                        </select>
     
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <input type="submit" name="btn_eliminar" value="ELIMINAR"/>
                    </td>
                </tr>
            </table>
            
        </form>
</html>
