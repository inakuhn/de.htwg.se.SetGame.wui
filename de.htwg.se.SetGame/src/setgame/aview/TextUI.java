package setgame.aview;
import com.google.inject.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
import setgame.modell.IField;
import setgame.controller.IController;
import de.htwg.se.util.observer.Event;
import de.htwg.se.util.observer.IObservable;
import de.htwg.se.util.observer.IObserver;

public class TextUI implements IObserver {

	private IController controller;
	private IField field;

	private final Logger logger = LogManager.getLogger("setgame.aview.tui");
	@Inject
	public TextUI(IController controller) {
		this.controller = controller;
		((IObservable) controller).addObserver(this);
	}

	private synchronized void out(String str) {
		logger.info(str);
	}

	private synchronized void outI(int num) {
		logger.info(num);
	}

	public synchronized void printTUI() {
		outI(controller.getPlayModus());
	}

	public boolean processTurn(Scanner scanner) {
		while (field == null) {
			out("Starte neues Spiel!");
			field.startUp();
		}

		if (controller.getPlayModus() == 0) {
			out("Spielermodus: Com vs Player 1");
		} else if (controller.getPlayModus() == 1) {
			out("Spielermodus: Player 1 vs Player 2");
		}

		// TODO: Kein Plan mehr...

		return true;
	}

	@Override
	public void update(Event e) {
		if (e == null) {
			printTUI();
		}
	}

}
