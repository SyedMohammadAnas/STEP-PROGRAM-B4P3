import java.util.Scanner;

public class TextFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        String[] words = splitText(text);
        String justified = justifyText(words, width);
        String centered = centerText(text, width);

        System.out.println("\nOriginal text:");
        System.out.println(text);
        System.out.println("\nJustified text:");
        displayFormatted(justified, width);
        System.out.println("\nCentered text:");
        System.out.println(centered);

        long builderTime = measurePerformance(() -> justifyText(words, width));
        long stringTime = measurePerformance(() -> justifyTextString(words, width));

        System.out.println("\nPerformance (nanoseconds):");
        System.out.println("StringBuilder: " + builderTime);
        System.out.println("String concatenation: " + stringTime);

        sc.close();
    }

    public static String[] splitText(String text) {
        String[] words = new String[text.length()];
        int count = 0;
        int start = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) {
                    words[count++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words[count++] = text.substring(start);
        }

        String[] result = new String[count];
        System.arraycopy(words, 0, result, 0, count);
        return result;
    }

    public static String justifyText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (line.length() + word.length() + 1 <= width) {
                if (line.length() > 0) line.append(" ");
                line.append(word);
            } else {
                result.append(line).append("\n");
                line = new StringBuilder(word);
            }
        }
        result.append(line);
        return result.toString();
    }

    public static String centerText(String text, int width) {
        int padding = Math.max(0, (width - text.length()) / 2);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < padding; i++) result.append(" ");
        result.append(text);
        return result.toString();
    }

    public static String justifyTextString(String[] words, int width) {
        String result = "";
        String line = "";

        for (String word : words) {
            if (line.length() + word.length() + 1 <= width) {
                if (line.length() > 0) line += " ";
                line += word;
            } else {
                result += line + "\n";
                line = word;
            }
        }
        result += line;
        return result;
    }

    public static void displayFormatted(String text, int width) {
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println((i+1) + ". " + lines[i] + " (" + lines[i].length() + " chars)");
        }
    }

    public static long measurePerformance(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }
}
