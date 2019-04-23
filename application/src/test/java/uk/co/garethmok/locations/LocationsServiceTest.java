package uk.co.garethmok.locations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.garethmok.coordinates.Coordinate;
import uk.co.garethmok.coordinates.CoordinatesService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationsServiceTest {

    @Mock
    private CoordinatesService coordinatesService;

    private LocationsService testSubject;

    @Before
    public void setUp() {
        testSubject = new LocationsService(coordinatesService);
    }

    @Test
    public void happyPath() {
        final String postcode = "turnip";
        final Coordinate postcodeCoordinate = new Coordinate();

        when(coordinatesService.coordinateFor(postcode)).thenReturn(postcodeCoordinate);

        final String result = testSubject.locations(postcode);

        verify(coordinatesService).coordinateFor(postcode);
    }
}