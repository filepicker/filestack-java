import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/**
 * Tests {@link Client Client} class.
 *
 * @author Shawn Aten (shawn@filestack.com)
 */
public class TestClient {
    private static final String API_KEY = "XXXXXXXXXXXXXXXXXXXXXXX";

    @Test
    public void testInstantiation() {
        Client client = new Client(API_KEY);
        assertNotNull("Unable to create Client", client);
    }
}
