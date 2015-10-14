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
//entity declaration:
@Entity
@NamedQueries({
  @NamedQuery(name="Inventory.findAll", query="select o from Inventory o"),
  @NamedQuery(name="Inventory.findByYear", query="select o from Inventory o where o.year=:year"),
  @NamedQuery(name="Inventory.findByRegion", query="select o from Inventory o where o.region=?1 ")
})
public class Inventory implements Serializable {
}

//client:
@Stateless
public class InventoryManagerBean implements InventoryManager,
                                             InventoryManagerLocal {
    /** <code>select o from Inventory o</code> */
    public List<Inventory> findAllInventory() {
        return em.createNamedQuery("Inventory.findAll", Inventory.class).getResultList();
    }
    /** <code>select o from Inventory o where o.year=:year</code> */
    public List<Inventory> findInventoryByYear(Object year) {
        return em.createNamedQuery("Inventory.findByYear", Inventory.class).setParameter("year", year).getResultList();
    }
    /** <code>select object(o) from Inventory o where o.region=?1 </code> */
    public List<Inventory> findInventoryByRegion(Object p1) {
        return em.createNamedQuery("findInventoryByRegion", Inventory.class).setParameter(0, p1).getResultList();
    }
}
```
