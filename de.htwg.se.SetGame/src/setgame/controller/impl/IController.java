package setgame.controller.impl;

import setgame.modell.impl.Card;

public interface IController {

	public abstract int spielModus();

	public abstract boolean isAsetForController(Card cardOne, Card cardTwo,
			Card cardThree, int player);

}