<%-- 
    Document   : MostrarTipoAnimal
    Created on : 30-10-2017, 13:30:06
    Author     : Daniela
--%>

<%@page import="Modelo.Animal"%>
<%@page import="java.util.List"%>
<% List<Animal> listaTipo = (List<Animal>) session.getAttribute("Lista_Tipo"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function editarFunction(id, nombre, opcion) {
                var frm_MostrarTipo = document.getElementById("frm_MostrarTipo");
                var idtipomod = document.getElementById("idtipomod");
                var nombremod = document.getElementById("nombremod");
                var idopcion = document.getElementById("btn_Modificar");
                idtipomod.value = id;
                nombremod.value = nombre;
                idopcion.value = opcion;                
                frm_MostrarTipo.submit();
            }
            
            function volver(){
                var frm_mostrarCliente = document.getElementById("frm_MostrarTipo");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                frm_mostrarCliente.submit();
            }
            function agregar(){
                var frm_mostrarCliente = document.getElementById("frm_MostrarTipo");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'AGREGAR';
                frm_mostrarCliente.submit();
                
            }
            function eliminar(){
                var frm_mostrarCliente = document.getElementById("frm_MostrarTipo");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'ELIMINAR';
                frm_mostrarCliente.submit();
            }

        </script>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medipet</title>
    </head>
    <body>
        <form id="frm_MostrarTipo" name="frm_MostrarTipo" action="./TipoAnimalServlet" method="POST">
            <h1>Datos Tipo Animal</h1>

            <input type="hidden" name="idtipomod" id="idtipomod"/>
            <input type="hidden" name="nombremod" id="nombremod"/>
            <input type="hidden" name="ACCION" id="ACCION"/>
            <table border="1">

                <tr>

                    <td ><b>ID TIPO MASCOTA</b></td>
                    <td ><b>NOMBRE</b></td>
                    <td><b>OPCION</b> </td>
                </tr>
                <% for (Animal tipo : listaTipo) {%>
                <tr>
                    <td><%= tipo.getIdtipo()%></td>
                    <td><%= tipo.getNombre()%></td>
                    <td>
                        <input type="button" name="Editar" value="Editar" onclick ="editarFunction('<%=tipo.getIdtipo()%>', '<%=tipo.getNombre()%>', 'M')"/>
                    </td> 
                </tr><%}%>
            </table>
            <table>
                <tr>
                    <td>
                        <input type="button" name="btn_Agregar" value="AGREGAR NUEVO TIPO ANIMAL" onclick="agregar()"/>
                    </td>
                    <td>
                        <input type="button" name="btn_Eliminar" value="ELIMINAR TIPO ANIMAL" onclick="eliminar()"/>
                    </td>                
                    <td>
                        <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
                    </td>
                </tr>     

            </table>

        </form>

    </body>
</html>
