package setgame.modell.impl;

import java.util.List;
import java.util.Map;

import setgame.modell.IField;

public abstract class AField implements IField {

	/**
	 * Instance variable
	 * 
	 */
	protected int sizeOfField;
	protected static final int INITIALVALUEOFFIELD = 12;
	protected static final int MAX = 81;
	protected static final int ONE = 1;
	protected Pack pack;
	protected Map<Integer, Integer> ramdomListe;
	/**
	 * card are the cars in game
	 */
	protected Map<Integer, Card> cardInFieldGame;
	/**
	 * pack for the game are the cards and the random positions
	 */
	protected List<Card> packForGame;

	public AField() {
		super();
	}

}