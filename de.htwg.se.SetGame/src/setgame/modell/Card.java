package setgame.modell;

public class Card {
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
	protected Card(String color, String form, String panelFilling,
			int anzahl) {
		this.setColor(color);
		this.setFomr(form);
		this.setPanelFilling(panelFilling);
		this.setNumberOfComponents(anzahl);

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
		if (color.equals(setgame.modell.Pack.COLORS[0]) || color.equals(setgame.modell.Pack.COLORS[1])
				|| color.equals(setgame.modell.Pack.COLORS[2])) {
			this.color = color;
		}else{
			this.color = null;
		}

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
		if (fomr.equals(setgame.modell.Pack.FORME[2]) || fomr.equals(setgame.modell.Pack.FORME[0])
				|| fomr.equals(setgame.modell.Pack.FORME[1])) {
			this.form = fomr;
		}else{
			this.form = null;
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
		if (panelFilling.equals(setgame.modell.Pack.FILL[0])
				|| panelFilling.equals(setgame.modell.Pack.FILL[1])
				|| panelFilling.equals(setgame.modell.Pack.FILL[2])) {
			this.panelFilling = panelFilling;
		}else{
			this.panelFilling = null;
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
	private void setNumberOfComponents(int numberOfComponents) {
		if (numberOfComponents == setgame.modell.Pack.NUMBEROFCOMPONET[0]
				|| numberOfComponents == setgame.modell.Pack.NUMBEROFCOMPONET[1]
				|| numberOfComponents == setgame.modell.Pack.NUMBEROFCOMPONET[2]) {
			this.anz = numberOfComponents;

		}else{
			this.anz = -1;
		}
	}
}
