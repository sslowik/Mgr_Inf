package ttt.Exceptions;

public class BoardCoordsExceededException extends RuntimeException {
    public BoardCoordsExceededException() {
        super("Wspołrzędne poza zakresem planszy!");
    }
}
