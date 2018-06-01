<%-- 
    Document   : Administrador
    Created on : 31-10-2017, 19:25:55
    Author     : CETECOM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form name="frm_AgregarAdministrador" action="./UsuarioServletSecundario" method="POST">
            <table>
                <legend>Ingrese los siguientes datos:</legend>

                <tr>
                    <td>
                        RUT
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_rut" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_nombre" required pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð '-]{1,50}"  aria-required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        APELLIDO PATERNO
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_apellidoPat" required pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð '-]{1,50}"  aria-required="true" />
                    </td>
                </tr>
                <tr>
                    <td>
                        APELLIDO MATERNO
                    </td>
                    <td>
                        <input type="text" name="txt_usuario_apellidoMat" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð '-]{1,50}" required aria-required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        FECHA DE NACIMIENTO
                    </td>
                    <td>
                        <input type="date" name="fechaNacUsuario" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        E-MAIL
                    </td>
                    <td>
                        <input type="email" name="txt_usuario_email" required placeholder="midireccion@gmail.com" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        CONTRASEÑA
                    </td>
                    <td>
                        <input type="password" name="txt_usuario_password" required />
                    </td>
                </tr>
            </table>
            <input type="submit" name="btn_agregarAdmin" value="Ingresar"/>
    </body>
</html>
