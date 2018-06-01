<%-- 
    Document   : buscarMascotaXCliente
    Created on : 05-11-2017, 3:59:40
    Author     : Daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPED</title>
            <script>
            
            function volver(){
                var formulario = document.getElementById("formulario");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'VOLVER';
                formulario.submit();
            }
            function buscar(){
                var formulario = document.getElementById("formulario");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = 'BUSCAR_MASCOTA_X_CLIENTE';
                formulario.submit();
                
            }

        </script>
    </head>
    <body>
        <form id="formulario" name="formulario" action="./BuscarServlet" method="POST">
            <input type="hidden" name="ACCION" id="ACCION"/>
            <label>Busqueda Por Cliente</label>
            <br>
            <p>Ingrese Rut Cliente</p>
            <input type="text" name="rutCliente" id="cliente"/>
            <br>
            <input type="button" name="Btn_Buscar" value="Buscar" onclick="buscar()"/>
            <input type="button" name="Btn_Volver" value="Volver" onclick="volver()"/>
        </form>
    </body>
</html>
