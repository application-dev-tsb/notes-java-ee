# Envirnoment Variables

## Tomcat
* go to {TOMCAT}/conf/catalina.properties
* add properties for your environment
* save file

## AWS (Elastic Beanstalk)
* Go to your Elastic Beanstalk application
* Configuration
* Software Configuration
* Environment Properties
* add the properties
* save configuration and wait for environment restart

## To Access from Java
```java
System.getProperty("<key>");
```
