package test.java.org.modelTest;
import org.junit.jupiter.api.Test;

import main.java.org.model.DuplicateNameException;
import main.java.org.model.ListManager;
import main.java.org.model.MissingNameException;
import main.java.org.model.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {

	private ListManager manager = new ListManager();

	@Test
	public void addShoppingList() throws DuplicateNameException {

		manager.addShoppingList("coop");

		//no exception
		assertDoesNotThrow(() -> {
			manager.addShoppingList("esselunga");
		});

		//exception of duplicate name
		assertThrows(DuplicateNameException.class, () -> {
			manager.addShoppingList("esselunga");
		});

		//consistency of name field
		assertEquals("esselunga", manager.getShoppingLists().get(1).getName());
		assertEquals("coop", manager.getShoppingLists().get(0).getName());	
	}

	@Test
	public void removeShoppingList() throws DuplicateNameException, MissingNameException {

		//adding lists for tests
		manager.addShoppingList("coop");
		manager.addShoppingList("esselunga");
		manager.addShoppingList("conad");

		//no exceptions
		assertDoesNotThrow(() -> {
			manager.removeShoppingList("coop");
		});

		//missing name exception case
		assertThrows(MissingNameException.class, () -> {
			manager.removeShoppingList("decathlon");
		});

		//outcome of successful list removal (since coop was removed, esselunga should now be in position 0)
		assertEquals("esselunga", manager.getShoppingLists().get(0).getName());
	}

	@Test
	public void addCategory() throws DuplicateNameException {

		manager.addCategory("saponi");

		//no exception of duplicate name
		assertDoesNotThrow(() -> {
			manager.addCategory("cibo");
		});

		//exception of duplicate name
		assertThrows(DuplicateNameException.class, () -> {
			manager.addCategory("cibo");
		});

		//consistency of added categories
		assertEquals("cibo", manager.getCategories().get(1));
		assertEquals("saponi", manager.getCategories().get(0));
	}


	@Test
	public void removeCategory() throws DuplicateNameException , MissingNameException {

		//adding lists for tests
		manager.addCategory("sottaceti");
		manager.addCategory("panini");
		manager.addCategory("frutta");

		//no exceptions
		assertDoesNotThrow(() -> {
			manager.removeCategory("sottaceti");
		});

		//missing name exception case
		assertThrows(MissingNameException.class, () -> {
			manager.removeCategory("verdura");
		});

		//outcome of successful list removal (since sottaceti was removed, panini should now be in position 0)
		assertEquals("panini", manager.getCategories().get(0));
	}


	@Test
	public void setDefaultCategory() throws DuplicateNameException, ValidationException {

		//dati x test
		manager.addShoppingList("coop");
		manager.addShoppingList("esselunga");
		manager.addCategory("frutta");
		manager.addCategory("bevande");
		//coop list
		manager.getShoppingLists().get(0).addArticle("mele", 1.2, "frutta", 5);
		manager.getShoppingLists().get(0).addArticle("pomodori", 1.4, "", 5);
		manager.getShoppingLists().get(0).addArticle("kiwi", 1.2, "frutta", 5);
		//esselunga list
		manager.getShoppingLists().get(1).addArticle("banane", 1.2, "frutta", 5);

		//no exceptions
		assertDoesNotThrow(() -> {
			manager.setDefaultCategory("frutta");
		});

		//consistency of operation: has List 0:Article "mele" category been set to "Uncathegorized"?
		assertEquals("Uncategorized", manager.getShoppingLists().get(0).getArticles().get(0).getCategory());

		//consistency of operation's scope: have articles from other lists than the first (position 0) been changed too?
		assertEquals("Uncategorized", manager.getShoppingLists().get(1).getArticles().get(0).getCategory());

	}

	public void categoryPresenceCheck() throws DuplicateNameException, ValidationException, MissingNameException {

		//dati x test
		manager.addCategory("frutta");
		manager.addCategory("bevande");
		
		//returns true
		assertEquals(true, manager.categoryPresenceCheck("bevande"));
		//returns false
		assertEquals(false, manager.categoryPresenceCheck("dolci"));
	}
}
