# Failure example: multi-module project with circular references

Project _module1_ depends on _module2_ and _module2_ depends on _module1_.

Fails with:

```
$> mvn install
...
[ERROR] The projects in the reactor contain a cyclic reference: Edge between 'Vertex{label='maven.course.failing-multimodule-circular:module2:1.0.0-SNAPSHOT'}' and 'Vertex{label='maven.course.failing-multimodule-circular:module1:1.0.0-SNAPSHOT'}' introduces to cycle in the graph maven.course.failing-multimodule-circular:module1:1.0.0-SNAPSHOT --> maven.course.failing-multimodule-circular:module2:1.0.0-SNAPSHOT --> maven.course.failing-multimodule-circular:module1:1.0.0-SNAPSHOT -> [Help 1]
...
```

