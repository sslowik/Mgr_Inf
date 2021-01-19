package ttt.cli;

import ttt.Strategy.CliPrinter;
import ttt.Strategy.TicTacToeFormatter;

import java.util.Scanner;

public class CliAsker {
    public static String chooseGameInterface() {
        Scanner scan = new Scanner(System.in);
        CliPrinter.println("Twój wybór: ");
        String line = scan.nextLine();
        CliPrinter.setPrintStrategy(new TicTacToeFormatter());
        CliPrinter.printWithStrategy(line);
        while (!line.equals("0") && !line.equals("1") && !line.equals("2")) {
            CliPrinter.printWithStrategy("Nie ma takiej opcji, spróbuj ponownie:");
            line = scan.nextLine();
        }
        return line;
    }
}
