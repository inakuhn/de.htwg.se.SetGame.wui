package setgame.modell;

import setgame.modell.impl.Card;

public interface ICard {

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getColor()
	 */
	public abstract String getColor();

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getFomr()
	 */
	public abstract String getFomr();

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getPanelFilling()
	 */
	public abstract String getPanelFilling();

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#getNumberOfComponents()
	 */
	public abstract int getNumberOfComponents();

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#toString()
	 */
	public abstract String toString();

	/* (non-Javadoc)
	 * @see setgame.modell.impl.ICard#comparTo(setgame.modell.impl.Card)
	 */

	boolean comparTo(Card card);

}