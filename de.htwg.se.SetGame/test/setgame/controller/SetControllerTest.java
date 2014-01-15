package setgame.controller;

import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import setgame.controller.impl.SetController;
import setgame.modell.impl.Card;

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
	}



	@Test
	public void testIsAsetForController() {
		
		if(this.aSetListe.size() >= 3){
			this.setcontroll.isAsetForController(aSetListe.get(0), aSetListe.get(1), aSetListe.get(2), this.setcontroll.getPlayerOne());
			if(this.setcontroll.geTplayerOnePoints() !=  1){
				fail("the point for the set is not abel!");
			}
		}
		if(this.setcontroll.getField().getAllCardsInGame().containsAll(aSetListe)){
			fail("the set was been not removed from the pack ");
		}
	
	}
	
}
