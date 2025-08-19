import java.util.Scanner;
public class BMICalculator {
    public static String[] calculateBMIAndStatus(double weight, double height) {
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) status = "Normal";
        else if (bmi >= 25.0 && bmi <= 39.9) status = "Overweight";
        else status = "Obese";
        return new String[]{String.format("%.2f", bmi), status};
    }
    public static String[][] processData(double[][] heightWeightData) {
        String[][] results = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = heightWeightData[i][0], height = heightWeightData[i][1];
            String[] bmiStatus = calculateBMIAndStatus(weight, height);
            results[i][0] = String.format("%.1f", height) + " cm";
            results[i][1] = String.format("%.1f", weight) + " kg";
            results[i][2] = bmiStatus[0];
            results[i][3] = bmiStatus[1];
        }
        return results;
    }
    public static void displayResults(String[][] results) {
        System.out.println("\n" + "=".repeat(80));
        System.out.printf("%-20s %-15s %-15s %-15s%n", "Person's Height", "Weight", "BMI", "Status");
        System.out.println("=".repeat(80));
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-20s %-15s %-15s %-15s%n", results[i][0], results[i][1], results[i][2], results[i][3]);
        }
        System.out.println("=".repeat(80));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] heightWeightData = new double[10][2];
        System.out.println("BMI Calculator for Team of 10 Members");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");
            System.out.print("Weight (in kg): ");
            heightWeightData[i][0] = scanner.nextDouble();
            System.out.print("Height (in cm): ");
            heightWeightData[i][1] = scanner.nextDouble();
        }
        String[][] results = processData(heightWeightData);
        displayResults(results);
        scanner.close();
    }
}
