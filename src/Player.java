package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Player {
	String name;
	public List<String> FoodTokens;//// Food tokens has 5 different types of foods (Should we make a class for Foodtoken?)
	public int eggs;
	public int ActionTokens = 8;
	public List<Cards> GainFoodRow;
	public List<Cards> GainEggsRow;
	public List<Cards> GainCardsRow;
	public List<Cards> Hand;
	int playerNum;//// For putting a number on a player
	public int eggCap;
	int Invertabrate;
	int Fruit;
	int Fish;
	int Rodent;
	int Seed;
	Map<String, Integer> Food;
	public Player(String _name, int _playerNum)
	{
		Hand = new ArrayList<Cards>();
		GainFoodRow = new ArrayList<Cards>();
		GainEggsRow = new ArrayList<Cards>();
		GainCardsRow = new ArrayList<Cards>();
		FoodTokens = new ArrayList<>();
		name = _name;
		eggCap = 0;
		eggs = 0;
		Invertabrate = 0;
		Fruit = 0;
		Fish = 0;
		Rodent = 0;
		Seed = 0;
		Food = new HashMap<String, Integer>();
		Food.put("Invertebrate", 0);
		Food.put("Fruit",0);
		Food.put("Seed",0);
		Food.put("Rodent",0);
		Food.put("Fish",0);
		}
	public int AmountofFood() {
		int amount;
		switch(GainFoodRow.size()) {
		case 0:
			amount = 1;
			break;
		case 1:
			amount = 1;
			break;
		case 2:
			amount = 2;
			break;
		case 3:
			amount = 2;
			break;
		case 4:
			amount = 3;
			break;
		default:
			amount  = 0;
			break;
		}
		return amount;
	}
	public int AmountofEggs() {
		int amount;
		switch(GainEggsRow.size()) {
		case 0:
			amount = 1;
			break;
		case 1:
			amount = 1;
			break;
		case 2:
			amount = 2;
			break;
		case 3:
			amount = 2;
			break;
		case 4:
			amount = 3;
			break;
		default:
			amount  = 0;
			break;
		}
		return amount;
	}
	public int AmountofCards() {
		int amount;
		switch(GainCardsRow.size()) {
		case 0:
			amount = 1;
			break;
		case 1:
			amount = 1;
			break;
		case 2:
			amount = 2;
			break;
		case 3:
			amount = 2;
			break;
		case 4:
			amount = 3;
			break;
		default:
			amount  = 0;
			break;
		}
		return amount;
	}
	public Boolean PutinForest(int choice) {
		boolean check;
		check = true;
		int RowPos = GainFoodRow.size();
		switch(RowPos) {
			case 0:
				GainFoodRow.add(Hand.get(choice));
				FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
				Hand.remove(choice);
				check = true;
				break;
			case 1:
				if(eggs >= 1) {
					GainFoodRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 1 eggs");
					check = false;
				}
				break;
			case 2:
				if(eggs >= 1) {
					GainFoodRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 1 eggs");
					check = false;
				}
				 break;
			case 3:
				if(eggs >= 1) {
					GainFoodRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 2 eggs");
					check = false;
				}
				break;
			case 4:
				if(eggs >= 2) {
					GainFoodRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 2 eggs");
					check = false;
				}
				break;
			case 5:
				System.out.println("Can't fit anymore birds into row");
				break;
		}
		if(GainFoodRow.isEmpty() == false) {
			eggCap += GainFoodRow.get(GainFoodRow.size()-1).egg;
		}
		return check;		
	}
	public Boolean PutinGrasslands(int choice) {
		boolean check;
		check = true;
		int RowPos = GainEggsRow.size();
		switch(RowPos)
		{
			case 0:
				GainEggsRow.add(Hand.get(choice));
				FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
				Hand.remove(choice);
				check = true;
				break;
			case 1:
				if(eggs >= 1) {
					GainEggsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 1 eggs");
					check = false;
				}
				break;
			case 2:
				if(eggs >= 1) {
					GainEggsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 1 eggs");
					check = false;
				}
				break;
			case 3:
				if(eggs >= 1) {
					GainEggsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 2 eggs");
					check = false;
				}
				break;
			case 4:
				if(eggs >= 2) {
					GainEggsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 2 eggs");
					check = false;
				}
				break;
			case 5:
				System.out.println("Can't fit anymore birds into row");
				break;			
		}
		if(GainEggsRow.isEmpty() == false) {
			eggCap += GainEggsRow.get(GainEggsRow.size()-1).egg;
		}
		return check;
	}
	public Boolean PutinWetlands(int choice) {
		boolean check;
		check = true;
		int RowPos = GainCardsRow.size();
		switch(RowPos) {
			case 0:
				GainCardsRow.add(Hand.get(choice));
				FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
				Hand.remove(choice);
				check = true;
				break;
			case 1:
				if(eggs >= 1) {
					GainCardsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 1 eggs");
					check = false;
				}
				break;
			case 2:
				if(eggs >= 1) {
					GainCardsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 1 eggs");
					check = false;
				}
				break;
			case 3:
				if(eggs >= 1) {
					GainCardsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 2 eggs");
					check = false;
				}
				break;
			case 4:
				if(eggs >= 2) {
					GainCardsRow.add(Hand.get(choice));
					FoodTokens.remove(FoodTokens.indexOf(Hand.get(choice).TypeOfFood));
					Hand.remove(choice);
					eggs--;
					check = true;
				}
				else {
					System.out.println("Need 2 eggs");
					check = false;
				}
				break;
			case 5:
				System.out.println("Can't fit anymore birds into row");
				break;
				
		}
		if(GainCardsRow.isEmpty() == false) {
			eggCap += GainCardsRow.get(GainCardsRow.size()-1).egg;
		}
		return check;
	}
	public void checkAmountofFood() {
		if(!FoodTokens.isEmpty()) {
			for(int i = 0; i < FoodTokens.size();i++) {
				Food.put(FoodTokens.get(i), +1);
			}
		}
		for (String keys : Food.keySet()) {
		   System.out.println(keys + ":"+ Food.get(keys));
		}
	}
	public void DisplayHand() {
		for(int i = 0; i < Hand.size(); i++) {
			System.out.println(i+":" + Hand.get(i).name + "" + "FoodType:" + Hand.get(i).TypeOfFood + "Habitat:" + Hand.get(i).Habitat);
		}
		System.out.println();
		checkAmountofFood();
	}
	public void DisplayHandAvail(String hab){
		System.out.println("Cards available for " + hab);
		for(int i = 0; i < Hand.size();i++) {
			if(Hand.get(i).Habitat ==  hab) {
				System.out.println(i + ") " + Hand.get(i).name);
			}
		}
	}
	public void ViewBoard() {
		System.out.println();
		System.out.print("Forest: ");
		if(GainFoodRow.size() > 0) {
			for(int i =0; i < GainFoodRow.size();i++)
			{
				System.out.print( "["+ GainFoodRow.get(i).name +"]"+ "   ");
			}
		}
		System.out.println();
		System.out.print("Grasslands: ");
		if(GainEggsRow.size() > 0) {
			for(int i =0; i < GainEggsRow.size();i++) {
				System.out.print( "["+ GainEggsRow.get(i).name +"]"+ "   ");
			}
		}
		System.out.println();
		System.out.print("Wetlands: ");
		if(GainCardsRow.size() > 0)
		{
			for(int i =0; i < GainCardsRow.size();i++) {
				System.out.print("["+ GainCardsRow.get(i).name +"]"+ "   ");
			}
		}
		System.out.println();
	}
	public int score() { ///Evaluates the score for the player on how many eggs they have in their habitat for now.
		return eggs;
	}

	
}
