# Java Persistence Query Language
```java
//annotation definition:
@Target({TYPE}) @Retention(RUNTIME)
public @interface NamedQuery {
    String name();
    String query ();
    LockModeType lockMode() default LockModeType.NONE;
    QueryHint[] hints() default {};
}
@Target({TYPE}) @Retention(RUNTIME)
public @interface NamedQueries {
    NamedQuery [] value ();
}

//usage:
@Entity
@NamedQueries({
  @NamedQuery(name="Inventory.findAll", query="select o from Inventory o"),
  @NamedQuery(name="Inventory.findByYear", query="select o from Inventory o where o.year=:year"),
  @NamedQuery(name="Inventory.findByRegion", query="select o from Inventory o where o.region=?1 ")
})
public class Inventory implements Serializable {
}
```
