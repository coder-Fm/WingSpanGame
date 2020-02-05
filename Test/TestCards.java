package Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import src.Cards;

public class TestCards {
	static ArrayList<Cards> firstdeck, seconddeck, thirddeck;
	static Cards card_1, card_2, card_3, card_4, card_5, card_6;


	public TestCards() {

	}
	
	@BeforeClass
	public static void setUpClass() {
		firstdeck = new ArrayList<Cards>();
		seconddeck = new ArrayList<Cards>();
		thirddeck = new ArrayList<Cards>();
		
		card_1 = new Cards(4,"Black Vulture","Fruit","Forest");
		card_2 = new Cards(2,"Black-Billed Magpie","Fish","Forest");
		card_3 = new Cards(3,"Turkey Vulture","Invertebrate","Wetland");
		card_4 = new Cards(1,"Belted KingFisher","Seed","Wetland");
		card_5 = new Cards(5,"Brown-Headed CowBird","Fruit","Grassland");
		
		firstdeck.add(card_1);
		firstdeck.add(card_2);
		seconddeck.add(card_3);
		seconddeck.add(card_2);
		thirddeck.add(card_4);
		thirddeck.add(card_5);
		
	}

	@Test
	public void decksMatch() {
		assertEquals(1, firstMatch(firstdeck, seconddeck));
	}
	
	@Test
	public void decksnoMatch() {
		assertEquals(2, firstMatch(firstdeck, thirddeck));
	}
	
	public static int firstMatch(ArrayList<Cards> deck1, ArrayList<Cards> deck2)
	{
		for (int i = 0; i < deck1.size(); i++) {
	           if (deck1.get(i).equals(deck2.get(i)))
	               return i;
		}
		return deck1.size();
	}
	
}
