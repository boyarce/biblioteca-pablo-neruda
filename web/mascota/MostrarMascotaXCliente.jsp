<%--
    Document   : Mascota
    Created on : 18-10-2017, 10:45:43
    Author     : Daniela
--%>
<%
    List<Mascota> listaMascota = (List<Mascota>) session.getAttribute("Lista_Mascota");
%>
<%@page import="Util.Util"%>
<%@page import="Modelo.Mascota"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        <script>

            function volver() {
                var frm_mostrarCliente = document.getElementById("frm_MostrarMascota");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                frm_mostrarCliente.submit();
            }


        </script>
    </head>
    <body>

        <h1>Tipo de Mascota</h1>

        <form id="frm_MostrarMascota" name="frm_MostrarMascota" action="./BuscarServlet" method="POST">
            <input type="hidden" name="ACCION" id="ACCION"/>
            <fieldset>
                <legend>Datos de Tipo de Mascota</legend>

                <table border="1">


                    <tr>
                        <td ><b>ID MASCOTA</b></td>
                        <td ><b>TIPO DE MASCOTA</b></td>
                        <td ><b>RUT CLIENTE</b></td>
                        <td ><b>NOMBRE</b></td>
                        <td ><b>FECHA DE NACIMIENTO</b></td>

                    </tr>
                    <%for (Mascota mascota : listaMascota) {%>
                    <tr>
                        <td><%= mascota.getIdMascota()%></td>
                        <td><%=mascota.getIdTipo()%></td>
                        <td><%=mascota.getRutCliente()%></td>
                        <td><%=mascota.getNombre()%></td>
                        <%String stFecha = Util.getFechaFormateada(mascota.getFechaNacimiento());%>
                        <td><%=stFecha%></td>
                    </tr>   <%}%>
                </table>
                <table>
                    <tr>
                        <td>
                            <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
