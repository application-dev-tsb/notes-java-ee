# JDBC Basic Setup

## MySQL Server Setup

## JDBC Driver

## Database Connection
```java
String url = "jdbc:mysql://aa14g91dds6xhe5.c9xqunjqncdm.ap-southeast-1.rds.amazonaws.com:3306/web_demo";

Class.forName("com.mysql.jdbc.Driver"); //to load the driver
Connection conn = = DriverManager.getConnection(url, user, password);
```

## Performing Statements
