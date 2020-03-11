# Usage

```
mvn exec:java -Dexec.mainClass=com.sonatype.maven.weather.yahoo.Main -Dexec.args="#some location#"
```

Example:

```
$> mvn exec:java -Dexec.mainClass=com.sonatype.maven.weather.yahoo.Main -Dexec.args="Rennes,France"
[INFO] Scanning for projects...
[INFO]
[INFO] ----------< maven.course.solutions:mvn.03.solution-migration >----------
[INFO] Building mvn.03.solution-migration 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ mvn.03.solution-migration ---
0    INFO  Main  - Using location: Rennes,France
*********************************
 Current Weather Conditions for:
  Rennes, Brittany, France

 Temperature: 7
   Condition: Partly Cloudy
    Humidity: 76
  Wind Chill: 3
*********************************
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.079 s
[INFO] Finished at: 2019-01-28T12:43:17+01:00
[INFO] ------------------------------------------------------------------------
```
