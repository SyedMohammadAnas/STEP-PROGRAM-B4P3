import java.util.Scanner;
public class UniqueCharacters {
    public static int findStringLength(String str) {
        int length = 0;
        try {
            while (true) { str.charAt(length); length++; }
        } catch (StringIndexOutOfBoundsException e) { return length; }
    }
    public static char[] findUniqueCharacters(String input) {
        int inputLength = findStringLength(input);
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find Unique Characters in a String");
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        int length = findStringLength(inputString);
        System.out.println("String length: " + length);
        char[] uniqueChars = findUniqueCharacters(inputString);
        System.out.println("Unique characters found: " + uniqueChars.length);
        System.out.print("Unique characters: [");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + (i < uniqueChars.length - 1 ? ", " : ""));
        }
        System.out.println("]");
        scanner.close();
    }
}
