<%-- 
    Document   : ModificarPerfil
    Created on : 17-10-2017, 15:39:30
    Author     : Daniela
--%>
<%@page import="Modelo.Perfil"%>
<%Perfil p = (Perfil)session.getAttribute("Perfil");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Modificar Perfil</h1>
        <form name="frm_ModificarPerfil" action="./PerfilServletSecundario" method="POST">
            <table>
                <% %>
                 <tr>
                    <td>
                        ID PERFIL 
                    </td>
                    <td>
                        <input type="text" name="txt_perfil_id" value="<%= p.getIdPerfil() %>" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                         <input type="text" name="txt_perfil_nombre" value="<%= p.getNombre()%>"/>
                    </td>
                </tr>
               <%%>
            </table>
                        <input type="submit" name="btn_modificar" value="MODIFICAR"/>
                   
            
        </form>
</html>
