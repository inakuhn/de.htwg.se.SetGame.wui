package setgame.aview.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import com.google.inject.Inject;

import setgame.controller.ISetController;
import de.htwg.se.observer.IObserver;
import de.htwg.se.observer.Event;

public class TextUI implements IObserver {
	
	private ISetController controller;
	
	private Logger logger = Logger.getLogger("setgame.aview.tui");
	
	@Inject
	public TextUI(ISetController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}
	
	@Override
	public void update(Event e) {
		print();
	}
	
	//TODO: TUI
	
	public void print() {
		//TODO LINE-TUI
	}

	

}
