# Usage example of custom maven plugin

Plugin `custom-uppercase-plugin`'s goal `uppercase` is configured to be called during the `process-resources` phase (see (custom-uppercase-plugin)[../custom-uppercase-plugin/README.md] for installation).

```
mvn process-resources
```

will generate the same file hierarchy than in `src/main/resources` to `target/upper` but in upper case and all files will have the same content.
