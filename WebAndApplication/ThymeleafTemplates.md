# Thymleaf

## Setup
- Add Classpath Dependencies
```xml
Maven
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring4</artifactId>
	<version>2.1.4.RELEASE</version>
</dependency>
```

- Update Web Config
```java
@Bean
public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
  ThymeleafViewResolver resolver = new ThymeleafViewResolver();
  resolver.setTemplateEngine(templateEngine);
  return resolver;
}
	
@Bean
public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
  SpringTemplateEngine templateEngine = new SpringTemplateEngine();
  templateEngine.setTemplateResolver(templateResolver);
  return templateEngine;
}

@Bean
public TemplateResolver templateResolver() {
  TemplateResolver resolver = new ServletContextTemplateResolver();
  resolver.setPrefix("/WEB-INF/views/");
  resolver.setSuffix(".html");
  resolver.setTemplateMode("HTML5");
  return resolver;
}
```
- Add Thymeleaf Templates
```html
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<body>
	<a th:href="@{/register}">Register</a>

	<h2>New Items</h2>
	<ul>
		<li th:each="item : ${newItems}" th:text="${item.name} - ${item.summary}"></li>
	</ul>
	
</body>
</html>
```
- Add Spring Security Dialect (Optional but Highly Recommended) 
```xml
<dependency>
	<groupId>org.thymeleaf.extras</groupId>
	<artifactId>thymeleaf-extras-springsecurity3</artifactId>
	<version>2.1.2.RELEASE</version>
</dependency>
```

```java
//Web Config
templateEngine.addDialect(new SpringSecurityDialect());
```
