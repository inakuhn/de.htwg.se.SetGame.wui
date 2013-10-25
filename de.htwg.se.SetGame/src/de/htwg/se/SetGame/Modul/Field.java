package de.htwg.se.SetGame.Modul;

import java.util.LinkedList;
import de.htwg.se.SetGame.Modul.Card.Cards;

public class Field {
	
	public int fieldsize;
	private Card card = new Card();
	private LinkedList<Cards> c = card.pack;
	
	public LinkedList<Cards> init() {
		int fieldsize = 12;
		LinkedList<Cards> field = new LinkedList<>();
		
		field = this.c;
		this.fieldsize = fieldsize;
		return fillField(field);
	}
	
	
	private LinkedList<Cards> fillField(LinkedList<Cards> F) {
		
		for(int i = 0; i < fieldsize; i++) {
			int j = (int) (Math.random()*81+1);
			
			if(!filledField(F)) {
				F.add(c.get(j));
				c.remove(j);
			}
			
		}
		
		return F;
		
	}
	
	private boolean filledField(LinkedList<Cards> F) {
		if(F == null) {
			return false;
		} else if( F.size() > fieldsize ){
			return true;
		} else {
			return false;
		}
	}

}
