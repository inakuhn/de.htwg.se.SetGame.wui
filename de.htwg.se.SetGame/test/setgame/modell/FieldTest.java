package setgame.modell;

import static org.junit.Assert.*;

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
		if(this.field == null){
			fail("field object ist gleich null");
			
		}
	}

	@Test
	public void testField() {
		if((this.field instanceof Field) == false){
			fail("field ist keine object der gr�sse field");
		}
	}

	@Test
	public void testsartUp() {

		if(this.field.cardInFieldGame.size() != 12){
			fail("feld is not the rigth size");
		}

	}

	@Test
	public void testRand() {
		TreeSet<Integer> liste = new TreeSet<Integer>();
		liste.addAll(this.field.ramdomListe.values());
		if(liste.size() != 81){
			fail("wrong size of randomgeneretor");
		}

	}

	@Test
	public void testFoundSet() {
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll(field.packforgame);
		for (int index = 0; index < (liste.size()-2); index++) {
			this.field.foundSet(liste.get(index),
					liste.get((index+1)),
					liste.get(index+2));
		}
		if(!this.field.packforgame.isEmpty()){
			fail("found a set methode is not working as the way we wish :/");
		}
	}

	@Test
	public void testCardsInField() {
		if(!this.field.cardInFieldGame.values().containsAll(this.field.getCardsInField())){
			fail("the card on feld are not the same as in the methode get card in field");
		}
	}

	@Test
	public void testSetSizeOfField() {
		LinkedList<Card> list = new LinkedList<Card>();
		list.add(this.field.getCardsInField().get(0));
		list.add(this.field.cardInFieldGame.get(1));
		list.add(this.field.cardInFieldGame.get(2));
		this.field.setSizeOfField(15, list);
		if(this.field.getCardsInField().size() != 15){
			fail("field size has been not modifed");
		}
		this.field.setSizeOfField(12, list);
		if(this.field.getSizeofField() != 12){
			fail("field size is wrong :(");
		}
	}

	@Test
	public void testChangeCards() {
		LinkedList<Card> liste =  new LinkedList<Card>(); 
		
		liste.add(this.field.cardInFieldGame.get(0));
		liste.add(this.field.getUnusedCards().get(0));
		liste.add(this.field.getUnusedCards().get(1));
		 this.field.changeCards(liste);
		
	}

	@Test
	public void testGetPackForControler() {
		if(field.packforgame.size() != 81){
			fail("feld gr��e stimmt nicht");
		}
	}

	@Test
	public void testGetSizeofField() {
		if(this.field.getSizeofField() != 12){
			fail("Feld an anfagen muss 12 sein!!!");
		}
	}
}