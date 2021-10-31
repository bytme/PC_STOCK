
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.UsuarioModel;
import restful.Model.conexion;

public class UsuarioServices {
    
    public ArrayList<UsuarioModel> getusuario() {
        ArrayList<UsuarioModel> lista = new ArrayList<>();
        conexion conn = new conexion();
        String sql = "SELECT * FROM usuario";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                // llegue hasta aqui
                UsuarioModel usuario = new UsuarioModel();
                usuario.setCodigo_usu(rs.getInt("codigo_usu"));
                usuario.setNombre_usu(rs.getString("nombre_usu"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCodigo_tipo_usu(rs.getString("codigo_tipo_usu"));
                usuario.setCodigo_estado_usu(rs.getString("codigo_estado_usu"));
                
                
                lista.add(usuario);
            }
        } catch (SQLException e) {
        }

        return lista;
}
     public UsuarioModel getUsuario(int codigo_usu) {
        UsuarioModel usuario = new UsuarioModel();
        conexion conex = new conexion();
        String Sql = "SELECT * FROM usuario WHERE codigo_usu = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, codigo_usu);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                usuario.setCodigo_usu(rs.getInt("codigo_usu"));
                usuario.setNombre_usu(rs.getString("nombre_usu"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCodigo_tipo_usu(rs.getString("codigo_tipo_usu"));
                usuario.setCodigo_estado_usu(rs.getString("codigo_estado_usu"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuario;
   }
      public UsuarioModel addUsuario(UsuarioModel usuario) {
        conexion conex = new conexion();
        String Sql = "INSERT INTO usuario(codigo_usu,nombre_usu,usuario,password,email,codigo_tipo_usu,codigo_estado_usu)";
        Sql = Sql + "values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, usuario.getCodigo_usu());
            pstm.setString(2, usuario.getNombre_usu());
            pstm.setString(3, usuario.getUsuario());
            pstm.setString(4, usuario.getPassword());
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getCodigo_tipo_usu());
            pstm.setString(7, usuario.getCodigo_estado_usu());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return usuario;
  }
      public UsuarioModel updateUsuario(UsuarioModel usuario) {
        conexion conn = new conexion();
        String sql = "UPDATE usuario SET nombre_usu=?,usuario=?,password=?,email=?,codigo_tipo_usu=?,Codigo_estado_usu=? WHERE codigo_usu= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, usuario.getCodigo_usu());
            pstm.setString(2, usuario.getNombre_usu());
            pstm.setString(3, usuario.getUsuario());
            pstm.setString(4, usuario.getPassword());
            pstm.setString(5, usuario.getEmail());
            pstm.setString(6, usuario.getCodigo_tipo_usu());
            pstm.setString(7, usuario.getCodigo_estado_usu());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return usuario;
    }
       public String delUsuario(int codigo_usu) {
        conexion conn = new conexion();

        String sql = "DELETE FROM usuario WHERE codigo_usu= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, codigo_usu);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
    
}
