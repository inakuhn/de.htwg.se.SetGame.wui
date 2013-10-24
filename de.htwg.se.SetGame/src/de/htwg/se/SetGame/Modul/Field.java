package de.htwg.se.SetGame.Modul;

import de.htwg.se.SetGame.Modul.Card.Cards;

public class Field {
	
	int fieldsize = 12;
	
	public void newField() {
		String[] Field = new String[fieldsize];
		fillField(Field);
	}
	
	public void fillField(String[] F) {
		
		for(int i = 0; i < fieldsize; i++) {
			if(!filledField(F, i)) {
				F[i] = "TODO: Karten einspeichern!";
			}
			
		}
		
	}
	
	public boolean filledField(String[] F,int n) {
		if(F[n] == null) {
			return false;
		} else {
			return true;
		}
	}

}
