<%-- 
    Document   : ModificarUsuario
    Created on : 18-10-2017, 10:43:53
    Author     : Daniela
--%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Perfil"%>
<%@page import="java.util.List"%>
<%
    List<Perfil> lista = (List<Perfil>) session.getAttribute("Lista_Perfil");
    Usuario u = (Usuario) session.getAttribute("Usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Modificar Usuario</h1>

        <form name="frm_modificarUsuario" action="./UsuarioServletSecundario" method="POST">
            <table>
                <%%>           
                <tr>
                    <td>
                        RUT
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_rut" value="<%=u.getRut()%>" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_nombre" value="<%=u.getNombre()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        APELLIDO PATERNO
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_apellidoPat" value="<%=u.getApellidoPaterno()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        APELLIDO MATERNO
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_apellidoMat" value="<%=u.getApellidoMaterno()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        FECHA DE NACIMIENTO
                    </td>
                    <td>
                        <input type="date" name="fecha" />
                    </td>
                </tr>
                <tr>
                    <td>
                        E-MAIL
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_email" value="<%=u.getCorreo()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        CONTRASEÑA
                    </td>
                    <td>
                        <input type="password" name="txt_usuario_password" value="<%=u.getPassword()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        PERFIL
                    </td>
                    <td>
                        <select name="cmb_perfil">
                            <option value="0"></option>
                            <% for (Perfil x : lista) {%>
                            <option value="<%=u.getIdPerfil()%>">
                                <%=x.getNombre()%>
                            </option>
                            <%}%>
                        </select>

                    </td>
                </tr>
            </table>


            <input type="submit" name="btn_Modificar" value="Modificar"/>

        </form>
    </body>
</html>
