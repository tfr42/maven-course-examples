# Polyglot Maven

See [polyglot-maven](https://github.com/takari/polyglot-maven).

## Convert an existing pom.xml to pom.XXX

Supported languages: [Atom, Groovy, Kotlin, YAML, ...](https://github.com/takari/polyglot-maven#available-languages).

Example to create a POM in yaml from an original XML POM file:

```
mvn io.takari.polyglot:polyglot-translate-plugin:translate \
  -Dinput=pom.xml.ori -Doutput=pom.yaml
```

## Add extension configuration

Create file [.mvn/extensions.xml](.mvn/extensions.xml) to specify the language used:

```
<?xml version="1.0" encoding="UTF-8"?>
<extensions>
  <extension>
    <groupId>io.takari.polyglot</groupId>
    <artifactId>ARTIFACTID</artifactId>
    <version>0.4.1</version>
  </extension>
</extensions>
```

## Run maven as usual
```
mvn install
```