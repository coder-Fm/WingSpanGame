package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Cards {
		//Attributes of a card
		public String name;
		public int egg;
		public String Habitat;
		public String TypeOfFood;
		Cards()
		{
			
		}
		Cards(int e,String n, String typeFood,String h){
			this.egg = e;
			this.name = n;
			this.Habitat = h;
			TypeOfFood = typeFood;
		}
		public List<Cards> makeCard(){
			 //int e,String n,int c,char h,String p
			List<Cards> FiveCards = new ArrayList<Cards>();
			return FiveCards;
	    }
}
