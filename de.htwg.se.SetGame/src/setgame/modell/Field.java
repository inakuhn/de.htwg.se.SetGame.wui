package setgame.modell;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class Field.
 * 
 * @author David Simon & Raina Bertolini
 * @date 7.12.2013
 * @category Modell
 */
public class Field {

	/**
	 * Instance variable
	 * 
	 */
	private static int FIELDSIZE = 12;
	private static final int MAX = 81;
	private static final int ONE = 1;
	private static int COUNTER = 0;

	/* Pack is the cards in the game */
	private Pack pack;
	Map<Integer, Integer> ramdomListe;

	/**
	 * card are the cars in game
	 */
	Map<Integer, Card> cardInFieldGame;

	/**
	 * pack for the game are the cards and the random positions
	 */

	LinkedList<Card> packforgame;

	/**
	 * startup of the objects
	 */
	public Field() {
		this.pack = new Pack();
		this.cardInFieldGame = new TreeMap<Integer, Card>();
		this.ramdomListe = new TreeMap<Integer, Integer>();
		this.packforgame = new LinkedList<Card>();
		new LinkedList<Card>();

		startUp();
	}

	/**
	 * Field will be initializes.
	 * 
	 * @return give back filled field
	 */
	public void startUp() {
		Map<Integer, Card> packForThegame = new TreeMap<Integer, Card>();
		rand();
		int i = 0;
		for (Card card : this.pack.getPack()) {
			packForThegame.put(this.ramdomListe.get(i), card);
			i++;
		}
		packforgame.addAll(packForThegame.values());

		fillField();
	}


	/**
	 * Filled array with integer number.
	 * 
	 * @return filled array
	 */
	public TreeMap<Integer, Integer> rand() {
		int[] tem = new int[MAX];
		boolean b;
		for (int key = 0; key < MAX; key++) {
			b = true;
			int element = (int) (Math.random() * MAX + ONE);
			for (int t = 0; t < MAX; t++) {
				if (element == tem[t] && key > 0) {
					key = key - 1;
					b = false;
				}
			}
			if (b) {

				this.ramdomListe.put(key, element);

				tem[key] = element;
			}

		}
		return (TreeMap<Integer, Integer>) ramdomListe;

	}

	/**
	 * Filled field with cards from the class Card
	 * 
	 * @return filled Field with Cards
	 */
	private void fillField() {

		for (int index = 0; index < FIELDSIZE; index++) {
			this.cardInFieldGame.put(index, this.packforgame.get(index));

		}
	}

	/**
	 * Insert new Cards in the field where cardOne , cardTwo ,cardThree went.
	 * 
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 */
	public void foundSet(Card cardOne, Card cardTwo, Card cardThree) {

		TreeSet<Integer> keyOfcardInField = new TreeSet<Integer>();
		LinkedList<Card> listCardarenoteinfieldCards = new LinkedList<Card>();
		for (Integer key : this.cardInFieldGame.keySet()) {
			if (this.cardInFieldGame.get(key).comparTo(cardOne)
					|| this.cardInFieldGame.get(key).comparTo(cardTwo)
					|| this.cardInFieldGame.get(key).comparTo(cardThree)) {
				keyOfcardInField.add(key);
				this.packforgame.remove(this.cardInFieldGame.get(key));
			}
		}
		for (Integer key : keyOfcardInField) {
			this.cardInFieldGame.remove(key);

		}

		listCardarenoteinfieldCards.addAll(getUnusedCards());

		for (int index = 0; index < FIELDSIZE; index++) {
			if (this.cardInFieldGame.get(index) == null
					&& !(listCardarenoteinfieldCards.isEmpty())) {
				this.cardInFieldGame.put(index,
						listCardarenoteinfieldCards.getFirst());
				listCardarenoteinfieldCards.removeFirst();
			} else if (this.cardInFieldGame.get(index) == null
					&& listCardarenoteinfieldCards.isEmpty()) {
				this.cardInFieldGame.remove(index);

			} else if (this.cardInFieldGame.containsKey(index) == false
					&& !(listCardarenoteinfieldCards.isEmpty())) {
				this.cardInFieldGame.put(index,
						listCardarenoteinfieldCards.getFirst());
				listCardarenoteinfieldCards.removeFirst();

			}
		}

	}

	/**
	 * @return all the cards in the field
	 */
	public LinkedList<Card> getCardsInField() {
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll(this.cardInFieldGame.values());
		return liste;

	}

	/**
	 * changes the size of the field in the game or at the begin with out losing
	 * Cards.
	 * 
	 * @param removeThisCards
	 *            TODO
	 */
	public void setSizeOfField(int size, LinkedList<Card> removeThisCards) {
		if (size < FIELDSIZE) {
			LinkedList<Integer> keys = new LinkedList<Integer>();
			for (Card card : removeThisCards) {
				for (Integer key : this.cardInFieldGame.keySet()) {
					if (this.cardInFieldGame.get(key).comparTo(card)) {
						keys.add(key);
					}
				}
			}
			for (Integer key : keys) {
				this.cardInFieldGame.remove(key);
			}
			FIELDSIZE = size;
		} else if (size > FIELDSIZE) {
			LinkedList<Card> list = new LinkedList<Card>();
			list.addAll(getUnusedCards());
			for (COUNTER = FIELDSIZE; COUNTER < size; COUNTER++) {
				if (!list.isEmpty()) {
					this.cardInFieldGame.put(COUNTER, list.getFirst());
					list.removeFirst();

				}
			}
			FIELDSIZE = size;
		}
	}

	/**
	 * the Controller always prove if a Set in Field is, if not the look through
	 * the existent pack and prove if still existing a Set if yes calls the
	 * changed Cards.
	 * 
	 * @param liste
	 */
	public void changeCards(LinkedList<Card> liste) {
		if (this.cardInFieldGame.size() < liste.size()) {
			FIELDSIZE = liste.size();
		}
		LinkedList<Integer> keysforbeuse = new LinkedList<Integer>();

		for (Integer key : this.cardInFieldGame.keySet()) {
			if (liste.contains(this.cardInFieldGame.get(key))) {
				liste.remove(this.cardInFieldGame.get(key));

			} else {
				keysforbeuse.add(key);
			}

		}
		for (Integer key : keysforbeuse) {
			if (!liste.isEmpty()) {
				this.cardInFieldGame.put(key, liste.getFirst());
				liste.removeFirst();
			} else if (liste.isEmpty()) {
				break;

			}

		}

	}
	

	/**
	 * @return the unused Cards in game!
	 */
	public LinkedList<Card> getUnusedCards() {
		LinkedList<Card> list = new LinkedList<Card>();
		list.addAll(this.packforgame);
		list.removeAll(this.cardInFieldGame.values());
		return list;
	}

	public int getSizeofField() {
		return cardInFieldGame.size();
	}

	public LinkedList<Card> getAllCardsInGame() {
		return this.packforgame;
	}

}
