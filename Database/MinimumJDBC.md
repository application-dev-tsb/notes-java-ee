# JDBC Basic Setup

## MySQL Server Setup

## JDBC Driver

add the driver library to your project:
```xml
<dependency>
  <groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.34</version>
</dependency>
```

load the driver BEFORE connecting to the server
```java
Class.forName("com.mysql.jdbc.Driver"); //if you forget this, expect a Driver Not Found Exception
```

## Database Connection
```java
String url = "jdbc:mysql://aa14g91dds6xhe5.c9xqunjqncdm.ap-southeast-1.rds.amazonaws.com:3306/web_demo";
Connection conn = = DriverManager.getConnection(url, user, password);
```

## Performing Statements
```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT personid,firstname,lastname FROM persons");
```
