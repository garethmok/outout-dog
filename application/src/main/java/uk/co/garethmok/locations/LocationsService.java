package uk.co.garethmok.locations;

import uk.co.garethmok.coordinates.CoordinatesService;

class LocationsService {

    private CoordinatesService coordinatesService;

    LocationsService(final CoordinatesService coordinatesService) {
        this.coordinatesService = coordinatesService;
    }

    String locations(final String postcode) {
        coordinatesService.coordinateFor(postcode);

        return null;
    }

}
