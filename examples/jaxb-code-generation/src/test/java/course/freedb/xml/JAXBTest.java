package course.freedb.xml;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import course.freedb.domain.Album;
import course.freedb.domain.Dictionary;
import course.freedb.domain.ObjectFactory;

public class JAXBTest {

	@Test
	public void testResource() {
		assertNotNull(getClass().getResourceAsStream("/freedb.xml"));
	}

	@Test
	public void testUnmarschallXML() throws Exception {
		JAXBContext context = JAXBContext.newInstance("course.freedb.domain");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		InputStream inputStream = getClass().getResourceAsStream("/freedb.xml");

		@SuppressWarnings("unchecked")
		JAXBElement<Dictionary> element = (JAXBElement<Dictionary>) unmarshaller.unmarshal(inputStream);
		Dictionary dictionary = element.getValue();

		assertNotNull(dictionary);
		assertFalse(dictionary.getAlbums().isEmpty());
		Album album = dictionary.getAlbums().get(0);
		assertNotNull(album.getName());
		assertFalse(dictionary.getAlbums().get(0).getTracks().isEmpty());
	}

	@Test
	public void testMarshallXML() throws Exception {
		Dictionary dictionary = generateFluentStructure();

		JAXBContext context = JAXBContext.newInstance("course.freedb.domain");
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Writer writer = new StringWriter();
		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<Dictionary> element = objectFactory.createDictionary(dictionary);

		marshaller.marshal(element, writer);

		String outputXml = writer.toString();
		writer.close();

		System.out.println(outputXml);
		assertNotNull(outputXml);
		assertFalse(outputXml.isEmpty());

	}

	private ObjectFactory factory = new ObjectFactory();

	private Dictionary generateFluentStructure() {
		return factory.createDictionary()
				.withAlbums(factory.createAlbum().withArtist("Artist").withDiscId("discId").withGenre("genre")
						.withYear(12345).withTracks(factory.createTrack().withTitle("title").withTrackNo(1)));
	}

}
