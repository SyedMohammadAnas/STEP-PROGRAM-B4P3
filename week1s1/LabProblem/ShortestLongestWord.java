import java.util.Scanner;

public class ShortestLongestWord {
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

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordLengths) {
        int shortest = Integer.MAX_VALUE;
        int longest = 0;

        for (String[] row : wordLengths) {
            int len = Integer.parseInt(row[1]);
            if (len < shortest) shortest = len;
            if (len > longest) longest = len;
        }

        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] wordLengths = getWordLengthArray(words);
        int[] minMax = findShortestLongest(wordLengths);

        System.out.println("Shortest word length: " + minMax[0]);
        System.out.println("Longest word length: " + minMax[1]);
        sc.close();
    }
}
