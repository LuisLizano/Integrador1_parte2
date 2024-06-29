package Controlador;

import Clases.Clientes;
import dao.daoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlCliente extends HttpServlet {

    daoCliente obj = new daoCliente();
    Clientes c = new Clientes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int op = Integer.parseInt(request.getParameter("opc"));

        if (op == 1) {
            añadeCliente(request, response);
        }

        if (op == 2) {
            editarCliente(request, response);
        }

        if (op == 3) {
            eliminarCliente(request, response);
        }

        if (op == 4) {
            desabilitarCliente(request, response);
        }
        
        if (op == 5) {
            consultaCliente(request, response);
        }
        
        
    }

    protected void añadeCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");


        if (obj.usuarioExisteEnAmbasTablas(usuario)) {

            request.setAttribute("error", "El nombre de usuario ya está en uso.");
            String pag = "/pagRegistro.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
            return;
        }

        c.setNombre(request.getParameter("nombres"));
        c.setApellidoP(request.getParameter("apellidoP"));
        c.setApellidoM(request.getParameter("apellidoM"));
        c.setDni(Integer.parseInt(request.getParameter("dni")));
        c.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        c.setEdad(Integer.parseInt(request.getParameter("edad")));
        c.setUser(usuario);
        c.setContraseña(request.getParameter("contraseña"));
        obj.añadirCliente(c);
        String pag = "/pagRegistro.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setNombre(request.getParameter("nombre"));
        c.setApellidoP(request.getParameter("apellidoP"));
        c.setApellidoM(request.getParameter("apellidoM"));
        c.setDni(Integer.parseInt(request.getParameter("dni")));
        c.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        c.setEdad(Integer.parseInt(request.getParameter("edad")));
        c.setRango(request.getParameter("rango"));
        c.setUser(request.getParameter("user"));
        c.setContraseña(request.getParameter("contraseña"));
        c.setEstado(request.getParameter("estado"));
        obj.editarCliente(c);
        String pag = "/pagGestionUsuarios.jsp?tipo=clientes";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void desabilitarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        c.setId(Integer.parseInt(request.getParameter("id")));
        obj.desabilitarCliente(c);
        String pag = "/pagGestionUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("nro"));
        obj.eliminarCliente(id);
        String pag = "/pagGestionUsuarios.jsp?tipo=clientes";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void consultaCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nro = Integer.parseInt(request.getParameter("nro"));
        c = obj.consultaCliente(nro);
        request.setAttribute("dato", c);
        String pag = "/pagGestionUsuarios.jsp?tipo=clientes";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
