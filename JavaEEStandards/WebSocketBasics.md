# HTML5 WebSocket and Java
* Bi-directional connection 
* Full-duplex communication
* Lean protocol (as compared to HTTP) <-- 2 bytes of overhead?
* Single TCP connection

Setup: Server
* Setup JEE7 Dependencies
* Create Endpoint Class (Annotation or extending Endpoint class)
```java
@ServerEndpoint("/test")
public class TestEndpoint {

}
```
* Implement Lifecycle Callbacks


Sources:
* [YouTube: HTML5 WebSocket and Java](https://www.youtube.com/watch?v=8QBdUcFqRkU)
* [YouTube: Arun Gupta - Nuts and Bolts of WebSocket](https://www.youtube.com/watch?v=qAFcu5OXyGs)
* [Oracle: Building Web Applications with WebSocket, JavaScript, and HTML5](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/HomeWebsocket/WebsocketHome.html#section4)
