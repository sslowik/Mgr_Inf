package ttt;

import javafx.application.Application;
import javafx.stage.Stage;
import ttt.Facade.LauncherFacade;
import ttt.gui.PlayersScene;

public class App extends Application {

    private static LauncherFacade launcher = new LauncherFacade();

    public static void main(String[] args) {
        String gameType = null;
        try {
            gameType = launcher.welcomePlayers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (gameType.equals("1")) launcher.launchGame(gameType, args);
        else launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new PlayersScene(primaryStage));
        primaryStage.show();
    }
}

