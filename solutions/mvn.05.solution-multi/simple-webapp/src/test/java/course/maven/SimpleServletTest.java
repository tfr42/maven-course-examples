package course.maven;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sonatype.maven.web.SimpleServlet;

@RunWith(MockitoJUnitRunner.class)
public class SimpleServletTest {

	private SimpleServlet simpleServlet = new SimpleServlet();
	@Mock
	private HttpServletResponse mockResponse;
	@Mock
	private HttpServletRequest mockRequest;

	@Test
	public void testDoGet() throws ServletException, IOException {
		StringWriter writer = new StringWriter();
		Mockito.when(mockResponse.getWriter()).thenReturn(new PrintWriter(writer));

		simpleServlet.doGet(mockRequest, mockResponse);

		assertTrue(writer.toString().contains("SimpleServlet Executed"));
	}

}
