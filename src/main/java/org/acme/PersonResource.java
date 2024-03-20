package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPeople() {
        return personService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Person create(Person person) {
        personService.create(person.getName());
        return person;
    }
}
