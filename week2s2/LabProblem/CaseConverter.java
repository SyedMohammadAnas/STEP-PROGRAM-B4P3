import java.util.Scanner;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upper = toUpperCase(text);
        String lower = toLowerCase(text);
        String title = toTitleCase(text);

        System.out.println("\nMethod\t\tResult\t\tBuilt-in\tMatch");
        System.out.println("------\t\t------\t\t--------\t-----");
        System.out.println("Uppercase\t" + upper + "\t" + text.toUpperCase() + "\t" + upper.equals(text.toUpperCase()));
        System.out.println("Lowercase\t" + lower + "\t" + text.toLowerCase() + "\t" + lower.equals(text.toLowerCase()));
        System.out.println("Title Case\t" + title);

        sc.close();
    }

    public static char toUpperCase(char c) {
        if (c >= 97 && c <= 122) return (char)(c - 32);
        return c;
    }

    public static String toUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(toUpperCase(c));
        }
        return result.toString();
    }

    public static char toLowerCase(char c) {
        if (c >= 65 && c <= 90) return (char)(c + 32);
        return c;
    }

    public static String toLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(toLowerCase(c));
        }
        return result.toString();
    }

    public static String toTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean nextUpper = true;

        for (char c : text.toCharArray()) {
            if (nextUpper && c != ' ') {
                result.append(toUpperCase(c));
                nextUpper = false;
            } else if (c == ' ') {
                result.append(c);
                nextUpper = true;
            } else {
                result.append(toLowerCase(c));
            }
        }
        return result.toString();
    }
}
