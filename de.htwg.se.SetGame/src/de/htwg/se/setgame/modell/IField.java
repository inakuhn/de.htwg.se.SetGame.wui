package de.htwg.se.setgame.modell;

import java.util.List;
import java.util.Map;

public interface IField {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#startUp()
	 */
	 void startUp();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#foundSet(setgame.modell.Card,
	 * setgame.modell.Card, setgame.modell.Card)
	 */
	 void foundSet(ICard cardOne, ICard cardTwo, ICard cardThree);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardsInField()
	 */
	 List<ICard> getCardsInField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#changeCards(java.util.List)
	 */
	 void changeCards(List<ICard> liste);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getUnusedCards()
	 */
	 List<ICard> getUnusedCards();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getSizeofField()
	 */
	 int getSizeofField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getAllCardsInGame()
	 */
	 List<ICard> getAllCardsInGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardInFieldGame()
	 */
	 Map<Integer, ICard> getCardInFieldGame();

	 void clear();

	void setSizeOfField(int size);

}