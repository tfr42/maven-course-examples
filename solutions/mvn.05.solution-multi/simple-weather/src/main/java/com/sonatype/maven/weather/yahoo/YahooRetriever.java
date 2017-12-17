package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String zipcode) throws Exception {
		String url = "https://query.yahooapis.com/v1/public/yql?q=" +
			"select%20*%20from%20weather.forecast%20where%20woeid%20in%20(" +
			"select%20woeid%20from%20geo.places(1)%20where%20text%3D" + zipcode + ")&format=xml" +
				"&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		log.info( "Retrieving Weather Data from: " + url);
		URLConnection conn = new URL(url).openConnection();
		log.debug("URLConnection established to: " + url);
		return conn.getInputStream();
	}

}
