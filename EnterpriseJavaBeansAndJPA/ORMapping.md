# O/R Mapping

## @Table
```java
//annotation definition:
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String name() default "";
    String catalog() default "";
    String schema() default "";
    UniqueConstraint[] uniqueConstraints() default {};
}

//usage:
@Entity
@Table(name="ADDRESSES")
public class Address implements Serializable {
}
```
* lets you specify details about the base table to which an entity is mapped
* in the absence of an @Table annotation, the default table name is the same name as the entity class itself **ADDRESS**
* an entity may also map to more than one table by specifying the **@SecondaryTable** annotation

## @Column
```java
//annotation definition:
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name() default "";
    boolean unique() default false;
    boolean nullable() default true;
    boolean insertable() default true;
    boolean updatable() default true;
    String columnDefinition() default "";
    String table() default "";
    int length() default 255;
    int precision() default 0; // decimal precision
    int scale() default 0; // decimal scale
}

//usage:
public class Address implements Serializable {
    @Column(name="ID") 
    String identifier;
}
```

## @OneToOne
```java
//annotation definition:
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneToOne {
    Class targetEntity() default void.class;
    CascadeType[] cascade() default {};
    FetchType fetch() default EAGER;
    boolean optional() default true;
    String mappedBy() default "";
}

//usage:
@Entity
public class Customer implements Serializable {
    @OneToOne @JoinColumn(name="MAILING_ADDRESS_REF",
                referencedColumnName="ADDRESS_PK")
    protected Address address;
    
}
@Entity
public class Address implements Serializable {
    @OneToOne(mappedBy="address") 
    protected Customer customer;
    
}
```

## @OneToMany and @ManyToOne
```java
//annotation definition:
//@OneToMany:
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface OneToMany {
  public Class targetEntity() default void.class;
  public CascadeType[] cascade() default {};
  public FetchType fetch() default FetchType.LAZY;
  public String mappedBy() default "";
  public boolean orphanRemoval() default false;
}
//@ManyToOne:
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ManyToOne {
  public Class targetEntity() default void.class;
  public CascadeType[] cascade() default {};
  public FetchType fetch() default FetchType.EAGER;
  public boolean optional() default true;
}

//usage:
@Entity
public class Orders implements Serializable {
    @OneToMany(mappedBy="orders")
    protected Collection<OrderItems> orderItemsCollection;
}
@Entity
public class OrderItems implements Serializable {
    @ManyToOne
    @JoinColumn(name="SELECTION_REF", referencedColumnName="SELECTION_PK") 
    protected Orders orders;
}
```

## @ManyToMany
```java
//annotation definition:
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ManyToMany {
  public Class targetEntity() default void.class;
  public CascadeType[] cascade() default {};
  public FetchType fetch() default FetchType.LAZY;
  public String mappedBy() default "";
}

//usage:
@Entity
public class Employee implements Serializable {
@ManyToMany(mappedBy="employees", cascade=CascadeType.PERSIST) @JoinTable(name="EMP_PROJ",
               joinColumns={@JoinColumn(name="EMP_ID", referencedColumnName="ID")},
               inverseJoinColumns={@JoinColumn(name="PROJ_ID", referencedColumnName="ID")})
    protected Collection<Project> projects;
}
@Entity
public class Project implements Serializable {
    @ManyToMany(mappedBy="projects") 
    protected Set<Employee> employees;
}
```

# Fetch Type
## Lazy (Default)
* merely a suggestion, implementation may load fields eagerly especially when its optimal to do so

## Eager
* fields should be pre-loaded

# Cascading Operations
```java
@Entity
public class Customer implements Serializable {
    @OneToOne(cascade=CascadeType.ALL) //ALL, PERSIST, MERGE, REMOVE, REFRESH
    protected Address address;
}
```
* when an EntityManager operation like persist() or remove() is called on the Customer entity, the operation will also be called on the Address instance held in the address field and on any cascading fields of that Address instance, and so on
