package de.htwg.se.setgame.modell;

public interface ICard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getColor()
	 */
	 /**
	 * @return
	 */
	String getColor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getFomr()
	 */
	 /**
	 * @return
	 */
	String getFomr();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getPanelFilling()
	 */
	 /**
	 * @return
	 */
	String getPanelFilling();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#getNumberOfComponents()
	 */
	 /**
	 * @return
	 */
	int getNumberOfComponents();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#toString()
	 */
	 /**
	 * @return
	 */
	String toString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.impl.ICard#comparTo(setgame.modell.impl.Card)
	 */

	/**
	 * @param card
	 * @return
	 */
	boolean comparTo(ICard card);

}