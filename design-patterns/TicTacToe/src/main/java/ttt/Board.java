package ttt;

import ttt.Exceptions.BoardFieldNotEmptyException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Board {

    private Map<Coords, BoardField> board;

    public Board(int maxSize) {
        board = new HashMap<>();
        for (int x = 1; x <= maxSize; x++) {
            for (int y = 1; y <= maxSize; y++) {
                board.put(new Coords(x, y), new BoardField() {
                    @Override
                    public String toString() {
                        return String.valueOf(getSign());
                    }
                });
            }
        }
    }

    public Coords findKey(Coords coords) {
        Iterator<Coords> keys = board.keySet().iterator();
        while (keys.hasNext()) {
            Coords key = keys.next();
            if (key.equals(coords)) {
                return key;
            }
        }
        return null;
    }

    public boolean hasEmpty() {
        for (BoardField item : board.values()) {
            if (!(item instanceof Player)) {
                return true;
            }
        }
        return false;
    }

    public void setValue(int x, int y, BoardField value) throws BoardFieldNotEmptyException {
        Coords key = findKey(new Coords(x, y));
        if (board.get(key) instanceof Player) {
            throw new BoardFieldNotEmptyException();
        }
        board.put(key, value);
    }

    public BoardField getValue(Coords coords) {
        return board.get(coords);
    }

    public BoardField getValue(int x, int y) {
        return board.get(findKey(new Coords(x, y)));
    }

    public int getSize() {
        return (int) Math.sqrt(board.size());
    }

    public static class Coords {
        private int x;
        private int y;

        public Coords(int x, int y) {

            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Coords) {
                Coords local = (Coords) obj;
                return (x == local.getX() && y == local.getY());
            }
            return false;
        }
    }

}
