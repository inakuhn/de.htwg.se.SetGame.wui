package setgame.modell;

import java.util.LinkedList;



/**
 * Class Field.
 * @author David Simon & Raina Bertolini
 * @date 7.12.2013
 * @category Modell
 */
public class Field {

	/**
	 * Instance variable
	 */
	private static final int FIELDSIZE = 12;
	private static final int MAX = 81;
	private static final int ONE = 1;
	private static int COUNTER = 0;
	private Pack card = new Pack();
	
	/**
	 *  All used Cards will be write in the LinkedList register
	 */
	private LinkedList<Card> register = new LinkedList<Card>();

	public Field() {
	}

	/** Field will be initializes.
	 *  @return give back filled field
	 */
	public Card[] init() {
		Card[] field = new Card[FIELDSIZE];

		return fillField(field);
	}

	/** Filled array with integer number.
	 *  @return filled array
	 */
	public int[] rand() {
		int[] array = new int[MAX];
		boolean b;
		for (int i = 0; i < MAX; i++) {
			b = true;
			int j = (int) (Math.random() * MAX + ONE);
			for (int t = 0; t < MAX; t++) {
				if (j == array[t] && i > 0) {
					i = i - 1;
					b = false;
				}
			}
			if (b) {
				array[i] = j;
			}
		}
		return array;
	}

	/** Filled field with cards from the class Card
	 *  @return filled Field with Cards
	 */
	private Card[] fillField(Card[] field) {

		int array[] = rand();

		for (int i = 0; i < FIELDSIZE; i++) {
			field[i] = card.getPack()[array[i]];
			register.add(card.getPack()[array[i]]);
		}

		return field;

	}
	
	/**
	 * Fill the variable fill with one card information and gives back.
	 * @return fill - return one "card information" 
	 */
	public Card getCardsInField() {	
		
		Card fill;
		int randfill[] = rand();
		boolean close = false;
		
		while(COUNTER != randfill.length) {
			close = false;
			
			if (register.equals(randfill[COUNTER])) {
				close = true;
				COUNTER++;
			}
			
			if (close == false) {
				fill = card.getPack()[randfill[COUNTER]];
				register.add(card.getPack()[randfill[COUNTER]]);
				return fill;
			}
		}
		
		System.err.printf("Game Over\n");
		return null;
	}
	/**
	 * Insert new Cards in the field where cardOne , cardTwo ,cardThree went.
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 */
	public void foudSet(Card cardOne, Card cardTwo, Card cardThree){
		
	}
	
	/**
	 * @return all the cards in the field
	 */
	public LinkedList<Card> cardsInField(){
		LinkedList<Card> list = new LinkedList<Card>();
		return list;
	}
	
	/**
	 *	changes the size of the field in the game or at the begin with out losing Cards. 
	 */
	public void setSizeOfField(){
		
	}
	
	
	/**	the Controller always prove if a Set in Field is, if not the look through the existent pack
	 * and prove if still existing a Set if yes calls the changed Cards. 
	 * @param liste
	 */
	public void changeCards(LinkedList<Card> liste){
		
	}
	/**
	 * @return the existence pack all Cards in game also the field cards!
	 */
	public LinkedList<Card> getPack(){
		LinkedList<Card> list = new LinkedList<Card>();
		return list;
		
	}

}
