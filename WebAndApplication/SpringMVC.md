# Basic Spring MVC

## Add Spring Web Dependencies
```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>${spring.version}</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>
```

## Create a Web Initializer
```java
/**
 * new from spring 3.2: under the cover this just loads
 * both the DispatcherServlet and ContextLoaderListener
 * NOTE: only supported on servlet containers 3.0+ (tomcat7)
 * 
 * Servlet 3.0 looks for an implementation of javax.servlet.ServletContainerInitializer interface
 * SpringServletContainerInitializer - springs own implementation
 * -- seeks out any WebApplicationInitilizer implementations
 */
public class TPCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	/**
	 * loads front-end objects such as controllers, view resolvers,
	 * handler mappings
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { TPCWebConfig.class };
	}

	/**
	 * loads the back-end objects in the middle and data tier
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { TPCRootConfig.class };
	}

}
```

## Web and Root Config
```java
@Configuration
@EnableWebMvc //equivalent to <mvc:annotation-driven>
@ComponentScan("com.hoac.tpcserver.web") //component scan on this package
public class TPCWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable(); //forward request for static resources to the default servlet
	}
}

@Configuration
@ComponentScan(
	basePackages={"com.hoac.tpcserver"}, 
	excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)}
)
public class TPCRootConfig {

}
```

## Simple Controller and Simple JSP
```java
@Controller
public class HomeController {

  //dont forget to add home.jsp inside /WEB-INF/views/
	@RequestMapping(value="/", method=GET)
	public String home() {
		return "home";
	}
}
```
