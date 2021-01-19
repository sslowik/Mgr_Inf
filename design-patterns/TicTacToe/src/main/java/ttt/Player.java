package ttt;

public class Player implements BoardField {

    private String name;
    private char sign;

    public Player(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    @Override
    public char getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return String.valueOf(sign);
    }
}