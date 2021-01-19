package ttt.Facade;

import javafx.application.Application;
import javafx.stage.Stage;
import ttt.Factory.GameInterface;
import ttt.Factory.GameInterfaceFactory;
import ttt.Singleton.SinGer;
import ttt.Strategy.CapitalizeFormatter;
import ttt.Strategy.CliPrinter;
import ttt.Strategy.TicTacToeFormatter;
import ttt.cli.CliAsker;
import ttt.gui.PlayersScene;


public class LauncherFacade {

    private GameInterface game;

    public LauncherFacade() {
    }

    public void launchGame(String gameType, String... args) {
        game = new GameInterfaceFactory(args).createGameInterface(gameType);
        game.startGame();
    }

    public String welcomePlayers() throws IllegalAccessException, InstantiationException {
        CliPrinter.setPrintStrategy(new TicTacToeFormatter());
        CliPrinter.printWithStrategy("Kółko i krzyżyk v0.88.8");
        CliPrinter.printWithStrategy("by Sławomir Słowik ");
        CliPrinter.setPrintStrategy(new CapitalizeFormatter());
        CliPrinter.printWithStrategy("życzymy udanej gry!");
        CliPrinter.println();
        System.out.println("Wybierz wersję gry: \r\n 1. Gra tekstowa w konsoli. \r\n 2. Gra okienkowa z JavaFX.");
        return SinGer
                .getInstance(CliAsker.class)
                .chooseGameInterface();
    }
}
