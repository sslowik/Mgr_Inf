package ttt.Decorator;

import ttt.Strategy.CliPrinter;
import ttt.Singleton.Engine;

import java.io.IOException;

public interface BoardDrawer {
//    void drawBoard() throws IOException;

    default void drawBoard() throws IOException {
        int iterationCount = Engine.getInstance().getBoardSize() * 2 + 1;
        for (int y = 0; y < iterationCount; y++) {
            for (int x = 0; x < iterationCount; x++) {
                if (y == 0) {
                    if (x != 0 && x % 2 == 0) {
                        CliPrinter.print(String.valueOf(x / 2));
                    } else {
                        CliPrinter.print(" ");
                    }
                } else if (y > 0 && y % 2 == 0 && x == 0) {
                    CliPrinter.print(String.valueOf(y / 2));
                } else {
                    if (y % 2 != 0) {
                        if (x % 2 == 0) {
                            CliPrinter.print("-");
                        } else {
                            CliPrinter.print("+");
                        }
                    } else {
                        if (x % 2 == 0) {
                            CliPrinter.print(Engine.getInstance().getBoardValue(x / 2, y / 2).getSign());
                        } else {
                            CliPrinter.print("|");
                        }
                    }
                }
            }
            CliPrinter.println();
        }
    }
}
