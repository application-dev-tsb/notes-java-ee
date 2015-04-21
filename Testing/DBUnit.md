# DBUnit 

## Setup
- add dependency
```xml
<dependency>
	<groupId>org.dbunit</groupId>
	<artifactId>dbunit</artifactId>
	<version>2.5.1</version>
	<scope>test</scope>
</dependency>
```
- create datasets from XML
```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<dataset>
  <tpc_users
    id="1001"
    username="test"
    password="testxxx"
    display_name="Test User"
    bio="xxxx"
    role="ROLE_USER"
  />
	<tpc_items 
	  id="1000" 
	  name="Bing Cherry Salad"
	  summary="Jello-like salad with bing cherries" 
	  user_id="1001" 
	/>
	
	<tpc_items 
	    id="1002" 
	    name="Bing Cherry Salad 2"
		  summary="Jello-like salad with bing cherries" 
		  user_id="1001" />
</dataset>
```

- prepare Database Tester instance in the JUnit setup method
```java
private DataSourceDatabaseTester databaseTester;
	
@Before
public void setUp() throws Exception {
	databaseTester = new DataSourceDatabaseTester(dataSource);
		
	IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset-items.xml"));
	databaseTester.setDataSet(dataSet);
	databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
		
	databaseTester.onSetup();
}
```

- execute teardown
```java
@After
public void tearDown() throws Exception {
	databaseTester.onTearDown();
}
```

## Running Tests
```java
@Test
public void findNewItems() {
	ItemRepositoryImpl itemRepository = new ItemRepositoryImpl();
	itemRepository.setDataSource(dataSource);
		
	List<Item> newItems = itemRepository.findNewItems();
		
	assertEquals(2, newItems.size());
}
```
