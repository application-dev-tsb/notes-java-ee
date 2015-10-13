
# Persistence.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
  <persistence-unit name="Chapter03PersistenceUnit" transaction-type="JTA">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <jta-data-source>jdbc/wineapp</jta-data-source>
    <class>com.apress.ejb.chapter03.entities.Address</class>
    <class>com.apress.ejb.chapter03.entities.Customer</class>
    <class>com.apress.ejb.chapter03.entities.CustomerOrder</class>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties>
      <property name="eclipselink.ddl-generation" value="create-tables"/>
    </properties>
  </persistence-unit>
  <persistence-unit name="Chapter03PersistenceUnit-JSE" transaction-type="RESOURCE_LOCAL">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <class>com.apress.ejb.chapter03.entities.Customer</class>
    <properties>
      <property name="javax.persistence.jdbc.driver" value="oracle.jdbc.OracleDriver"/>
      <property name="javax.persistence.jdbc.url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
      <property name="javax.persistence.jdbc.user" value="wineapp"/>
      <property name="javax.persistence.jdbc.password" value="221CE6B0A87AC61AE68FF3A130F7F666"/>
      <property name="eclipselink.logging.level" value="FINER"/>
    </properties>
  </persistence-unit>
</persistence>

```
