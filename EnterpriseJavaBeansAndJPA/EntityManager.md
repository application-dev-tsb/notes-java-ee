# Entity Manager
* maintains a cache of instances within a transactional context called a persistence context
* To apply changes back to the persistent store, the client calls the **merge()**
```java
@Stateless
public class CustomerManager {
  @PersistenceContext(unitName="Chapter03PersistenceUnit")
  private EntityManager em;
  public void createCustomer() {
    final Customer cust = new Customer();
    cust.setName("Moneybags MgGee");
    em.persist(cust);
} }

//alternative:
public class CustomerService {
  public static void main(String[] args) {
    final EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("Chapter03PersistenceUnit-JSE");
    final EntityManager em = emf.createEntityManager();
    final Customer cust = new Customer();
    cust.setName("Best Customer Ever");
    em.persist(cust);
  }
}
```
