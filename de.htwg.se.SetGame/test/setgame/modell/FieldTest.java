package setgame.modell;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import setgame.modell.Field;
import setgame.modell.Card.Cards;

public class FieldTest {
	Field f;

	@Before
	public void setUp() {
		this.f = new Field();

	}

	@Test
	public void test() {
		if(this.f == null)
			fail("NullPointer");

	}

	@Test
	public void testFieldradom() {
		System.out.println("ok!");

	}

	@Test
	public void testField() {
		if (!(f instanceof Field))
			fail("Not a instance of");
	}

	@Test
	public void testInit() {
		Cards[] c = f.init();
		for(Cards t : c){
			if(t == null)
				fail("card existiert nicht");
		}
	}

	@Test
	public void testRand() {
		int array[] = f.rand();
		boolean vertauscht;
		for (int i = array.length - 1; i >= 0; i--) {
			vertauscht = false;
			// Durchlauf des Felds von 0 bis i:
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int t = array[j];
					array[j] = array[j + 1];
					array[j + 1] = t;
					vertauscht = true;
				}
			}
			if (!vertauscht)
				break;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}
	}

}
