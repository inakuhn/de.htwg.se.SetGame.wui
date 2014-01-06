package setgame.controller;

import setgame.modell.impl.ACard;

public interface IController {

	/* (non-Javadoc)
	 * @see setgame.controller.IController#spielModus()
	 */
	public abstract int spielModus();

	/* (non-Javadoc)
	 * @see setgame.controller.IController#isAset(setgame.modell.impl.Card, setgame.modell.impl.Card, setgame.modell.impl.Card, int)
	 */
	public abstract boolean isAset(ACard cardOne, ACard cardTwo, ACard cardThree,
			int player);

}