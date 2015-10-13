# Entity Lifecycle

## New
* not been associated with an EntityManager’s persistence context

## Managed
```java
@Stateless
public class MySessionEJB {
  @PersistenceContext(unitName = "Chapter03PersistenceUnit")
  private EntityManager em;
  public void persistEntity(Object entity) {
    em.persist(entity);
} }
```

## Detached
* an entity remains in a managed state for the life of the persistence context in which it is contained, or until it is removed from the database
* detached entities do not undergo change tracking or other internal optimizations
* need to call **merge()** again to bring it back to the managed state

## Removed
* an entity becomes a removed instance when its remove() method is called
