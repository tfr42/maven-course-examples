package course.maven.profile;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test to be executed on Windows only.
 */
public class WindowsIT {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testWindowsSystemProperty() {
        assertTrue(System.getProperty("os.name").startsWith("Windows"));
    }
}