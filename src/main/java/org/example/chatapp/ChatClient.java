package org.example.chatapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClient {
    private String username;
    private ChatMediator mediator;

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    @FXML
    protected void onSendButtonClick() {
        String message = messageField.getText();
        mediator.sendMessage(message, username);
        chatArea.appendText("Me: " + message + "\n");
        messageField.clear();
    }

    public void receiveMessage(String message, String sender) {
        Platform.runLater(() -> chatArea.appendText(sender + ": " + message + "\n"));
    }
}