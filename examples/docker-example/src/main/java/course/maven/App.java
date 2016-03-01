package course.maven;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello, world!" );
        System.out.println( "Running with Java SE " + System.getProperty("java.version")
        + " by " + System.getProperty("java.vendor"));
        System.out.println( "on " + System.getProperty("os.name")
                + " " + System.getProperty("os.version"));

        System.out.println("JRE: " + System.getProperty("java.vm.version")
        + " " + System.getProperty("java.runtime.name"));
        System.out.println("JVM: " + System.getProperty("java.vm.name"));
    }
}
