<%-- 
    Document   : MostrarPerfil
    Created on : 17-10-2017, 14:47:26
    Author     : Daniela
--%>
<%List<Perfil> lista = (List<Perfil>)session.getAttribute("Lista_Perfil"); %>

<%@page import="java.util.List"%>
<%@page import="Controlador.ControladorPerfil"%>
<%@page import="Modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        <script>
            function editarFunction(id, nombre, opcion) {
                var formulario = document.getElementById("formulario");
                var idperfilmod = document.getElementById("idperfilmod");
                var nombremod = document.getElementById("nombremod");
                var idopcion = document.getElementById("ACCION");
                idperfilmod.value = id;
                nombremod.value = nombre;
                idopcion.value = opcion;
                formulario.submit();
            }
            function volver(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarCliente");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                frm_mostrarCliente.submit();
            }
            function agregar(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarCliente");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'AGREGAR';
                frm_mostrarCliente.submit();
                
            }
            function eliminar(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarCliente");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'ELIMINAR';
                frm_mostrarCliente.submit();
            }
        </script>
    </head>
    <body>

        <h1>Perfil</h1>


        <form id="formulario" name="frm_MostrarPerfil" action="./ServletPerfil" method="POST">

            <input type="hidden" name="idperfilmod" id="idperfilmod"/>
            <input type="hidden" name="nombremod" id="nombremod"/>
            <input type="hidden" name="ACCION" id="ACCION"/>

            <label>Datos de Perfil</label>
            <table border="1">

                <tr>
                    <td ><b>ID Perfil</b></td>
                    <td ><b>NOMBRE</b></td>
                    <td><b>OPCION</b> </td>
                </tr>
                <% for (Perfil x : lista) {%>
                <tr align="center">
                    <td>
                        <%=x.getIdPerfil()%>
                    </td>
                    <td>
                        <%=x.getNombre()%>
                    </td>
                    <td>
                        <input type="button" name="Editar" value="Editar" onclick ="editarFunction('<%=x.getIdPerfil()%>','<%=x.getNombre()%>','M')"/>
                    </td>     
                </tr>
                <%}%>
            </table>

            <table>
                <tr>
                    <td>
                        <input type="button" name="btn_Agregar" value="AGREGAR NUEVO PERFIL" onclick="agregar()"/>
                    </td>
                    <td>
                        <input type="button" name="btn_Eliminar" value="ELIMINAR PERFIL" onclick="eliminar()"/>
                    </td>

                    <td>
                        <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
