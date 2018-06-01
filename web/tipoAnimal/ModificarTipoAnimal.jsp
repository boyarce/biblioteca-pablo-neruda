<%-- 
    Document   : ModificarTipoAnimal
    Created on : 17-10-2017, 15:58:27
    Author     : Daniela
--%>
<%@page import="Modelo.Animal"%>
<%
    Animal a = (Animal)session.getAttribute("Animal");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>MEDIPET</title>
    </head>
    <body>
        <h1>Modificar Tipo de Mascota</h1>
        <form name="frm_ModificarAnimal" action="./TipoServletSecundario" method="POST">
             <table>
                 <% %>
                <tr>
                    <td>
                        ID TIPO DE MASCOTA
                    </td>
                    <td>
                        <input type="text" name="txt_id" value="<%= a.getIdtipo()%>" readonly/>
                    </td>
                </tr>               
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_nombre" value="<%= a.getNombre()%>" />
                    </td>
                </tr>
                <%%>
            </table>
            <input type="submit" name="btn_Modificar" value="MODIFICAR"/>
        </form>
    </body>
</html>
