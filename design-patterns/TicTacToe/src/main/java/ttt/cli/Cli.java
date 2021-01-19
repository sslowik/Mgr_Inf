package ttt.cli;

import javafx.stage.Stage;
import ttt.Factory.GameInterface;
import ttt.Strategy.CliPrinter;
import ttt.Decorator.BoardDrawer;
import ttt.Decorator.HeaderCliDecorator;
import ttt.Decorator.HeaderStyle;
import ttt.Exceptions.BoardFieldNotEmptyException;
import ttt.Singleton.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Cli implements GameInterface {

    private String[] args;
    private BoardDrawer drawer;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ;

    public Cli(String[] args) {
        this.args = args;
    }

    private String read() throws IOException {
        return reader.readLine();
    }

    private void initPlayers() throws IOException {
        int i = 1;
        String name;
        do {
            CliPrinter.print("Podaj nazwę " + (i++) + "-go gracza:\r\n");
            name = read();
        } while (!Engine.getInstance().addPlayer(name));
    }

    @Override
    public void startGame() {
        drawer = getCliStyle();
        try {
            CliPrinter.println("Kółko i Krzyżyk v0.88");
            CliPrinter.println("Jeśli chcesz wyjść z gry wpisz \"(q)uit\"");
            initPlayers();
            String msg = "Zaczyna gracz: " + Engine.getInstance().getCurrentPlayer().getName() + ".\r\nPodaj współrzędne oddzielone przecinkiem: ";
            do {
                drawer.drawBoard();
                CliPrinter.println(msg);
                String line = read();
                if (line.toLowerCase().contains("q")) {
                    break;
                }
                String[] coords = line.split(",");
                try {
                    if (coords.length != 2
                            || Stream.of(coords).anyMatch(e -> Integer.valueOf(e) > Engine.getInstance().getBoardSize())
                            || Stream.of(coords).anyMatch(e -> Integer.valueOf(e) <= 0)
                    ) {
                        CliPrinter.println("Błędne współrzędne, spróbuj jeszcze raz: ");
                        continue;
                    }
                    msg = Engine.getInstance().turn(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]));
                } catch (NumberFormatException
                        | BoardFieldNotEmptyException
                        | IndexOutOfBoundsException
                        | NullPointerException e) {
                    CliPrinter.println("Błędny wybór: " + e.getMessage());
                }
            } while (true);
            CliPrinter.println("Koniec gry! Do następnego razu!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BoardDrawer getCliStyle() {
        BoardDrawer drawer = new BoardDrawer() {
        };
        System.out.println("Wybrałeś grę konsolową. Wybierz styl nagłówka: \r\n 0: Brak. \r\n 1: Klasyczny. \r\n 2: Fikuśny.");
        String style = CliAsker.chooseGameInterface();
        switch (style) {
            case ("1"):
                drawer = new HeaderCliDecorator(drawer, HeaderStyle.SIMPLE);
                System.out.println("Wybrałeś nagłówek klasyczny.");
                break;
            case ("2"):
                drawer = new HeaderCliDecorator(drawer, HeaderStyle.FANCY);
                System.out.println("Wybrałeś nagłówek fikuśny.");
                break;
            default:
                System.out.println("Bez nagłówka? Doskonały wybór!");
                break;
        }
        return drawer;
    }
}
