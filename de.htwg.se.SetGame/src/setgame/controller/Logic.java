package setgame.controller;

import java.util.LinkedList;



import de.htwg.se.observer.Observable;
import setgame.modell.Card;

/**
 * @author Raina & David
 * Logic class for the game
 *
 */
public class Logic extends Observable {
	setgame.modell.Field field;

	/**
	 *  Logic Construct make for the game a new field with a new pack!!!
	 */
	public Logic() {
		this.field = new setgame.modell.Field();
		this.field.startUp();
	}


	/**
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 * @return true if all the cards are in the field is only a safety Method
	 */
	private boolean isInFiel(Card cardOne, Card cardTwo, Card cardThree) {
		int counter = 3;
		for (Card card : field.getCardsInField())
			if (card.getColor().equals(cardOne.getColor())
					&& card.getFomr().equals(cardOne.getFomr())
					&& card.getNumberOfComponents() == cardOne
							.getNumberOfComponents()
					&& card.getPanelFilling().equals(cardOne.getPanelFilling())
					|| card.getColor().equals(cardTwo.getColor())
					&& card.getFomr().equals(cardTwo.getFomr())
					&& card.getNumberOfComponents() == cardTwo
							.getNumberOfComponents()
					&& card.getPanelFilling().equals(cardTwo.getPanelFilling())
					|| card.getColor().equals(cardThree.getColor())
					&& card.getFomr().equals(cardThree.getFomr())
					&& card.getNumberOfComponents() == cardThree
							.getNumberOfComponents()
					&& card.getPanelFilling().equals(
							cardThree.getPanelFilling())) {
				counter++;
			}

		if (counter == 3)
			return true;
		else
			return false;
	}

	/**
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 * @return return true if is a set.
	 */
	public boolean isAset(Card cardOne, Card cardTwo, Card cardThree) {
		if (!isInFiel(cardOne, cardTwo, cardThree))
			return false;
		else {
			if (proveColor(cardOne, cardTwo, cardThree)
					&& proveFilling(cardOne, cardTwo, cardThree)
					&& proveNumberOfComponents(cardOne, cardTwo, cardThree)
					&& proveFilling(cardOne, cardTwo, cardThree)) {
				field.foundSet(cardOne, cardTwo, cardThree);
				alltheSetsInField(field.getCardsInField());
				return true;
			} else {
				return false;
			}
		}

	}

	

	/**
	 * @param fielCards is the Cards in field the new ones if there is no set anymore.
	 */
	private void alltheSetsInField(LinkedList<Card> fielCards) {
		boolean foudSet = false;
		if(getSet(fielCards) != null)
			foudSet = true;
		if(foudSet == false){
			changeCardsinGame();
		}
		
	}

	/**
	 * 	changed the Cards in the field if necessary.
	 *  to 
	 */
	private void changeCardsinGame() {
		LinkedList<Card> allCards = new LinkedList<Card>();
		allCards.addAll(field.getAllCardsInGame());
		if(!allCards.isEmpty() && getSet(allCards) != null){
			if(getSet(field.getUnusedCards()) != null && getSet(field.getUnusedCards()).size() >= 3){
				
							
			}
			

			
		}
			
		
	}

	private boolean proveColor(Card cardOne, Card cardTwo, Card cardThree) {
		if (cardOne.getColor().equals(cardTwo.getColor())
				&& cardOne.getColor().equals(cardTwo.getColor())) {
			return true;
		} else if ((false == (cardOne.getColor().equals(cardTwo.getColor())))
				&& (false == (cardOne.getColor().equals(cardThree.getColor())))
				&& (false == (cardTwo.getColor().equals(cardThree.getColor())))) {
			return true;
		}
		return false;
	}

	private boolean proveNumberOfComponents(Card cardOne, Card cardTwo,
			Card cardThree) {
		if (cardOne.getNumberOfComponents() == cardTwo.getNumberOfComponents()
				&& cardOne.getNumberOfComponents() == cardThree
						.getNumberOfComponents()) {
			return true;
		} else if (cardOne.getNumberOfComponents() != cardTwo
				.getNumberOfComponents()
				&& cardOne.getNumberOfComponents() != cardThree
						.getNumberOfComponents()
				&& cardTwo.getNumberOfComponents() != cardThree
						.getNumberOfComponents()) {
			return true;
		}
		return false;
	}

	private boolean proveFilling(Card cardOne, Card cardTwo, Card cardThree) {
		if (cardOne.getPanelFilling().equals(cardTwo.getPanelFilling())
				&& cardOne.getPanelFilling().equals(cardTwo.getPanelFilling())) {
			return true;
		} else if ((false == (cardOne.getPanelFilling().equals(cardTwo
				.getPanelFilling())))
				&& (false == (cardOne.getColor().equals(cardThree.getColor())))
				&& (false == (cardTwo.getColor().equals(cardThree.getColor())))) {
			return true;
		}
		return false;
	}
	private LinkedList<Card> getSet(LinkedList<Card> list){
		LinkedList<Card> setList = new LinkedList<Card>();
		if(list.size() < 3){
			return null;
		}else{
			for(Card cardOne : list){
				for(Card cardTwo : list){
					for(Card cardThree : list){
						if(isAset(cardOne, cardTwo, cardThree)){
							setList.add(cardOne);
							setList.add(cardTwo);
							setList.add(cardThree);
							return setList;
						}
					}
				}
			}
			
		}
		return null;
	}
}
