package course.maven;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Created by tf on 09.02.17.
 */
public class SimpleServletIT {

	@Test
	public void verifyThatServletResponseIsValid() throws IOException {
		String port = System.getProperty("test.server.port") == null ? "8080" : System.getProperty("test.server.port");
		URL url = new URL("http://localhost:" + port + "/simple");
		System.out.println(url.toExternalForm());
		URLConnection conn = url.openConnection();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
			String pageText = reader.lines().collect(Collectors.joining("\n"));
			assertThat(pageText, containsString("SimpleServlet"));
		}
	}
}
