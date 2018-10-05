package rest;

import DTO.*;
import entity.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.Facade;
import java.util.Date;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
        String json = gson.toJson(fp.getAllPersons());
        
        return Response.ok(json).build();
    }
    
    @Path("complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonJsonFromId(@PathParam("id") long id)
    {
        String json = gson.toJson(fp.getPerson(id));

        return Response.ok(json).build();
    }
    
    @Path("complete/contactinfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsContactInfoJson()
    {
        String json = gson.toJson(fp.getAllPersonsContactInfo());

        return Response.ok(json).build();
    }
    
    
    @GET
    @Path("complete/contactinfo/{id}")   
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonContactInfoJson(@PathParam("id") long id)
    {   
        
        String json = gson.toJson(fp.getPersonContactInfo(id));

        return Response.ok(json).build();
    }
    
    @GET
    @Path("complete/contactinfo/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonalContactPhoneJson(@PathParam("number") String number){
        String json = gson.toJson(fp.getPersonInfoWithPhone(number));
        return Response.ok(json).build();
    }
    
    @GET
    @Path("complete/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsZipJson(@PathParam("zip")String zip){
        String json = gson.toJson(fp.getPersonsInCity(zip));
        return Response.ok(json).build();
        
    }
    
//    @POST
//    @Path("create")
//    @Consumes("application/json")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addPersonJson(String json) // {"firstName": "Post","lastName": "Man","email": "somePost","address": {"street":"someStreet", "additionalInfo":"some"}}
//    {
//        Person person = gson.fromJson(json, Person.class);
//
//        fp.addPerson(person);
//
//        return Response.ok(json).entity(json).build();
//
//    }

}