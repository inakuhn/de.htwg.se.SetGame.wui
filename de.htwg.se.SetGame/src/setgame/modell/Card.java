package setgame.modell;


final class Card {
	/*Instance variable*/
	private Cards pack[];
	private String[] forme = { "ovally", "wave", "balk" };
	private String[] colors = { "red", "green", "purple" };
	private String[] filling = { "halffill", "fill", "empty" };
	private final int[] numbers = { 1, 2, 3 };
	private static final int SIZEOFARRAY = 81;
	private static final int NUMBEROFEACHCARD = 3;
	private int colorIndex = 0;
	private int formeIndex = 0;
	private int fillgingIndex = 0;
	private int numbersIdex = 0;

	/* One card in card */
	protected class Cards {
		private String color;
		private String fomr;
		private String panelFilling;
		private int anz;

		/*Set Cards option*/
		protected Cards(String color, String form, String panelFilling, int anzahl) {

			this.setColor(color);
			this.setFomr(form);
			this.setPanelFilling(panelFilling);
			this.setAnz(anzahl);

		}

		/* Get Color of Cards */
		protected String getColor() {
			return color;
		}

		/* Set Color of Cards */
		private void setColor(String color) throws IllegalArgumentException {
			if (color.equals(colors[0]) || color.equals(colors[1])
					|| color.equals(colors[2])) {
				this.color = color;
			} else {
				throw new IllegalArgumentException("WErte für karte illegal!"+anz);
			}
		}

		/*Get format of cards*/
		protected String getFomr() {
			return fomr;
		}

		/*Set format of cards*/
		private void setFomr(String fomr) throws IllegalArgumentException {
			if (fomr.equals(forme[2]) || fomr.equals(forme[0])
					|| fomr.equals(forme[1])) {
				this.fomr = fomr;
			} else {
				throw new IllegalArgumentException("WErte für karte illegal!"+anz);
			}
		}

		/*Get Panel filling option*/
		protected String getPanelFilling() {
			return panelFilling;
		}

		/* Set Panel filling option */
		private void setPanelFilling(String panelFilling) throws IllegalArgumentException {
			if (panelFilling.equals(filling[0])
					|| panelFilling.equals(filling[1])
					|| panelFilling.equals(filling[2])) {
				this.panelFilling = panelFilling;
			} else { 
					throw new IllegalArgumentException("WErte für karte illegal!"+anz);
			}

		}

		/* Get number of  */
		protected int getAnz() {
			return anz;
		}
		
		
		/* Set number of */
		private void setAnz(int anz) throws IllegalArgumentException {
			if (anz == numbers[0] || anz == numbers[1] || anz == numbers[2]) 
				this.anz = anz;
			else 
				throw new IllegalArgumentException("WErte für karte illegal!"+anz);

	}


	}
	
	protected Card(){
		this.pack = creatCards();
	}
	/* Create Cards */
	
	private Cards[] creatCards() {
		Cards list[] = new Cards[SIZEOFARRAY];
		for (int i = 0; i < SIZEOFARRAY; i++) {

			list[i] = new Cards(colors[colorIndex], forme[formeIndex],
					filling[fillgingIndex], numbers[numbersIdex]);
			getFormedIndex();

		}
		return list;

	}

	/* Get Index of */
	private void getFormedIndex() {
		int t = this.formeIndex + 1;
		if (t == NUMBEROFEACHCARD) {
			setFillgTexT();
			this.formeIndex = 0;
		} else {
			this.formeIndex = t;
		}

	}

	/**/
	private void setFillgTexT() {
		int t = this.fillgingIndex + 1;
		if (t == NUMBEROFEACHCARD) {
			this.fillgingIndex = 0;
			setNumbersOfIndex(this.numbersIdex);
		} else {
			this.fillgingIndex = t;
		}

	}

	/* Set Numbers of Index */
	private void setNumbersOfIndex(int i) {
		int t = i + 1;
		if (t == NUMBEROFEACHCARD) {
			this.numbersIdex = 0;
			setColorIndex(this.colorIndex);
		} else {
			this.numbersIdex = t;
		}
	}

	/*Set Color Index*/
	private void setColorIndex(int i) {
		int t = i + 1;
		if (t == NUMBEROFEACHCARD) {
			this.colorIndex = 0;
		}
		this.colorIndex = t;

	}

	/**/
	protected Cards[] getCards() {
		return this.pack;
	}

}
