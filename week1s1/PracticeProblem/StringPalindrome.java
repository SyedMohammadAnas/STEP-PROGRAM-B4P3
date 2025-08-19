import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String rev = new StringBuilder(str).reverse().toString();
        boolean isPalindrome = str.equalsIgnoreCase(rev);
        System.out.println("Is palindrome: " + isPalindrome);
        sc.close();
    }
}
