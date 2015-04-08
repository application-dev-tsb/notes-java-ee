# Securing Web Application

## Notes:
- [Spring Security and REST API](http://java.dzone.com/articles/secure-rest-services-using)
- [Secure REST API](http://jaxenter.com/rest-api-spring-java-8-112289.html)
- [Spring Security Config](http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/)

## Configuring Spring Security (Basic In-Memory Security)
- Add Dependencies (Web and Configuration)
```xml
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-config</artifactId>
	<version>${spring.security.version}</version>
</dependency>
		
<dependency>
	 <groupId>org.springframework.security</groupId>
	 <artifactId>spring-security-web</artifactId>
	 <version>${spring.security.version}</version>
</dependency>
```
- Add Spring Security Filter
```java
@Order(1) //make sure this is loaded first
public class TPCSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
```

- Add Security Config
```java
@Configuration
@EnableWebSecurity
public class TPCWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
}
```

- Update Web Initializer
```java
@Order(2) //load this AFTER S.S.
public class TPCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { 
				TPCWebSecurityConfig.class, //Add the Security Config
				...
				...
		};
	}
}
```
