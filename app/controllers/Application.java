package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.controller.IController;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import play.libs.Json;

public class Application extends Controller {

    static IController controller = SetGame.getInstance(false).getIController();
    static Helper h = new Helper(controller);


    public static Result index() {
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result solve() {
        return ok(views.html.solve.render(controller, h.getField(), h.getASet()));
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

    /***************WEBSOCKET ************************/
    public static WebSocket<String> ws() {
        return new MyWebSocket(controller);
    }
}
