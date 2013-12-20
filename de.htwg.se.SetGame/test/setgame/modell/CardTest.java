package setgame.modell;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import setgame.modell.Card;

public class CardTest {

	Card card = null;
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
