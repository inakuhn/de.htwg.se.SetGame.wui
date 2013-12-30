package setgame.controller;

import java.util.LinkedList;

import setgame.modell.Field;

import java.util.List;
import java.util.Timer;

import de.htwg.se.observer.Observable;
import setgame.modell.Card;

/**
 * @author Raina & David Logic class for the game
 * 
 */
public class SetController extends Observable {
	private Field field;
	private int counter;
	private static final int NUMBEROFSETCARDS = 3;
	private final int  playerOne;
	private final int playerTwo;
	private int playerOneCounter;
	private int playerTwoCounter;
	private final int gameModus;
	private static final int COMPUTERMODUS = 0;
	private final int countDownMinuten;

	/**
	 * Logic Construct make for the game a new field with a new pack!!!
	 */
	public SetController(int spielmodus) {
		this.field = new setgame.modell.Field();
		this.counter = 0;
		this.field.startUp();
		if(spielmodus == COMPUTERMODUS){
			this.gameModus = 0;			
		}else{
			this.gameModus = 1;
	
		}
		this.playerOne = 1;
		this.playerTwo = 2;
		this.playerOneCounter = 0;
		this.playerTwoCounter = 0;
		this.countDownMinuten = 120;
		
	}
	public int spielModus(){
		return this.gameModus;
	}
	private int startCountDown() {
		
		System.out.println("ja eoidjoiejdoeijdoidjoie");
		return 1;
	}
	private int getTimeForCountDown() {
		return this.countDownMinuten;
		
	}
	/**
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 * @return true if all the cards are in the field is only a safety Method
	 */
	private boolean isInFiel(Card cardOne, Card cardTwo, Card cardThree) {
		this.counter = 0;
		for (Card card : field.getCardsInField()) {
			if (card.comparTo(cardOne) || card.comparTo(cardTwo)
					|| card.comparTo(cardThree)) {
				counter++;
			}
		}
		if (this.counter == NUMBEROFSETCARDS) {
			return true;
		}
		return false;

	}
	public boolean isAset(Card cardOne, Card cardTwo, Card cardThree, int player){
		if(isAset(cardOne, cardTwo, cardThree)){
			if(this.playerOne == player){
				this.playerOneCounter = this.playerOneCounter + 1;;
			}else if(this.playerTwo == player){
				this.playerTwoCounter =  this.playerTwoCounter + 1;
			}
			if(this.gameModus == COMPUTERMODUS){
				startCountDown();
			}
			if(playerOne == player || player == this.playerTwo){
				return true;
			}
		}
		return false;
	}

	/**
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 * @return return true if is a set.
	 */
	private boolean isAset(Card cardOne, Card cardTwo, Card cardThree) {
		
		if (!isInFiel(cardOne, cardTwo, cardThree)) {
			return false;
		} else {
			if (proveColor(cardOne, cardTwo, cardThree)
					&& proveFilling(cardOne, cardTwo, cardThree)
					&& proveNumberOfComponents(cardOne, cardTwo, cardThree)
					&& proveForm(cardOne, cardTwo, cardThree)) {
					field.foundSet(cardOne, cardTwo, cardThree);
				if (!(getSet(this.field.getCardsInField()).isEmpty())) {
					return true;
				} else if (alltheSetsInField(this.field.getAllCardsInGame())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param list
	 *            is the Cards in field the new ones if there is no set anymore.
	 */
	private boolean alltheSetsInField(List<Card> list) {
		if (!getSet(list).isEmpty()) {
			return true;
		}
		if (changeCardsinGame()) {
			return true;
		}

		return false;

	}

	/**
	 * changed the Cards in the field if necessary. to
	 */
	private boolean changeCardsinGame() {
		List<Card> allCards = new LinkedList<Card>();
		allCards.addAll(field.getAllCardsInGame());
		if (!allCards.isEmpty() && !getSet(allCards).isEmpty()) {
			field.changeCards(getSet(allCards));
			return true;
		}
		return false;

	}

	private boolean proveColor(Card cardOne, Card cardTwo, Card cardThree) {
		return proveString(cardOne.getColor(), cardTwo.getColor(),
				cardThree.getColor());
	}

	private boolean proveNumberOfComponents(Card cardOne, Card cardTwo,
			Card cardThree) {
		if (cardOne.getNumberOfComponents() == cardTwo.getNumberOfComponents()
				&& cardOne.getNumberOfComponents() == cardThree
						.getNumberOfComponents()) {
			return true;
		} else if (cardOne.getNumberOfComponents() != cardTwo
				.getNumberOfComponents()
				&& cardOne.getNumberOfComponents() != cardThree
						.getNumberOfComponents()
				&& cardTwo.getNumberOfComponents() != cardThree
						.getNumberOfComponents()) {
			return true;
		}
		return false;
	}

	private boolean proveFilling(Card cardOne, Card cardTwo, Card cardThree) {
		return proveString(cardOne.getPanelFilling(),
				cardTwo.getPanelFilling(), cardThree.getPanelFilling());
	}

	private boolean proveForm(Card cardOne, Card cardTwo, Card cardThree) {
		return proveString(cardOne.getFomr(), cardTwo.getFomr(),
				cardThree.getFomr());
	}

	private boolean proveString(String stringOne, String stringTwo,
			String stringThree) {
		if (stringOne.equals(stringTwo) && stringOne.equals(stringThree)) {
			return true;
		} else if (!(stringOne.equals(stringTwo) && !(stringOne
				.equals(stringThree))) && !(stringTwo.equals(stringThree))) {
			return true;
		}
		return false;
	}

	private List<Card> getSet(List<Card> list) {
		LinkedList<Card> setList = new LinkedList<Card>();
		if (list.size() >= NUMBEROFSETCARDS) {
			for (Card cardOne : list) {
				for (Card cardTwo : list) {
					if (!cardTwo.comparTo(cardOne)) {
						for (Card cardThree : list) {

							if (isAset(cardOne, cardTwo, cardThree)
									&& !cardThree.comparTo(cardOne)
									&& !(cardTwo.comparTo(cardTwo))) {
								setList.add(cardOne);
								setList.add(cardTwo);
								setList.add(cardThree);
								return setList;
							}
						}
					}
				}
			}
		}
		return setList;
	}
}
