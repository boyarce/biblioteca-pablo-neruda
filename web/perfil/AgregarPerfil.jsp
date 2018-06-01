<%-- 
    Document   : AgregarPerfil
    Created on : 17-10-2017, 15:00:18
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
       <h1>Agregar Perfil</h1>
        
         <form name="frm_AgregarPerfil" action="./PerfilServletSecundario" method="POST">
            <label>Ingrese los siguientes datos:</label>
             
             <table>
                 <tr>
                    <td>
                        ID PERFIL
                    </td>
                    <td>
                         <input type="text" name="txt_IdPerfil" />
                    </td>
                </tr>
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                         <input type="text" name="txt_perfil_nombre" />
                    </td>
                </tr>
               
            </table>
            
                        <input type="submit" name="btn_agregar" value="Ingresar"/>
                 
        </form>
    </body>
</html>
