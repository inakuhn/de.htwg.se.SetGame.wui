package de.htwg.se.SetGame.data;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

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
