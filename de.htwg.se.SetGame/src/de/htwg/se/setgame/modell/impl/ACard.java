package de.htwg.se.setgame.modell.impl;

import de.htwg.se.setgame.modell.ICard;

public abstract class ACard implements ICard {

	private String color;
	private String form;
	private String panelFilling;
	private int anz;

	public ACard() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getPanelFilling() {
		return panelFilling;
	}

	public void setPanelFilling(String panelFilling) {
		this.panelFilling = panelFilling;
	}

	public int getAnz() {
		return anz;
	}

	public void setAnz(int anz) {
		this.anz = anz;
	}

}