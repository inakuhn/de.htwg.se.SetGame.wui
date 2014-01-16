package de.htwg.se.setgame.controller;

import java.util.List;

import java.util.Map;

import de.htwg.se.setgame.modell.IField;
import de.htwg.se.setgame.modell.impl.Card;
import de.htwg.se.setgame.util.observer.IObservable;

public interface IController extends IObservable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.IController#isAset(setgame.modell.impl.Card,
	 * setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	void isAsetForController(Card cardOne, Card cardTwo, Card cardThree,
			int player);

	List<Card> getCardinGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.impl.IController#spielModus()
	 */

	abstract IField getField();

	abstract boolean areSetInField();

	abstract List<Card> getAsetInGame();

	abstract boolean stillSetInGAme();

	abstract List<Card> getSetInField();

	abstract int geTplayerOnePoints();

	abstract int geTplayerTwoPoints();

	abstract int getPlayerOne();

	abstract int getPlayerTwo();

	void newGame();

	void setFieldSize(int size);

	List<Card> getCardInFieldGame();

	Map<Integer, Card> getCardsAndTheIndexOfFIeld();

}