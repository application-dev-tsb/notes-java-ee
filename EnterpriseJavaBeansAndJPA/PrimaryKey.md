# Primary Key
```java
//simple PK
@Entity
public class Customer implements Serializable {
  @Id
  private Integer id;
}
```

## Autopopulated Primary Key
```java
```

## Composite Primary Key
```java
@Entity
@IdClass(CustomerPK.class)
public class Customer implements Serializable {
  
  @Id
  private Integer customerId;
    
  @Id
  private String name;
  
}
```
