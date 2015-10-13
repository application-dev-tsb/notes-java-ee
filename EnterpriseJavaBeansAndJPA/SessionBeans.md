# Session Beans

## Stateless Session Beans
```java
import javax.ejb.Stateless;
@Stateless(name="SearchFacade")
public class SearchFacadeBean implements SearchFacade, SearchFacadeLocal {
  public SearchFacadeBean() {
  } 
}
```

## Stateful Session Beans
```java
import javax.ejb.Stateful;
@Stateful(name="ShoppingCart")
public class ShoppingCartBean implements ShoppingCart, ShoppingCartLocal {
  public ShoppingCartBean() {
  } 
}
```

## Singleton Session Beans
```java
import javax.ejb.Singleton;
import javax.ejb.Startup;
@Singleton (name = "ShopperCount")
@Startup
public class ShopperCountBean {
  private int shopperCounter;
  // Increment number of shopper counter
  public void incrementShopperCount() {
    shopperCounter++;
  }
  // Return number of shoppers
  public int getShopperCount() {
    return shopperCounter;
  }
}
```

## Time Service
```java
import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
@Singleton
@Startup
@DependsOn("ShopperCountBean")
public class LogShopperCount {
  // Logs shopper count every 2 hours
  @Schedule(hour="*/2")
  public void logShopperCount() {
  // Log shopper count
  } 
}
```
