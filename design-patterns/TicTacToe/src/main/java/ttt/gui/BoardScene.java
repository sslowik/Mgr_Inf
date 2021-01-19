package ttt.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ttt.Board.Coords;
import ttt.BoardField;
import ttt.Singleton.Engine;
import ttt.Player;

public class BoardScene extends Scene {

    private VBox root;
    private GridPane board;
    private TextArea log;
    private Coords currentCoords;

    public BoardScene() {
        super(new VBox(), 600, 400);
        log = new TextArea();
        board = new GridPane();

        root = (VBox) this.getRoot();
        root.getChildren().add(new Label("OOO  +++   Kółko i krzyżyk   +++   OOO"));
        root.getChildren().add(reloadBoard());
        root.getChildren().add(log);
    }

    public Node reloadBoard() {
        board.getChildren().clear();
        TurnObserver turnEvent = new TurnObserver(this);
        BoardScene scene = this;
        int size = Engine.getInstance().getBoardSize();

        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                Coords key = Engine.getInstance().getCoords(x, y);
                Object val = Engine.getInstance().getBoardValue(key);
                if (val instanceof Player) {
                    board.add(new Label(val.toString()), x - 1, y - 1);
                } else {
                    ObservableList<BoardField> values = FXCollections.observableArrayList(
                            (BoardField) val, Engine.getInstance().getCurrentPlayer());
                    ComboBox<BoardField> field = new ComboBox<>(values);
                    field.setUserData(key);
                    field.setOnMouseClicked((e) -> scene.setCurrentCoords((Coords) ((Node) e.getSource()).getUserData()));
                    field.valueProperty().addListener(turnEvent);
                    board.add(field, x - 1, y - 1);
                }
            }
        }
        return board;
    }

    public void appendTextToLog(String msg) {
        log.appendText("\n" + msg);
    }

    public Coords getCurrentCoords() {
        return currentCoords;
    }

    public void setCurrentCoords(Coords currentCoords) {
        this.currentCoords = currentCoords;
    }
}
