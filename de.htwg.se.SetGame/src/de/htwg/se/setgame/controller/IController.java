package de.htwg.se.setgame.controller;

import java.util.List;






import de.htwg.se.setgame.modell.IField;
import de.htwg.se.setgame.modell.impl.Card;
import de.htwg.se.setgame.util.observer.IObservable;

public interface IController extends IObservable {


	/* (non-Javadoc)
	 * @see setgame.controller.IController#isAset(setgame.modell.impl.Card, setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	public boolean isAsetForController(Card cardOne, Card cardTwo, Card cardThree,
			int player);
	public List<Card> getCardinGame();
	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.controller.impl.IController#spielModus()
	 */

	public abstract IField getField();

	public abstract boolean areSetInField();


	public abstract List<Card> getAsetInGame();

	public abstract boolean stillSetInGAme();

	public abstract List<Card> getSetInField();

	public abstract int geTplayerOnePoints();

	public abstract int geTplayerTwoPoints();

	public abstract int getPlayerOne();

	public abstract int getPlayerTwo();
	public void newGame();


}