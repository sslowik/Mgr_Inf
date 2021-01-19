package ttt.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ttt.Singleton.Engine;


public class PlayersScene extends Scene {

    private GridPane root;

    public PlayersScene(Stage stage) {
        super(new GridPane(), 300, 100);

        root = (GridPane) this.getRoot();
        Label label = new Label("Dodaj gracza");
        root.add(label, 0, 0);
        TextField player = new TextField();
        Button addPlayer = new Button("Dodaj gracza");
        addPlayer.setOnMouseClicked(event -> {
            boolean next = false;
            if (!player.getText().isEmpty()) {
                next = Engine.getInstance().addPlayer(player.getText());
                label.setText("Dodano gracza " + player.getText() + ". Dodaj następnego: ");
                player.clear();
            }
            if (next) {
                stage.setScene(new BoardScene());
            }
        });
        root.add(player, 0, 1);
        root.add(addPlayer, 1, 1);
    }
}
