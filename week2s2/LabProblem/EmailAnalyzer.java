import java.util.Scanner;

public class EmailAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of emails: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] emails = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter email " + (i+1) + ": ");
            emails[i] = sc.nextLine();
        }

        System.out.println("\nEmail\t\t\tUsername\tDomain\t\tExtension\tValid");
        System.out.println("-----\t\t\t--------\t------\t\t---------\t-----");

        int validCount = 0;
        for (String email : emails) {
            if (isValidEmail(email)) {
                validCount++;
                String username = extractUsername(email);
                String domain = extractDomain(email);
                String extension = extractExtension(domain);

                System.out.println(email + "\t" + username + "\t\t" +
                                 domain + "\t\t" + extension + "\t\tYes");
            } else {
                System.out.println(email + "\t\t\t\t\t\t\tNo");
            }
        }

        System.out.println("\nValid emails: " + validCount + "/" + count);
        sc.close();
    }

    public static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastDotIndex = email.lastIndexOf('.');
        return atIndex > 0 && lastDotIndex > atIndex && lastDotIndex < email.length() - 1;
    }

    public static String extractUsername(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    public static String extractDomain(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    public static String extractExtension(String domain) {
        int dotIndex = domain.lastIndexOf('.');
        return dotIndex > 0 ? domain.substring(dotIndex + 1) : "";
    }
}
