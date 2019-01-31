package com.sonatype.maven.weather.yahoo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource(	"log4j.properties"));

		// Read the searched location from the Command-line (if none supplied, use 11201 for New York City)
		String location = "11201";
		if (args != null && args.length > 0) {
			location = args[0];
		}
		log.info("Using location: " + location);
		// Start the program
		new Main(location).start();
	}

	private String location;

	public Main(String location) {
		this.location = location;
	}

	public void start() throws Exception {
		System.out.print( new WeatherService().retrieveForecast( location ) );
	}

}
