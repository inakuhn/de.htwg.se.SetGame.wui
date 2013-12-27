package setgame.modell;

import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import setgame.modell.Field;

public class FieldTest {
	Field field;

	@Before
	public void setUp() {
		this.field = new Field();
	}

	@Test
	public void test() {
		assert (this.field != null);
	}

	@Test
	public void testField() {
		assert ((this.field instanceof Field) != false);
	}

	@Test
	public void testsartUp() {
		LinkedList<Card> list = new LinkedList<Card>();
		for (Card card : field.cardInFieldGame.values()) {
			list.add(card);
		}
		assert (list.size() != 12);
	}

	@Test
	public void testRand() {
		TreeSet<Integer> liste = new TreeSet<Integer>();
		for (Integer integers : field.ramdomListe.values()) {
			liste.add(integers);
		}
		assert (liste.size() != 81);

	}

	@Test
	public void testFoundSet() {
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll(field.packForThegame.values());
		for (int index = 0; index < (liste.size()-2); index++) {
			this.field.foundSet(liste.get(index),
					liste.get((index+1)),
					liste.get(index+2));
			
		}

		assert (this.field.getAllCardsInGame().isEmpty() != false);
	}

	@Test
	public void testCardsInField() {
		for (Card card : this.field.cardsInField()) {
			assert(!this.field.getAllCardsInGame().contains(card));
		}
	}

	@Test
	public void testSetSizeOfField() {
		this.field.setSizeOfField(15);
		assert (this.field.cardsInField().size() != 15);
	}

	@Test
	public void testChangeCards() {
		assert(this.field != null);
	}

	@Test
	public void testGetPackForControler() {
		assert (field.getPackForControler().size() != 81);
	}

	@Test
	public void testGetSizeofField() {
		assert (this.field.cardInFieldGame.size() != 12);
	}
}