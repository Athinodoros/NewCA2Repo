/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Person;
import exception.PersonNotFoundException;
import facade.JSONconverter;
import facade.PersonFacade;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Athinodoros
 */
@Path("person")
public class apiResourcePerson {

    PersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory(deploy.DeploymentConfiguration.PU_NAME));
    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of apiResource
     */
    public apiResourcePerson() {
    }

    /**
     * Retrieves representation of an instance of rest.apiResourcePerson
     *
     * @param perid
     * @return an instance of java.lang.String
     * @throws exception.PersonNotFoundException
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getPerson(@PathParam("id") Long perid) throws PersonNotFoundException {
        //TODO return proper representation object
        return gson.toJson(facade.getPerson(perid), Person.class);
    }
    @GET
    @Path("all")
    @Produces("application/json")
    public String getAllPerson(@PathParam("id") Long perid) {
        //TODO return proper representation object
        return gson.toJson(facade.getPersons());
    }

    /**
     * PUT method for updating or creating an instance of apiResourcePerson
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String postPerson(String content) {

        return JSONconverter.getJSONFromPerson(facade.createPerson(JSONconverter.getPersonFromJSON(content)));
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public String putJson(String content) throws PersonNotFoundException {

        return JSONconverter.getJSONFromPerson(facade.updatePerson(JSONconverter.getPersonFromJSON(content)));
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    public String deletePerson(String content) throws PersonNotFoundException {

        return JSONconverter.getJSONFromPerson(facade.deletePerson(JSONconverter.getPersonFromJSON(content)));
    }
}
