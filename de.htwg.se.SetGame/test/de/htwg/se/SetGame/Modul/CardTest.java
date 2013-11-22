package de.htwg.se.SetGame.Modul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import de.htwg.se.setgame.modell.Card;
import de.htwg.se.setgame.modell.Card.Cards;

public class CardTest {
	Card card;
	Cards[] list;

	@Before
	public void setUp() throws Exception {
		this.card = new Card();
		this.list = card.getCards();

	}

	@Test
	public void testCard() {
		boolean b = false;
		boolean n = true;

		for (Cards c : list) {
			for (Cards cards : list) {
				if (c.getColor().equals(cards.getColor())
						|| c.getFomr().equals(cards.getFomr())
						|| c.getPanelFilling().equals(cards.getPanelFilling())
						|| c.getAnz() == cards.getAnz()) {

					b = true;
				} else if(c.getColor().equals(null)
						|| c.getFomr().equals(null)
						|| c.getPanelFilling().equals(null)
						|| c.getAnz() == -1) {
					b = false;
				}
			}
		}

		if (!b)
			fail("not gut :(");
	}

	@Test
	public void testGetCards() {
		if (!(this.list instanceof Cards[]))
			fail("not a instance of");

	}

}
