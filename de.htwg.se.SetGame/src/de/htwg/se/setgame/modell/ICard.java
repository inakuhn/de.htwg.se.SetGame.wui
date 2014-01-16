package de.htwg.se.setgame.modell;

import de.htwg.se.setgame.modell.impl.Card;

public interface ICard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getColor()
	 */
	abstract String getColor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getFomr()
	 */
	abstract String getFomr();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getPanelFilling()
	 */
	abstract String getPanelFilling();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getNumberOfComponents()
	 */
	abstract int getNumberOfComponents();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#toString()
	 */
	abstract String toString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#comparTo(setgame.modell.impl.Card)
	 */

	boolean comparTo(Card card);

}