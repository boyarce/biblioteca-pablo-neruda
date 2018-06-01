<%-- 
    Document   : MenuUsuario
    Created on : 03-11-2017, 11:42:34
    Author     : Daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
        <script>
            function enviarServer(opt) {

                var formulario = document.getElementById("frm_IndexMostrarCapaUsuario");
                var idopcion = document.getElementById("ACCION");
                idopcion.value = opt;
                formulario.submit();
            }
        </script>
    </head>
    <body>
        <form id="frm_IndexMostrarCapaUsuario" name="frm_IndexMostrarCapaUsuario" action="./IndexUsuarios" method="POST">
            <input type="hidden" name="ACCION" id="ACCION"/>
            <table>
                <tr>
                    <td>
                        <input type="button" name="btn_mostrarCliente" value="MOSTRAR CLIENTES" onclick="enviarServer('MOSTRAR_CLIENTE')"/>            
                    </td>
                    <td>
                        <input type="button" name="btn_mostrarAtenciones" value="MOSTRAR ATENCIONES" onclick="enviarServer('MOSTRAR_ATENCIONES')"/>
                    </td>
                    <td>
                        <input type="button" name="btn_mostrarMascotas" value="MOSTRAR MASCOTAS" onclick="enviarServer('MOSTRAR_MASCOTAS')"/>           
                    </td>
                </tr>
            </table>


            <fieldset>
                <legend>Busquedas</legend>
                <table>
                    <tr>
                        <td>
                            BUSCAR MASCOTA POR CLIENTE
                        </td>
                        <td>
                            <input type="button" name="btn_buscarxCliente" value="BUSCAR" onclick="enviarServer('BUSCAR_MAS_X_CLI')"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            BUSCAR ATENCIONES POR RUT CLIENTE
                        </td>
                        <td>
                            <input type="button" name="btn_buscarxrut" value="BUSCAR" onclick="enviarServer('BUSCAR_AT_X_CLI')"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            BUSCAR ATENCIONES POR MASCOTA
                        </td>
                        <td>
                            <input type="button" name="btn_buscarxMascota" value="BUSCAR" onclick="enviarServer('BUSCAR_AT_X_MAS')"/>
                        </td>
                    </tr>
                </table>
            </fieldset>

        </form>
    </body>
</html>
