package de.htwg.se.setgame.modell.impl;

import de.htwg.se.setgame.modell.ICard;

public abstract class ACard implements ICard{

	protected String color;
	protected String form;
	protected String panelFilling;
	protected int anz;

	public ACard() {
		super();
	}

}