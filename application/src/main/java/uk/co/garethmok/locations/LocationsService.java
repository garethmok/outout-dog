package uk.co.garethmok.locations;

import uk.co.garethmok.coordinates.Coordinate;
import uk.co.garethmok.coordinates.CoordinatesService;

import java.util.Set;

class LocationsService {

    private CoordinatesService coordinatesService;
    private LocationsRepository locationsRepository;

    LocationsService(final CoordinatesService coordinatesService, final LocationsRepository locationsRepository) {
        this.coordinatesService = coordinatesService;
        this.locationsRepository = locationsRepository;
    }

    Set<Coordinate> locations(final String postcode) {
        final Coordinate postcodeCoordinate = coordinatesService.coordinateFor(postcode);

        return locationsRepository.locationsWithin(postcodeCoordinate);
    }

}
