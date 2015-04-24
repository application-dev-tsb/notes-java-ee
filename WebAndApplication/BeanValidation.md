# Bean Validation (JSR-303)

## Setup
- Add Bean Validation Specs to classpath
```xml
<dependency>
 	<groupId>javax.validation</groupId>
	<artifactId>validation-api</artifactId>
	<version>1.1.0.Final</version>
</dependency>
```
- Add JSR-303 Implementation to classpath
```xml
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-validator</artifactId>
	<version>5.1.3.Final</version>
</dependency>
```

- Enable Annotation-Driven on your web config
```java
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	//web config
}
```

- Annotate Java Bean for Validation
```java
public class User {

	private Long id;
	
	@NotNull
	@Size(min=6, max=50)
	private String username;
	
	@NotNull
	@Size(min=8, max=24)
	private String password;
	
	@NotNull
	@Size(min=4, max=50)
	private String displayName;
}
```

- Use the @Valid in controller method
```java
@RequestMapping(method=POST)
public String submitRegistration(@Valid User user, BindingResult bindingResult) {
	if (bindingResult.hasErrors()) {
		return "registration-form";
	}
}
```
