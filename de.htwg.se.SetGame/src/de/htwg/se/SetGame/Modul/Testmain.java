package de.htwg.se.SetGame.Modul;

import java.util.LinkedList;

import de.htwg.se.SetGame.Modul.Card.Cards;
import de.htwg.se.SetGame.Modul.*;

public class Testmain {
	
	public static void main(String [] args)
	{
		LinkedList<Cards> testlist = new LinkedList<>();
		Field test = null;
		testlist = test.init();
		
		for (int i = 0; i < 12; i++) {
			System.out.printf(i + ".Zahl: ");
			System.out.println(testlist.get(i).anz + ";" + testlist.get(i).color + ";" + testlist.get(i).fomr + ";" 
			+ testlist.get(i).panelFilling );
		}
	}

}
