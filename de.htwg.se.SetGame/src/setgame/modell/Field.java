package setgame.modell;

import java.util.LinkedList;

import setgame.modell.Card.Cards;

public class Field {

	private static final int FIELDSIZE = 12;

	private static final int MAX = 81;
	private static final int ONE = 1;
	private Card card = new Card();
	
	private LinkedList<Cards> register = new LinkedList<Cards>();

	public Field() {
	}

	public Cards[] init() {
		Cards[] field = new Cards[FIELDSIZE];

		return fillField(field);
	}

	public int[] rand() {
		int[] array = new int[MAX];
		boolean b;
		for (int i = 0; i < MAX; i++) {
			b = true;
			int j = (int) (Math.random() * MAX + ONE);
			for (int t = 0; t < MAX; t++) {
				if (j == array[t] && i > 0) {
					i = i - 1;
					b = false;
				}
			}
			if (b) {
				array[i] = j;

			}
		}
		return array;
	}

	private Cards[] fillField(Cards[] f) {

		int array[] = rand();

		for (int i = 0; i < FIELDSIZE; i++) {

			f[i] = card.getCards()[array[i]];
			register.add(card.getCards()[array[i]]);

		}

		return f;

	}
	
	public Cards getCardsInField() {	
		
		Cards fill;
		int randfill[] = rand();
		boolean close = false;
		int i = 0;
		int l = randfill.length;
		
		while(i == l) {
			close = false;
			
			if (register.equals(randfill[i])) {
				close = true;
				i++;
			}
			
			if (close == false) {
				fill = card.getCards()[randfill[i]];
				return fill;
			}
		}
		
		System.err.printf("Game Over\n");
		return null;
	}

}
