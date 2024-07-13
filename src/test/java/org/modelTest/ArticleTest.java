package test.java.org.modelTest;
import org.junit.jupiter.api.Test;

import main.java.org.model.Article;
import main.java.org.model.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {
	
	@Test
	public void addQuantity() throws ValidationException {
		Article article = new Article("latte", 0, "alimentari", 1);
		boolean articleNotValid = false;
		try {
			article.addQuantity(-2);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			articleNotValid=true;
		}
		assertTrue(articleNotValid);
		
		articleNotValid = true;
		try {
			article.addQuantity(2);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			articleNotValid = false;
		}
		assertTrue(articleNotValid);
		
		assertEquals(3,article.getQuantity());
		
		
	}
	
	@Test
	public void subtractQuantity() throws ValidationException {
		fail ("Not yet implemented");
	}
	
	@Test
	public void setDefaultCategory() {
		fail ("Not yet implemented");
	}
		
	
	
}
