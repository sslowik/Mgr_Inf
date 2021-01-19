package ttt.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import ttt.Factory.GameInterface;

public class Gui extends Application implements GameInterface {
    private String[] args;

    public Gui(String[] args) {
        this.args = args;
    }

    @Override
    public void startGame() {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new PlayersScene(primaryStage));
        primaryStage.show();
    }
}
