import java.util.Scanner;
public class FirstNonRepeating {
    public static char findFirstNonRepeating(String str) {
        int[] frequency = new int[256];
        for (int i = 0; i < str.length(); i++) frequency[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++) if (frequency[str.charAt(i)] == 1) return str.charAt(i);
        return '\0';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find First Non-Repeating Character");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char result = findFirstNonRepeating(input);
        System.out.println(result == '\0' ? "No non-repeating character found." : "First non-repeating character: " + result);
        scanner.close();
    }
}
