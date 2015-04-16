# Enabling SSL for Servers

## Apache Tomcat 8.0 Local Server
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

## Elastic Beanstalk Server
- Point subdomain to load balancer url (example: xxx.test.com)
```
Hostname: xxx
Address: xxxx.elasticbeanstalk.com
Record Type: CNAME
```

- Create a Private Key
```ssh
openssl genrsa 2048 > privatekey.pem
```

- To create a CSR (Certificate Signing Request)
```ssh
openssl req -new -key privatekey.pem -out csr.pem
```

- Generate a self-signed certificate
```ssh
openssl x509 -req -days 365 -in csr.pem -signkey privatekey.pem -out server.crt
```

- Upload a signed certificate
```ssh
aws iam upload-server-certificate --server-certificate-name stagecertificate --certificate-body file://server.crt --private-key file://privatekey.pem
```
NOTE: make sure your IAM user has admin access policy

```json
{
    "ServerCertificateMetadata": {
        "ServerCertificateId": "XXXXXX", 
        "ServerCertificateName": "mycertificate", 
        "Expiration": "2016-04-15T04:47:28Z", 
        "Path": "/", 
        "Arn": "arn:aws:iam::11111:server-certificate/mycertificate", 
        "UploadDate": "2015-04-16T04:49:59.755Z"
    }
}
```

- Enable HTTPS on AWS
```
Elastic Beanstalk > Select Environment > Configuration > Network Tier > 

Change The Following:
Secure listener port: 443
Protocol: HTTPS
SSL certificate id: xxxxxx
 
```
