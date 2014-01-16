package de.htwg.se.setgame.modell.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import de.htwg.se.setgame.modell.IField;

public abstract class AField implements IField {

	/**
	 * Instance variable
	 * 
	 */
	protected int sizeOfField;
	protected static final int INITIALVALUEOFFIELD = 12;
	protected static final int MAX = 81;
	protected static final int ONE = 1;
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