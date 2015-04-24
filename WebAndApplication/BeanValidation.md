# Bean Validation

## Setup
- Add Java Validation API to classpath
```xml
<dependency>
	<groupId>javax.validation</groupId>
	<artifactId>validation-api</artifactId>
	<version>1.1.0.Final</version>
</dependency>
```
- Add Validation Implementation Library
```xml
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-validator</artifactId>
	<version>5.1.3.Final</version>
</dependency>
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
