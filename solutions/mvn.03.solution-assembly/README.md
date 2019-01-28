# Usage

```
mvn package
```

Then unzip produced bundle file `target/mvn.03.solution-assembly-#version#-SNAPSHOT-bundle.zip` to some directory and call the `run.sh`/`run.cmd` command from the `bin` directory.

Example:

```
$> run.sh Bornheim,Germany
0    INFO  Main  - Using location: Bornheim,Germany
*********************************
 Current Weather Conditions for:
  Bornheim, NW, Germany

 Temperature: 2
   Condition: Showers
    Humidity: 87
  Wind Chill: -2
*********************************
```
