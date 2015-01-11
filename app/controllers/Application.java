package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.modell.ICard;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

public class Application extends Controller {

    static IController controller = SetGame.getInstance(false).getIController();
    static Helper h = new Helper(controller);

    
    public static Result index() {
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result solve() {
        return ok(views.html.solve.render(controller, h.getField(), h.getASet()));
    }

    public static Result help() {
        return ok(views.html.help.render(controller));
    }

    public static Result size(Integer number) {
        controller.setFieldSize(number);
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result set(Integer player, Integer cardOne, Integer cardTwo, Integer cardThree) {
        controller.isASetForController(h.getCard(cardOne), h.getCard(cardTwo), h.getCard(cardThree), player);
        return ok(views.html.index.render(controller, h.getField()));
    }

    public static Result reset() {
        controller.newGame();
        return ok(views.html.index.render(controller, h.getField()));
    }
    /***************WEBSOCKET ************************/


    public static WebSocket<String> ws() {
        return new WebSocket<String>() {

            // Called when the Websocket Handshake is done.
            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {

                // For each event received on the socket,
                in.onMessage(new F.Callback<String>() {
                    public void invoke(String event) {

                        // Log events to the console
                        System.out.println(event);

                    }
                });

                // When the socket is closed.
                in.onClose(new F.Callback0() {
                    public void invoke() {

                        System.out.println("Disconnected");

                    }
                });

                // Send a single 'Hello!' message
                out.write("Hello!");
                System.out.println("Hallo");

            }

        };

    }








}
