package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.controller.IController;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import play.libs.Json;

import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Application extends Controller {

    static IController controller = SetGame.getInstance(false).getIController();
    static Helper h = new Helper(controller);


    public static Result index() {
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result size(Integer number) {
        controller.setFieldSize(number);
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result set(Integer player, Integer cardOne, Integer cardTwo, Integer cardThree) {
        return ok(Json.toJson(h.isASet(player, cardOne, cardTwo, cardThree)));
    }

    public static Result reset() {
        controller.newGame();
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result cards() {
        return ok(Json.toJson(h.getField()));
    }

    public static Result points() {
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("player1", controller.getPlayerOnePoints());
        result.put("player2", controller.getPlayerTwoPoints());
        result.put("cards", controller.getCardinGame().size());
        return ok(Json.toJson(result));
    }

    public static Result solve() {
        return ok(Json.toJson(h.getASet()));
    }

    /***************WEBSOCKET ************************/
    public static WebSocket<String> ws() {
        return new MyWebSocket(controller);
    }
}
