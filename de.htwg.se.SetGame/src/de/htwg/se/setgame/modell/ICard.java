package de.htwg.se.setgame.modell;

import de.htwg.se.setgame.modell.impl.Card;

public interface ICard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getColor()
	 */
	 String getColor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getFomr()
	 */
	 String getFomr();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getPanelFilling()
	 */
	 String getPanelFilling();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getNumberOfComponents()
	 */
	 int getNumberOfComponents();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#toString()
	 */
	 String toString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#comparTo(setgame.modell.impl.Card)
	 */

	boolean comparTo(Card card);

}