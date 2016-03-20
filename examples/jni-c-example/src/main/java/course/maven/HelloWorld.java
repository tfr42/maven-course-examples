package course.maven;

import course.maven.nar.NarSystem;

/**
 * This class loads library and executes a native method.
 */
public class HelloWorld {

    private native void print();

    public static void main(String[] args) {
        System.out.println("java.library.path="+System.getProperty("java.library.path"));
        new HelloWorld().print();
    }

    static {
        // Replaces the load library
        // System.loadLibrary("HelloWorld");
        NarSystem.loadLibrary();
    }

}
