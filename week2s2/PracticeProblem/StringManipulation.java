import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence with mixed formatting: ");
        String input = scanner.nextLine();
        System.out.println("\n=== PROCESSING RESULTS ===");
        System.out.println("Original: " + input);
        String trimmed = input.trim();
        System.out.println("1. Trimmed: " + trimmed);
        System.out.println("2. Spaces to underscores: " + trimmed.replace(" ", "_"));
        System.out.println("3. No digits: " + trimmed.replaceAll("\\d", ""));
        String[] words = trimmed.split("\\s+");
        System.out.println("4. Split words: " + String.join(" | ", words));
        System.out.println("5. No punctuation: " + removePunctuation(trimmed));
        System.out.println("6. Capitalized: " + capitalizeWords(trimmed));
        System.out.println("7. Reversed order: " + reverseWordOrder(trimmed));
        countWordFrequency(trimmed);
        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", words);
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        System.out.println("8. Word frequency:");
        frequency.forEach((word, count) -> System.out.println("   " + word + ": " + count));
    }
}
