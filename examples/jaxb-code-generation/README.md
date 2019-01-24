# Java code generation with maven-jaxb2-plugin

Source generation is included as part of the `generate-sources` phase or can be called directly:

```
mvn generate-sources
```

This generates Java source files from the XML Schema ([src/main/resources/dictionary.xsd](src/main/resources/dictionary.xsd)).
The generated sources are written to `target/generated-sources/` and included in the source path.

Consult the maven-jaxb2-plugin's (online documentation](https://github.com/highsource/maven-jaxb2-plugin) for details.
