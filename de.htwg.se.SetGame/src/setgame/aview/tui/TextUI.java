package setgame.aview.tui;

import org.apache.log4j.Logger;
import java.util.Scanner;

import setgame.modell.IField;
import setgame.controller.IController;

import de.htwg.se.observer.IObservable;

import de.htwg.se.observer.IObserver;
import de.htwg.se.observer.Event;

public class TextUI implements IObserver {
	
	private IController controller;	
	private IField field;

	
	private Logger logger = Logger.getLogger("setgame.aview.tui");
	
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
    	outI(controller.spielModus());
    }
    
    public boolean processTurn(Scanner scanner) {
    	while (field == null) {
    		out("Starte neues Spiel!");
    		field.startUp();
    	}
    	
    	if(controller.spielModus() == 0) {
    		out("Spielermodus: Com vs Player 1");
    	} else if (controller.spielModus() == 1) {
    		out("Spielermodus: Player 1 vs Player 2");
    	}
    	
    	

    	//TODO: Kein Plan mehr...
    	
 
    	return true;
    }
	
	@Override
	public void update(Event e) {
        if (e == null) {
            printTUI();
        }
	}

}
