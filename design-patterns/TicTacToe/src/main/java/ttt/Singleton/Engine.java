package ttt.Singleton;

import ttt.*;
import ttt.Board.Coords;
import ttt.Exceptions.BoardCoordsExceededException;
import ttt.Exceptions.BoardFieldNotEmptyException;

import java.util.ArrayList;
import java.util.List;

import static ttt.Status.*;

public class Engine {

    private static final char[] SIGNS = {'O', 'X'};
    private static final int maxPlayerQuantity = 2;
    private static final Board board = new Board(3);

    //TODO SinGer
    private static Engine instance;

    public static Engine getInstance() {
        if (instance == null) {
            reset();
        }
        return instance;
    }

    public static Engine reset() {
        return instance = new Engine();
    }

    private List<Player> players;
    private Player currentPlayer;

    private Engine() {
        players = new ArrayList<>();
    }

    public Coords getCoords(int x, int y) {
        return board.findKey(new Coords(x, y));
    }

    private void getNextPlayer() {
        int i = players.indexOf(currentPlayer);
        currentPlayer = (i == 0) ? players.get(1) : players.get(0);
    }

    private Status checkStatus() {
        if (
            // oś X
                (board.getValue(1, 1) == board.getValue(2, 1) && board.getValue(1, 1) == board.getValue(3, 1)) ||
                (board.getValue(1, 2) == board.getValue(2, 2) && board.getValue(1, 2) == board.getValue(3, 2)) ||
                (board.getValue(1, 3) == board.getValue(2, 3) && board.getValue(1, 3) == board.getValue(3, 3)) ||
                // oś Y
                (board.getValue(1, 1) == board.getValue(1, 2) && board.getValue(1, 1) == board.getValue(1, 3)) ||
                (board.getValue(2, 1) == board.getValue(2, 2) && board.getValue(2, 1) == board.getValue(2, 3)) ||
                (board.getValue(3, 1) == board.getValue(3, 2) && board.getValue(3, 1) == board.getValue(3, 3)) ||
                // przekątne
                (board.getValue(1, 1) == board.getValue(2, 2) && board.getValue(1, 1) == board.getValue(3, 3)) ||
                (board.getValue(3, 1) == board.getValue(2, 2) && board.getValue(3, 1) == board.getValue(1, 3))
        ) {
            return WIN;
        }
        if (board.hasEmpty()) {
            return TURN;
        } else {
            return PAT;
        }
    }

    public String turn(Coords coords) throws BoardFieldNotEmptyException {
        return turn(coords.getX(), coords.getY());
    }

    public String turn(int x, int y) throws BoardFieldNotEmptyException {
        try {
            board.setValue(x, y, currentPlayer);
        } catch (BoardCoordsExceededException e) {
            e.getMessage();
        }
        StatusMessenger status = checkStatus();
        if (!status.equals(WIN)) {
            getNextPlayer();
        }
        status.setPlayer(currentPlayer);
        return status.getMessage();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public BoardField getBoardValue(Coords coords) {
        return board.getValue(coords);
    }

    public BoardField getBoardValue(int x, int y) throws BoardCoordsExceededException {
        return board.getValue(x, y);
    }

    public int getBoardSize() {
        return board.getSize();
    }

    public boolean addPlayer(String name) {
        players.add(new Player(name, Engine.SIGNS[players.size()]));

        if (players.size() == maxPlayerQuantity) {
            currentPlayer = players.get(0);
            return true;
        }
        return false;
    }
}
