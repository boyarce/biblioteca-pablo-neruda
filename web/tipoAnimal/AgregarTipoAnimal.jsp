<%-- 
    Document   : AgregarTipoAnimal
    Created on : 17-10-2017, 15:57:34
    Author     : Daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Agregar Tipo de Mascota</h1>

        <form name="frm_AgregarAnimal" action="./TipoServletSecundario" method="POST">
           
             <label>Ingrese los siguientes datos:</label>
            <table>
               
                <tr>
                    <td>
                        ID TIPO
                    </td>
                    <td>
                        <input type="text" name="txt_IdTipo" />
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_animal_nombre" />
                    </td>
                </tr>

            </table>

            <input type="submit" name="btn_agregar" value="Ingresar"/>

        </form>
    </body>
</html>
