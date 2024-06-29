package Controlador;

import Clases.*;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validar extends HttpServlet {

    Administrador admin = new Administrador();
    Clientes cliente = new Clientes();
    daoAdministrador daoAdmin = new daoAdministrador();
    daoCliente daoCliente = new daoCliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));

        if (op == 1) {
            login(request, response);
        }
        
        if (op == 2) {
            dirigirRegistro(request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        admin.setUser(usuario);
        admin.setContraseña(contraseña);
        cliente.setUser(usuario);
        cliente.setContraseña(contraseña);
        String rangoAdmin = daoAdmin.existeAdministrador(admin);
        String rangoCliente = daoCliente.existeCliente(cliente);

        String pag = "";
        if (rangoAdmin != null) {
            ses.setAttribute("Administrador", admin);
            pag = "/pagPrincipalA.jsp";
        } else if (rangoCliente != null) {
            ses.setAttribute("Cliente", cliente);
            pag = "/pagPrincipal.jsp";
        }

        if (!pag.isEmpty()) {
            request.getRequestDispatcher(pag).forward(request, response);
        } else {
            pag = "pagInicio.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        }
    }

    protected void dirigirRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pag = "/pagRegistro.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
