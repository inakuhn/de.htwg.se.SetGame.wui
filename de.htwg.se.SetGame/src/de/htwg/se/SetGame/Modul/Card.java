package de.htwg.se.SetGame.Modul;

public class Card {
	private Cards pack[];
	private int numberOfCard = 0;
	private String[] forme = { "ovally", "wave", "balk" };
	private String[] colors = { "red", "green", "purple" };
	private String[] filling = { "halffill", "fill", "empty" };
	private final int[] numbers = { 1, 2, 3 };
	private static final int arraysize = 81;
	private static final int numberthree = 3;

	/* One card in card */
	public class Cards {
		private String color;
		private String fomr;
		private String panelFilling;
		private int anz;

		public Cards(String color, String form, String panelFilling, int anzahl) {

			this.setColor(color);
			this.setFomr(form);
			this.setPanelFilling(panelFilling);
			this.setAnz(anzahl);

		}

		public String getColor() {
			return color;
		}

		private void setColor(String color) {
			if (color.equals(colors[0]) || color.equals(colors[1])
					|| color.equals(colors[2])){
				this.color = color;
			}else{
				this.color = null;
			}
		}

		public String getFomr() {
			return fomr;
		}

		private void setFomr(String fomr) {
			if (fomr.equals(forme[2]) || fomr.equals(forme[0])
					|| fomr.equals(forme[1]))
				this.fomr = fomr;
			else
				this.fomr = null;
		}

		public String getPanelFilling() {
			return panelFilling;
		}

		private void setPanelFilling(String panelFilling) {
			if (panelFilling.equals(filling[0])
					|| panelFilling.equals(filling[1])
					|| panelFilling.equals(filling[2]))
				this.panelFilling = panelFilling;
			else
				this.panelFilling = null;
		}

		public int getAnz() {
			return anz;
		}

		private void setAnz(int anz) {
			if (anz == numbers[0] || anz == numbers[1] || anz == numbers[2])
				this.anz = anz;
			else
				this.anz = -1;
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
			if (formeIndex == numberthree) {
				formeIndex = 0;
				fillgingIndex++;
				if (fillgingIndex == numberthree) {
					fillgingIndex = 0;
					numbersIdex++;
					if (numbersIdex == numberthree) {
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

	public Cards[] getCards() {
		return this.pack;
	}

}
