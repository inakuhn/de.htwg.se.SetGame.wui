package setgame.modell;

import java.util.LinkedList;

/**
 * @author David Simon & Raina Bertolini
 * class use to create all the combinations of the pack
 */
final class Pack {
	
	/**
	 *  Instance variable
	 */
	private Card pack[];
	protected static final String[] FORME = { "ovally", "wave", "balk" };
	protected static final String[] COLORS = { "red", "green", "purple" };
	protected static final String[] FILL = { "halffill", "fill", "empty" };
	protected static final int[] NUMBEROFCOMPONET = { 1, 2, 3 };
	private static final int SIZEOFARRAY = 81;
	private static final int NUMBEROFEACHCARD = 3;
	private int colorIndex = 0;
	private int formeIndex = 0;
	private int fillgingIndex = 0;
	private int numbersIdex = 0;


	

	/**
	 * Construct for card
	 */

	public Pack() {
		this.pack = creatCards();

	}

	/**
	 * @return the finish pack of the Game
	 */
	private Card[] creatCards() {
		Card list[] = new Card[SIZEOFARRAY];
		for (int i = 0; i < SIZEOFARRAY; i++) {

			list[i] = new Card(COLORS[colorIndex], FORME[formeIndex],
					FILL[fillgingIndex], NUMBEROFCOMPONET[numbersIdex]);
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
	protected LinkedList<Card> getPack() {
		LinkedList<Card> liste = new LinkedList<Card>();
		for(Card card : this.pack){
			liste.add(card);
		}
		return liste;
	}
	protected String[] getcolors(){
		return Pack.COLORS;
		
	}
	protected String[] getFormes(){
		return Pack.FORME;
	}
	protected String[] getFill(){
		return Pack.FILL;
	}


}
