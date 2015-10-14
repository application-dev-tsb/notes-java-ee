# O/R Mapping

## @Table
```java
//annotation definition
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
//annotation definition
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
