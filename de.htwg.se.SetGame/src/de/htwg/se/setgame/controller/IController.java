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
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 * @param player
	 */
	void isAsetForController(ICard cardOne, ICard cardTwo, ICard cardThree,
			int player);

	/**
	 * @return
	 */
	List<ICard> getCardinGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.impl.IController#spielModus()
	 */

	/**
	 * @return
	 */
	Field getField();

	/**
	 * @return
	 */
	boolean areSetInField();

	/**
	 * @return
	 */
	List<ICard> getAsetInGame();

	/**
	 * @return
	 */
	boolean stillSetInGAme();

	/**
	 * @return
	 */
	List<ICard> getSetInField();

	/**
	 * @return
	 */
	int geTplayerOnePoints();

	/**
	 * @return
	 */
	int geTplayerTwoPoints();

	/**
	 * @return
	 */
	int getPlayerOne();

	/**
	 * @return
	 */
	int getPlayerTwo();

	/**
	 * 
	 */
	void newGame();

	/**
	 * @param size
	 */
	void setFieldSize(int size);

	/**
	 * @return
	 */
	List<ICard> getCardInFieldGame();

	/**
	 * @return
	 */
	Map<Integer, ICard> getCardsAndTheIndexOfFIeld();

}