package de.crowdcode.maven.plugins.uppercase;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author idueppe
 *
 */
@Mojo(name="message")
public class MessageMojo extends AbstractMojo {

	@Parameter(property = "nachricht", defaultValue = "Hello World")
	private String message;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info(message);
	}

}
