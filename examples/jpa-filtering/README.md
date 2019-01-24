# Example for filtering resources

`${...}` placeholders in copied resources get expanded with the values from [src/main/filters/db.properties](src/main/filters/db.properties) during the phase `process-resources`
for configured files.

Compare for instance `src/main/resources/db-connection.properties` and `target/classes/db-connection.properties`.
Resources excluded from filter gets copied "as it".
