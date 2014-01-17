package de.htwg.se.setgame.modell.impl;

/**
 * @author David Simon & Raina Bertolini
 *
 */
public class Card extends ACard {
	/**
	 * This method create a new card object
	 * 
	 * @param color
	 * @param form
	 * @param panelFilling
	 * @param anzahl
	 */
	public Card(String color, String form, String panelFilling,
			int anzahl) {
		this.setColor(color);
		this.setFomr(form);
		this.setPanelFilling(panelFilling);
		this.setNumberOfComponents(anzahl);

	}

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getColor()
	 */
	@Override
	public String getColor() {
		return super.getColor();
	}

	/**
	 * @param color
	 *            set the color of a card
	 */
	public void setColor(String color) {
		if (color.equals(Pack.COLORS[0]) || color.equals(Pack.COLORS[1])
				|| color.equals(Pack.COLORS[2])) {
			super.setColor( color);
		}else{
			super.setColor( null);
		}

	}

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getFomr()
	 */
	@Override
	public String getFomr() {
		return getForm();
	}

	/**
	 * @param fomr
	 *            set the form of the Card
	 * @throws IllegalArgumentException
	 *             if the form is not allowed
	 */
	private void setFomr(String fomr) {
		if (fomr.equals(Pack.FORME[2]) || fomr.equals(Pack.FORME[0])
				|| fomr.equals(Pack.FORME[1])) {
			this.setForm(fomr);
		}else{
			this.setForm(null);
		}
	}

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getPanelFilling()
	 */
	@Override
	public String getPanelFilling() {
		return super.getPanelFilling();
	}

	/**
	 * @param panelFilling
	 *            filling of the card
	 * @throws IllegalArgumentException
	 *             if filling is not allowed
	 */
	public void setPanelFilling(String panelFilling) {
		if (panelFilling.equals(Pack.FILL[0])
				|| panelFilling.equals(Pack.FILL[1])
				|| panelFilling.equals(Pack.FILL[2])) {
			super.setPanelFilling(panelFilling);
		}else{
			super.setPanelFilling(null);
		}

	}

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getNumberOfComponents()
	 */
	public int getNumberOfComponents() {
		return super.getAnz();
	}

	/**
	 * @param numberOfComponents
	 * @throws IllegalArgumentException
	 *             if numberOfComponents is not allowed
	 */
	private void setNumberOfComponents(int numberOfComponents) {
		if (numberOfComponents == Pack.NUMBEROFCOMPONET[0]
				|| numberOfComponents == Pack.NUMBEROFCOMPONET[1]
				|| numberOfComponents == Pack.NUMBEROFCOMPONET[2]) {
			this.setAnz(numberOfComponents);

		}else{
			this.setAnz(-1);
		}
	}
	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#toString()
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("|"+this.getColor()+"| \n "+"|"+this.getForm()+"| \n "+"|"+this.getPanelFilling()+"| \n "+"|"+this.getAnz()+"|\n");
		return sb.toString();
	}
	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#comparTo(setgame.modell.impl.Card)
	 */
	public boolean comparTo(Card card){
		if(this.getColor().equals(card.getColor()) && this.getAnz() == card.getAnz() && this.getForm().equals(card.getForm()) && this.getPanelFilling().equals(card.getPanelFilling())){
			return true;
		}
		return false;
		
	}




}
