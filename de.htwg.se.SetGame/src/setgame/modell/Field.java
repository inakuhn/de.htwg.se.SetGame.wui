package setgame.modell;

import java.util.LinkedList;
import java.util.List;
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
	private int sizeOfField;
	private static final int INITIALVALUEOFFIELD = 12;
	private static final int MAX = 81;
	private static final int ONE = 1;

	/* Pack is the cards in the game */
	private Pack pack;
	private Map<Integer, Integer> ramdomListe;

	/**
	 * card are the cars in game
	 */
	private Map<Integer, Card> cardInFieldGame;

	/**
	 * pack for the game are the cards and the random positions
	 */

	private List<Card> packForGame;

	/**
	 * startup of the objects
	 */
	public Field() {
		this.pack = new Pack();
		this.sizeOfField = INITIALVALUEOFFIELD;
		this.cardInFieldGame = new TreeMap<Integer, Card>();
		this.ramdomListe = new TreeMap<Integer, Integer>();
		this.packForGame = new LinkedList<Card>();
		new LinkedList<Card>();
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
			packForThegame.put(this.getRamdomListe().get(i), card);
			i++;
		}
		packForGame.addAll(packForThegame.values());

		startUpOfField();
	}


	/**
	 * Filled array with integer number.
	 * 
	 * @return filled array
	 */
	public Map<Integer, Integer> rand() {
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

				this.getRamdomListe().put(key, element);

				tem[key] = element;
			}

		}
		return getRamdomListe();

	}

	/**
	 * Filled field with cards from the class Card
	 * 
	 * @return filled Field with Cards
	 */
	private void startUpOfField() {

		for (int index = 0; index < sizeOfField; index++) {
			this.getCardInFieldGame().put(index, this.packForGame.get(index));

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
		for (Integer key : this.getCardInFieldGame().keySet()) {
			if (this.getCardInFieldGame().get(key).comparTo(cardOne)
					|| this.getCardInFieldGame().get(key).comparTo(cardTwo)
					|| this.getCardInFieldGame().get(key).comparTo(cardThree)) {
				keyOfcardInField.add(key);
				this.packForGame.remove(this.getCardInFieldGame().get(key));
			}
		}
		for (Integer key : keyOfcardInField) {
			this.getCardInFieldGame().remove(key);

		}

		listCardarenoteinfieldCards.addAll(getUnusedCards());

		for (int index = 0; index < sizeOfField; index++) {
			if (this.getCardInFieldGame().get(index) == null
					&& !(listCardarenoteinfieldCards.isEmpty())) {
				this.getCardInFieldGame().put(index,
						listCardarenoteinfieldCards.getFirst());
				listCardarenoteinfieldCards.removeFirst();
			} else if (this.getCardInFieldGame().get(index) == null
					&& listCardarenoteinfieldCards.isEmpty()) {
				this.getCardInFieldGame().remove(index);

			} else if (this.getCardInFieldGame().containsKey(index) == false
					&& !(listCardarenoteinfieldCards.isEmpty())) {
				this.getCardInFieldGame().put(index,
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
		liste.addAll(this.getCardInFieldGame().values());
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
		if (size < sizeOfField) {
			LinkedList<Integer> keys = new LinkedList<Integer>();
			for (Card card : removeThisCards) {
				for (Integer key : this.getCardInFieldGame().keySet()) {
					if (this.getCardInFieldGame().get(key).comparTo(card)) {
						keys.add(key);
					}
				}
			}
			for (Integer key : keys) {
				this.getCardInFieldGame().remove(key);
			}
			sizeOfField = size;
		} else if (size > sizeOfField) {
			LinkedList<Card> list = new LinkedList<Card>();
			list.addAll(getUnusedCards());
			for (int key = sizeOfField; key < size; key++) {
				if (!list.isEmpty()) {
					this.getCardInFieldGame().put(key, list.getFirst());
					list.removeFirst();

				}
			}
			sizeOfField = size;
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
		if (this.getCardInFieldGame().size() < liste.size()) {
			sizeOfField = liste.size();
		}
		LinkedList<Integer> keysforbeuse = new LinkedList<Integer>();

		for (Integer key : this.getCardInFieldGame().keySet()) {
			if (liste.contains(this.getCardInFieldGame().get(key))) {
				liste.remove(this.getCardInFieldGame().get(key));

			} else {
				keysforbeuse.add(key);
			}

		}
		for (Integer key : keysforbeuse) {
			if (!liste.isEmpty()) {
				this.getCardInFieldGame().put(key, liste.getFirst());
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
		list.addAll(this.packForGame);
		list.removeAll(this.getCardInFieldGame().values());
		return list;
	}

	public int getSizeofField() {
		return getCardInFieldGame().size();
	}

	public List<Card> getAllCardsInGame() {
		return this.packForGame;
	}

	/**
	 * @return the ramdomListe
	 */
	public Map<Integer, Integer> getRamdomListe() {
		return ramdomListe;
	}

	/**
	 * @return the cardInFieldGame
	 */
	public Map<Integer, Card> getCardInFieldGame() {
		return cardInFieldGame;
	}



}
