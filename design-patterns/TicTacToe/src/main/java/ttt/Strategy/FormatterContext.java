package ttt.Strategy;

public class FormatterContext {
    private TextFormatterStrategy strategy;

    public void setStrategy(TextFormatterStrategy strategy) {
        this.strategy = strategy;
    }

    public String getStrategy() {
        return strategy.getClass().getSimpleName();
    }

    public String format(String msg) {
        return strategy.format(msg);
    }
}
