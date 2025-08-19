import java.util.Scanner;

public class StringLengthWithoutLength {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int customLength = findLength(input);
        int builtinLength = input.length();

        System.out.println("Custom length: " + customLength);
        System.out.println("Built-in length: " + builtinLength);
        sc.close();
    }
}
