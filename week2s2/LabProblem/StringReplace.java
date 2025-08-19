import java.util.Scanner;

public class StringReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main text: ");
        String text = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String find = sc.nextLine();
        System.out.print("Enter replacement: ");
        String replace = sc.nextLine();

        String result = replaceSubstring(text, find, replace);
        String builtInResult = text.replace(find, replace);
        boolean isSame = result.equals(builtInResult);

        System.out.println("\nOriginal: " + text);
        System.out.println("Custom replace: " + result);
        System.out.println("Built-in replace: " + builtInResult);
        System.out.println("Results match: " + isSame);

        sc.close();
    }

    public static int[] findOccurrences(String text, String find) {
        int[] positions = new int[text.length()];
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(find, index)) != -1) {
            positions[count++] = index;
            index += find.length();
        }

        int[] result = new int[count];
        System.arraycopy(positions, 0, result, 0, count);
        return result;
    }

    public static String replaceSubstring(String text, String find, String replace) {
        int[] positions = findOccurrences(text, find);
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;

        for (int pos : positions) {
            result.append(text, lastIndex, pos);
            result.append(replace);
            lastIndex = pos + find.length();
        }
        result.append(text, lastIndex, text.length());

        return result.toString();
    }
}
