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
	Pack pack;
	@Before
	public void setUp(){
		this.setcontroll = new SetController(1);
		this.pack = new Pack();
	}
	@Test
	public void testSetController() {
		fail("Not yet implemented");
	}

	@Test
	public void testgetPlayModus() {
		if(!(this.setcontroll.getPlayModus() == 0) || !(this.setcontroll.getPlayModus() == 1)){
			fail("setgamemodus ist falche nicht computer und nicht zweier player");
		}
	}

	@Test
	public void testIsAsetForController() {
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll()
		for()
	}

	@Test
	public void testIsAset() {
		fail("Not yet implemented");
	}

}
