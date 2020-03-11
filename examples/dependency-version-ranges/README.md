# Using versions Maven plugin

## resolve-ranges

```
mvn versions:resolve-ranges
```

Replaces the version ranges used in the _pom.xml_ file with the specific version beeing used in build. Original _pom.xml_ file is backuped as _pom.xml.versionsBackup_.

Example:

```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>[3.5.0,4.0.0.Alpha)</version>
</dependency>
```

gets replaced with

```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
	<version>3.6.10.Final</version>
</dependency>
```

Further information at https://www.mojohaus.org/versions-maven-plugin/
