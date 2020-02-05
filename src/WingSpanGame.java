package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import src.Player;

public class WingSpanGame {
	public static void main(String args[]) throws NumberFormatException, IOException {
		Deck Deck = new Deck();//// Initialize the Deck
		List<Player> PlayerList = new ArrayList<Player>();	///Initialize the list of Players
		System.out.println("How many player (0-4)");
		Scanner input = new Scanner(System.in);
		int numPlayers = input.nextInt();
		///////User implementation (how many players in game and their names)
		while(true) {
		
			if(numPlayers > 0 && numPlayers <= 4)
			{
				for(int i = 1; i <= numPlayers; i++)
				{
					System.out.println("Enter the name of player " + i);
					String name = input.next();
					int playerNum = i;
					PlayerList.add(new Player(name,playerNum));
				}
			break;
			}
			else
			{
			numPlayers = input.nextInt();
			}
		}
		for(int i = 0; i < PlayerList.size(); i ++)/// Deals 5 card to each player
		{
			PlayerList.get(i).Hand.addAll(Deck.gimmeCards(5));
		}
		Dice Roll = new Dice();//// This establishes the bird feeder.
		Roll.RollDice();
		Roll.DisplayDice();

		int option;
		Boolean takesTurn = false;
		for(int a = 0; a < 8; a++)////The start of the game, the for loop goes around 8 times representing 8 action cubes
		{
			for(int i = 0; i <= PlayerList.size()-1;i++)//// Loops through all players established in the game
			{
				System.out.println();
				while(takesTurn == false)///// A while loop to make sure each player does a valid action. If not it return the same player to the beginning menu
				{
					Scanner op = new Scanner(System.in);
					System.out.println(PlayerList.get(i).name+ " choose option: ");////// The main action menu
					System.out.println("1: Play Bird Card");
					System.out.println("2: Gain Food");
					System.out.println("3: Gain Eggs");
					System.out.println("4: Gain Card");
							option = op.nextInt();
							while (option != 1 && option != 2 && option != 3 && option != 4){///User validation for all 4 options
					            System.out.println("You must enter 1,2,3, or 4");
					            option = op.nextInt();
					        }
							switch(option)
							{
								case 1:///Case  1 establishes the Play bird action.
									if(PlayerList.get(i).Hand.isEmpty())
									{
										System.out.println("No more cards buddy");
										takesTurn = false;
									}
									else
									{
										System.out.println("Choose row:");
										System.out.println("1) Forest");
										System.out.println("2) Grasslands");
										System.out.println("3) Wetlands");
										option = op.nextInt();
										while(option != 1 && option != 2 && option != 3)
										{
											option = op.nextInt();
										}
										switch(option)//// Within this action another switch statement is implemented to place the bird card in any 3 of the rows.
										{
											case 1:
												PlayerList.get(i).DisplayHand();
												System.out.println("Choose card: ");
												option = op.nextInt();
												while(option >= PlayerList.get(i).Hand.size())
												{	
													option = op.nextInt();
												}
												// forest
												
												if(PlayerList.get(i).Hand.get(option).Habitat.trim().equals("Forest") && PlayerList.get(i).FoodTokens.contains(PlayerList.get(i).Hand.get(option).TypeOfFood))
												{
													PlayerList.get(i).PutinForest(option);
													takesTurn = true;
												}
												else
												{
													if(PlayerList.get(i).Hand.get(option).Habitat.trim().equals("Forest") == false)
													{
														System.out.println("Wrong Habitat");
													}
													else
													{
														System.out.println("Not enough food");
													}
													takesTurn = false;
												}
												break;
											case 2:
												PlayerList.get(i).DisplayHand();
												System.out.println("Choose card: ");
												option = op.nextInt();
												while(option >= PlayerList.get(i).Hand.size())
												{	
													option = op.nextInt();
												}
												
												if(PlayerList.get(i).Hand.get(option).Habitat.trim().equals("Grassland")  && PlayerList.get(i).FoodTokens.contains(PlayerList.get(i).Hand.get(option).TypeOfFood))
												//if(PlayerList.get(i).Hand.get(option))
												{
													PlayerList.get(i).PutinGrasslands(option);
													takesTurn = true;
												}
												else
												{
													if(PlayerList.get(i).Hand.get(option).Habitat.trim().equals("Grassland") == false)
													
													{
														System.out.println("Wrong Habitat");
													}
													else
													{
														System.out.println("Not enough food");
													}
													takesTurn = false;
												}
												break;
											case 3:
												PlayerList.get(i).DisplayHand();
												System.out.println("Choose card: ");
												option = op.nextInt();
												while(option >= PlayerList.get(i).Hand.size())
												{	
													option = op.nextInt();
												}
												if(PlayerList.get(i).Hand.get(option).Habitat == "Wetland" && 
														PlayerList.get(i).FoodTokens.contains(PlayerList.get(i).Hand.get(option).TypeOfFood))
												{
													PlayerList.get(i).PutinWetlands(option);
													takesTurn = true;
												}
												else
												{
													if(PlayerList.get(i).Hand.get(option).Habitat.trim().equals("Wetland") == false) {
														System.out.println("Wrong Habitat");
													}
													else {
														System.out.println("Not enough food");
													}
													takesTurn = false;
												}
												break;
										}
									}
									PlayerList.get(i).ViewBoard();
									break;
								case 2:
									Roll.DisplayDice();
									int amount = PlayerList.get(i).AmountofFood();
									String yesno;
									if(Roll.CheckIfAllSame()==true)
									{
										System.out.println("ReRoll???? (yes/no)");
										yesno = op.nextLine();
										while (!yesno.equals ("yes") && !yesno.equals ("no")){
								            System.out.println("You must write 'yes' or 'no'");
								            yesno = op.nextLine();
								        }
										if( yesno.equals("yes"))
										{
											Roll.CurrentDiceRoll.clear();
											Roll.RollDice();
											Roll.DisplayDice();
										}
									}
																										
									System.out.println("Choose " + amount+ " foods: ");
									for(int k = 0; k < amount; k++)
									{
											while(op.hasNext())
											{
												option = op.nextInt();
												if(option < Roll.CurrentDiceRoll.size() )
												{ break; }
												else { continue; }
											}
											PlayerList.get(i).FoodTokens.add(Roll.CurrentDiceRoll.get(option));
											Roll.CurrentDiceRoll.remove(option);
									}
									
									takesTurn = true;
									break;
								case 3:
									if (PlayerList.get(i).eggCap >= PlayerList.get(i).eggs+PlayerList.get(i).AmountofEggs())
									{
										PlayerList.get(i).Hand.addAll(Deck.gimmeCards(PlayerList.get(i).AmountofEggs()));
										takesTurn = true;
									}
									else {
										System.out.println("Not enough birds to gain eggs");
										takesTurn = false; 
										}

									break;
								case 4:///// Case 4 gives cards to the Player. Amount of cards based on the how many bird cards in play on board.
									PlayerList.get(i).Hand.addAll(Deck.gimmeCards(PlayerList.get(i).AmountofCards()));
									takesTurn = true;
									break;
							}
					}
				takesTurn = false;
				}
			}
		int num = 0;
		String winner = null;
		Boolean tie = false;
		List<Integer> eggs = new ArrayList<Integer>();
		for(int i = 0; i < PlayerList.size();i++)
		{
			System.out.println("Player "+i+" score : "+ PlayerList.get(i).score());//// Check score on amount of eggs
			if(PlayerList.get(i).score() > num)
			{
				num = PlayerList.get(i).score();
				winner = PlayerList.get(i).name;
			}
			
			
		}

		System.out.println("The winner is " + winner + "!!!!!");
		
		input.close();
	}
	
		
}
