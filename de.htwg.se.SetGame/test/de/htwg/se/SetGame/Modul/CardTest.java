package de.htwg.se.SetGame.Modul;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Test;

import de.htwg.se.SetGame.Modul.Card;
import de.htwg.se.SetGame.Modul.Card.Cards;

public class CardTest {
	Card card;

	@Test
	public boolean test() {
		card = new Card();
		LinkedList<Cards> list = card.pack;
		for (Cards c : list) {
			for (Cards cards : list) {
				if (c.color.equals(cards.color) || c.fomr.equals(cards.fomr)
						|| c.panelFilling.equals(cards.panelFilling)
						|| c.anz == cards.anz) {
					return false;
				}
			}
		}
		if(card.getNumerofCards() == list.size()){
			return true;
			
		}
	
		return false;
	}
}
