package de.htwg.se.setgame.controller;

import java.util.List;
import java.util.Map;

import de.htwg.se.setgame.modell.ICard;
import de.htwg.se.setgame.modell.impl.Field;
import de.htwg.se.setgame.util.observer.IObservable;

public interface IController extends IObservable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.IController#isAset(setgame.modell.impl.Card,
	 * setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	void isAsetForController(ICard cardOne, ICard cardTwo, ICard cardThree,
			int player);

	List<ICard> getCardinGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.impl.IController#spielModus()
	 */

	Field getField();

	boolean areSetInField();

	List<ICard> getAsetInGame();

	boolean stillSetInGAme();

	List<ICard> getSetInField();

	int geTplayerOnePoints();

	int geTplayerTwoPoints();

	int getPlayerOne();

	int getPlayerTwo();

	void newGame();

	void setFieldSize(int size);

	List<ICard> getCardInFieldGame();

	Map<Integer, ICard> getCardsAndTheIndexOfFIeld();

}