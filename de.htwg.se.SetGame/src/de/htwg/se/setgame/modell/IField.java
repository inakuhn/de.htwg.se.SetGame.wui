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
	 void startUp();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#foundSet(setgame.modell.Card,
	 * setgame.modell.Card, setgame.modell.Card)
	 */
	 void foundSet(Card cardOne, Card cardTwo, Card cardThree);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardsInField()
	 */
	 List<Card> getCardsInField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#changeCards(java.util.List)
	 */
	 void changeCards(List<Card> liste);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getUnusedCards()
	 */
	 List<Card> getUnusedCards();

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
	 List<Card> getAllCardsInGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardInFieldGame()
	 */
	 Map<Integer, Card> getCardInFieldGame();

	 void clear();

	void setSizeOfField(int size);

}