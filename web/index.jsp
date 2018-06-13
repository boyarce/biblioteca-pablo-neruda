<%-- 
    Document   : index
    Created on : 17-10-2017, 14:19:20
    Author     : Daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BIBLIOTECA</title>
        <script>
            function onInit(){
                
                var frm_inicial = document.getElementById('frm_inicial');
                var inicio = document.getElementById('inicio');
                inicio.value = "I";
                frm_inicial.submit();
            }
            
        </script>
    </head>
    <body onload="onInit()">
        <form id="frm_inicial" name="frm_inicial" action="./IndexServlet" method="POST">
            <input type="Hidden" id="inicio" name="inicio" value="ok"/>
        </form>
        
    </body>
</html>
