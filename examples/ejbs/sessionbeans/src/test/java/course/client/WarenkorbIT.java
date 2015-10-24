package course.client;

import course.common.Warenkorb;
import course.util.JNDI;

import javax.naming.NamingException;

import static course.util.JNDI.lookup;
import static org.junit.Assert.assertEquals;

public class WarenkorbIT {
	
	public void verifyThatWarenkorbContainsItems() throws NamingException {
		String p1 = "USB-Stick", p2 = "Notebook";
		Warenkorb warenkorb = (Warenkorb) lookup(JNDI.GLASSFISH_ENV, "course.common.Warenkorb");
		warenkorb.kaufen(p1, 5);
		warenkorb.kaufen(p2, 1);
		warenkorb.kaufen(p1, 2);
		System.out.println(warenkorb.getInhalt());
//		warenkorb = null; geht nicht
		assertEquals(7, warenkorb.getInhalt().get(p1).intValue());
		warenkorb.abmelden();
		
		
//		warenkorb = (Warenkorb) JNDI.lookup(JNDI.GLASSFISH_ENV,"course.common.Warenkorb");
		System.out.println("Inhalt:"+warenkorb.getInhalt());
	}
}
