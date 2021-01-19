package ttt.Strategy;

public class TicTacToeFormatter implements TextFormatterStrategy {

    @Override
    public String format(String message) {
        int len = (50 - message.length()) / 4;
        StringBuilder sb = new StringBuilder();
        sb.append("+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o\r\n");
        for (int i = 0; i < len; i++) sb.append("+o");
        sb.append(" " + message + " ");
        for (int i = 0; i < len; i++) sb.append("+o");
        sb.append("\r\n+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o\r\n");
        return sb.toString();
    }
}
