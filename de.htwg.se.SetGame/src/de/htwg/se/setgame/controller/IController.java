package de.htwg.se.setgame.controller;

import java.util.List;
import java.util.Map;

import de.htwg.se.setgame.modell.ICard;
import de.htwg.se.setgame.modell.impl.Field;
import de.htwg.se.setgame.util.observer.IObservable;

/**
 * @author raina
 *
 */
/**
 * @author raina
 *
 */
public interface IController extends IObservable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.IController#isAset(setgame.modell.impl.Card,
	 * setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	/**
	 * @param cardOne card for set
	 * @param cardTwo card for set
	 * @param cardThree card for set
	 * @param player wich player is
	 */
	void isAsetForController(ICard cardOne, ICard cardTwo, ICard cardThree,
			int player);

	/**
	 * @return card in game
	 */
	List<ICard> getCardinGame();

	/**
	 * @return field
	 */
	Field getField();

	/**
	 * @return true is is a set
	 */
	boolean areSetInField();

	/**
	 * @return return a set
	 */
	List<ICard> getAsetInGame();

	/**
	 * @return look trougth the pack and see if still a set
	 */
	boolean stillSetInGAme();

	/**
	 * @return return the set in field
	 */
	List<ICard> getSetInField();

	/**
	 * @return points player one
	 */
	int geTplayerOnePoints();

	/**
	 * @return points player two
	 */
	int geTplayerTwoPoints();

	/**
	 * @return player one
	 */
	int getPlayerOne();

	/**
	 * @return player two
	 */
	int getPlayerTwo();

	/**
	 * 	reset game
	 */
	void newGame();

	/**
	 * @param size set size field
	 */
	void setFieldSize(int size);

	/**
	 * @return cards in field
	 */
	List<ICard> getCardInFieldGame();

	/**
	 * @return index and card in the index
	 */
	Map<Integer, ICard> getCardsAndTheIndexOfCardInField();

}