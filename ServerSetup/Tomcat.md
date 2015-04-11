# Apache Tomcat 8.0 Notes

## Enable SSL
- Generate Self-signed Certificate
```ssh
C:\Apps\jdk1.8.0_25\bin\keytool -genkey -alias tomcatssl -keyalg RSA -keystore c:\tomcatssl.keystore
```
- Add HTTPS connector to tomcat\conf\server.xml
```xml
<Connector port="8443" 
  protocol="HTTP/1.1" 
  SSLEnabled="true"
  maxThreads="150" 
  scheme="https" 
  secure="true"
  clientAuth="false" 
  sslProtocol="TLS" 
	keystoreFile="C:\tomcatssl.keystore"
	keystorePass="mypassword" />
```
