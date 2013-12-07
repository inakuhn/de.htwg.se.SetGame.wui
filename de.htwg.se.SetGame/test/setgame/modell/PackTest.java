package setgame.modell;

import org.junit.Test;


public class PackTest {
	Pack card;
	Pack c;

	@Test
	public void testCard() {
		card = new Pack();
	}

	@Test
	public void testGetCards() {
		this.c = new Pack();
		boolean b = false;
		for (Card cartas : c.getPack()) {
			if (cartas.getColor().equals(c.getcolors()[0])
					|| cartas.getColor().equals(c.getcolors()[1])
					|| cartas.getColor().equals(c.getcolors()[2])
					&& cartas.getFomr().equals(c.getFormes()[0])
					|| cartas.getFomr().equals(c.getFormes()[1])
					|| cartas.getFomr().equals(c.getFormes()[2])
					&& cartas.getPanelFilling().equals(c.getFill()[0])
					|| cartas.getPanelFilling().equals(c.getFill()[1])
					|| cartas.getPanelFilling().equals(c.getFill()[2])
					&& cartas.getNumberOfComponents() == 1
					|| cartas.getNumberOfComponents() == 2
					|| cartas.getNumberOfComponents() == 3) {
				b = true;
			} else {
				b = false;
			}

		}
		assert(!b);
		
	}
} 
