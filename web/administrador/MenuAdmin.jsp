<%-- 
    Document   : MenuAdmin
    Created on : 03-11-2017, 11:42:19
    Author     : Daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <form name="frm_IndexMostrarCapaAdmin" action="./IndexServlet" method="POST">
            <table>
                <tr>
                    <td>
                        <input type="submit" name="btn_mostrarCliente" value="MOSTRAR CLIENTES"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_mostrarUsuario" value="MOSTRAR USUARIOS"/> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_mostrarAtenciones" value="MOSTRAR ATENCIONES"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_mostrarMascotas" value="MOSTRAR MASCOTAS"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_mostrarTipo" value="MOSTRAR TIPO DE MASCOTA"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_mostrarPerfil" value="MOSTRAR PERFIL USUARIO"/>
                    </td>
                </tr>
            </table>

        </form>
    </body>
</html>
