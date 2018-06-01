<%-- 
    Document   : login
    Created on : 31-10-2017, 19:31:00
    Author     : CETECOM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medipet</title>
    </head>
    <body>
        <form name="frm_login" action="./IndexServlet" method="POST">
            <fieldset>
                <table>
                    <tr>
                        <td>
                            Usuario
                        </td>
                        <td>
                            <input type="email" name="txtUsuario" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Contraseña
                        </td>
                        <td>
                             <input type="password" name="txtPass" required/>
                        </td>
                    </tr>
                </table>
                <input type="submit" name="btnLogin" value="Aceptar" />
            </fieldset>
        </form>
    </body>
</html>
