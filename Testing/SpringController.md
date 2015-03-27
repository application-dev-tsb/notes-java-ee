# Unit Testing Spring MVC Controllers

## Add Dependencies
```xml
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.hamcrest</groupId>
	<artifactId>hamcrest-all</artifactId>
	<version>1.3</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.mockito</groupId>
	<artifactId>mockito-all</artifactId>
	<version>1.10.19</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>${spring.version}</version>
	<scope>test</scope>
</dependency>
```

## Unit Test

sample controller:
```java
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
	
	private ItemRepository itemRepository;

	@RequestMapping(method=GET)
	public String home(Model model) {
		model.addAttribute("newItems", itemRepository.findNewItems());
		return "home";
	}

	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}
```

sample test:
```java
//imports
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@Test
public void homeTest() throws Exception {
	List<Item> expectedItems = createItems(15);
	ItemRepository mockItemRepository = mock(ItemRepository.class);
	when(mockItemRepository.findNewItems()).thenReturn(expectedItems);
		
	HomeController controller = new HomeController();
	controller.setItemRepository(mockItemRepository);
		
	MockMvc mockMvc = standaloneSetup(controller)
		.setSingleView(new InternalResourceView("/WEB-INF/views/home.jsp"))
		.build();
		
	mockMvc.perform(get("/"))
	       .andExpect(view().name("home"))
	       .andExpect(model().attributeExists("newItems"))
	       .andExpect(model().attribute("newItems", hasItems(expectedItems.toArray())));
}
```
