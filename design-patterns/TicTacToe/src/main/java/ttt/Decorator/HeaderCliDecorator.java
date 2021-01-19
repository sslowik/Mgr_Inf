package ttt.Decorator;

import ttt.Strategy.CliPrinter;

import java.io.IOException;

public class HeaderCliDecorator extends BoardDecorator implements BoardDrawer{

    private HeaderStyle style;
    private BoardDrawer _drawer;

    public HeaderCliDecorator(BoardDrawer cli, HeaderStyle style) {
        this._drawer = cli;
        this.style = style;
    }

    @Override
    public void drawBoard() throws IOException {
        CliPrinter.println(style.getHeader());
        _drawer.drawBoard();
    }
}
