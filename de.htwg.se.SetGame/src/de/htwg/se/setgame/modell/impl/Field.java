package de.htwg.se.setgame.modell.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class Field.
 * 
 * @author David Simon & Raina Bertolini
 * @date 7.12.2013
 * @category Modell
 */
public class Field extends AField {

	/**
	 * startup of the objects
	 */
	public Field() {
		this.pack = new Pack();
		this.sizeOfField = INITIALVALUEOFFIELD;
		this.cardInFieldGame = new TreeMap<Integer, Card>();
		this.ramdomListe = new TreeMap<Integer, Integer>();
		this.packForGame = new LinkedList<Card>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#startUp()
	 */
	@Override
	public void startUp() {
		Map<Integer, Card> packForThegame = new TreeMap<Integer, Card>();
		rand();

		int i = 0;
		for (Card card : this.pack.getPack()) {
			packForThegame.put(this.getRamdomListe().get(i), card);
			i++;
		}
		packForGame.addAll(packForThegame.values());

		startUpOfField();
	}

	/**
	 * Filled array with integer number.
	 * 
	 * @return filled array
	 */
	public Map<Integer, Integer> rand() {
		int[] tem = new int[MAX];
		boolean b;
		for (int key = 0; key < MAX; key++) {
			b = true;
			int element = (int) (Math.random() * MAX + ONE);
			for (int t = 0; t < MAX; t++) {
				if (element == tem[t] && key > 0) {
					key = key - 1;
					b = false;
				}
			}
			if (b) {

				this.getRamdomListe().put(key, element);

				tem[key] = element;
			}

		}
		return getRamdomListe();

	}

	/**
	 * Filled field with cards from the class Card
	 * 
	 * @return filled Field with Cards
	 */
	private void startUpOfField() {

		for (int index = 0; index < sizeOfField; index++) {
			this.getCardInFieldGame().put(index, this.packForGame.get(index));

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#foundSet(setgame.modell.Card,
	 * setgame.modell.Card, setgame.modell.Card)
	 */
	@Override
	public void foundSet(Card cardOne, Card cardTwo, Card cardThree) {

		TreeSet<Integer> keyOfcardInField = new TreeSet<Integer>();
		for (Integer key : this.getCardInFieldGame().keySet()) {
			if (this.getCardInFieldGame().get(key).comparTo(cardOne)
					|| this.getCardInFieldGame().get(key).comparTo(cardTwo)
					|| this.getCardInFieldGame().get(key).comparTo(cardThree)) {
				keyOfcardInField.add(key);
				this.packForGame.remove(this.getCardInFieldGame().get(key));
			}
		}
		for (Integer key : keyOfcardInField) {
			this.getCardInFieldGame().remove(key);

		}
		fillField();

	}

	private void fillField() {
		LinkedList<Card> listCardarenoteinfieldCards = new LinkedList<Card>();
		listCardarenoteinfieldCards.addAll(getUnusedCards());

		for (int index = 0; index < sizeOfField; index++) {
			if (this.getCardInFieldGame().get(index) == null
					&& !(listCardarenoteinfieldCards.isEmpty())) {
				this.getCardInFieldGame().put(index,
						listCardarenoteinfieldCards.getFirst());
				listCardarenoteinfieldCards.removeFirst();
			} else if (this.getCardInFieldGame().get(index) == null
					&& listCardarenoteinfieldCards.isEmpty()) {
				this.getCardInFieldGame().remove(index);

			} else if (!(this.getCardInFieldGame().containsKey(index))
					&& !(listCardarenoteinfieldCards.isEmpty())) {
				this.getCardInFieldGame().put(index,
						listCardarenoteinfieldCards.getFirst());
				listCardarenoteinfieldCards.removeFirst();

			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardsInField()
	 */
	@Override
	public List<Card> getCardsInField() {
		List<Card> liste = new LinkedList<Card>();
		liste.addAll(this.getCardInFieldGame().values());
		return liste;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#setSizeOfField(int, java.util.List)
	 */
	@Override
	public void setSizeOfField(int size) {
		if (size < sizeOfField) {
			int diference = sizeOfField - size;
			LinkedList<Integer> keys = new LinkedList<Integer>();
				for(int i= 0 ; i < diference ;i++){
					keys.add(i);
				}
			
			for (Integer key : keys) {
				this.getCardInFieldGame().remove(key);
			}
			sizeOfField = size;
		} else if (size > sizeOfField) {
			LinkedList<Card> list = new LinkedList<Card>();
			list.addAll(getUnusedCards());
			
			for (int key = 0; key < size; key++) {
				if (!list.isEmpty() && !getCardInFieldGame().keySet().contains(key)) {
					this.getCardInFieldGame().put(key, list.getFirst());
					list.removeFirst();

				}
			}
			sizeOfField = size;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#changeCards(java.util.List)
	 */
	@Override
	public void changeCards(List<Card> liste) {
		LinkedList<Card> tmpList = new LinkedList<Card>();
		tmpList.addAll(liste);
		if (this.getCardInFieldGame().size() < tmpList.size()) {
			sizeOfField = tmpList.size();
		}
		LinkedList<Integer> keysforbeuse = new LinkedList<Integer>();

		for (Integer key : this.getCardInFieldGame().keySet()) {
			if (tmpList.contains(this.getCardInFieldGame().get(key))) {
				tmpList.remove(this.getCardInFieldGame().get(key));

			} else {
				keysforbeuse.add(key);
			}

		}
		for (Integer key : keysforbeuse) {
			if (!tmpList.isEmpty()) {
				this.getCardInFieldGame().put(key, tmpList.getFirst());
				tmpList.removeFirst();
			} else if (tmpList.isEmpty()) {
				break;

			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getUnusedCards()
	 */
	@Override
	public List<Card> getUnusedCards() {
		LinkedList<Card> list = new LinkedList<Card>();
		list.addAll(this.packForGame);
		list.removeAll(this.getCardInFieldGame().values());
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getSizeofField()
	 */
	@Override
	public int getSizeofField() {
		return getCardInFieldGame().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getAllCardsInGame()
	 */
	@Override
	public List<Card> getAllCardsInGame() {
		return this.packForGame;
	}

	/**
	 * @return the ramdomListe
	 */
	public Map<Integer, Integer> getRamdomListe() {
		return ramdomListe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see setgame.modell.IField#getCardInFieldGame()
	 */
	@Override
	public Map<Integer, Card> getCardInFieldGame() {
		return cardInFieldGame;
	}

	@Override
	public void clear() {
		this.pack = null;
		this.pack = new Pack();
		this.sizeOfField = INITIALVALUEOFFIELD;
		this.cardInFieldGame.clear();
		this.ramdomListe.clear();
		this.packForGame.clear();

	}

	@Override
	public String toString() {
		String langstString = this.pack.getFill()[0];
		StringBuilder field = new StringBuilder();
		field.append("\n");
		Set<Integer> listeofcontains = new TreeSet<>();
		int t = 0;
		while (t != this.sizeOfField) {
			int i = 0;
			for (Integer key : cardInFieldGame.keySet()) {
				if (!listeofcontains.contains(key)) {
					double legth = langstString.toCharArray().length;
					double fehlt = legth - 1;
					double me = fehlt/2;
					fehlt = fehlt - me;
					for(int loop = 0 ; loop < me; loop++){
						field.append(" ");
					}
					field.append("["+key+"]");
					for(int loop = 0 ; loop < fehlt; loop++){
						field.append(" ");
					}
					i++;
					if (i == 3) {
						i = 0;
						break;
					}
				}
			}
			field.append("\n");
			for (Integer key : cardInFieldGame.keySet()) {
				if (!listeofcontains.contains(key)) {
					int legth = langstString.toCharArray().length;
					int fehlt = legth - cardInFieldGame.get(key).getColor().toCharArray().length;
					int me = fehlt/2;
					fehlt = fehlt - me;
					field.append("|");
					for(int loop = 0 ; loop < me; loop++){
						field.append(" ");
					}
					field.append(cardInFieldGame.get(key).color);
					for(int loop = 0 ; loop < fehlt; loop++){
						field.append(" ");
					}
					field.append("|  ");
					i++;
					if (i == 3) {
						i = 0;
						break;
					}
				}
			}
			field.append("\n");
			for (Integer key : cardInFieldGame.keySet()) {
				if (!listeofcontains.contains(key)) {
					int legth = langstString.toCharArray().length;
					int fehlt = legth - cardInFieldGame.get(key).getFomr().toCharArray().length;
					int me = fehlt/2;
					fehlt = fehlt - me;
					field.append("|");
					for(int loop = 0 ; loop < me; loop++){
						field.append(" ");
					}
					field.append(cardInFieldGame.get(key).form);
					for(int loop = 0 ; loop < fehlt; loop++){
						field.append(" ");
					}
					field.append("|  ");
					i++;
					if (i == 3) {
						i = 0;
						break;
					}
				}
			}
			field.append("\n");
			for (Integer key : cardInFieldGame.keySet()) {
				if (!listeofcontains.contains(key)) {
					int legth = langstString.toCharArray().length;
					int fehlt = legth - 1;
					int me = fehlt/2;
					fehlt = fehlt - me;
					field.append("|");
					for(int loop = 0 ; loop < me; loop++){
						field.append(" ");
					}
					field.append(cardInFieldGame.get(key).anz);
					for(int loop = 0 ; loop < fehlt; loop++){
						field.append(" ");
					}
					field.append("|  ");
					i++;
					if (i == 3) {
						i = 0;
						break;
					}
				}

			}
			field.append("\n");
			for (Integer key : cardInFieldGame.keySet()) {
				if (!listeofcontains.contains(key)) {
					int legth = langstString.toCharArray().length;
					int fehlt = legth - cardInFieldGame.get(key).getPanelFilling().toCharArray().length;
					int me = fehlt/2;
					fehlt = fehlt - me;
					field.append("|");
					for(int loop = 0 ; loop < me; loop++){
						field.append(" ");
					}
					field.append(cardInFieldGame.get(key).panelFilling);
					for(int loop = 0 ; loop < fehlt; loop++){
						field.append(" ");
					}
					field.append("|  ");
					listeofcontains.add(key);
					i++;
					if (i == 3) {
						i = 0;
						break;
					}
				}
			}
			field.append("\n\n\n");
		t++;
		if(sizeOfField == listeofcontains.size()){
			break;
		}
		}
		return field.toString();
	}
}
