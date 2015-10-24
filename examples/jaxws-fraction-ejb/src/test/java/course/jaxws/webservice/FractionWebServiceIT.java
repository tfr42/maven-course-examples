package course.jaxws.webservice;

import javax.xml.ws.WebServiceRef;

import course.jaxws.generated.BruchDienst;
import course.jaxws.generated.FractionBeanService;
import org.junit.Assert;
import org.junit.Test;

public class FractionWebServiceIT {
	
	@WebServiceRef(wsdlLocation="http://localhost:9000/service?wsdl") 
	private static FractionBeanService service;

	@Test
	public void verifyThatFractionWebServiceIsAvailable() {
		BruchDienst bruch = service.getBruchDienstPort();
		bruch.setzeWert(12, 3);
		Assert.assertEquals(4, bruch.aktuellerWert(),0.01);
	}

}
