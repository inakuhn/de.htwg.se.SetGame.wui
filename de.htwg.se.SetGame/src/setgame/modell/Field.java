package setgame.modell;

import setgame.modell.Card.Cards;








public class Field {

	private static final int FIELDSIZE = 12;

	private static final int MAX = 81;
	private static final int ONE = 1;
	private Card card = new Card();

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

		}

		return f;

	}

}
