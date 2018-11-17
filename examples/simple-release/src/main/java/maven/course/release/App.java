package maven.course.release;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello, world!" );
        displayPackageDetails(Package.getPackage("maven.course.release"));
        try {
            displayManifestEntries();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Display (to standard output) build number retrieved from manifest file.
     */
    private static void displayManifestEntries() throws IOException {
        URL location = App.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("Reading Build-Number from: " + location);
        JarFile jarFile = new JarFile(location.getFile());
        Manifest mf = jarFile.getManifest();
        Attributes mainAttributes = mf.getMainAttributes();
        System.out.println("\tBuild-Number: " + mainAttributes.getValue("Build-Number"));
    }

    /**
     * Display (to standard output) package details for provided Package.
     *
     * @param pkg Package whose details need to be printed to standard output.
     */
    private static void displayPackageDetails(final Package pkg)
    {
        final String name = pkg.getName();
        System.out.println(name);
        System.out.println("\tSpec Title/Version: " + pkg.getSpecificationTitle() + " " + pkg.getSpecificationVersion());
        System.out.println("\tSpec Vendor: " +  pkg.getSpecificationVendor());
        System.out.println("\tImplementation: " + pkg.getImplementationTitle() + " " + pkg.getImplementationVersion());
        System.out.println("\tImplementation Vendor: " + pkg.getImplementationVendor());

    }
}
