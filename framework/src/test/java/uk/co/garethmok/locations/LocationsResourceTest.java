package uk.co.garethmok.locations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LocationsResourceTest {

    @Mock
    private LocationsService locationsService;

    private LocationsResource testSubject;

    @Before
    public void setUp() {
        testSubject = new LocationsResource(locationsService);
    }

    @Test
    public void callsLocationsService() {
        final String postcode = "turnip";

        when(locationsService.locations(postcode)).thenReturn("swede");

        final Response result = testSubject.locations(postcode);

        verify(locationsService).locations(postcode);

        assertThat(result.getStatus()).isEqualTo(200);
        assertThat(result.getEntity()).isEqualTo("swede");
    }

}