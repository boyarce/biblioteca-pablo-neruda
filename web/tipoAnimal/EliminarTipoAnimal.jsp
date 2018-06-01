<%-- 
    Document   : EliminarTipoAnimal
    Created on : 17-10-2017, 15:58:05
    Author     : Daniela
--%>
<%@page import="Modelo.Animal"%>
<%@page import="java.util.List"%>
<% List<Animal> listaTipo = (List<Animal>) session.getAttribute("Lista_Tipo");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Eliminar Tipo de Mascota</h1>
        <form name="frmEliminarTipoMascota" action="./TipoServletSecundario" method="POST">
            <table>
                <tr>
                    <td>
                        Ingrese el tipo de animal a eliminar
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

            </table>
            <input type="submit" name="btn_Eliminar" value="ELIMINAR"/>
        </form>
    </body>
</html>
