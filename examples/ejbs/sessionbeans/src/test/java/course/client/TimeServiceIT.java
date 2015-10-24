package course.client;

import course.common.TimeService;
import course.util.JNDI;

import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;

public class TimeServiceIT {
	public void verifyThatTimeServiceIsAvailable() throws NamingException {
//		TimeService timeService = (TimeService) JNDI.lookup(JNDI.GLASSFISH_ENV,"course.common.TimeService");
		TimeService timeService = (TimeService) JNDI.lookup(JNDI.GLASSFISH_ENV,"my/Timer");
//		TimeService timeService = (TimeService) JNDI.lookup(JNDI.JBOSS_ENV,"course.client.TimeService");
		String time = timeService.getTime();
		System.out.println(time);
		assertNotNull(time);
	}
}
