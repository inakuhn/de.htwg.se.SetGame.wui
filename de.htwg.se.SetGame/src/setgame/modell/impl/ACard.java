package setgame.modell.impl;

import setgame.modell.ICard;

public abstract class ACard implements ICard{

	protected String color;
	protected String form;
	protected String panelFilling;
	protected int anz;

	public ACard() {
		super();
	}

}