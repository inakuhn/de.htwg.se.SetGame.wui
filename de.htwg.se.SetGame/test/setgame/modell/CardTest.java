package setgame.modell;
import org.junit.Before;
import org.junit.Test;

import setgame.modell.impl.Card;

public class CardTest {

	ICard card = null;
	@Before
	public void setUp() {
		this.card = new Card("red", "wave", "fill", 1);

	}
	@Test
	public void testCard() {
		assert(card != null);
		
	}

	@Test
	public void testGetColor() {
		assert(card.getColor() != null);
	}
	@Test
	public void testGetFomr() {
		assert(card.getFomr() != null);
	}

	@Test
	public void testGetPanelFilling() {
		assert(card.getPanelFilling() != null);
	}

	@Test
	public void testGetNumberOfComponents() {
		assert(card.getNumberOfComponents() != -1);
	}

}
