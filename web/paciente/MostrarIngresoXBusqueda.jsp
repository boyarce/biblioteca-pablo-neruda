<%-- 
    Document   : MostrarIngreso
    Created on : 17-10-2017, 15:57:49
    Author     : Daniela
--%>
<%@page import="Util.Util"%>
<%@page import="Modelo.Ingreso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    List<Ingreso> listaIngreso = (List<Ingreso>) session.getAttribute("Lista_Ingreso");
    Ingreso i = (Ingreso) session.getAttribute("Ingreso");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        <script>
            function volver(){
                var formulario = document.getElementById("frm_mostrarIngreso");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                formulario.submit();
            }
        </script>
    </head>
    <body>
        <h1>Atenciones Ingresadas</h1>
        <form id="frm_mostrarIngreso" name="frm_mostrarIngreso" action="./BuscarServlet" method="POST">
            <input type="hidden" name="ACCION" id="ACCION"/>
            <label>Datos de Atenciones</label>
            <table border="1">

                <tr>
                    <td ><b>ID ATENCION</b></td>
                    <td ><b>FECHA DE ATENCION</b></td>
                    <td ><b>ID MASCOTA</b></td>
                    <td ><b>RUT USUARIO</b></td>
                    <td ><b>RUT MEDICO</b></td>
                    <td ><b>RUT CLIENTE</b></td>
                    <td ><b>DESCRIPCION DE SINTOMAS</b></td>
                    <td ><b>DIAGNOSTICO</b></td>
                    <td ><b>PROCEDIMIENTO</b></td>
                    <td ><b>VALOR CONSULTA</b></td>
                    
                </tr>
                <% for (Ingreso consulta : listaIngreso) {%>
                <tr>
                    <td><%=consulta.getIdAtencion()%></td>
                    <% String stFecha = Util.getFechaFormateada(consulta.getFechaAtencion());%>
                    <td><%=stFecha%></td>
                    <td><%=consulta.getIdMascota()%></td>
                    <td><%=consulta.getRutUsuario()%></td>
                    <td><%=consulta.getRutMedico()%></td>
                    <td><%=consulta.getRutCliente()%></td>
                    <td><%=consulta.getDescripcionSintomas()%></td>
                    <td><%=consulta.getDiagnostico()%></td>
                    <td><%=consulta.getProcedimiento()%></td>
                    <td><%=consulta.getValorConsulta()%></td>
                    
                </tr><%}%>
            </table>
            <table>
                <tr>
                    <td>
                        <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
