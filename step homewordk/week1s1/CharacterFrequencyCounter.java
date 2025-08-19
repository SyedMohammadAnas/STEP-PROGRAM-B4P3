import java.util.Scanner;
public class CharacterFrequencyCounter {
    public static String[] findCharacterFrequency(String str) {
        char[] chars = str.toCharArray();
        int[] frequency = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            frequency[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && chars[j] != '0') {
                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }
        int resultSize = 0;
        for (int i = 0; i < chars.length; i++) if (chars[i] != '0') resultSize++;
        String[] result = new String[resultSize];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + ":" + frequency[i];
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Character Frequency Counter using Nested Loops");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String[] frequencies = findCharacterFrequency(input);
        System.out.println("\nCharacter frequencies:");
        for (String freq : frequencies) System.out.println(freq);
        scanner.close();
    }
}
