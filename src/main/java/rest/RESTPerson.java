package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class RESTPerson
{

    @Context
    private UriInfo context;
    @Context
    private ServletContext servletContext;

    Date date = new Date();

    Gson gson;
    Facade fp = new Facade(Persistence.createEntityManagerFactory("pu"));

    public RESTPerson()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Path("complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsJson()
    {
        String json = gson.toJson(fp.getPersons());

        return Response.ok(json).build();
    }
    
    @Path("complete/id")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonJsonFromId()
    {
        String json = gson.toJson(fp.getPersons());

        return Response.ok(json).build();
    }
    @Path("complete/contactinfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsContactInfoJson()
    {
        String json = gson.toJson(fp.getPersons());

        return Response.ok(json).build();
    }
    @Path("complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsJson()
    {
        String json = gson.toJson(fp.getPersons());

        return Response.ok(json).build();
    }
    @Path("complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsJson()
    {
        String json = gson.toJson(fp.getPersons());

        return Response.ok(json).build();
    }
    @Path("complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsJson()
    {
        String json = gson.toJson(fp.getPersons());

        return Response.ok(json).build();
    }
}
