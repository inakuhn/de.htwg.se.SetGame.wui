package de.htwg.se.SetGame.Modul;

import java.util.LinkedList;

import org.hamcrest.CoreMatchers;

import de.htwg.se.SetGame.Modul.Card.Cards;

public class Field {
	
	private int fieldsize;
	private int counter = 0;
	private boolean free = true;
	private final int max = 12;
	private Card card = new Card();
	private Cards[] c = card.pack;
	
	
	public Field(){
		init();
	}
	
	public Cards[] init() {
		int fieldsize = 12;
		Cards[] field =  new Cards[fieldsize];
		

		this.fieldsize = fieldsize;
		return fillField(field);
	}
	
	
	private Cards[] fillField(Cards[] F) {
		
		int[] again = new int[max];

		for(int i = 0; i < fieldsize; i++) {
		int j = (int) (Math.random()*80+0);

			if(filledField(F)) {
				
				for(int l = 0; l < counter; l++) {
					if(again[l] == j) {
						free = false;
					}
				}
			
				if (free == true) {
					F[i] = c[j];
					again[counter] = j;
					counter++;
				} else {
					i--;
					free = true;
				}	
			}
			
		}
		
		return F;
		
	}
	
	private boolean filledField(Cards[] F) {
		if(F == null) {
			return true;
		}
		if( F.length == fieldsize+1 ){
			return false;
		} else {
			return true;
		}
	}

}
