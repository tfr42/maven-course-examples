package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public final class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String zipcode) throws Exception {
		String url = "https://query.yahooapis.com/v1/public/yql?q=" +
			"select%20*%20from%20weather.forecast%20where%20woeid%20in%20(" +
			"select%20woeid%20from%20geo.places(1)%20where%20text%3D" + zipcode + ")&format=xml" +
				"&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		log.info( "Retrieving Weather Data from: " + url);
		URLConnection conn = new URL(url).openConnection();
		if (useProxy() && useProxyAuthentication()) {
			String httpProxyUser = System.getProperty("http.proxyUsername");
			String httpProxyPassword = System.getProperty("http.proxyPassword");
			log.info("Using Proxy with authentication");
			Authenticator.setDefault(new ProxyAuthenticator(httpProxyUser,
					httpProxyPassword));
		}
		log.debug("URLConnection established to: " + url);
		return conn.getInputStream();
	}

	private boolean useProxyAuthentication() {
		final String proxyUser = System.getProperty("http.proxyUsername");
		final String proxyPassword = System.getProperty("http.proxyPassword");
		if (proxyUser != null && proxyPassword != null) {
			log.debug("Using Proxy user: + " + proxyUser + "with password"
					+ proxyPassword);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @see <a
	 *      href="http://download.oracle.com/javase/6/docs/technotes/guides/net/proxies.html">Proxy</a>
	 * @see <a
	 *      href="http://download.oracle.com/javase/6/docs/technotes/guides/net/properties.html">Networking
	 *      Properties</a>
	 */
	private boolean useProxy() {
		final String proxyHost = System.getProperty("http.proxyHost");
		final String proxyPort = System.getProperty("http.proxyPort");
		if (proxyHost != null && proxyPort != null) {
			log.debug("Using Proxy: + " + proxyHost + ":" + proxyPort);
			return true;
		}
		return false;
	}

}
