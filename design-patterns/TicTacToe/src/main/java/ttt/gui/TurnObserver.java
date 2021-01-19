package ttt.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import ttt.BoardField;
import ttt.Singleton.Engine;

public class TurnObserver implements ChangeListener<BoardField> {

    private BoardScene scene;

    public TurnObserver(BoardScene scene) {
        this.scene = scene;
    }

    @Override
    public void changed(ObservableValue<? extends BoardField> observable, BoardField oldValue, BoardField newValue) {
        try {
            String msg = Engine.getInstance().turn(scene.getCurrentCoords());
            scene.appendTextToLog(msg);
            scene.reloadBoard();
        } catch (Exception e) {
            scene.appendTextToLog("ERROR(" + e.getClass().getSimpleName() + "): " + e.getMessage());
        }
    }
}
