package de.htwg.se.setgame.modell;

import java.util.List;
import java.util.Map;

import de.htwg.se.setgame.modell.impl.Card;

public interface IField {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#startUp()
	 */
	abstract void startUp();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#foundSet(setgame.modell.Card,
	 * setgame.modell.Card, setgame.modell.Card)
	 */
	abstract void foundSet(Card cardOne, Card cardTwo, Card cardThree);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardsInField()
	 */
	abstract List<Card> getCardsInField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#changeCards(java.util.List)
	 */
	abstract void changeCards(List<Card> liste);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getUnusedCards()
	 */
	abstract List<Card> getUnusedCards();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getSizeofField()
	 */
	abstract int getSizeofField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getAllCardsInGame()
	 */
	abstract List<Card> getAllCardsInGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardInFieldGame()
	 */
	abstract Map<Integer, Card> getCardInFieldGame();

	abstract void clear();

	void setSizeOfField(int size);

}