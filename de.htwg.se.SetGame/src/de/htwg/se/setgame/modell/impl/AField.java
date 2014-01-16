package de.htwg.se.setgame.modell.impl;

import java.util.List;
import java.util.Map;

import de.htwg.se.setgame.modell.IField;

public abstract class AField implements IField {

	public Map<Integer, Card> cardInFieldGame;
	/**
	 * pack for the game are the cards and the random positions
	 */
	protected List<Card> packForGame;

	public AField() {
		super();
	}

}