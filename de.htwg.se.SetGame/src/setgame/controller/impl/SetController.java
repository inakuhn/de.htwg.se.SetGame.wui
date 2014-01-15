package setgame.controller.impl;


import java.util.LinkedList;

import setgame.controller.IController;
import setgame.modell.ICard;
import setgame.modell.IField;

import java.util.List;

import de.htwg.se.util.observer.Observable;
import setgame.modell.impl.Card;


/**
 * @author Raina & David Logic class for the game
 * 
 */
public class SetController extends Observable implements IController {
	private IField field;
	private int counter;
	private static final int NUMBEROFSETCARDS = 3;
	private final int playerOne;
	private final int playerTwo;
	private int playerOneCounter;
	private int playerTwoCounter;
	private static final int COMPUTERMODUS = 0;

	/**
	 * Logic Construct make for the game a new field with a new pack!!!
	 */
	public SetController(int spielmodus) {
		this.field = new setgame.modell.impl.Field();
		this.counter = 0;
		this.field.startUp();
		this.playerOne = 1;
		this.playerTwo = 2;
		this.playerOneCounter = 0;
		this.playerTwoCounter = 0;
		checkIfIsASeTInGame();

	}

	private void checkIfIsASeTInGame() {
		List<Card> liste = new LinkedList<Card>();
		liste.addAll(getSet(this.field.getAllCardsInGame()));
		if(liste.size() < NUMBEROFSETCARDS){
			while(!changeCardsinGame()){
				
			}
			
		}
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.impl.IController#spielModus()
	 */
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getPlayModus()
	 */

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
			if (proveIfIsASet(cardOne, cardTwo, cardThree)) {
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

	private boolean proveColor(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveString(cardOne.getColor(), cardTwo.getColor(),
				cardThree.getColor());
	}

	private boolean proveNumberOfComponents(ICard cardOne, ICard cardTwo,
			ICard cardThree) {
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

	private boolean proveFilling(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveString(cardOne.getPanelFilling(),
				cardTwo.getPanelFilling(), cardThree.getPanelFilling());
	}

	private boolean proveForm(ICard cardOne, ICard cardTwo, ICard cardThree) {
		return proveString(cardOne.getFomr(), cardTwo.getFomr(),
				cardThree.getFomr());
	}

	private boolean proveString(String stringOne, String stringTwo,
			String stringThree) {
		if (stringOne.compareTo(stringTwo) == 0
				&& stringOne.compareTo(stringThree) == 0 && stringTwo.compareTo(stringThree) == 0) {
			return true;
		} else if (stringOne.compareTo(stringTwo) != 0
				&& stringOne.compareTo(stringThree) != 0
				&& stringTwo.compareTo(stringThree) != 0) {
			return true;
		}
		return false;
	}

	private boolean proveIfIsASet(Card cardOne, Card cardTwo, Card cardThree) {
		if (proveColor(cardOne, cardTwo, cardThree)
				&& proveFilling(cardOne, cardTwo, cardThree)
				&& proveNumberOfComponents(cardOne, cardTwo, cardThree)
				&& proveForm(cardOne, cardTwo, cardThree)) {
			return true;
		}
		return false;

	}

	private List<Card> getSet(List<Card> list) {
		LinkedList<Card> setList = new LinkedList<Card>();
		if (list.size() >= NUMBEROFSETCARDS) {

			for (Card cardOne : list) {
				for (Card cardTwo : list) {
					if (!cardOne.equals(cardTwo)) {
						for (Card cardThree : list) {

							if (proveIfIsASet(cardOne, cardTwo, cardThree)
									&& !cardThree.equals(cardOne)
									&& !(cardTwo.equals(cardThree))) {

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

	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getCardinGame()
	 */
	@Override
	public List<Card> getCardinGame() {
		return this.field.getAllCardsInGame();
	}

	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getField()
	 */
	@Override
	public IField getField() {
		return this.field;
	}

	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#areSetInField()
	 */
	@Override
	public boolean areSetInField() {
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll(getSet(this.field.getCardsInField()));
		if (liste.isEmpty()) {
			return changeCardsinGame();

		}
		return true;
	}

	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#isAsetForController(setgame.modell.impl.Card, setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	@Override
	public boolean isAsetForController(Card cardOne, Card cardTwo,
			Card cardThree, int player) {
		if (isAset(cardOne, cardTwo, cardThree)) {
			if (this.playerOne == player) {
				this.playerOneCounter = this.playerOneCounter + 1;
			} else if (this.playerTwo == player) {
				this.playerTwoCounter = this.playerTwoCounter + 1;
			}
			if (playerOne == player || player == this.playerTwo) {
				return true;
			}
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getAsetInGame()
	 */
	@Override
	public List<Card> getAsetInGame(){
		return getSet(this.field.getCardsInField());
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#stillSetInGAme()
	 */
	@Override
	public boolean stillSetInGAme() {
		LinkedList<Card> liste = new LinkedList<Card>();
		liste.addAll(getSet(this.field.getAllCardsInGame()));
		System.out.println("LIsteedwwsasswsaeee"+liste);
		if(liste.isEmpty()){
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getSetInField()
	 */
	@Override
	public List<Card> getSetInField(){
		return getSet(this.field.getCardsInField());
		
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#geTplayerOnePoints()
	 */
	@Override
	public int geTplayerOnePoints(){
		return this.playerOneCounter;
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#geTplayerTwoPoints()
	 */
	@Override
	public int geTplayerTwoPoints(){
		return this.playerTwoCounter;
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getPlayerOne()
	 */
	@Override
	public int getPlayerOne(){
		return this.playerOne;
	}
	/* (non-Javadoc)
	 * @see setgame.controller.impl.ISuperController#getPlayerTwo()
	 */
	@Override
	public int getPlayerTwo(){
		return this.playerTwo;
	}

}
