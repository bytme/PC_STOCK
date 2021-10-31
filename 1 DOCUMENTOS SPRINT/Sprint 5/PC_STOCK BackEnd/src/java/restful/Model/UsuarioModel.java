
package restful.Model;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioModel {
   private int codigo_usu;
   private String nombre_usu;
   private String usuario;
   private String password;
   private String email;
   private String codigo_tipo_usu;
   private String codigo_estado_usu;

    public UsuarioModel() {
    }

    public UsuarioModel(int codigo_usu, String nombre_usu, String usuario, String password, String email, String codigo_tipo_usu, String codigo_estado_usu) {
        this.codigo_usu = codigo_usu;
        this.nombre_usu = nombre_usu;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.codigo_tipo_usu = codigo_tipo_usu;
        this.codigo_estado_usu = codigo_estado_usu;
    }

    public int getCodigo_usu() {
        return codigo_usu;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCodigo_tipo_usu() {
        return codigo_tipo_usu;
    }

    public String getCodigo_estado_usu() {
        return codigo_estado_usu;
    }

    public void setCodigo_usu(int codigo_usu) {
        this.codigo_usu = codigo_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodigo_tipo_usu(String codigo_tipo_usu) {
        this.codigo_tipo_usu = codigo_tipo_usu;
    }

    public void setCodigo_estado_usu(String codigo_estado_usu) {
        this.codigo_estado_usu = codigo_estado_usu;
    }
   
   
}
