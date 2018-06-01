<%-- 
    Document   : ModificarCliente
    Created on : 18-10-2017, 10:44:11
    Author     : Daniela
--%>
<%@page import="Modelo.Cliente"%>
<%Cliente c = (Cliente) session.getAttribute("Cliente");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        
    </head>
    <body>
        <h1>Modificar Cliente</h1>
        <form name="frm_ModificarCliente" action="./ClienteServletSecundario" method="POST">
            <table>
                <%%>
                <tr>
                    <td>
                        RUT
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_rut" value="<%=c.getRut()%>" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_nombre" value="<%=c.getNombre()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        DIRECCION
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_direccion"  value="<%=c.getDireccion()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        FECHA DE NACIMIENTO
                    </td>
                    <td>
                        <input type="date" id="fechanacimiento_cliente" name="fechanacimiento_cliente" />
                    </td>
                </tr>
                <tr>
                    <td>
                        CORREO ELECTRONICO
                    </td>
                    <td>
                        <input type="text" name="txt_cliente_email" value="<%=c.getCorreo()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        SEXO
                    </td>
                    <td>
                       <input type="text" name="txt_sexo" value="<%=c.getSexo()%>" />
                    </td>
                </tr>
                <%%>
            </table>


            <input type="submit" name="btn_modificar" value="MODIFICAR"/>

        </form>
            <script>
            var fecha = '<%=c.getFechaNacimientoHTML()%>';
            var fechanacimiento_cliente = document.getElementById('fechanacimiento_cliente');
            console.info(fechanacimiento_cliente);
            fechanacimiento_cliente.value = fecha;
        </script>
    </body>
</html>
