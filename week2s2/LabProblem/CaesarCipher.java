import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);
        boolean isValid = text.equals(decrypted);

        System.out.println("\nOriginal: " + text + " (ASCII: " + getASCII(text) + ")");
        System.out.println("Encrypted: " + encrypted + " (ASCII: " + getASCII(encrypted) + ")");
        System.out.println("Decrypted: " + decrypted + " (ASCII: " + getASCII(decrypted) + ")");
        System.out.println("Decryption valid: " + isValid);

        sc.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(shiftChar(c, shift));
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static char shiftChar(char c, int shift) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(((c - 'A' + shift + 26) % 26) + 'A');
        } else if (c >= 'a' && c <= 'z') {
            return (char)(((c - 'a' + shift + 26) % 26) + 'a');
        }
        return c;
    }

    public static String getASCII(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((int)c).append(" ");
        }
        return result.toString().trim();
    }
}
