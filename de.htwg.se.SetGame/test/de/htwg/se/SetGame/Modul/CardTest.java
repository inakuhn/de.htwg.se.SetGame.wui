package de.htwg.se.SetGame.Modul;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import de.htwg.se.SetGame.Modul.Card;

public class CardTest {
	@Test
	public boolean test(TreeSet<Card> c) {
		TreeSet<Card> list = new TreeSet<Card>();
		for(Card cards : c){
			list.add(cards);
			
		}
		if(list.equals(c)){
			return true;
			
		}
		return false;
	}
	

}
