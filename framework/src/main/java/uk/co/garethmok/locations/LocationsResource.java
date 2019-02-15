package uk.co.garethmok.locations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
public class LocationsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsResource.class);

    private final LocationsService locationsService;

    LocationsResource(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @POST
    public Response locations(@QueryParam("postcode") final String postcode) {
        LOGGER.info("Locations requested for", postcode);

        final String locationsFound = locationsService.locations(postcode);

        return Response.ok(locationsFound).build();
    }

}
