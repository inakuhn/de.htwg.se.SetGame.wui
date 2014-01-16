package setgame.controller;


import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.setgame.controller.impl.SetController;
import de.htwg.se.setgame.modell.impl.Card;

public class SetControllerTest {
	SetController setcontroll;
	LinkedList<Card> aSetListe;

	@Before
	public void setUp() {
		this.setcontroll = new SetController();
		this.aSetListe = new LinkedList<Card>();
		aSetListe.addAll(this.setcontroll.getSetInField());
	}

	@Test
	public void testSetController() {
		System.out.println(this.setcontroll.geTplayerOnePoints());
	}

	@Test
	public void testIsAsetForController() {
		setcontroll.isAsetForController(aSetListe.get(0), aSetListe.get(1), aSetListe.get(2), setcontroll.getPlayerOne());
		
	}

}
