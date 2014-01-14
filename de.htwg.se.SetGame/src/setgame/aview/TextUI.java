package setgame.aview;

import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import setgame.controller.IController;
import de.htwg.se.util.observer.Event;
import de.htwg.se.util.observer.IObserver;

public class TextUI implements IObserver {

	private IController controller;
	private String newLine = System.getProperty("line.separator");

	private final Logger logger = LogManager.getLogger("setgame.aview.tui");

	@Inject
	public TextUI(IController controller) {
		this.controller = controller;
		controller.addObserver(this);

	}

	public boolean processInputLine(String line) {
		switch (line) {

		case "h":
			
			break;
		case "s":

			break;
		case "e":

			break;

		default:
			break;
		}
		return true;

	}

	@Override
	public void update(Event e) {
		printTUI();

	}

	private void printTUI() {
		// TODO Auto-generated method stub

	}

}
