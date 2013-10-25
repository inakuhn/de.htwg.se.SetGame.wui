package de.htwg.se.SetGame.Modul;

import java.util.LinkedList;
import de.htwg.se.SetGame.Modul.Card.Cards;

public class Field {
	
	public int fieldsize;
	private Card card = new Card();
	private LinkedList<Cards> c = card.pack;
	
	private Cards l;
	
	
	public Field(){
		init();
	}
	
	public LinkedList<Cards> init() {
		int fieldsize = 12;
		LinkedList<Cards> field = new LinkedList<>();
		field.clear();

		this.fieldsize = fieldsize;
		return fillField(field);
	}
	
	
	private LinkedList<Cards> fillField(LinkedList<Cards> F) {
		
		for(int i = 0; i < fieldsize; i++) {
			int j = (int) (Math.random()*80+0);
			
			if(filledField(F)) {
				
				l = c.get(j);
				F.add(l);
			}
			
		}
		
		return F;
		
	}
	
	private boolean filledField(LinkedList<Cards> F) {
		if(F == null) {
			return true;
		}
		if( F.size() == fieldsize+1 ){
			return false;
		} else {
			return true;
		}
	}

}
