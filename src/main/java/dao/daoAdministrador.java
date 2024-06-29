package dao;

import Clases.*;
import Conexion.MySQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class daoAdministrador {

    Connection cn;
    PreparedStatement st;
    ResultSet rs;

    public String existeAdministrador(Administrador a) {
        cn = MySQLConexion.getConexion();
        String sql = "SELECT Rango FROM Administrador WHERE Usuario = ? AND Contraseña = ?;";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, a.getUser());
            st.setString(2, a.getContraseña());
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("Rango");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean añadirAdministrador(Administrador a) {
        if (usuarioExisteEnAmbasTablas(a.getUser())) {
            return false;
        }

        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO Administrador (nombre, apellidoP, apellidoM, dni, telefono, edad, rango, usuario, contraseña, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, a.getNombre());
            st.setString(2, a.getApellidoP());
            st.setString(3, a.getApellidoM());
            st.setInt(4, a.getDni());
            st.setInt(5, a.getTelefono());
            st.setInt(6, a.getEdad());
            st.setString(7, "Administrador");
            st.setString(8, a.getUser());
            st.setString(9, a.getContraseña());
            st.setString(10, "Activo");
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean usuarioExisteEnAmbasTablas(String usuario) {
        boolean existe = false;
        Connection cn = MySQLConexion.getConexion();
        String sqlCliente = "SELECT * FROM Cliente WHERE Usuario = ?";
        String sqlAdmin = "SELECT * FROM Administrador WHERE Usuario = ?";

        try {
            PreparedStatement stCliente = cn.prepareStatement(sqlCliente);
            stCliente.setString(1, usuario);
            ResultSet rsCliente = stCliente.executeQuery();
            if (rsCliente.next()) {
                existe = true;
            }
            rsCliente.close();
            stCliente.close();

            if (!existe) {
                PreparedStatement stAdmin = cn.prepareStatement(sqlAdmin);
                stAdmin.setString(1, usuario);
                ResultSet rsAdmin = stAdmin.executeQuery();
                if (rsAdmin.next()) {
                    existe = true;
                }
                rsAdmin.close();
                stAdmin.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return existe;
    }

    public boolean editarAdministrador(Administrador a) {
        cn = MySQLConexion.getConexion();
        String sql = "UPDATE Administrador SET nombre = ?, apellidoP = ?, apellidoM = ?, dni = ?, telefono = ?, edad = ?, rango = ?, usuario = ?, contraseña = ?, estado = ? WHERE id = ?";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, a.getNombre());
            st.setString(2, a.getApellidoP());
            st.setString(3, a.getApellidoM());
            st.setInt(4, a.getDni());
            st.setInt(5, a.getTelefono());
            st.setInt(6, a.getEdad());
            st.setString(7, a.getRango());
            st.setString(8, a.getUser());
            st.setString(9, a.getContraseña());
            st.setString(10, a.getEstado());
            st.setInt(11, a.getId());
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAdministrador(int id) {
        cn = MySQLConexion.getConexion();
        String sql = "DELETE FROM Administrador WHERE id = ?";
        try {
            st = cn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean desabilitarAdministrador(Administrador a) {
        cn = MySQLConexion.getConexion();
        String sql = "UPDATE Administrador SET estado = ? WHERE id = ?";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, a.getEstado());
            st.setInt(2, a.getId());
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Administrador> obtenerTodosAdministradores() {
        cn = MySQLConexion.getConexion();
        String sql = "SELECT * FROM Administrador";
        List<Administrador> lista = new ArrayList<>();
        try {
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Administrador a = new Administrador();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setApellidoP(rs.getString("apellidoP"));
                a.setApellidoM(rs.getString("apellidoM"));
                a.setDni(rs.getInt("dni"));
                a.setTelefono(rs.getInt("telefono"));
                a.setEdad(rs.getInt("edad"));
                a.setRango(rs.getString("rango"));
                a.setUser(rs.getString("usuario"));
                a.setContraseña(rs.getString("contraseña"));
                a.setEstado(rs.getString("estado"));
                lista.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
