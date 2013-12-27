package setgame.modell;

import java.util.LinkedList;
import java.util.TreeSet;

public class maintryes {
	public static void main(String[] args) {
		LinkedList<Card> list = new LinkedList<Card>();
		Field field = new Field();
		System.out.println("Card in field: \n");
		for (Card card : field.cardsInField()) {
			list.add(card);
			System.out.println(card);
		}
		int index = 0;
		for (Card card : field.cardInFieldGame.values()) {
			if (!(list.get(index).comparTo(card)))
				System.out.println("\n\n neinnnnnnnnnnnn \n \n");
			index++;
		}

		for (Integer key : field.cardInFieldGame.keySet())
			System.out.println(key + " = " + field.cardInFieldGame.get(key));
		TreeSet<Integer> organizeListe = new TreeSet<Integer>();
		for (Integer value : field.packForThegame.keySet())
			organizeListe.add(value);
		System.out.println(organizeListe);

		System.out.println(field.packForThegame.size());
		LinkedList<Card> liste = new LinkedList<Card>();
		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println(field.packForThegame.size());
		list.clear();
		list.addAll(field.cardsInField());

		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println(field.packForThegame.size());
		list.clear();
		list.addAll(field.cardsInField());

		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println(field.packForThegame.size());
		list.clear();
		list.addAll(field.cardsInField());

		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println(field.packForThegame.size());
		list.clear();
		list.addAll(field.cardsInField());

		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println(field.packForThegame.size());
		list.clear();
		list.addAll(field.cardsInField());
		Card cardOne = null; 
		Card cardTwo = null;
		Card cardThree= null;
		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				cardOne= liste.get(0);
				cardTwo = liste.get(1);
				cardThree = liste.get(2);
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println("here ???? " + field.packForThegame.size());
		list.clear();
		System.out.println(field.cardInFieldGame);
		list.addAll(field.cardsInField());

		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println("i am here??" + field.packForThegame.size());
		list.clear();
		System.out.println("sdwd" + field.cardInFieldGame);
		list.addAll(field.cardsInField());

		for (int i = 0; i < list.size(); i++) {
			liste.add(list.get(i));
			if (liste.size() == 3) {
				System.out
						.println("liste         sdwwdqdqwdqwdqwdw = " + liste);
				field.foundSet(liste.get(0), liste.get(1), liste.get(2));
				liste.clear();
			}
		}
		System.out.println("i am here??" + field.packForThegame.size());
		System.out.println(cardOne);
		System.out.println(cardTwo);
		System.out.println(cardThree);
		field.foundSet(cardOne, cardTwo, cardThree);

	}

}
