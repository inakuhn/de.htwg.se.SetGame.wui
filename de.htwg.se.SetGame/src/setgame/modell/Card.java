package setgame.modell;

/**
 * @author rabertol class use to create all the combinations of the pack
 */
final class Card {
	/* Instance variable */
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

	/**
	 * @author rabertol Class use to create each card of the pack
	 * 
	 */

	protected class Cards {
		private String color;
		private String form;
		private String panelFilling;
		private int anz;

		/**
		 * This method create a new card object
		 * 
		 * @param color
		 * @param form
		 * @param panelFilling
		 * @param anzahl
		 */
		protected Cards(String color, String form, String panelFilling,
				int anzahl) {
			this.setColor(color);
			this.setFomr(form);
			this.setPanelFilling(panelFilling);
			this.setAnz(anzahl);

		}

		/**
		 * @return color of the card
		 */
		protected String getColor() {
			return color;
		}

		/**
		 * @param color
		 *            set the color of a card
		 */
		private void setColor(String color) {
			if (color.equals(colors[0]) || color.equals(colors[1])
					|| color.equals(colors[2]))
				this.color = color;

		}

		/**
		 * @return form of the card
		 */
		protected String getFomr() {
			return form;
		}

		/**
		 * @param fomr
		 *            set the form of the Card
		 * @throws IllegalArgumentException
		 *             if the form is not allowed
		 */
		private void setFomr(String fomr) {
			if (fomr.equals(forme[2]) || fomr.equals(forme[0])
					|| fomr.equals(forme[1])) {
				this.form = fomr;
			}
		}

		/**
		 * @return which fill the Card has
		 */
		protected String getPanelFilling() {
			return panelFilling;
		}

		/**
		 * @param panelFilling
		 *            filling of the card
		 * @throws IllegalArgumentException
		 *             if filling is not allowed
		 */
		private void setPanelFilling(String panelFilling) {
			if (panelFilling.equals(filling[0])
					|| panelFilling.equals(filling[1])
					|| panelFilling.equals(filling[2])) {
				this.panelFilling = panelFilling;
			}

		}

		/**
		 * @return how much Components one card contains
		 */
		protected int getNumberOfComponents() {
			return anz;
		}

		/**
		 * @param numberOfComponents
		 * @throws IllegalArgumentException
		 *             if numberOfComponents is not allowed
		 */
		private void setAnz(int numberOfComponents) {
			if (numberOfComponents == numbers[0]
					|| numberOfComponents == numbers[1]
					|| numberOfComponents == numbers[2])
				this.anz = numberOfComponents;

		}

	}

	/**
	 * Construct for card
	 */
	protected Card() {
		this.pack = creatCards();
	}

	/**
	 * @return the finish pack of the Game
	 */
	private Cards[] creatCards() {
		Cards list[] = new Cards[SIZEOFARRAY];
		for (int i = 0; i < SIZEOFARRAY; i++) {

			list[i] = new Cards(colors[colorIndex], forme[formeIndex],
					filling[fillgingIndex], numbers[numbersIdex]);
			setFormedIndex();

		}
		return list;

	}

	/**
	 * set number of index form
	 */
	private void setFormedIndex() {
		int t = this.formeIndex + 1;
		if (t == NUMBEROFEACHCARD) {
			setFillIndex();
			this.formeIndex = 0;
		} else {
			this.formeIndex = t;
		}

	}

	/**
	 * set index of the fill
	 */
	private void setFillIndex() {
		int t = this.fillgingIndex + 1;
		if (t == NUMBEROFEACHCARD) {
			this.fillgingIndex = 0;
			setComponentsOfIndex();
		} else {
			this.fillgingIndex = t;
		}

	}

	/**
	 * set index of number of Components
	 */
	private void setComponentsOfIndex() {
		int t = this.numbersIdex + 1;
		if (t == NUMBEROFEACHCARD) {
			this.numbersIdex = 0;
			setColorIndex();
		} else {
			this.numbersIdex = t;
		}
	}

	/**
	 * Set Color Index
	 */
	private void setColorIndex() {
		int t = this.colorIndex + 1;
		if (t == NUMBEROFEACHCARD) {
			this.colorIndex = 0;
		}
		this.colorIndex = t;

	}

	/**
	 * @return pack of cards
	 */
	protected Cards[] getCards() {
		return this.pack;
	}

}
