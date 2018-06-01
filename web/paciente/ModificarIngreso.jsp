<%-- 
    Document   : ModificarIngreso
    Created on : 18-10-2017, 10:44:24
    Author     : Daniela
--%>
<%@page import="Modelo.Ingreso"%>
<%@page import="Modelo.Animal"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%
    HttpSession sesion = request.getSession();
    List<Usuario> listaUsuario = (List<Usuario>) sesion.getAttribute("Lista_Usuario");
    List<Usuario> listaRut = (List<Usuario>) sesion.getAttribute("Lista_RutMedico");
    List<Cliente> listaCliente = (List<Cliente>) sesion.getAttribute("Lista_Cliente");
    List<Animal> listaTipo = (List<Animal>) session.getAttribute("Lista_Tipo");
    Ingreso i = (Ingreso) session.getAttribute("Ingreso");
%>	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Modificar Ingreso</h1>
        <form name="frm_ModificarIngreso" action="./IngresoServletSecundario" method="POST">
            <% %>
            <table>
                <tr>
                    <td>
                        ID Atencion
                    </td>
                    <td>
                        <input type="text" name="txt_IdAtencion" value="<%=i.getIdAtencion()%>" readonly />
                    </td>
                </tr>
                <tr>
                    <td>
                        FECHA DE ATENCION
                    </td>
                    <td>
                        <input type="date" name="fecha_atencion" />
                    </td>
                </tr>
                <tr>
                    <td>
                        RUT USUARIO
                    </td>
                    <td>
                        <select name="cmb_RutUsuarioIngreso">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Usuario x : listaUsuario) {%>
                            <option value="<%=i.getRutUsuario()%>">
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        RUT MEDICO
                    </td>
                    <td>
                        <select name="cmb_RutMedicoIngreso">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Usuario x : listaRut) {%>
                            <option value="<%=i.getRutMedico()%>" >
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        RUT CLIENTE
                    </td>
                    <td>
                        <select name="cmb_RutClienteIngreso">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Cliente x : listaCliente) {%>
                            <option value="<%=i.getRutCliente()%>" >
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        TIPO DE MASCOTA
                    </td>
                    <td>
                        <select name="cmb_TipoMascotaIngreso">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Animal x : listaTipo) {%>
                            <option value="<%=i.getIdMascota()%>" >
                                <%=x.getNombre()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        DESCRIPCION DE SINTOMAS
                    </td>
                    <td>
                        <input type="text" name="txt_DescripcionIngreso" value="<%=i.getDescripcionSintomas()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        DIAGNOSTICO
                    </td>
                    <td>
                        <input type="text" name="txt_DIAGNOSTICOIngreso" value="<%=i.getDiagnostico()%>"  />
                    </td>
                </tr>
                <tr>
                    <td>
                        PROCEDIMIENTO
                    </td>
                    <td>
                        <input type="text" name="txt_PROCEDIMIENTOIngreso" value="<%=i.getProcedimiento()%>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        VALOR CONSULTA
                    </td>
                    <td>
                        <input type="text" name="txt_VALORCONSULTAIngreso" value="<%=i.getValorConsulta()%>" />
                    </td>
                </tr>

                <tr>
                    <td>
                        <input type="submit" name="btn_modificar" value="MODIFICAR"/>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
