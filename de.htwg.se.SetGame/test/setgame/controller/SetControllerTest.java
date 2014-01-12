package setgame.controller;

import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import setgame.controller.impl.SetController;
import setgame.modell.impl.Card;
import setgame.modell.impl.Pack;

public class SetControllerTest {
	SetController setcontroll;
	LinkedList<Card> aSetListe;

	@Before
	public void setUp() {
		this.setcontroll = new SetController(1);
		this.aSetListe = new LinkedList<Card>();
		aSetListe.add(this.setcontroll.)
	}

	@Test
	public void testSetController() {
	}

	@Test
	public void testgetPlayModus() {
		if ((this.setcontroll.getPlayModus() == 0)
				&& !(this.setcontroll.getPlayModus() == 1)) {
			fail("setgamemodus ist falche nicht computer und nicht zweier player");
		}
	}

	@Test
	public void testIsAsetForController() {
		while (!this.setcontroll.areSetInField()) {
			this.setcontroll.areSetInField();
			System.out.println("StillSet?"
					+ this.setcontroll.getField().getCardInFieldGame() + "\n");
		}
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll(this.setcontroll.getField().getAllCardsInGame());
		LinkedList<Card> controll = new LinkedList<Card>();
		controll.addAll(this.setcontroll.getField().getAllCardsInGame());
		System.out.println("ssssss" + setcontroll.stillSetInGAme());
		int counter = 0;
		while (setcontroll.stillSetInGAme()) {
			if (this.setcontroll.getSetInField().size() >= 3) {
				this.setcontroll.isAsetForController(this.setcontroll
						.getSetInField().get(0), this.setcontroll
						.getSetInField().get(1), this.setcontroll
						.getSetInField().get(2), 1);
			}
		}

		System.out.println(this.setcontroll.getField().getAllCardsInGame()
				.size()
				+ counter);

	}
}
