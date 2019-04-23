package uk.co.garethmok.locations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.garethmok.coordinates.Coordinate;
import uk.co.garethmok.coordinates.CoordinatesService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationsServiceTest {

    @Mock
    private CoordinatesService coordinatesService;
    @Mock
    private LocationsRepository locationsRepository;

    private LocationsService testSubject;

    @Before
    public void setUp() {
        testSubject = new LocationsService(coordinatesService, locationsRepository);
    }

    @Test
    public void findsLocations() {
        final String postcode = "turnip";
        final Coordinate postcodeCoordinate = new Coordinate();
        final Set<Coordinate> expectedResult = emptySet();

        when(coordinatesService.coordinateFor(postcode)).thenReturn(postcodeCoordinate);
        when(locationsRepository.locationsWithin(postcodeCoordinate)).thenReturn(expectedResult);

        final Set<Coordinate> actualResult = testSubject.locations(postcode);

        verify(coordinatesService).coordinateFor(postcode);
        verify(locationsRepository).locationsWithin(postcodeCoordinate);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}