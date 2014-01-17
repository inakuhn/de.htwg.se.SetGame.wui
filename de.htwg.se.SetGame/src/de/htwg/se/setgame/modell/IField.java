package de.htwg.se.setgame.modell;

import java.util.List;
import java.util.Map;

public interface IField {

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#startUp()
	 */
	 /**
	 * 
	 */
	/**
	 * 
	 */
	void startUp();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#foundSet(setgame.modell.Card,
	 * setgame.modell.Card, setgame.modell.Card)
	 */
	 /**
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 */
	/**
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 */
	void foundSet(ICard cardOne, ICard cardTwo, ICard cardThree);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardsInField()
	 */
	 /**
	 * @return
	 */
	/**
	 * @return
	 */
	List<ICard> getCardsInField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#changeCards(java.util.List)
	 */
	 /**
	 * @param liste
	 */
	/**
	 * @param liste
	 */
	void changeCards(List<ICard> liste);

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getUnusedCards()
	 */
	 /**
	 * @return
	 */
	/**
	 * @return
	 */
	List<ICard> getUnusedCards();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getSizeofField()
	 */
	 /**
	 * @return
	 */
	/**
	 * @return
	 */
	int getSizeofField();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getAllCardsInGame()
	 */
	 /**
	 * @return
	 */
	/**
	 * @return
	 */
	List<ICard> getAllCardsInGame();

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardInFieldGame()
	 */
	 /**
	 * @return
	 */
	/**
	 * @return
	 */
	Map<Integer, ICard> getCardInFieldGame();

	 /**
	 * 
	 */
	/**
	 * 
	 */
	void clear();

	/**
	 * @param size
	 */
	/**
	 * @param size
	 */
	void setSizeOfField(int size);

}