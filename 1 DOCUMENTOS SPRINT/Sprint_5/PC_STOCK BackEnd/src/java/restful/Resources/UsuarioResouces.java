
package restful.Resources;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.UsuarioModel;
import restful.Service.UsuarioServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioResouces {
    UsuarioServices servicio=new UsuarioServices();
    
    @GET
     public ArrayList<UsuarioModel> getUsuario() {

        return servicio.getusuario();
    }
     
    @Path("/{codigo_usu}")
    @GET
    public UsuarioModel getUsuario(@PathParam("codigo_usu") int codigo_usu) {

        return servicio.getUsuario(codigo_usu);
    }
    @POST
    public UsuarioModel addUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuarioModel usuario = gson.fromJson(JSON, UsuarioModel.class);
        return servicio.addUsuario(usuario);
    }

    @DELETE
    @Path("/{codigo_usu}")
    public String delUsuario(@PathParam("codigo_usu") int codigo_usu) {

        return servicio.delUsuario(codigo_usu);

    }

    @PUT
    public UsuarioModel updateUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuarioModel usuario = gson.fromJson(JSON, UsuarioModel.class);
        return servicio.updateUsuario(usuario);
    }
}
