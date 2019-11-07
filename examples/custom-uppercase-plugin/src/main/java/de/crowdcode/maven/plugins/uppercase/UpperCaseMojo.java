package de.crowdcode.maven.plugins.uppercase;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which creates a copy of files, renaming them with upper case.
 * 
 */
@Mojo(name="uppercase", defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class UpperCaseMojo extends AbstractMojo {
	/**
	 * Directory where the files should be written
	 */
	@Parameter(defaultValue = "${project.build.directory}/upperCases", required = true)
	private File outputDirectory;

	@Parameter(property = "message", defaultValue = "Hello World!")
	private String message;

	/**
	 * Directory containing the source files.
	 */
	@Parameter(defaultValue = "${basedir}/src/main/resources")
	private File sourceDirectory;

	public void execute() throws MojoExecutionException {
		
		if (!sourceDirectory.exists()) {
			throw new MojoExecutionException("Error no sourceDirectory defined!");
		}

		if (!outputDirectory.exists()) {
			outputDirectory.mkdir();
		}

		File[] sourceFiles = sourceDirectory.listFiles();
		processFiles(sourceFiles, outputDirectory);
	}

	private void processFiles(final File[] sourceFiles, final File directory) throws MojoExecutionException {
		for (File file : sourceFiles) {

			File upperFile = new File(directory, file.getName().toUpperCase());
			if (file.isDirectory()) {
				upperFile.mkdir();
				processFiles(file.listFiles(), upperFile);
			} else {
				getLog().info("Found file " + file.getName());
				writeFile(upperFile);
			}
		}

	}

	private void writeFile(File upperFile) throws MojoExecutionException {
		try (FileWriter writer = new FileWriter(upperFile)) {
			writer.write(message);
		} catch (IOException e) {
			throw new MojoExecutionException("Error creating file " + upperFile, e);
		}
	}

}
