## [Hvordan lage egen starter](https://docs.spring.io/spring-boot/docs/2.0.0.M3/reference/html/boot-features-developing-auto-configuration.html)


## Noen kjekke triks med ObjectMapper


### Slå på "pretty" print
```java
new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT) 
```

### Endre quoteChar
```java
new ObjectMapper(new JsonFactoryBuilder().quoteChar('|').build());
```
