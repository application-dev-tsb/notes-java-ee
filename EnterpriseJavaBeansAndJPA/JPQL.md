# Java Persistence Query Language
* named queries are cached
* dynamic queries may be cached by the provider in most cases
* sometimes dynamic queries will never be cached:
```java
public long queryFinancialRecordsOfDept(String deptName, String companyName) { 
    String query = "SELECT d.records " + 
                   "FROM Department d " + 
                   "WHERE d.name = '" + deptName +  
                   "' AND " + 
                   "      d.company.name = '" + companyName + "'"; 
    return em.createQuery(query, Long.class).getSingleResult(); 
} 
```

## Named Queries
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

## Dynamic Queries
```java
em.createQuery("select o from Customer o", Customer.class).getResultList();
```

## Bulk Update and Delete
```java
em.createQuery("delete from CustomerOrder o where o.status = 'FULFILLED'").executeUpdate();
```
* care should be taken when performing bulk update and delete operations, since they bypass the PersistenceContext and can lead to cache inconsistency
* make sure you call **EntityManager.flush()** after performing a bulk operation
