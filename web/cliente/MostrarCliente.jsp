<%-- 
    Document   : MostrarCliente
    Created on : 18-10-2017, 10:45:16
    Author     : Daniela
--%>

<%@page import="Util.Util"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Cliente> clienteList = (List<Cliente>) session.getAttribute("Lista_Cliente"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        <script>
            function editarFunction(rut, nombre, direccion, fecha, correo, sexo, opcion) {
                var frm_mostrarCliente = document.getElementById("frm_mostrarCliente");
                var rutmod = document.getElementById("rutmod");
                var nombremod = document.getElementById("nombremod");
                var direccionMod = document.getElementById("direccionMod");
                var fechaMod = document.getElementById("fechaMod");
                var correoMod = document.getElementById("correoMod");
                var sexoMod = document.getElementById("sexoMod");
                var idopcion = document.getElementById("ACCION");
                rutmod.value = rut;
                nombremod.value = nombre;
                direccionMod.value = direccion;
                fechaMod.value = fecha;
                correoMod.value = correo;
                sexoMod.value = sexo;
                idopcion.value = opcion;
                frm_mostrarCliente.submit();
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
        <h1>Cliente</h1>

        <form id="frm_mostrarCliente" name="frm_mostrarCliente" action="./ClienteServletInicial" method="POST">
            <label>Datos de Cliente</label>
            <input type="hidden" name="rutmod" id="rutmod"/>
            <input type="hidden" name="nombremod" id="nombremod"/>
            <input type="hidden" name="direccionMod" id="direccionMod"/>
            <input type="hidden" name="fechaMod" id="fechaMod"/>
            <input type="hidden" name="correoMod" id="correoMod"/>
            <input type="hidden" name="sexoMod" id="sexoMod"/>
            <input type="hidden" name="ACCION" id="ACCION"/>

            <table border="1">

                <tr>
                    <td ><b>RUT</b></td>
                    <td ><b>NOMBRE</b></td>
                    <td ><b>DIRECCION</b></td>
                    <td ><b>FECHA DE NACIMIENTO</b></td>
                    <td ><b>CORREO ELECTRONICO</b></td>
                    <td ><b>SEXO</b></td>
                    <td><b>OPCION</b> </td>
                </tr>
                <%for (Cliente cliente : clienteList) {%>
                <tr>
                    <td><%=cliente.getRut()%></td>
                    <td><%=cliente.getNombre()%></td>
                    <td><%=cliente.getDireccion()%></td>
                    <% String stFecha = Util.getFechaFormateada(cliente.getFechanacimiento());%>
                    <td><%=stFecha%></td>
                    <td><%=cliente.getCorreo()%></td>
                    <td><%=cliente.getSexo()%></td>
                    <td>
                        <input type="button" name="Editar" value="Editar" onclick ="editarFunction('<%=cliente.getRut()%>', '<%=cliente.getNombre()%>', '<%=cliente.getDireccion()%>', '<%=stFecha%>', '<%=cliente.getCorreo()%>', '<%=cliente.getSexo()%>', 'MODIFICAR')"/>
                    </td>    
                </tr><%}%>
            </table>
            <table>
                <tr>
                    <td>
                        <input type="button" name="btn_Agregar" value="AGREGAR NUEVO CLIENTE" onclick="agregar()"/>
                    </td>
                    <td>
                        <input type="button" name="btn_Eliminar" value="ELIMINAR CLIENTE" onclick="eliminar()"/>
                    </td>                    
                    <td>
                        <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
