package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * 
 * @see <a href="https://developer.yahoo.com/weather/documentation.html">Yahoo Weather API documentation</a>
 */
public final class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	final String appId = "PMdibE50";
	final String consumerKey = "dj0yJmk9RGR1UmNRU1F6cEtrJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTc5";
	final String consumerSecret = "7bb62f76d783684133941cdc4be180876801dd87";

	final String serviceUrl = "https://weather-ydn-yql.media.yahoo.com/forecastrss";

	public InputStream retrieve(String location) throws Exception {
		final String encodedLocation = URLEncoder.encode(location, "UTF-8");

		long timestamp = System.currentTimeMillis() / 1000;
		final String oauthNonce = createNonce();

		List<String> parameters = new ArrayList<>();
		parameters.add("oauth_consumer_key=" + consumerKey);
		parameters.add("oauth_nonce=" + oauthNonce);
		parameters.add("oauth_signature_method=HMAC-SHA1");
		parameters.add("oauth_timestamp=" + timestamp);
		parameters.add("oauth_version=1.0");
		parameters.add("location=" + encodedLocation);
		parameters.add("format=xml");
		parameters.add("u=c"); // metric units
		
		String allParameters = parameters.stream().sorted().collect(Collectors.joining("&"));

		String toBeSigned = "GET&" + URLEncoder.encode(serviceUrl, "UTF-8") + "&"
				+ URLEncoder.encode(allParameters, "UTF-8");

		String signature = signRequest(toBeSigned);

		String authorizationLine = "OAuth " //
				+ "oauth_consumer_key=\"" + consumerKey + "\", " //
				+ "oauth_nonce=\"" + oauthNonce + "\", " //
				+ "oauth_timestamp=\"" + timestamp + "\", " //
				+ "oauth_signature_method=\"HMAC-SHA1\", " //
				+ "oauth_signature=\"" + signature + "\", " //
				+ "oauth_version=\"1.0\"";

		URL url = new URL(serviceUrl + "?location=" + encodedLocation + "&format=xml&u=c");
		URLConnection conn = url.openConnection();
		conn.addRequestProperty("Authorization", authorizationLine);
		conn.addRequestProperty("Yahoo-App-Id", appId);
		conn.addRequestProperty("Content-Type", "application/json");

		configureProxy(conn);
		log.debug("URLConnection established to: " + url);
		return conn.getInputStream();
	}

	private void configureProxy(URLConnection conn) {
		if (useProxy() && useProxyAuthentication()) {
			String httpProxyUser = System.getProperty("http.proxyUsername");
			String httpProxyPassword = System.getProperty("http.proxyPassword");
			log.info("Using Proxy with authentication");
			Authenticator.setDefault(new ProxyAuthenticator(httpProxyUser, httpProxyPassword));
		}
	}

	String createNonce() {
		byte[] nonce = new byte[32];
		Random rand = new Random();
		rand.nextBytes(nonce);
		String oauthNonce = new String(nonce).replaceAll("\\W", "");
		return oauthNonce;
	}

	String signRequest(String signatureString) {
		String signature = null;
		try {
			SecretKeySpec signingKey = new SecretKeySpec((consumerSecret + "&").getBytes(), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHMAC = mac.doFinal(signatureString.getBytes());
			Encoder encoder = Base64.getEncoder();
			signature = encoder.encodeToString(rawHMAC);
		} catch (Exception e) {
			System.err.println("Unable to append signature");
			System.exit(0);
		}
		return signature;
	}

	private boolean useProxyAuthentication() {
		final String proxyUser = System.getProperty("http.proxyUsername");
		final String proxyPassword = System.getProperty("http.proxyPassword");
		if (proxyUser != null && proxyPassword != null) {
			log.debug("Using Proxy user: + " + proxyUser + "with password" + proxyPassword);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @see <a href=
	 *      "http://download.oracle.com/javase/6/docs/technotes/guides/net/proxies.html">Proxy</a>
	 * @see <a href=
	 *      "http://download.oracle.com/javase/6/docs/technotes/guides/net/properties.html">Networking
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
