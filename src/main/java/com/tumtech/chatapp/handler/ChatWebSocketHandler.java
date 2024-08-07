package com.tumtech.chatapp.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatWebSocketHandler extends TextWebSocketHandler {
public static Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());


public void afterConnectionEstablished(WebSocketSession session){
    sessions.add(session);
}

protected void handleTextMessage (WebSocketSession session, TextMessage message) throws IOException {
    for(WebSocketSession socketSession: sessions){
        if(socketSession.isOpen()){
            socketSession.sendMessage(message);
        }
    }

}

public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
    sessions.remove(session);
}
}
