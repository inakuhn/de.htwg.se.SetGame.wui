
package de.htwg.se.aview;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import de.htwg.se.aview.SetGame;

public class SetGameTest {
	SetGame set;
	@Before
	public void setUp(){
		this.set = new SetGame();
	}
	@Test
	public void test() {
		if(this.set == null){
			fail("set ins a null");
		}
	}

}
