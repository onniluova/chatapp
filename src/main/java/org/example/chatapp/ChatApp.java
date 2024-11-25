package org.example.chatapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private ChatMediator mediator = new ChatMediatorImpl();

    @Override
    public void start(Stage primaryStage) throws Exception {
        createClientWindow("User1");
        createClientWindow("User2");
        createClientWindow("User3");
    }

    private void createClientWindow(String username) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chat-client.fxml"));
        loader.setController(new ChatClient(username, mediator));
        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}