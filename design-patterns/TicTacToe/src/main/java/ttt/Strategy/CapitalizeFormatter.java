package ttt.Strategy;

public class CapitalizeFormatter implements TextFormatterStrategy {

    @Override
    public String format(String msg) {
        return msg.substring(0, 1).toUpperCase() + msg.substring(1);
    }
}
