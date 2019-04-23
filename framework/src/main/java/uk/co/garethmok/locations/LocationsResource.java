package uk.co.garethmok.locations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.garethmok.coordinates.Coordinate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
public class LocationsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsResource.class);

    private final LocationsService locationsService;

    LocationsResource(final LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @POST
    public Response locations(@QueryParam("postcode") final String postcode) {
        LOGGER.info("Locations requested for", postcode);

        final Set<Coordinate> locationsFound = locationsService.locations(postcode);

        return Response.ok(locationsFound).build();
    }

}
