package test.java.org.modelTest;
import org.junit.jupiter.api.Test;

import main.java.org.model.Article;
import main.java.org.model.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

	@Test
	void testArticle() throws ValidationException {
		//testing the overloaded constructor methods
		Article article = new Article("latte", 2);
		assertEquals("Uncategorized", article.getCategory());
		assertEquals(1, article.getQuantity());

		Article article2 = new Article("latte", 1.7,"alimentari");
		assertNotEquals("Uncategorized", article2.getCategory());
		assertEquals(1, article2.getQuantity());

		Article article3 = new Article("latte", 1.7, 3);
		assertEquals("Uncategorized", article3.getCategory());
		assertNotEquals(3, article2.getQuantity());

		//testing whether exception is thrown or nor
		assertDoesNotThrow(() -> {
			@SuppressWarnings("unused")
			Article article4 = new Article("latte", 2);
		});
		assertThrows(ValidationException.class, () -> {
			@SuppressWarnings("unused")
			Article article5 = new Article("latte", 2, "cibo", -4);

		});
	}

	@Test
	void testAddQuantity() throws ValidationException {
		// Initialize the article
		Article article = new Article("latte", 1.7, "alimentari", 1);

		// Test adding negative quantity - should be throwing ValidationException
		assertThrows(ValidationException.class, () -> {
			article.addQuantity(-2);
		});

		// Test adding positive quantity
		article.addQuantity(2);
		assertEquals(3, article.getQuantity());

		// Verify no exception is thrown for valid quantity addition
		assertDoesNotThrow(() -> {
			article.addQuantity(1);
		});

	}


	@Test
	public void subtractQuantity() throws ValidationException {
		// Initialize the article
		Article article = new Article("latte", 1.7, "alimentari", 4);

		// Test removing negative quantity - should be throwing ValidationException
		assertThrows(ValidationException.class, () -> {
			article.addQuantity(-2);
		});

		// Test removing positive quantity
		article.subtractQuantity(3);
		assertEquals(1, article.getQuantity());

		// Verify no exception is thrown for valid quantity addition
		assertDoesNotThrow(() -> {
			article.subtractQuantity(1);
		});

	}

	@Test
	public void setDefaultCategory() throws ValidationException {
		// Initialize the article
		Article article = new Article("latte", 1.7, "alimentari", 4);

		// Verify method
		article.setDefaultCategory();
		assertEquals("Uncategorized", article.getCategory());
	}



}
