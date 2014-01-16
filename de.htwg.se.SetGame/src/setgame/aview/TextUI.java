package setgame.aview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import setgame.controller.IController;
import de.htwg.se.util.observer.Event;
import de.htwg.se.util.observer.IObserver;

import com.google.inject.Inject;

public class TextUI implements IObserver {

	private IController controller;
	private String newLine = System.getProperty("line.separator");

	private final Logger logger = LogManager.getLogger("setgame.aview.tui");

	public TextUI(IController controller) {
		this.controller = controller;
		controller.addObserver(this);

	}

	public boolean processInputLine(String line) {
		boolean cont = true;
		String[] splintWords = line.split(" ");
		Integer[] arrayForSerNumber = new Integer[3];
		switch (splintWords[0]) {
		case "set":

			if (comparIfPlayerIsRigth(splintWords[1])
					&& splintWords.length == 5) {
				arrayForSerNumber[0] = Integer.parseInt(splintWords[2]);
				arrayForSerNumber[1] = Integer.parseInt(splintWords[3]);
				arrayForSerNumber[2] = Integer.parseInt(splintWords[4]);
				boolean b = true;
				for (int index = 0; index < arrayForSerNumber.length; index++) {
					if (arrayForSerNumber[index] < 0
							|| arrayForSerNumber[index] > 11) {
						b = false;
						logger.info(this.newLine
								+ "wrong number please number between 0-11");
						break;
					}

				}
				if (b) {
					printAseT(arrayForSerNumber, splintWords[1]);
				}
			}
			logger.info("Please write set with player (PlayerOne or PlayerTwo) and the number from the cards \n Example: set PlayerOne 1 2 3\n");
			break;
		case "GetPoints":
			if (splintWords[1].compareTo("PlayerOne") == 0) {
				logger.info(newLine + "Point PlayerOne = "
						+ this.controller.geTplayerTwoPoints());
			} else if (splintWords[1].compareTo("PlayerTwo") == 0) {
				logger.info(newLine + "Point PlayerOne = "
						+ this.controller.geTplayerTwoPoints());
			} else {
				logger.info("Hey dude let´s go learn how to play this ;) if you want to now your pontis xD please write GetPoints PlayerOne ;)");
			}
			break;
		case "newGame":
			this.controller.newGame();
			
		case "":
			
		}
		return true;

	}

	private void printAseT(Integer[] arrayForSerNumber, String string) {
		int player = -1;
		if (string.compareTo("PlayerOne") == 0) {
			player = this.controller.getPlayerOne();

		} else if (string.compareTo("PlayerTwo") == 0) {
			player = this.controller.getPlayerTwo();
		}
		if (player != -1) {
			if (this.controller.isAsetForController(
					this.controller.getField().getCardInFieldGame()
							.get(arrayForSerNumber[0]),
					this.controller.getField().getCardInFieldGame()
							.get(arrayForSerNumber[1]),
					this.controller.getField().getCardInFieldGame()
							.get(arrayForSerNumber[2]),
					this.controller.getPlayerOne())) {
				logger.info(this.newLine + "Congratilations it is a SET!!!");
			} else {
				logger.info(this.newLine
						+ "Dude Set is wrong how could you!! =(");
			}
		}
	}

	@Override
	public void update(Event e) {
		printTUI();

	}

	private boolean comparIfPlayerIsRigth(String string) {
		return string.compareTo("PlayerOne") == 0
				|| string.compareTo("PlayerTwo") == 0;
	}

	private void printTUI() {

	}

}
