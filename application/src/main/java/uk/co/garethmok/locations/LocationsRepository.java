package uk.co.garethmok.locations;

import uk.co.garethmok.coordinates.Coordinate;

import java.util.Set;

public interface LocationsRepository {

    Set<Coordinate> locationsWithin(Coordinate postcodeCoordinate);

}
