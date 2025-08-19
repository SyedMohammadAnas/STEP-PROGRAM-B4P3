import java.util.Scanner;
public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) reversed.append(str.charAt(i));
        return reversed.toString();
    }
    public static boolean isPalindromeReversal(String text) {
        char[] originalChars = text.toCharArray();
        String reversedText = reverseString(text);
        char[] reversedChars = reversedText.toCharArray();
        for (int i = 0; i < originalChars.length; i++) if (originalChars[i] != reversedChars[i]) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palindrome Checker - Three Methods");
        System.out.print("Enter text to check: ");
        String input = scanner.nextLine();
        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean result3 = isPalindromeReversal(input);
        System.out.println("\nResults:");
        System.out.println("Logic 1 (Iterative): " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursive): " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (Reversal): " + (result3 ? "Palindrome" : "Not Palindrome"));
        scanner.close();
    }
}
