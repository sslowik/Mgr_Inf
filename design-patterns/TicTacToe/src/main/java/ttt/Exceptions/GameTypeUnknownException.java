package ttt.Exceptions;


@SuppressWarnings("serial")
public class GameTypeUnknownException extends RuntimeException {

    public GameTypeUnknownException() {
        super("Nieznany typ gry. Napewno dobrze wybrałeś?");
    }
}
