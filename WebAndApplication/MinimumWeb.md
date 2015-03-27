# Web Application

## Setup
```xml
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>servlet-api</artifactId>
	<version>3.0-alpha-1</version>
	<scope>provided</scope>
</dependency>
```

JSTL (Optional, but you will most likely need this)
```xml
<dependency>
	<groupId>jstl</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
</dependency>
```

WEB-INF/web.xml
```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
      version="3.0">

    <display-name>App Name</display-name>
    
</web-app>
```

## Code

Using Java Code Inside a JSP
```html
<html>
<body>
<% //run any java code here %>
<h2><%= request.getContextPath() //output %> Hello World!</h2>
</body>
</html>
```
