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
            //f, t, RutUsuario, RutMedico, RutCliente, Descripcion, diagnostico, procedimiento, v
            function editarFunction(id, fecha, tipo, rutusuario, rutmedico, rutcliente, desc, diag, proc, valor, opcion) {
                var frm_mostrarIngreso = document.getElementById("frm_mostrarIngreso");
                var idAtencionMod = document.getElementById("idAtencionMod");
                var fechaMod = document.getElementById("fechaMod");
                var idMascotaMod = document.getElementById("idMascotaMod");
                var rutUsuarioMod = document.getElementById("rutUsuarioMod");
                var rutMedicoMod = document.getElementById("rutMedicoMod");
                var rutClienteMod = document.getElementById("rutClienteMod");
                var descripcionMod = document.getElementById("descripcionMod");
                var diagnnosticoMod = document.getElementById("diagnnosticoMod");
                var procedimientoMod = document.getElementById("procedimientoMod");
                var valorMod = document.getElementById("valorMod");
                var idopcion = document.getElementById("ACCION");
                idAtencionMod.value = id;
                fechaMod.value = fecha;
                idMascotaMod.value = tipo;
                rutUsuarioMod.value = rutusuario;
                rutMedicoMod.value = rutmedico;
                rutClienteMod.value = rutcliente;
                descripcionMod.value = desc;
                diagnnosticoMod.value = diag;
                procedimientoMod.value = proc;
                valorMod.value = valor;
                idopcion.value = opcion;
                frm_mostrarIngreso.submit();
            }
             function volver(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarIngreso");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                frm_mostrarCliente.submit();
            }
            function agregar(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarIngreso");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'AGREGAR';
                frm_mostrarCliente.submit();
                
            }
            function eliminar(){
                var frm_mostrarCliente = document.getElementById("frm_mostrarIngreso");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'ELIMINAR';
                frm_mostrarCliente.submit();
            }
        </script>
    </head>
    <body>
        <h1>Atenciones Ingresadas</h1>
        <form id="frm_mostrarIngreso" name="frm_mostrarIngreso" action="./IngresoServletInicial" method="POST">
            <input type="hidden" name="idAtencionMod" id="idAtencionMod"/>
            <input type="hidden" name="fechaMod" id="fechaMod"/>
            <input type="hidden" name="idMascotaMod" id="idMascotaMod"/>
            <input type="hidden" name="rutUsuarioMod" id="rutUsuarioMod"/>
            <input type="hidden" name="rutMedicoMod" id="rutMedicoMod"/>
            <input type="hidden" name="rutClienteMod" id="rutClienteMod"/>
            <input type="hidden" name="descripcionMod" id="descripcionMod"/>
            <input type="hidden" name="diagnnosticoMod" id="diagnnosticoMod"/>
            <input type="hidden" name="procedimientoMod" id="procedimientoMod"/>
            <input type="hidden" name="valorMod" id="valorMod"/>            
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
                    <td><b>OPCION</b> </td>
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
                    <td>
                        <input type="button" name="Editar" value="Editar" onclick ="editarFunction('<%=consulta.getIdAtencion()%>', '<%=stFecha%>', '<%=consulta.getIdMascota()%>', '<%=consulta.getRutUsuario()%>', '<%=consulta.getRutMedico()%>', '<%=consulta.getRutCliente()%>', '<%=consulta.getDescripcionSintomas()%>', '<%=consulta.getDiagnostico()%>', '<%=consulta.getProcedimiento()%>', '<%=consulta.getValorConsulta()%>', 'MODIFICAR')"/>
                    </td>
                </tr><%}%>
            </table>
            <table>
                <tr>
                    <td>
                        <input type="button" name="btn_Agregar" value="AGREGAR NUEVO ATENCION" onclick="agregar()"/>
                    </td>
                    <td>
                        <input type="button" name="btn_Eliminar" value="ELIMINAR ATENCION" onclick="eliminar()"/>
                    </td>
                    <td>
                        <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
