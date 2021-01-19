package ttt.Decorator;

public enum HeaderStyle {
    SIMPLE("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\r\n" +
            "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\r\n" +
            "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\r\n"),
    FANCY("^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ \r\n" +
            " * * * * * * * D A J C I E  * * *  C Z A D U ! * * * * * * * * * *  \r\n" +
            "^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ + ^ - ^ \r\n");

    private String header;

    HeaderStyle(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
