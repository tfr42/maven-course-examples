package com.sonatype.maven.weather.yahoo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource(	"log4j.properties"));

		// Read the Zip Code from the Command-line (if none supplied, use 11201 for New York City)
		String zipcode = "11201";
		if (args != null && args.length > 0) {
			zipcode = args[0];
		}
		log.info("Using zip code: " + zipcode);
		// Start the program
		new Main(zipcode).start();
	}

	private String zip;

	public Main(String zip) {
		this.zip = zip;
	}

	public void start() throws Exception {
		System.out.print( new WeatherService().retrieveForecast( zip ) );
	}

}
