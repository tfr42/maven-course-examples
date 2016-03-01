package course.maven;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream printOut = new PrintStream(os);
        System.setOut(printOut);
        App.main(new String[]{});
        printOut.flush();
        assertThat(os.toString("UTF-8"), containsString("Hello, world!"));
    }
}
