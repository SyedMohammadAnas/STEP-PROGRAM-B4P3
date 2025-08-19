import java.util.Scanner;

public class StringPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int iterations = sc.nextInt();

        long stringTime = stringConcatenation(iterations);
        long builderTime = stringBuilderTest(iterations);
        long bufferTime = stringBufferTest(iterations);

        System.out.println("\nMethod\t\t\tTime (ms)\tMemory Efficiency");
        System.out.println("------\t\t\t---------\t------------------");
        System.out.println("String Concatenation\t" + stringTime + "\t\tLow");
        System.out.println("StringBuilder\t\t" + builderTime + "\t\tHigh");
        System.out.println("StringBuffer\t\t" + bufferTime + "\t\tMedium");

        sc.close();
    }

    public static long stringConcatenation(int iterations) {
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "test" + i;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long stringBuilderTest(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            result.append("test").append(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long stringBufferTest(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            result.append("test").append(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
