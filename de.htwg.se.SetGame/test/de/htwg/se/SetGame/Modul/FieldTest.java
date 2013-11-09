package de.htwg.se.SetGame.Modul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.SetGame.Modul.Card.Cards;

public class FieldTest {
	Field f;

	@Before
	public void setUp() {
		this.f = new Field();

	}

	@Test
	public void test() {
		assert (this.f == null);

	}

	@Test
	public void testFieldradom() {
		Cards[] c = f.init();
		for(Cards t : c)
			System.out.println(t.getAnz() + " ; "+ t.getColor()+" ; "+ t.getFomr() +" ; "+ t.getPanelFilling());

	}

	@Test
	public void testField() {
		assert (f instanceof Field);
	}

	@Test
	public void testInit() {
		assert (this.f.init() instanceof Cards[] || f.init() == null);
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
