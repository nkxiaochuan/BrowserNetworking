package com.network.browser.controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketController extends TextWebSocketHandler {

	@Override  
    protected void handleTextMessage(WebSocketSession session,  
            TextMessage message) throws Exception {  
        super.handleTextMessage(session, message);  
        System.out.println(message.toString());
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
        session.sendMessage(returnMessage);  
    }
}
