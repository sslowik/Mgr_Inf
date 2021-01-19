package ttt;

public enum Status implements StatusMessenger {

    WIN(" wygrał/a, gratulacje!\r\n"),
    PAT("Remis!"),
    TURN(", teraz Twój ruch!\r\n");

    private String message;
    private Player player;

    Status(String message) {
        this.message = message;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getMessage() {
        return player.getName() + message;
    }
}
