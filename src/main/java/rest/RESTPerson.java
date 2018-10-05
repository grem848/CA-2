package rest;

import DTO.*;
import entity.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import facade.Facade;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonsJson()
    {
        
        String json = gson.toJson(fp.getAllPersons());

        if(fp.getAllPersons() != null){
              return Response
                .status(200)
                .entity(gson.toJson(json))
                .type(MediaType.APPLICATION_JSON)
                .build();
        } else {
            JsonObject error = new JsonObject();
                error.addProperty("ErrorMessage", "This email is already in use");
                
                
                
            return Response
                    .status(200)
                    .entity(error)
                    .type(MediaType.APPLICATION_JSON)
                    .build();    

        }
    }

    @Path("complete/{email}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonJsonFromId(@PathParam("email") String email)
    {
        
        PersonDTO person = fp.getPerson(email);
        if(person != null){
            
      return Response
                .status(200)
                .entity(gson.toJson(person))
                .type(MediaType.APPLICATION_JSON)
                .build();
        } else {
                JsonObject error = new JsonObject();
                error.addProperty("ErrorMessage", "This email doesn't exist");
                
                
                
            return Response
                    .status(200)
                    .entity(gson.toJson(error))
                    .type(MediaType.APPLICATION_JSON)
                    .build();    

        }
    }

    @Path("complete/contactinfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsContactInfoJson()
    {
     
        List<PersonDTO> persons = fp.getAllPersons();
        
        return Response
                .status(200)
                .entity(gson.toJson(persons))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("complete/contactinfo/{email}")    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonByEmail(@PathParam("email") String email) {     
       
       
       ContactInfo json = null;
       json = fp.getPersonContactInfo(email);
   
       
       if( json != null){
       
       return Response
               .status(200)
               .entity(gson.toJson(json))
               .type(MediaType.APPLICATION_JSON)
               .build();
       }else {
         System.out.println("errorasjhfajfjshfjsfa");
                    
          JsonObject error = new JsonObject();
                error.addProperty("ErrorMessage", "This email doesn't exist!");
            System.out.println(error);
                    
                
                
            return Response
                    .status(200)
                    .entity(gson.toJson(error))
                    .type(MediaType.APPLICATION_JSON)
                    .build();    
    
       }
        
    }
    
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPersonJson(String json) // {"firstName": "Post","lastName": "Man","email": "somePost","address": {"street":"someStreet", "additionalInfo":"some"}}
    {
        
        Person person = gson.fromJson(json, Person.class);
        PersonDTO personDTO = fp.getPerson(person.getEmail());
        System.out.println(personDTO);
        
        if (personDTO == null) {
            System.out.println(person);
                PersonDTO p = fp.addPerson(person);
                return Response
                    .status(200)
                    .entity(gson.toJson(p))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } else {
                JsonObject error = new JsonObject();
                error.addProperty("ErrorMessage", "This email is already in use");
                
                
                
            return Response
                    .status(200)
                    .entity(error)
                    .type(MediaType.APPLICATION_JSON)
                    .build();    
    
        }
    }

    @PUT
    @Path("edit")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPersonJson(String json)
    {
        Person person = gson.fromJson(json, Person.class);
        try
        {
            fp.editPerson(person);

            return Response.ok().entity(json).build();

        } catch (Exception e)
        {
            System.out.println(e);
            return Response.status(Response.Status.NOT_FOUND).entity("{\"status\":\"PERSON NOT FOUND\"}").build();
        }
    }
    
    
    @GET
    @Path("{zipcodes}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getZipcodesJson(@PathParam("zipcodes") String zipcode)
    {
        String json = gson.toJson(fp.getAllZipCodes());

        return Response.ok(json).build();
    }

}
