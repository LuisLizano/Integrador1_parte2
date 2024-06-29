package dao;

import Clases.*;
import Conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class daoCliente {

    Connection cn;
    PreparedStatement st;
    ResultSet rs;

    public String existeCliente(Clientes c) {
        cn = MySQLConexion.getConexion();
        String sql = "SELECT Rango FROM Cliente WHERE Usuario = ? AND Contraseña = ?;";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, c.getUser());
            st.setString(2, c.getContraseña());
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("Rango");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean añadirCliente(Clientes c) {
        if (usuarioExisteEnAmbasTablas(c.getUser())) {
            return false;
        }

        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO Cliente (nombre, apellidoP, apellidoM, dni, telefono, edad, rango, usuario, contraseña, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getNombre());
            st.setString(2, c.getApellidoP());
            st.setString(3, c.getApellidoM());
            st.setInt(4, c.getDni());
            st.setInt(5, c.getTelefono());
            st.setInt(6, c.getEdad());
            st.setString(7, "Cliente");
            st.setString(8, c.getUser());
            st.setString(9, c.getContraseña());
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

    public boolean editarCliente(Clientes c) {
        cn = MySQLConexion.getConexion();
        String sql = "UPDATE Cliente SET nombre = ?, apellidoP = ?, apellidoM = ?, dni = ?, telefono = ?, edad = ?, rango = ?, usuario = ?, contraseña = ?, estado = ? WHERE id = ?";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, c.getNombre());
            st.setString(2, c.getApellidoP());
            st.setString(3, c.getApellidoM());
            st.setInt(4, c.getDni());
            st.setInt(5, c.getTelefono());
            st.setInt(6, c.getEdad());
            st.setString(7, c.getRango());
            st.setString(8, c.getUser());
            st.setString(9, c.getContraseña());
            st.setString(10, c.getEstado());
            st.setInt(11, c.getId());
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(int id) {
        cn = MySQLConexion.getConexion();
        String sql = "DELETE FROM Cliente WHERE id = ?";
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

    public boolean desabilitarCliente(Clientes c) {
        cn = MySQLConexion.getConexion();
        String sql = "UPDATE Cliente SET estado = ? WHERE id = ?";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, c.getEstado());
            st.setInt(2, c.getId());
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Clientes> obtenerTodosClientes() {
        cn = MySQLConexion.getConexion();
        String sql = "SELECT * FROM Cliente";
        List<Clientes> lista = new ArrayList<>();
        try {
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidoP(rs.getString("apellidoP"));
                c.setApellidoM(rs.getString("apellidoM"));
                c.setDni(rs.getInt("dni"));
                c.setTelefono(rs.getInt("telefono"));
                c.setEdad(rs.getInt("edad"));
                c.setRango(rs.getString("rango"));
                c.setUser(rs.getString("usuario"));
                c.setContraseña(rs.getString("contraseña"));
                c.setEstado(rs.getString("estado"));
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Clientes consultaCliente(int id) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "SELECT id, nombre, apellidoP, apellidoM, dni, telefono, edad, rango, usuario, contraseña, estado FROM Cliente WHERE id = ?;";
        Clientes c = null;
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Clientes();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidoP(rs.getString("apellidoP"));
                c.setApellidoM(rs.getString("apellidoM"));
                c.setDni(rs.getInt("dni"));
                c.setTelefono(rs.getInt("telefono"));
                c.setEdad(rs.getInt("edad"));
                c.setRango(rs.getString("rango"));
                c.setUser(rs.getString("usuario"));
                c.setContraseña(rs.getString("contraseña"));
                c.setEstado(rs.getString("estado"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
}
