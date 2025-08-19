public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";
        System.out.println("=== STRING ANALYSIS RESULTS ===");
        System.out.println("1. Original length: " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("2. Trimmed length: " + trimmed.length());
        System.out.println("3. Character at index 5: '" + sampleText.charAt(5) + "'");
        System.out.println("4. Substring 'Programming': " + sampleText.substring(6, 17));
        System.out.println("5. Index of 'Fun': " + sampleText.indexOf("Fun"));
        System.out.println("6. Contains 'Java': " + sampleText.contains("Java"));
        System.out.println("7. Starts with 'Java' (after trim): " + trimmed.startsWith("Java"));
        System.out.println("8. Ends with '!': " + sampleText.endsWith("!"));
        System.out.println("9. Uppercase: " + sampleText.toUpperCase());
        System.out.println("10. Lowercase: " + sampleText.toLowerCase());
        System.out.println("Vowels count: " + countVowels(sampleText));
        findAllOccurrences(sampleText, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) count++;
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        System.out.print("Positions of '" + target + "': ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) System.out.print(i + " ");
        }
        System.out.println();
    }
}
