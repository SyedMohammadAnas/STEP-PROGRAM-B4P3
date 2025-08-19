import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("\n=== ASCII ANALYSIS ===");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            String type = classifyCharacter(ch);
            System.out.println("'" + ch + "' - ASCII: " + ascii + " - Type: " + type);
            if (Character.isLetter(ch)) {
                char opposite = toggleCase(ch);
                int oppositeAscii = (int) opposite;
                System.out.println("  Opposite case: '" + opposite + "' (ASCII: " + oppositeAscii + ")");
                System.out.println("  Difference: " + Math.abs(ascii - oppositeAscii));
            }
        }
        System.out.println("\nCaesar Cipher (shift=3): " + caesarCipher(input, 3));
        System.out.println("\nASCII Table (65-90):");
        displayASCIITable(65, 90);
        int[] asciiArray = stringToASCII(input);
        System.out.println("\nString to ASCII array: " + java.util.Arrays.toString(asciiArray));
        System.out.println("ASCII array back to string: " + asciiToString(asciiArray));
        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        if (Character.isLowerCase(ch)) return (char) (ch - 32);
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else result.append(ch);
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print((char) i + "(" + i + ") ");
            if ((i - start + 1) % 10 == 0) System.out.println();
        }
        System.out.println();
    }

    public static int[] stringToASCII(String text) {
        int[] ascii = new int[text.length()];
        for (int i = 0; i < text.length(); i++) ascii[i] = (int) text.charAt(i);
        return ascii;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        for (int ascii : asciiValues) result.append((char) ascii);
        return result.toString();
    }
}
