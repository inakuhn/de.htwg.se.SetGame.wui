package setgame.controller;

import java.util.List;


import de.htwg.se.util.observer.IObservable;
import setgame.modell.impl.Card;

public interface IController extends IObservable {

	/* (non-Javadoc)
	 * @see setgame.controller.IController#spielModus()
	 */
	public int getPlayModus();

	/* (non-Javadoc)
	 * @see setgame.controller.IController#isAset(setgame.modell.impl.Card, setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	public boolean isAsetForController(Card cardOne, Card cardTwo, Card cardThree,
			int player);
	public List<Card> getCardinGame();


}