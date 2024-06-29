<%@page import="Clases.Administrador"%>
<%@page import="dao.daoAdministrador"%>
<%@page import="dao.daoCliente"%>
<%@page import="Clases.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/gestionUsuarios.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <title>Pagina Gestión Clientes</title>
    </head>
    <body>

        <%
            daoCliente obj = new daoCliente();
            daoAdministrador obj2 = new daoAdministrador();
            String tipo = request.getParameter("tipo");
            Clientes p = null;
            Administrador a = null;
            if (request.getAttribute("dato") instanceof Clientes) {
                p = (Clientes) request.getAttribute("dato");
            } else if (request.getAttribute("dato") instanceof Administrador) {
                a = (Administrador) request.getAttribute("dato");
            }
        %>
        <div class="container">
            <div class="button-container">
                <a href="pagGestionUsuarios.jsp?tipo=clientes" class="button">
                    <img src="Imagenes/cliente-boton.png" alt="Clientes">
                    <p>Clientes</p>
                </a>
                <a href="pagGestionUsuarios.jsp?tipo=empleados" class="button">
                    <img src="Imagenes/empleado-boton.png" alt="Empleados">
                    <p>Empleados</p>
                </a>
            </div>
            <div class="form-container">
                <h2>Información :</h2>
                <form action="controlCliente">
                    <div class="form-grid">
                        <label class="input-container">
                            <input type="text" id="id" name="id" value="<%= (p != null) ? p.getId() : (a != null) ? a.getId() : ""%>" class="input" placeholder=" " readonly>
                            <span class="label__name">Id</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="nombre" name="nombre" value="<%= (p != null) ? p.getNombre() : (a != null) ? a.getNombre() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Nombre</span>
                        </label>
                        <!-- Repite esto para los demás campos -->
                        <label class="input-container">
                            <input type="text" id="apellidoP" name="apellidoP" value="<%= (p != null) ? p.getApellidoP() : (a != null) ? a.getApellidoP() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Apellido Paterno</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="apellidoM" name="apellidoM" value="<%= (p != null) ? p.getApellidoM() : (a != null) ? a.getApellidoM() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Apellido Materno</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="dni" name="dni" value="<%= (p != null) ? p.getDni() : (a != null) ? a.getDni() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">DNI</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="telefono" name="telefono" value="<%= (p != null) ? p.getTelefono() : (a != null) ? a.getTelefono() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Teléfono</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="edad" name="edad" value="<%= (p != null) ? p.getEdad() : (a != null) ? a.getEdad() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Edad</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="rango" name="rango" value="<%= (p != null) ? p.getRango() : (a != null) ? a.getRango() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Rango</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="user" name="user" value="<%= (p != null) ? p.getUser() : (a != null) ? a.getUser() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Usuario</span>
                        </label>
                        <label class="input-container">
                            <input type="password" id="contraseña" name="contraseña" value="<%= (p != null) ? p.getContraseña() : (a != null) ? a.getContraseña() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Contraseña</span>
                        </label>
                        <label class="input-container">
                            <input type="text" id="estado" name="estado" value="<%= (p != null) ? p.getEstado() : (a != null) ? a.getEstado() : ""%>" class="input" placeholder=" ">
                            <span class="label__name">Estado</span>
                        </label>
                        <div class="add-button-container">
                            <button type="submit" class="add-button" name="opc" value="1">
                                Añadir <i class="fas fa-plus-circle"></i>
                            </button>
                            <button type="submit" class="edit-button" name="opc" value="2">
                                Editar <i class="fas fa-edit"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="table-container">
                <table id="data-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido P.</th>
                            <th>Apellido M.</th>
                            <th>DNI</th>
                            <th>Teléfono</th>
                            <th>Edad</th>
                            <th>Rango</th>
                            <th>Usuario</th>
                            <th>Contraseña</th>
                            <th>Estado</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if ("clientes".equals(tipo)) {
                                for (Clientes x : obj.obtenerTodosClientes()) {
                        %>
                        <tr>
                            <td><%=x.getId()%></td>
                            <td><%=x.getNombre()%></td>
                            <td><%=x.getApellidoP()%></td>
                            <td><%=x.getApellidoM()%></td>
                            <td><%=x.getDni()%></td>
                            <td><%=x.getTelefono()%></td>
                            <td><%=x.getEdad()%></td>
                            <td><%=x.getRango()%></td>
                            <td><%=x.getUser()%></td>
                            <td><%=x.getContraseña()%></td>
                            <td><%=x.getEstado()%></td>
                            <td><a href="controlCliente?opc=5&nro=<%=x.getId()%>">Edit</a></td>
                            <td><a href="controlCliente?opc=3&nro=<%=x.getId()%>">Delete</a></td>
                        </tr>
                        <%
                            }
                        } else if ("empleados".equals(tipo)) {
                            for (Administrador y : obj2.obtenerTodosAdministradores()) {
                        %>
                        <tr>
                            <td><%=y.getId()%></td>
                            <td><%=y.getNombre()%></td>
                            <td><%=y.getApellidoP()%></td>
                            <td><%=y.getApellidoM()%></td>
                            <td><%=y.getDni()%></td>
                            <td><%=y.getTelefono()%></td>
                            <td><%=y.getEdad()%></td>
                            <td><%=y.getRango()%></td>
                            <td><%=y.getUser()%></td>
                            <td><%=y.getContraseña()%></td>
                            <td><%=y.getEstado()%></td>
                            <td><a href="controlCliente?opc=6&nro=<%=y.getId()%>">Edit</a></td>
                            <td><a href="controlCliente?opc=3&nro=<%=y.getId()%>">Delete</a></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="Javascript/pagGestionUsuario.js"></script>
    </body>

    <%
       
    %>
</html>

