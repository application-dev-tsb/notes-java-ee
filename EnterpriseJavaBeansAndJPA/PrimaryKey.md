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
@Entity
@SequenceGenerator(name = " CustomerSequence",
                   sequenceName = " CUSTOMER_SEQ",
                   initialValue = 100, allocationSize = 20)
public class Customer implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
                  generator = " CustomerSequence")
  private Integer id;
}
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
