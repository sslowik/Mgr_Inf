package ttt.Strategy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CliPrinter {
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static FormatterContext form = new FormatterContext();

    public static void printWithStrategy(String text) {
        String strategicMessage = form.format(text);
        print(strategicMessage);
    }

    public static void print(String text) {
        for (int i = 0; i < 3; i++) {
            try {
                writer.write(text);
                writer.flush();
            } catch (IOException ioe) {
                System.out.println(String.format("Failed to write text: [%s]. Retrying...)", text));
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            break;
        }
    }

    public static void print(char ch) {
        print(String.valueOf(ch));
    }

    public static void println(String text) {
        print(text + "\r\n");
    }

    public static void println() {
        print("\r\n");
    }

    public static void setPrintStrategy(TextFormatterStrategy strategy) {
        form.setStrategy(strategy);
    }

    public static String getPrintStrategy() {
        return form.getStrategy();
    }
}
