package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.controller.IController;
import play.mvc.Controller;
import play.mvc.Result;

import java.lang.String;

public class Application extends Controller {

    static IController controller = SetGame.getInstance(false).getIController();
    
    public static Result index() {
        return ok(views.html.index.render(TextUI.MESSAGE_WELCOME, controller));
    }
    
}
