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
            function editarFunction(id, tipo, rut, nombre, fecha, opcion) {
                var frm_MostrarMascota = document.getElementById("frm_MostrarMascota");
                var idmascotamod = document.getElementById("idmascotamod");
                var tipomascotamod = document.getElementById("tipomascotamod");
                var rutclientemod = document.getElementById("rutclientemod");
                var nombremod = document.getElementById("nombremod");
                var fechamod = document.getElementById("fechamod");
                var idopcion = document.getElementById("btn_Modificar");
                idmascotamod.value = id;
                tipomascotamod.value = tipo;
                rutclientemod.value = rut;
                nombremod.value = nombre;
                fechamod.value = fecha;
                idopcion.value = opcion;
                frm_MostrarMascota.submit();
            }
            function volver() {
                var frm_mostrarCliente = document.getElementById("frm_MostrarMascota");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                frm_mostrarCliente.submit();
            }
            function agregar() {
                var frm_mostrarCliente = document.getElementById("frm_MostrarMascota");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'AGREGAR';
                frm_mostrarCliente.submit();
            }

        </script>
    </head>
    <body>

        <h1>Tipo de Mascota</h1>

        <form id="frm_MostrarMascota" name="frm_MostrarMascota" action="./MascotaServletInicial" method="POST">

            <input type="hidden" name="idmascotamod" id="idmascotamod"/>
            <input type="hidden" name="tipomascotamod" id="tipomascotamod"/>
            <input type="hidden" name="rutclientemod" id="rutclientemod"/>
            <input type="hidden" name="fechamod" id="fechamod"/>
            <input type="hidden" name="nombremod" id="nombremod"/>
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
                        <td><b>OPCION</b> </td>

                    </tr>
                    <%for (Mascota mascota : listaMascota) {%>
                    <tr>
                        <td><%= mascota.getIdMascota()%></td>
                        <td><%=mascota.getIdTipo()%></td>
                        <td><%=mascota.getRutCliente()%></td>
                        <td><%=mascota.getNombre()%></td>
                        <%String stFecha = Util.getFechaFormateada(mascota.getFechaNacimiento());%>
                        <td><%=stFecha%></td>
                        <td>
                            <input type="button" name="Editar" value="Editar" onclick ="editarFunction('<%= mascota.getIdMascota()%>', '<%=mascota.getIdTipo()%>', '<%=mascota.getRutCliente()%>', '<%=mascota.getNombre()%>', '<%=stFecha%>', 'M')"/>
                        </td>  </tr>   <%}%>
                </table>
                <table>
                    <tr>
                        <td>
                            <input type="submit" name="btn_Agregar" value="AGREGAR MASCOTA" onclick="agregar()"/>
                        </td>
                        <td>
                            <input type="submit" name="Btn_Volver" value="Volver" onclick="eliminar()"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
