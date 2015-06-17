package controllers;

import de.htwg.se.setgame.controller.IController;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

import java.util.HashMap;
import java.util.Map;

public class Application extends Controller {

    static GameManager manager = new GameManager();

    public static Result index() {
        controller(); //Creates new session, do not remove,
        return ok(views.html.index.render("Set - The Game"));
    }

    private static IController controller() {
        return manager.get(session());
    }

    private static Helper h() {
        return new Helper(controller());
    }

    public static Result size(Integer number) {
        controller().setFieldSize(number);
        return ok(Json.toJson(true));
    }

    public static Result set(Integer cardOne, Integer cardTwo, Integer cardThree) throws NumberFormatException {
        Integer player = Integer.parseInt(session(GameManager.PLAYER));
        return ok(Json.toJson(h().isASet(player, cardOne, cardTwo, cardThree)));
    }

    public static Result reset() {
        controller().newGame();
        return ok(Json.toJson(true));
    }

    public static Result cards() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("player", session(GameManager.PLAYER));
        result.put("cards", h().getField());
        return ok(Json.toJson(result));
    }

    public static Result points() {
        IController c = controller();
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("player1", c.getPlayerOnePoints());
        result.put("player2", c.getPlayerTwoPoints());
        result.put("cards", c.getCardinGame().size());
        return ok(Json.toJson(result));
    }

    public static Result solve() {
        return ok(Json.toJson(h().getASet()));
    }
    
    public static Result saveGame() {
    	return ok();
    }
    
    public static Result loadGame(String gameId) {
    	System.out.println(gameId);
    	return ok();
    }

    /***************WEBSOCKET ************************/
    public static WebSocket<String> ws() {
        return new MyWebSocket(controller());
    }
}
