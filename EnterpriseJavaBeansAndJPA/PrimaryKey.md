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
//using @IdClass
public class CustomerPK implements Serializable {
  private Integer id;
  private String name;
  public void setId(Integer id) { this.id = id; }
  public Integer getId() { return id; }
  public void setName(String name) { this.name = name; }
  public String getName() { return name; }
  @Override
  public int hashCode() { return 0; /* Implementation here */ }
  @Override
  public boolean equals(Object obj) { return false; /* Implementation here */ }
}

@Entity
@IdClass(CustomerPK.class)
public class Customer implements Serializable {
  
  @Id
  private Integer customerId;
    
  @Id
  private String name;
  
}
```

```java
//using @EmbeddedId
@Embeddable
public class CustomerPK implements Serializable {
  Long id;
  String name;
  public void setId(Long id) { this.id = id; }
  public Long getId() { return id; }
  public void setName(String name) { this.name = name; }
  public String getName() { return name; }
  @Override
  public int hashCode() { return 0; /* Implementation here */ }
  @Override
  public boolean equals(Object obj) { return false; /* Implementation here */ }
}

@Entity
public class Customer implements Serializable {
  @EmbeddedId
  private CustomerPK customerId;
  
  public CustomerPK getCustomerId() { return customerId; }
  public void setCustomerId(CustomerPK customerId) {
    this.customerId = customerId;
  }
// ... 
}
```
