package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
    private int RollCount;   // number of rolls
    private int Sides;       // number of die sides
    public int RemainDice; 
    public List<String> CurrentDiceRoll;

	
    // Die constructor
    public Dice()
    {
    	this(6);
    	CurrentDiceRoll = new ArrayList<String>();
    	RemainDice = 0;
    }
    
    // Dice takes an integer parameter sides and initializes the 
    // number of roll, die sides and the random generator
    public Dice(int sides)
    {
    	RollCount = 0;
    	Sides = sides;
    	new Random();
    	
    }

    // Integer function that returns the random roll of the dice
    // range [1-6]
    public int Roll()
    {
    	int randomNum = ThreadLocalRandom.current().nextInt(0, 5 + 1);
    	return randomNum;
    }
    
    // Returns the number of sides of die
    public int Sides_num()
    {
    	return Sides;
    }
    
    // Returns the number of times a die rolled
    public int Rolls_num()
    {
    	return RollCount;
    }
    
    // return a string for the dice
    public String toString()
    {
    	return "Number of sides: " + Sides_num() + 
    			" Number of rolls: " + Rolls_num();
    }
    public Boolean CheckIfAllSame()
    {
    	boolean same = true;
    	for(int i = 0; i < CurrentDiceRoll.size(); i++)
    	{
    		if(CurrentDiceRoll.get(0)!=CurrentDiceRoll.get(i))
    		{
    			same = false;
    		}
    		else
    			continue;
    	}
    	return same;
    }
    //
    public void RollDice() {
    	
        String[] FoodTokenList = {"Invertebrate", "Seed", "Fish", "Fruit", "Rodent"};
    	
    	for(int k = 0; k < 5; k++)
    	{
		    int roll = Roll();
		    switch (roll) {
		        case 0: 
		        	CurrentDiceRoll.add(FoodTokenList[roll]);
		            break;
		        case 1:
		        	CurrentDiceRoll.add(FoodTokenList[roll]);
		            break;
		        case 2:
		        	CurrentDiceRoll.add(FoodTokenList[roll]);
		            break;
		        case 3:
		        	CurrentDiceRoll.add(FoodTokenList[roll]);
		            break;
		        case 4:
		        	CurrentDiceRoll.add(FoodTokenList[roll]);
		            break;
		        case 5:
		        	CurrentDiceRoll.add(FoodTokenList[roll-1]);
		            break;
		    }
    	} 
    	RemainDice = 6;
    }
    public void DisplayDice()
    {
    	System.out.println( "Current Dice Roll: ");
    	for(int i = 0; i < CurrentDiceRoll.size();i++)
    	{
    		System.out.println( (i) + ") " + CurrentDiceRoll.get(i));
    	}
    }
	
    public String getrolls()
    {
    	String[] FoodTokenList = {"Invertebrate", "Seed", "Fish", "Fruit", "Rodent"};
    	String[] DiceList = new String[FoodTokenList.length];
    	int index = 0;
    	for (Object value : FoodTokenList) {
    	  DiceList[index] = (String) value;
    	  index++;
    	}
    	return FoodTokenList[index];
    }
}
