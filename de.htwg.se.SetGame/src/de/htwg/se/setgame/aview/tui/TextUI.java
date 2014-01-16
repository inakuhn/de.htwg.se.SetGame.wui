package de.htwg.se.setgame.aview.tui;


import org.apache.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.modell.impl.Card;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

public class TextUI implements IObserver {

	private IController controller;
	private String newLine = System.getProperty("line.separator");

	private Logger logger = Logger.getLogger("de.htwg.se.setgame.aview.tui");

	@Inject
	public TextUI(IController controller) {
		this.controller = controller;
		controller.addObserver(this);

	}

	@Override
	public void update(Event e) {
		printTUI();

	}

	public boolean processInputLine(String line) {
		logger.info(newLine+controller.getCardinGame().size());
		if (!controller.stillSetInGAme()) {
			logger.info("Hey dude! there is no longger stes in game for you here is the Points ;) "
					+ this.newLine
					+ "Player 1 = "
					+ controller.geTplayerOnePoints()
					+ this.newLine
					+ "Player Two " + controller.geTplayerTwoPoints());
			if (controller.geTplayerTwoPoints() < controller
					.geTplayerOnePoints()) {
				logger.info("Gongratilations player one Dude you are amazing!!");
			} else if (controller.geTplayerTwoPoints() > controller
					.geTplayerOnePoints()) {
				logger.info("Gongratilations player Two Dude you are amazing!!");
			} else {
				logger.info("nobody wins nobody pays the dinne xD");
			}
			return false;
		}
		boolean cont = true;
		String[] splintWords = line.split(" ");
		for (int i = 0; i < splintWords.length; i++) {
			logger.info("Antrage = " + splintWords[i] + newLine);
		}
		Integer[] arrayForSerNumber = new Integer[3];
		if (this.controller.getCardinGame().isEmpty()) {
			logger.info(this.newLine + "THere is no sets anymore!!!"
					+ this.newLine);
			cont = false;
		}
		int index = 0;
		if (splintWords[index].compareTo("set") == 0) {
			if (comparIfPlayerIsRigth(splintWords[1])) {
				if (splintWords.length > 4) {
					arrayForSerNumber[0] = Integer.parseInt(splintWords[2]);
					arrayForSerNumber[1] = Integer.parseInt(splintWords[3]);
					arrayForSerNumber[2] = Integer.parseInt(splintWords[4]);
					boolean b = true;
					for (int index1 = 0; index1 < arrayForSerNumber.length; index1++) {
						if (arrayForSerNumber[index1] < 0
								|| arrayForSerNumber[index1] > 11) {
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
			}

		} else if (splintWords[index].compareTo("GetPoints") == 0) {
			logger.info(this.newLine + "Player one = "
					+ controller.geTplayerOnePoints() + this.newLine
					+ "Player Two = " + controller.geTplayerTwoPoints()
					+ this.newLine);
		} else if (splintWords[index].compareTo("h") == 0) {
			logger.info("A tipp your set begiss with  " + this.newLine
					+ controller.getAsetInGame().get(0));
			printTUI();

		} else if (splintWords[index].compareTo("exit") == 0) {
			cont = false;
		} else if (splintWords[index].compareTo("solve") == 0) {
			if (this.controller.getSetInField().size() >= 3) {
				logger.info("solved"
						+ this.controller.getSetInField().toString() + newLine
						+ controller.getField().getAllCardsInGame().size());
				this.controller.isAsetForController(this.controller
						.getSetInField().get(0), this.controller
						.getSetInField().get(1), this.controller
						.getSetInField().get(2), 3);
				printTUI();
			} else {
				logger.info("number of cards = "
						+ controller.getField().getAllCardsInGame().size());
				printTUI();

			}
		} else if (splintWords[index].compareTo("s") == 0) {
			for(Card card : controller.getSetInField()){
				for(Integer key : controller.getcardandindexoffiels().keySet()){	
					if(controller.getcardandindexoffiels().get(key).comparTo(card)){
						logger.info("Index  == "+key);
					}
					
				}
				logger.info(newLine);
			}
		} else if (splintWords[index].compareTo("nw") == 0) {
			this.controller.newGame();
			logger.info(this.newLine + "size of Pack = "
					+ controller.getField().getAllCardsInGame().size()
					+ newLine + controller.getField().getCardsInField().size());

			printTUI();
		} else if (splintWords[index].compareTo("size") == 0) {
			Integer i = Integer.parseInt(splintWords[1]);
			this.controller.setFieldSize(i);
			printTUI();
		}

		return cont;

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
							.get(arrayForSerNumber[2]), player)) {
				logger.info(this.newLine
						+ "Congratilations it is a SET!! ! size == "
						+ controller.getField().getAllCardsInGame().size());
			} else {
				logger.info(this.newLine
						+ "Dude Set is wrong how could you!! =(");
			}
		}
	}

	private boolean comparIfPlayerIsRigth(String string) {
		return string.compareTo("PlayerOne") == 0
				|| string.compareTo("PlayerTwo") == 0;
	}

	public void printTUI() {
		logger.info("Welcome to SetGame!!!! "
				+ this.newLine
				+ "Well ist not that hard to play ;)"
				+ this.newLine
				+ "If you found a set please write : set PlayerOne (or PlayerTwo) and the number of the fields 1 2 3 (0-11)"
				+ this.newLine
				+ "if you need a tipp plese write h"
				+ this.newLine
				+ "if you want to know the solution please write s"
				+ this.newLine
				+ "If you want to know the game point please write GetPoints"
				+ this.newLine
				+ "if you want to solve the set with out knowing just write solve"
				+ this.newLine + "Set size of the fiel 3-80 size number"
				+ this.newLine + "For a newGame plase write nw" + this.newLine
				+ "Have fun!!!"
				+ "if you want to finisch the game please write exit"
				+ this.controller.getField().toString());
	}

}
