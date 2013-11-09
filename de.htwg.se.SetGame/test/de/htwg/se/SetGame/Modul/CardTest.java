package de.htwg.se.SetGame.Modul;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.SetGame.Modul.Card;
import de.htwg.se.SetGame.Modul.Card.Cards;

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
				} else {
					b = false;
				}
			}
		}

		System.out.println(b + " " + n);
	}

	@Test
	public void testGetCards() {
		if (this.list instanceof Cards[]) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
