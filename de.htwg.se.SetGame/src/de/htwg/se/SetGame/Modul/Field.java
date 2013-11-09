package de.htwg.se.SetGame.Modul;



import de.htwg.se.SetGame.Modul.Card.Cards;

public class Field {

	private int fieldsize;

	private static final int MAX = 81;
	private static final int ONE = 1;
	private Card card = new Card();

	public Field() {
	}

	private void setField(int i){
		this.fieldsize = i;
	}
	public int getField(){
		return this.fieldsize;
	}
	public Cards[] init() {
		setField(12);
		Cards[] field = new Cards[fieldsize];

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
			if (b)
				array[i] = j;
		}
		return array;
	}

	private Cards[] fillField(Cards[] f) {

		int array[] = rand();

		for (int i = 0; i < fieldsize; i++) {

			f[i] = card.getCards()[array[i]];

		}

		return f;

	}

	private boolean filledField(Cards[] f) {
		if (f == null) {
			return true;
		}
		if (f.length == fieldsize + 1) {
			return false;
		} else {
			return true;
		}
	}

}
