import java.util.Scanner;
public class CharacterFrequency {
    public static String[][] findCharacterFrequency(String str) {
        int[] frequency = new int[256];
        for (int i = 0; i < str.length(); i++) frequency[str.charAt(i)]++;
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) if (frequency[i] > 0) uniqueCount++;
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(frequency[i]);
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find Character Frequency in String");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String[][] frequencies = findCharacterFrequency(input);
        System.out.println("\nCharacter frequencies:");
        System.out.println("Character | Frequency");
        System.out.println("----------|----------");
        for (String[] freq : frequencies) System.out.printf("%-9s | %s%n", freq[0], freq[1]);
        scanner.close();
    }
}
