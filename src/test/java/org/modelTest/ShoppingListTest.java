package test.java.org.modelTest;

import org.junit.jupiter.api.Test;

import main.java.org.model.ShoppingList;
import main.java.org.model.ValidationException;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingListTest {

	private ShoppingList list = new ShoppingList("testList");

	@Test
	public void addArticle() throws ValidationException {

		//testing ValidationException by adding negative quantity
		assertThrows(ValidationException.class, () -> {
			list.addArticle("latte", 1.7, "", -2);
		});

		//testing positive quantity
		assertDoesNotThrow(() -> {
			list.addArticle("latte", 1.7, "", 3);
		});

		//testing expected article
		assertEquals("latte",list.getArticles().get(0).getName());
		assertEquals(1.7 ,list.getArticles().get(0).getCost());
		assertEquals("Uncategorized" ,list.getArticles().get(0).getCategory());
		assertEquals(3 ,list.getArticles().get(0).getQuantity());

		//testing 'articleMatch = true' branch of method
		list.addArticle("latte", 1.7, "", 2);
		assertEquals(3+2 ,list.getArticles().get(0).getQuantity());

		//testing 'articleMatch = false' branch of method
		list.addArticle("bottoni", 1.7, "", 5);
		assertEquals("bottoni",list.getArticles().get(1).getName());

	}

	@Test
	public void removeArticle() throws ValidationException {

		//entering exception
		list.addArticle("latte", 1.7, "", 3);
		assertThrows(ValidationException.class, () -> {
			list.removeArticle("latte", -6);
		});

		//regular execution
		assertDoesNotThrow(() -> {
			list.removeArticle("latte", 1);
		});

		//testing value
		assertEquals(2 ,list.getArticles().get(0).getQuantity());

		//testing removal of article
		list.addArticle("bottoni", 1.7, "", 5);
		list.removeArticle("latte", 94);
		assertEquals("bottoni",list.getArticles().get(0).getName());  //bottoni isnt in position 1 anymore, but in 0 since latte got removed
	}

	@Test
	public void findByPrefix() throws ValidationException {

		list.addArticle("latte", 1.7, "", 3);
		list.addArticle("pesce", 2.3, "", 4);
		list.addArticle("pesciolini", 3.2, "", null);

		//funzionamento corretto
		assertEquals(2,list.findByPrefix("pesc").size());
		assertEquals(0,list.findByPrefix("carne").size());
		assertEquals(1,list.findByPrefix("pesci").size());

	}

	@Test
	public void priceOfList() throws ValidationException {
		list.addArticle("latte", 44, "", 1);
		list.addArticle("pesce", 11, "", 3);
		list.addArticle("pesciolini", 10.60, "", null);
		
		//funzionamento somma prezzi
		assertEquals(87.60, list.priceOfList());
		
	}

	@Test
	public void findByCategory() throws ValidationException {
		
		list.addArticle("latte", 44, "latticini", 1);
		list.addArticle("pesce", 11, "", 3);
		list.addArticle("pesciolini", 10.60, "", null);
		
		//funzionamento hit e non hit
		assertEquals(2, list.findByCategory("Uncategorized").size());
		assertEquals(0, list.findByCategory("Frutta").size());
		
		//funzionamento Case-Sensitive
		list.addArticle("brie", 44, "LATTICINI", 1);
		assertEquals(2, list.findByCategory("latticini").size());

	}

	@Test
	public void setDefaultCategory() throws ValidationException {
		
		list.addArticle("latte", 44, "latticini", 1);
		list.addArticle("pesce", 11, "DaComprareAllaCOOP", 3);
		list.addArticle("pesciolini", 10.60, "DaComprareAllaCOOP", null);
		list.addArticle("brie", 44, "LATTICIONI", 1);
		
		list.setDefaultCategory("DaComprareAllaCOOP");
		
		//checking if only correct entries got set to default
		assertNotEquals("Uncategorized", list.getArticles().get(0).getCategory());	// not equals
		assertEquals("Uncategorized", list.getArticles().get(1).getCategory());
		assertEquals("Uncategorized", list.getArticles().get(2).getCategory());
		assertNotEquals("Uncategorized", list.getArticles().get(3).getCategory());	//not equals
	}
}
