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
		System.out.println(this.setcontroll.geTplayerOnePoints());
	}

	@Test
	public void testIsAsetForController() {
		LinkedList<Integer> liste = new LinkedList<>();
		for (Integer key : this.setcontroll.getField().getCardInFieldGame()
				.keySet()) {
			if (aSetListe.contains(this.setcontroll.getField()
					.getCardInFieldGame().get(key))) {
				liste.add(key);
			}
		}
		if (this.aSetListe.size() >= 3 && liste.size() >= 3) {
			this.setcontroll
					.isAsetForController(this.setcontroll.getField()
							.getCardInFieldGame().get(liste.get(0)),
							this.setcontroll.getField().getCardInFieldGame()
									.get(liste.get(1)),
							this.setcontroll.getField().getCardInFieldGame()
									.get(liste.get(2)),
							this.setcontroll.getPlayerOne());
			if (this.setcontroll.geTplayerOnePoints() != 1) {
				fail("the point for the set is not abel!");
			}
			System.out.println(this.setcontroll.getPlayerOne());
		}
		if (this.setcontroll.getField().getAllCardsInGame()
				.containsAll(aSetListe)) {
			fail("the set was been not removed from the pack ");
		}

	}

}
