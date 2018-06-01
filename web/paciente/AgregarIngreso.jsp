<%-- 
    Document   : AgregarIngreso
    Created on : 18-10-2017, 10:41:53
    Author     : Daniela
--%>
<%@page import="Modelo.Mascota"%>

<%@page import="Modelo.Perfil"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%

    List<Usuario> listaUsuario = (List<Usuario>) session.getAttribute("Lista_Usuario");
    List<Usuario> listaRut = (List<Usuario>) session.getAttribute("Lista_RutMedico");
    List<Cliente> listaCliente = (List<Cliente>) session.getAttribute("Lista_Cliente");
    //List<Perfil> listaPerfil = (List<Perfil>)session.getAttribute("Lista_Perfil");
    List<Mascota> listaTipo = (List<Mascota>) session.getAttribute("Lista_Mascota");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MEDIPET</title>
    </head>
    <body>
        <h1>Agregar Atencion</h1>

        <form name="frm_AgregarConsulta" action="./IngresoServletSecundario" method="POST">

            <label>Ingrese los siguientes datos:</label>

            <table>
                <tr>
                    <td>
                        ID ATENCION
                    </td>
                    <td>
                        <input type="text" name="txt_IDAtencion" />
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
                            <option value="<%=x.getRut()%>">
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
                            <option value="<%=x.getRut()%>">
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
                            <option value="<%=x.getRut()%>">
                                <%=x.getRut()%>
                            </option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        MASCOTA
                    </td>
                    <td>
                        <select name="cmb_TipoMascotaIngreso">
                            <option value="0">--SELECCIONE--</option>
                            <% for (Mascota x : listaTipo) {%>
                            <option value="<%=x.getIdMascota()%>">
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
                        <input type="text" name="txt_DescripcionIngreso" />
                    </td>
                </tr>
                <tr>
                    <td>
                        DIAGNOSTICO
                    </td>
                    <td>
                        <input type="text" name="txt_DIAGNOSTICOIngreso" />
                    </td>
                </tr>
                <tr>
                    <td>
                        PROCEDIMIENTO
                    </td>
                    <td>
                        <input type="text" name="txt_PROCEDIMIENTOIngreso" />
                    </td>
                </tr>
                <tr>
                    <td>
                        VALOR CONSULTA
                    </td>
                    <td>
                        <input type="text" name="txt_VALORCONSULTAIngreso" />
                    </td>
                </tr>

            </table>

            <input type="submit" name="btn_agregar" value="Ingresar"/>

        </form>
    </body>
</html>
