# Entity
```java
//simplest entity class
@Entity
public class Customer implements Serializable {

  @Id
  private long customerId;
  private String name;
  public long getCustomerId() { return customerId; }
  public void setCustomerId(long customerId) { this.customerId = customerId; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
}
```

## Deciding to place Annotations on Instance Variables or Property Accessors
* By policy, only the persistence framework and the class methods themselves are allowed to access these fields directly
* When annotations are specified on the entity’s instance variables, the persistence manager accesses the instance variables directly when reading and writing a persistent property to and from the entity
* When annotating property accessors instead of instance variables, the persistence manager reads and writes property data through these property accessors
