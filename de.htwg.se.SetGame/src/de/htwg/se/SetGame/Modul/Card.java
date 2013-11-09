package de.htwg.se.SetGame.Modul;

public class Card {
	Cards pack[];
	private int numberOfCard = 0;
	private String[] forme = { "ovally", "wave", "balk" };
	private String[] colors = { "red", "green", "purple" };
	private String[] filling = { "halffill", "fill", "empty" };
	private int[] numbers = { 1, 2, 3 };
	private int numberSix = 6;
	private int siebenundZ = 27;

	/* One card in card */
	public class Cards {
		String color;
		String fomr;
		String panelFilling;
		int anz;

		public Cards(String color, String form, String panelFilling, int anzahl) {

			if ((color.equals(colors[0]) || color.equals(colors[1]) || color
					.equals(colors[2]))
					&& (form.equals(forme[2]) || form.equals(forme[0]) || form
							.equals(forme[1]))
					&& (panelFilling.equals(filling[0])
							|| panelFilling.equals(filling[1]) || panelFilling
								.equals(filling[2]))
					&& (anzahl == 1 || anzahl == 2 || anzahl == 3)) {

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
		Cards list[] = new Cards[81];
		int colorIndex = 0;
		int formeIndex = 0;
		int fillgingIndex = 0;
		int numbersIdex = 0;

		for (int i = 0; i < 81; i++) {

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

}
