<%-- 
    Document   : ModificarMascota
    Created on : 18-10-2017, 10:44:34
    Author     : Daniela
--%>
<%@page import="Modelo.Mascota"%>
<%@page import="Modelo.Animal"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
<%
    
    List<Cliente> listaCliente =(List<Cliente>)session.getAttribute("Lista_Cliente");
    List<Animal> listaTipo = (List<Animal>)session.getAttribute("Lista_TipoAnimal");
    Mascota m = (Mascota)session.getAttribute("Mascota");    
%>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>MEDIPET</title>
         
    </head>
    <body>
        <h1>Modificar Mascota</h1>
        <form name="frm_ModificarMascota" action="./MascotaServletSecundario" method="POST">
            
            <table>
                <% %>
                 <tr>
                    <td>
                       ID MASCOTA
                    </td>
                    <td>
                        <input type="text" name="txt_idMascota" value="<%=m.getIdMascota()%>" readonly/>
                    </td>
                </tr>
                <tr>
                    <td>
                        RUT CLIENTE
                    </td>
                    <td>
                        <select name="cmb_rutCliente_mascota">
                            <option><%= m.getRutCliente()%></option>
                            <% for(Cliente x: listaCliente){ %>
                                <option value="<%=x.getRut()%>">
                                    <%=x.getRut()%>
                                </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
               
                <td>
                    TIPO DE MASCOTA
                </td>
                <td>
                    <select name="cmb_tipoMascota">
                        <% for(Animal x: listaTipo){ %>
                        <option value="<%=m.getIdTipo()%>"> <%=x.getNombre()%></option>
                        <option value="<%=x.getIdtipo()%>"> <%=x.getNombre()%></option>
                            <%}%>
                    </select>
                </td>
                </tr>
                
                <tr>
                    <td>
                        NOMBRE
                    </td>
                    <td>
                        <input type="text" name="txt_mascota_nombre" value="<%=m.getNombre()%>" />
                    </td>
                </tr>

                <tr>
                    <td>
                        FECHA DE NACIMIENTO
                    </td>
                    <td>
                        <input type="date" name="fecha_nacimiento_mascota" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_modificar" value="MODIFICAR"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
