package setgame.modell;

import java.util.LinkedList;

public class maintryes {
	public static void main(String[] args) {
		LinkedList<Card> list = new LinkedList<Card>();
		Pack pack = new Pack();
		for(Card card : pack.getPack()){
			list.add(card);
			System.out.println(card.getColor()+" , "+card.getFomr()+" , "+card.getPanelFilling()+" , "+card.getNumberOfComponents());
		}
		System.out.println(list.size());
	}
}
