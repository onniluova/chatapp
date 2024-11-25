package org.example.chatapp;

public interface ChatMediator {
    void registerClient(ChatClient client);
    void sendMessage(String message, String sender);
}