package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {

	private static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(final InputStream inputStream) throws Exception {
		final Weather weather = new Weather();
		
		log.debug( "Creating XML Reader" );
		SAXReader xmlReader = createXmlReader();
		Document doc = xmlReader.read( inputStream );

		log.trace( "Parsing XML Response: " + doc.asXML());
		weather.setCity( doc.valueOf("//yweather:location/@city"));
		weather.setRegion( doc.valueOf("//yweather:location/@region").trim() );
		weather.setCountry( doc.valueOf("//yweather:location/@country") );
		weather.setCondition( doc.valueOf("//yweather:condition/@text") );
		weather.setTemp( doc.valueOf("//yweather:condition/@temp").trim() );
		weather.setChill( doc.valueOf("//yweather:wind/@chill") );
		weather.setHumidity( doc.valueOf("//yweather:atmosphere/@humidity") );

		return weather;
	}

	private SAXReader createXmlReader() {
		Map<String,String> uris = new HashMap<>();
        uris.put( "yahoo", "http://www.yahooapis.com/v1/base.rng" );
		uris.put( "yweather", "http://xml.weather.yahoo.com/ns/rss/1.0" );

        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs( uris );
        
		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory( factory );
		return xmlReader;
	}

}
