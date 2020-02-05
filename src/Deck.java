package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Deck {
	List<Cards> deck;
	public Deck()
	{
		deck = new ArrayList<>();
		
	}
	
	public void Shuffle() {
		Collections.shuffle(deck);
	}
	
	public List<Cards> gimmeCards(int howMany) throws FileNotFoundException
	{
		List<Cards>TempDeck = new ArrayList<>();
		for(int i = 0; i < howMany; i ++)
		{
			if(deck.isEmpty())
			{
				deck.addAll(makeDeck());
				Shuffle();
			}
			TempDeck.add(deck.get(i));
			deck.remove(i);
		}
		return TempDeck;
	}
	
	public List<Cards> makeDeck() throws FileNotFoundException
	{
		
		List<Cards> newDeck = new ArrayList<>();/////Establishes a Deck of cards
		 Scanner br  = new Scanner( new File("cardTextFile.txt"));
		 String line = null;
		 int eggsNum = 0;
		 while (br.hasNext())
		 {
			 line = br.nextLine();
		      String[] values = line.split(",");
		      Cards temp = new Cards(eggsNum,values[1],values[2],values[3]);
		      newDeck.add(temp);
		 }
		 br.close();
		 return newDeck;
		 
	}
	
	public void DisplayDeck()
	{
		for(int i = 0; i < deck.size();i++)
		{
			System.out.println(i + ": " + deck.get(i).name);
		}
	}
}
