package de.htwg.se.SetGame.Modul;

public class Card {
	private Cards pack[];
	private int numberOfCard = 0;
	private String[] forme = { "ovally", "wave", "balk" };
	private String[] colors = { "red", "green", "purple" };
	private String[] filling = { "halffill", "fill", "empty" };
	private int[] numbers = { 1, 2, 3};
	private int arraysize = 81;

	/* One card in card */
	public class Cards {
		protected String color;
		protected String fomr;
		protected String panelFilling;
		protected int anz;

		public Cards(String color, String form, String panelFilling, int anzahl) {

			if ((color.equals(colors[0]) || color.equals(colors[1]) || color
					.equals(colors[2]))
					&& (form.equals(forme[2]) || form.equals(forme[0]) || form
							.equals(forme[1]))
					&& (panelFilling.equals(filling[0])
							|| panelFilling.equals(filling[1]) || panelFilling
								.equals(filling[2]))
					&& (anzahl == numbers[0] || anzahl == numbers[1] || anzahl == numbers[2])) {

				this.color = color;
				this.fomr = form;
				this.panelFilling = panelFilling;
				this.anz = anzahl;

			}
		}
	}

	public Card() {
		this.pack = creatCards();
	}

	private Cards[] creatCards() {
		Cards list[] = new Cards[arraysize];
		int colorIndex = 0;
		int formeIndex = 0;
		int fillgingIndex = 0;
		int numbersIdex = 0;

		for (int i = 0; i < arraysize; i++) {

			list[i] = new Cards(colors[colorIndex], forme[formeIndex],
					filling[fillgingIndex], numbers[numbersIdex]);
			formeIndex++;
			if (formeIndex == numbers[2]) {
				formeIndex = 0;
				fillgingIndex++;
				if (fillgingIndex == numbers[2]) {
					fillgingIndex = 0;
					numbersIdex++;
					if (numbersIdex == numbers[2]) {
						numbersIdex = 0;
						colorIndex++;

					}

				}

			}

		}

		int size = 0;
		for (int i = 0; i < list.length; i++) {
			size = size + 1;
		}
		this.numberOfCard = size;
		return list;

	}

	public int getNumerofCards() {
		return this.numberOfCard;

	}
	public Cards[] getCards(){
		return this.pack;
	}

}
