package setgame.modell;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
	/* ramdomLieste is the random for the game */
	private int randomIndex;
	Map<Integer, Integer> ramdomListe;

	/**
	 * cardinfield are the cars in game
	 */
	Map<Integer, Card> cardInFieldGame;

	/**
	 * pack for the game are the cards and the random positions
	 */
	Map<Integer, Card> packForThegame;

	int array[];

	/**
	 * All used Cards will be write in the LinkedList register
	 */
	private LinkedList<Card> register;

	/**
	 * startup of the objects
	 */
	public Field() {
		this.pack = new Pack();
		this.cardInFieldGame = new TreeMap<Integer, Card>();
		this.ramdomListe = new TreeMap<Integer, Integer>();
		this.packForThegame = new TreeMap<Integer, Card>();
		this.randomIndex = 1;
		 this.register = new LinkedList<Card>();

		startUp();
	}

	/**
	 * Field will be initializes.
	 * 
	 * @return give back filled field
	 */
	public void startUp() {
		rand();
		int i = 0;
		for (Card card : this.pack.getPack()) {
			packForThegame.put(this.ramdomListe.get(i), card);
			i++;
		}
		
		System.out.println("Pack for game");
		System.out.println(packForThegame);
		fillField();
	}

	private void setRandomIndex() {
		if(this.randomIndex < MAX)
			this.randomIndex = randomIndex + ONE;
	}

	private int getRandomIndex() {
		return this.randomIndex;
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
	private TreeMap<Integer, Card> fillField() {

		for (int index = 0; index < FIELDSIZE; index++) {
			this.cardInFieldGame.put(index,
					this.packForThegame.get(getRandomIndex()));
			setRandomIndex();
		}

		return (TreeMap<Integer, Card>) cardInFieldGame;

	}

	// /**
	// * Fill the variable fill with one card information and gives back.
	// *
	// * @return fill - return one "card information"
	// */
	// private Card setCardsInField() {
	//
	// Card fill;
	// int randfill[] = this.array;
	// boolean close = false;
	//
	// while (COUNTER != randfill.length) {
	// close = false;
	//
	// if (register.equals(randfill[COUNTER])) {
	// close = true;
	// COUNTER++;
	// }
	//
	// if (close == false) {
	// fill = pack.getPack().get(randfill[COUNTER]);
	// register.add(pack.getPack().get(randfill[COUNTER]));
	// return fill;
	// }
	// }
	//
	// return null;
	// }

	/**
	 * Insert new Cards in the field where cardOne , cardTwo ,cardThree went.
	 * 
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 */
	public void foundSet(Card cardOne, Card cardTwo, Card cardThree) {
		TreeMap<Integer, Card> setPositionInField = new TreeMap<Integer, Card>();
		TreeMap<Integer, Card> temporaltoremoveCard = new TreeMap<Integer, Card>();
		if(!(cardOne.equals(null)) && !(cardTwo.equals(null)) && !(cardThree.equals(null)) ){
			for (Integer key : this.cardInFieldGame.keySet()) {
				if (this.cardInFieldGame.get(key).comparTo(cardOne)
						|| this.cardInFieldGame.get(key).comparTo(cardTwo)
						|| this.cardInFieldGame.get(key).comparTo(cardThree)) {
					setPositionInField.put(key, this.cardInFieldGame.get(key));
				}
			}
			for (Integer keyOfPack : this.packForThegame.keySet()) {
				if (this.packForThegame.get(keyOfPack).comparTo(cardOne)
						|| this.packForThegame.get(keyOfPack).comparTo(cardTwo)
						|| this.packForThegame.get(keyOfPack).comparTo(
								cardThree)) {
					temporaltoremoveCard.put(keyOfPack,
							this.packForThegame.get(keyOfPack));
				}
			}
			System.out.println("Size of felder = "+ this.cardInFieldGame.size());
		
			System.out.println(cardInFieldGame);
			for(Integer key : setPositionInField.keySet()){
				this.cardInFieldGame.remove(key);
				
			}
			for (Integer key : setPositionInField.keySet()) {
				
				this.cardInFieldGame.put(key,
						this.packForThegame.get(getRandomIndex()));
					System.out.println("Random = "+ getRandomIndex());
				setRandomIndex();
			}
			for (Integer key : temporaltoremoveCard.keySet()) {
				this.packForThegame.remove(key);
		
			}
			System.out.println("sizeof pack = "+this.packForThegame.size());
		}
		}
	

	/**
	 * @return all the cards in the field
	 */
	public LinkedList<Card> cardsInField() {
		LinkedList<Card> liste = new LinkedList<Card>();
		for(Card card : this.cardInFieldGame.values())
			liste.add(card);
		return liste;

	}

	/**
	 * changes the size of the field in the game or at the begin with out losing
	 * Cards.
	 */
	public void setSizeOfField(int size) {
		if (size < FIELDSIZE) {
			changeFieldToSmallSize(size);
		} else if (size > FIELDSIZE) {
			FIELDSIZE = size;
			// cardInFieldGame = new Card[FIELDSIZE];
		}
	}

	private void changeFieldToSmallSize(int size) {
		LinkedList<Card> savelist = new LinkedList<Card>();
		int saveSize = size + 1;

		for (int n = saveSize; n < FIELDSIZE; n++) {
			savelist.add(cardInFieldGame.get(n));
		}

		register.remove(savelist);

	}

	/**
	 * the Controller always prove if a Set in Field is, if not the look through
	 * the existent pack and prove if still existing a Set if yes calls the
	 * changed Cards.
	 * 
	 * @param liste
	 */
	public void changeCards(LinkedList<Card> liste) {
		int size = liste.size();

		if (FIELDSIZE >= size) {

			for (int n = 0; n < size; n++) {
				// cardInFieldGame[n] = liste.get(n);
			}

		} else {

			setSizeOfField(size);

			for (int n = 0; n < size; n++) {
				// cardInFieldGame[n] = liste.get(n);
			}

		}

	}

	/**
	 * @return the unused Cards in game!
	 */
	public LinkedList<Card> getPackForControler() {
		LinkedList<Card> list = new LinkedList<Card>();

		for (Card rest : this.packForThegame.values()) {
			if (!this.cardInFieldGame.containsValue(rest)) {
				list.add(rest);
			}
		}

		return list;
	}

	public int getSizeofField() {
		return cardInFieldGame.size();
	}

	public LinkedList<Card> getAllCardsInGame() {
		LinkedList<Card> list = new LinkedList<Card>();
		for (Card card : this.packForThegame.values()) {
			list.add(card);
		}
		return list;
	}

}
