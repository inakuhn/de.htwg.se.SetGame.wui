package de.htwg.se.SetGame.Modul;

public class Card {
	private Cards pack[];
	private String[] forme = { "ovally", "wave", "balk" };
	private String[] colors = { "red", "green", "purple" };
	private String[] filling = { "halffill", "fill", "empty" };
	private final int[] numbers = { 1, 2, 3 };
	private static final int SIZEOFARRAY = 81;
	private static final int THREE = 3;
	private int colorIndex = 0;
	private int formeIndex = 0;
	private int fillgingIndex = 0;
	private int numbersIdex = 0;

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
					|| color.equals(colors[2])) {
				this.color = color;
			} else {
				this.color = null;
			}
		}

		public String getFomr() {
			return fomr;
		}

		private void setFomr(String fomr) {
			if (fomr.equals(forme[2]) || fomr.equals(forme[0])
					|| fomr.equals(forme[1])) {
				this.fomr = fomr;
			} else {
				this.fomr = null;
			}
		}

		public String getPanelFilling() {
			return panelFilling;
		}

		private void setPanelFilling(String panelFilling) {
			if (panelFilling.equals(filling[0])
					|| panelFilling.equals(filling[1])
					|| panelFilling.equals(filling[2])) {
				this.panelFilling = panelFilling;
			} else {
				this.panelFilling = null;
			}

		}

		public int getAnz() {
			return anz;
		}

		private void setAnz(int anz) {
			if (anz == numbers[0] || anz == numbers[1] || anz == numbers[2]) {
				this.anz = anz;
			} else {
				this.anz = -1;
			}
		}
	}

	public Card() {
		this.pack = creatCards();
	}

	private Cards[] creatCards() {
		Cards list[] = new Cards[SIZEOFARRAY];

		for (int i = 0; i < SIZEOFARRAY; i++) {

			list[i] = new Cards(colors[colorIndex], forme[formeIndex],
					filling[fillgingIndex], numbers[numbersIdex]);
			getFormedIndex();

		}
		return list;

	}

	private void getFormedIndex() {
		int t = this.formeIndex + 1;
		if (t == THREE) {
			setFillgTexT();
			this.formeIndex = 0;
		} else {
			this.formeIndex = t;
		}

	}

	private void setFillgTexT() {
		int t = this.fillgingIndex + 1;
		if (t == THREE) {
			this.fillgingIndex = 0;
			setNumbersOfIndex(this.numbersIdex);
		} else {
			this.fillgingIndex = t;
		}

	}

	private void setNumbersOfIndex(int i) {
		int t = i + 1;
		if (t == THREE) {
			this.numbersIdex = 0;
			setColorIndex(this.colorIndex);
		} else {
			this.numbersIdex = t;
		}
	}

	private void setColorIndex(int i) {
		int t = i + 1;
		if (t == THREE) {
			this.colorIndex = 0;
		}
		this.colorIndex = t;

	}

	public Cards[] getCards() {
		return this.pack;
	}

}
