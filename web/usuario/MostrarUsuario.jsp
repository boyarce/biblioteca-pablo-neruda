<%-- 
    Document   : MostrarUsuario
    Created on : 18-10-2017, 10:44:56
    Author     : Daniela
--%>
<%    List<Usuario> listaUsuario = (List<Usuario>) session.getAttribute("Lista_Usuario");

%>

<%@page import="Util.Util"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        <script>
            function editarFunction(rut, nombre, paterno, materno, fecha, correo, pass, perfil, opcion) {
                var frm_mostrarUsuario = document.getElementById("frm_mostrarUsuario");
                var rutmod = document.getElementById("rutmod");
                var nombremod = document.getElementById("nombremod");
                var apPatMod = document.getElementById("apPatMod");
                var apMatMod = document.getElementById("apMatMod");
                var fecha = document.getElementById("fecha");
                var correoMod = document.getElementById("correoMod");
                var passwordMod = document.getElementById("passwordMod");
                var perfilMod = document.getElementById("perfilMod");
                var idopcion = document.getElementById("ACCION");
                rutmod.value = rut;
                nombremod.value = nombre;
                apPatMod.value = paterno;
                apMatMod.value = materno;
                fecha.value = fecha;
                correoMod.value = correo;
                passwordMod.value = pass;
                perfilMod.value = perfil;
                idopcion.value = opcion;
                frm_mostrarUsuario.submit();
            }
            function volver(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarUsuario");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                frm_mostrarCliente.submit();
            }
            function agregar(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarUsuario");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'AGREGAR';
                frm_mostrarCliente.submit();
                
            }
            function eliminar(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarUsuario");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'ELIMINAR';
                frm_mostrarCliente.submit();
            }
        </script>
    </head>
    <body>
        <h1>Usuario</h1>
        <form id="frm_mostrarUsuario" name="frm_mostrarUsuario" action="./UsuarioServletInicial" method="POST">
            <table border="1">
                <label>Datos de Usuario</label>
                <input type="hidden" name="rutmod" id="rutmod"/>
                <input type="hidden" name="nombremod" id="nombremod"/>
                <input type="hidden" name="apPatMod" id="apPatMod"/>
                <input type="hidden" name="apMatMod" id="apMatMod"/>
                <input type="hidden" name="fecha" id="fecha"/>
                <input type="hidden" name="correoMod" id="correoMod"/>
                <input type="hidden" name="passwordMod" id="passwordMod"/>
                <input type="hidden" name="perfilMod" id="perfilMod"/>
                <input type="hidden" name="ACCION" id="ACCION"/>

                <tr>
                    <td ><b>RUT</b></td>
                    <td ><b>NOMBRE</b></td>
                    <td ><b>APELLIDO PATERNO</b></td>
                    <td ><b>APELLIDO MATERNO</b></td>
                    <td ><b>FECHA DE NACIMIENTO</b></td>
                    <td ><b>CORREO ELECTRONICO</b></td>
                    <td ><b>PERFIL</b></td>
                    <td><b>OPCION</b> </td>
                </tr>
                <%for (Usuario usuario : listaUsuario) {%>
                <tr>
                    <td><%=usuario.getRut()%></td>
                    <td><%=usuario.getNombre()%></td>
                    <td><%=usuario.getApellidoPaterno()%></td>
                    <td><%=usuario.getApellidoMaterno()%></td>
                    <%String stFecha = Util.getFechaFormateada(usuario.getFechaNacimiento());%>
                    <td><%=stFecha%></td>
                    <td><%=usuario.getCorreo()%></td>
                    <td><%=usuario.getIdPerfil()%></td>
                    <td>
                        <input type="button" name="Editar" value="Editar" onclick ="editarFunction('<%=usuario.getRut()%>', '<%=usuario.getNombre()%>', '<%=usuario.getApellidoPaterno()%>', '<%=usuario.getApellidoMaterno()%>', '<%=stFecha%>', '<%=usuario.getCorreo()%>', '<%=usuario.getPassword()%>', '<%=usuario.getIdPerfil()%>', 'MODIFICAR')"/>
                    </td>
                </tr><%}%>
            </table>

            <table>
                <tr>
                    <td>
                        <input type="button" name="btn_AgregarUsuario" value="AGREGAR NUEVO USUARIO" onclick="agregar()"/>
                    </td>
                    <td>
                        <input type="button" name="btn_EliminarUsuario" value="ELIMINAR USUARIO" onclick="eliminar()"/>
                    </td>                    
                    <td>
                        <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
