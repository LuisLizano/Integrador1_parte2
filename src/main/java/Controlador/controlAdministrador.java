
package Controlador;

import Clases.Administrador;
import dao.daoAdministrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlAdministrador extends HttpServlet {
    
    daoAdministrador obj = new daoAdministrador();
    Administrador a = new Administrador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int op = Integer.parseInt(request.getParameter("opc"));

        if (op == 1) {
            añadeAdministrador(request, response);
        }

        if (op == 2) {
            editarAdministrador(request, response);
        }

        if (op == 3) {
            eliminarAdministrador(request, response);
        }

        if (op == 4) {
            desabilitarAdministrador(request, response);
        }
        
    }
    
    protected void añadeAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");


        if (obj.usuarioExisteEnAmbasTablas(usuario)) {

            request.setAttribute("error", "El nombre de usuario ya está en uso.");
            String pag = "/pagRegistro.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
            return;
        }

        a.setNombre(request.getParameter("nombres"));
        a.setApellidoP(request.getParameter("apellidoP"));
        a.setApellidoM(request.getParameter("apellidoM"));
        a.setDni(Integer.parseInt(request.getParameter("dni")));
        a.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        a.setEdad(Integer.parseInt(request.getParameter("edad")));
        a.setUser(usuario);
        a.setContraseña(request.getParameter("contraseña"));
        obj.añadirAdministrador(a);
        String pag = "/pagGestionUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void editarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        a.setId(Integer.parseInt(request.getParameter("id")));
        a.setNombre(request.getParameter("nombre"));
        a.setApellidoP(request.getParameter("apellidoP"));
        a.setApellidoM(request.getParameter("apellidoM"));
        a.setDni(Integer.parseInt(request.getParameter("dni")));
        a.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        a.setEdad(Integer.parseInt(request.getParameter("edad")));
        a.setRango(request.getParameter("rango"));
        a.setUser(request.getParameter("user"));
        a.setContraseña(request.getParameter("contraseña"));
        a.setEstado(request.getParameter("estado"));
        obj.editarAdministrador(a);
        String pag = "/pagGestionUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void desabilitarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        a.setId(Integer.parseInt(request.getParameter("id")));
        obj.desabilitarAdministrador(a);
        String pag = "/pagGestionUsuarios.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void eliminarAdministrador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("nro"));
        obj.eliminarAdministrador(id);
        String pag = "/pagGestionUsuarios.jsp";
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
