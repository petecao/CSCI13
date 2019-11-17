package weather;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Location tests
 */
public class LocationTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetLatLgn() {
        try {
            LocationFactory locationFactory = NominatimLocationFactory.getInstance();
            Location location = locationFactory.getLocation("95677");
            System.out.println("lat: " + location.getLatitude() + " lgn: " + location.getLongitude());
            assertEquals(38.7870973, location.getLatitude(), .01);
            assertEquals(-121.2282958, location.getLongitude(), .01);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
