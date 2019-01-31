package course.maven.weather.yahoo;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

import com.sonatype.maven.weather.yahoo.Weather;
import com.sonatype.maven.weather.yahoo.YahooParser;

public class YahooParserTest {

	@Test
	public void testParser() throws Exception {
		InputStream nyData = getClass().getResourceAsStream("/ny-weather.xml");
		Weather weather = new YahooParser().parse(nyData);
		assertEquals("New York", weather.getCity());
		assertEquals("NY", weather.getRegion());
		assertEquals("US", weather.getCountry());
		assertEquals("39", weather.getTemp());
		assertEquals("Fair", weather.getCondition());
		assertEquals("39", weather.getChill());
		assertEquals("67", weather.getHumidity());
	}

	@Test
	public void testParserResultBonn() throws Exception {
		InputStream nyData = getClass().getResourceAsStream("/yahoo.weather.bonn.xml");
		Weather weather = new YahooParser().parse(nyData);
		assertEquals("Bonn", weather.getCity());
		assertEquals("NW", weather.getRegion());
		assertEquals("Germany", weather.getCountry());
		assertEquals("2", weather.getTemp());
		assertEquals("Showers", weather.getCondition());
		assertEquals("-2", weather.getChill());
		assertEquals("87", weather.getHumidity());
	}

}
