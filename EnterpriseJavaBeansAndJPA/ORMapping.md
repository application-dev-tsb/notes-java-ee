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

//owner:
@Entity
public class Customer implements Serializable {

    @OneToOne @JoinColumn(name="MAILING_ADDRESS_REF",
                referencedColumnName="ADDRESS_PK")
    protected Address address;
    
}

//referenced:
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


```
