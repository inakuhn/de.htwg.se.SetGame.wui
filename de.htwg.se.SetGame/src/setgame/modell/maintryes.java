package setgame.modell;

import java.util.LinkedList;
import java.util.TreeSet;

public class maintryes {
	public static void main(String[] args) {
		LinkedList<Card> list = new LinkedList<Card>();
		Pack pack = new Pack();
		for(Card card : pack.getPack()){
			list.add(card);
			System.out.println(card);
		}
		System.out.println("Site of liste = "+list.size());
	
		
		
		Field field = new Field();
		for(Card card : field.init()){
			System.out.println(card);
		}
		System.out.println("Card in field==");
		int i = 0;
		for(Card card : field.cardsInField()){
			System.out.println(card+", "+i);
			i++;
		}
		TreeSet<Integer> organizeListe = new TreeSet<Integer>();

		System.out.println(organizeListe);
		
		
	}
}
