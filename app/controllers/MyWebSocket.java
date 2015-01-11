package controllers;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;
import play.libs.F;
import play.mvc.WebSocket;

import java.util.Observer;

/**
 * Created by raina on 11.01.2015.
 */
public class MyWebSocket extends WebSocket<String> implements IObserver {

    private IController controller;
    WebSocket.In<String> in;
    WebSocket.Out<String> out;

    public MyWebSocket(IController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    // Called when the Websocket Handshake is done.
    @Override
    public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
        this.in = in;
        this.out = out;

    }

    @Override
    public void update(Event event) {
        out.write("Update!");
    }

}
