package Test;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File; 

public class TestDeck {
	
	public TestDeck() {
		
	}
	@Test
	public void TestDeckFile() {
		ClassLoader classLoader = this.getClass().getClassLoader();
	    File file = new File(classLoader.getResource("Test/cardTextFile.txt").getFile());
	    assertTrue(file.exists());
	}
	
}
