package course.maven;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WeatherIntegrationTest  {
	private static Logger LOG = Logger.getLogger(WeatherIntegrationTest.class);

	private WebDriver driver = new HtmlUnitDriver();

	@Before
	public void setUp() {
		driver.get("http://localhost:8088/");
	}

	@Test
	public void testGetWeatherForZip02101() {
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("location"));

        element.clear();
        // Enter something to search for
        element.sendKeys("02101");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        LOG.info("Form submitted to: " + driver.getCurrentUrl());
        
        String actualPage = driver.getPageSource();
        LOG.info("Page content is: " + actualPage );
        assertTrue(actualPage.contains("Boston"));
	}

	@After
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
