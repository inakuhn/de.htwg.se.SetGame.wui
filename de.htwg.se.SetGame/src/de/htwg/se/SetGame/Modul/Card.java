package de.htwg.se.SetGame.Modul;
import java.awt.*;
import java.util.TreeMap;
import java.text.Format;
import java.util.TreeSet;
public class Card {
	TreeSet<Cards> pack;
	/*One card in card*/
	public class Cards{
		String color;
		String fomr;
		int anz;
		public Cards(String color, String form, int anzahl){
			this.color = color;
			this.fomr = form;
			this.anz = anzahl;
		}		
	}
	public Card(){
		
		this.pack = creatCards();
		
	}
	private TreeSet<Cards> creatCards() {
		TreeSet<Cards> list = new TreeSet<>();
		//Cards card1 = new Cards("", form, anzahl)
		
		
		
		return list;
		
	}
}