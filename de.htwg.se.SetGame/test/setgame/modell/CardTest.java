package setgame.modell;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	Card card = null;
	@Before
	private void setUp() {
		this.card = new Card("red", "wave", "empty", 1);

	}
	@Test
	public void testCard() {
		assert(card == null);
		
	}

	@Test
	public void testGetColor() {
		if(this.card.getColor() == null){
			fail("coler = null");
		}else{
			assert(!(card.getColor().equals(setgame.modell.Pack.COLORS[0]) || card.getColor().equals(setgame.modell.Pack.COLORS[1]) || card.getColor().equals(setgame.modell.Pack.COLORS[2] )));
	
		}
	}
	@Test
	public void testGetFomr() {
		assert(card.getFomr() == null);
	}

	@Test
	public void testGetPanelFilling() {
		assert(card.getPanelFilling() == null);
	}

	@Test
	public void testGetNumberOfComponents() {
		assert(card.getNumberOfComponents() == -1);
	}

}
