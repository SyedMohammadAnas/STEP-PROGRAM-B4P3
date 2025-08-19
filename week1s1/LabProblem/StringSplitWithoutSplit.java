import java.util.Scanner;

public class StringSplitWithoutSplit {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] customSplit(String text) {
        int len = findLength(text);
        int wordCount = 0;
        int[] spaceIndexes = new int[len];

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[wordCount++] = i;
            }
        }
        wordCount++;

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[wordCount - 1] = text.substring(start);

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] customWords = customSplit(input);
        String[] builtinWords = input.split(" ");

        System.out.println("Custom split: " + String.join(", ", customWords));
        System.out.println("Built-in split: " + String.join(", ", builtinWords));
        System.out.println("Arrays match: " + compareArrays(customWords, builtinWords));
        sc.close();
    }
}
