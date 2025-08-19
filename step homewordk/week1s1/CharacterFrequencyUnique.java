import java.util.Scanner;
public class CharacterFrequencyUnique {
    public static char[] findUniqueCharacters(String input) {
        int inputLength = input.length();
        char[] tempArray = new char[inputLength];
        int uniqueCount = 0;
        for (int i = 0; i < inputLength; i++) {
            char currentChar = input.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (tempArray[j] == currentChar) { isUnique = false; break; }
            }
            if (isUnique) { tempArray[uniqueCount] = currentChar; uniqueCount++; }
        }
        char[] resultArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) resultArray[i] = tempArray[i];
        return resultArray;
    }
    public static String[][] findCharacterFrequency(String str) {
        int[] frequency = new int[256];
        for (int i = 0; i < str.length(); i++) frequency[str.charAt(i)]++;
        char[] uniqueChars = findUniqueCharacters(str);
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[ch]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find Character Frequency Using Unique Characters");
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
