<%-- 
    Document   : AgregarCliente
    Created on : 18-10-2017, 10:41:39
    Author     : Daniela
--%>
<% String mensaje =(String)session.getAttribute("Error");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Bienvenido a Medipet!</h1>

        <form name="frm_ingresoCliente" action="./ClienteServletSecundario" method="POST">
            <label>Ingrese los siguientes datos:</label>

            <table>


                <tr>
                    <td>
                        RUT
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_rut" required aria-required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_nombre" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð '-]{1,50}" required aria-required="true" />
                    </td>
                </tr>
                <tr>
                    <td>
                        DIRECCION
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_direccion"  pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð '-]{1,50}" required aria-required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        FECHA DE NACIMIENTO
                    </td>
                    <td>
                        <input type="date" name="fechanacimiento_cliente" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        CORREO ELECTRONICO
                    </td>
                    <td>
                        <input type="email" name="txt_cliente_email" required placeholder="midireccion@gmail.com" size="50"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        SEXO
                    </td>
                    <td>
                        <select name="cmb_sexo" >
                            <option  value="0">--SELECCIONE--</option>
                            <option value="F">Femenino</option>
                            <option value="M">Masculino</option>
                        </select>
                    </td>
                </tr>
            </table>


            <input type="submit" name="btn_aceptar" value="INGRESAR"/>
            <label><%= mensaje%></label>
        </form>
    </body>
</html>
