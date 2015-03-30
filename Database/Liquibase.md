# Liquibase

## Run During Deployment: Spring
[Documentation](http://www.liquibase.org/documentation/spring.html)
1.) Add Dependencies
```xml
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-jdbc</artifactId>
	<version>${spring.version}</version>
</dependency>
		
<dependency>
	<groupId>org.liquibase</groupId>
	<artifactId>liquibase-core</artifactId>
	<version>3.3.2</version>
</dependency>
```
2.) Add changelog.sql
```sql
--liquibase formatted sql

--changeset hack-of-all-codes:1
CREATE TABLE tpc_items (
	id int AUTO_INCREMENT,
	name VARCHAR(255),
	summary VARCHAR(255),
	PRIMARY KEY(id)
);
--rollback DROP TABLE tpc_items;

--changeset hack-of-all-codes:2
INSERT INTO tpc_items (name, summary) VALUES ('Test Item 1', 'This is very awesome 1');
INSERT INTO tpc_items (name, summary) VALUES ('Test Item 2', 'This is very awesome 2');
```

3.) Add DataSource and SpringLiquibase beans
```java

@Bean
public DataSource dataSource() {
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName(val(JDBC_DRIVER_CLASS));
	ds.setUrl(val(URL_STRING));
	ds.setUsername(val(DB_USER));
	ds.setPassword(val(DB_PASSWORD));
	return ds;
}
	
@Bean
public SpringLiquibase liquibase() {
	SpringLiquibase liquibase = new SpringLiquibase();
	liquibase.setChangeLog("classpath:tpc-changelog.sql");
	liquibase.setDataSource(dataSource());
	return liquibase;
}
```

## Using with Maven Plugin
[Documentation](http://www.liquibase.org/documentation/maven/)

## Run During Deployment: Servlet Listener
[Documentation](http://www.liquibase.org/documentation/servlet_listener.html)
