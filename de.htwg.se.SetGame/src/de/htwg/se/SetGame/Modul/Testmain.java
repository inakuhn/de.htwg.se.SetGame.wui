package de.htwg.se.SetGame.Modul;

import java.util.LinkedList;

import de.htwg.se.SetGame.Modul.Card.Cards;
import de.htwg.se.SetGame.Modul.*;

public class Testmain {
	
	public static void main(String [] args)
	{
		Cards[] testlist =  new Cards[12];
		Field test = new Field();
		
		testlist = test.init();
		
		for (int i = 0; i < 12; i++) {
			System.out.printf((i+1) + ".Zahl: ");
			System.out.println(testlist[i].color + "; " + testlist[i].panelFilling + "; " + testlist[i].fomr + "; " + testlist[i].anz);
		}
	}

}
