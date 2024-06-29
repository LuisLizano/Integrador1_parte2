
package dao;

import Clases.Usuario;
import Conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class daoUsuario {
    
    Connection cn;
    PreparedStatement st;
    ResultSet rs;   
    Usuario u = new Usuario();
    
    public String existeUsuario(Usuario u) {
        cn = MySQLConexion.getConexion();
        String sql = "SELECT Rango FROM Usuario WHERE Usuario = ? AND Contraseña = ?;";
        try {
            st = cn.prepareStatement(sql);
            st.setString(1, u.getUser());
            st.setString(2, u.getContraseña());
            rs = st.executeQuery();
            if (rs.next()) {               
                return rs.getString("Rango");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
