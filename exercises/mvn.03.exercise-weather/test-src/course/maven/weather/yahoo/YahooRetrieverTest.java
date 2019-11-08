package course.maven.weather.yahoo;

import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.sonatype.maven.weather.yahoo.YahooRetriever;

public class YahooRetrieverTest {

	@Test
	public void simpleTest() throws Exception {
		YahooRetriever yahooRetriever = new YahooRetriever();
		final String content;
		try (InputStream is = yahooRetriever.retrieve("bonn,germany")) {
			content = IOUtils.toString(is);	
		}

		assertThat(content, CoreMatchers.containsString("Yahoo! Weather - Bonn, NW, DE"));
	}

}
