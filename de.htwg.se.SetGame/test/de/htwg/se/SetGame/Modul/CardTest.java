package de.htwg.se.SetGame.Modul;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.SetGame.Modul.Card;
import de.htwg.se.SetGame.Modul.Card.Cards;

public class CardTest {
	Card card;
	Cards[] list;

	@Before
	public void setUp() throws Exception{
		this.card = new Card();
		this.list = card.getCards();
		
	}
	@Test
	public void test() {
		boolean b = false;
		boolean n = false;

		for (Cards c : list) {
			for (Cards cards : list) {
				if (c.getColor().equals(cards.getColor()) || c.getFomr().equals(cards.getFomr())
						|| c.getPanelFilling().equals(cards.getPanelFilling())
						|| c.getAnz() == cards.getAnz()) {
					b = true;
				}else{
					b = false;
				}
			}
		}
		if(card.getNumerofCards() == list.length){
			n = true;
			
		}
		System.out.println(b+" "+n);
	}
	
	
	
}
