package org.example.chatapp;

import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, String sender) {
        for (ChatClient client : clients.values()) {
            if (!client.getUsername().equals(sender)) {
                client.receiveMessage(message, sender);
            }
        }
    }
}