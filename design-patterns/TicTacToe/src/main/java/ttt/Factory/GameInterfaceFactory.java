package ttt.Factory;

import ttt.Exceptions.GameTypeUnknownException;
import ttt.cli.Cli;
import ttt.gui.Gui;

public class GameInterfaceFactory {

    private String[] args;

    public GameInterfaceFactory(String[] args) {
        this.args = args;
    }

    public GameInterface createGameInterface(String gameType) {
        switch (gameType) {
            case "1":
                return new Cli(args);
            case "2":
                return new Gui(args);
            default:
                throw new GameTypeUnknownException();
        }
    }
}
