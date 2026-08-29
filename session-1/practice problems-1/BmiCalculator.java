public class BmiCalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
    static void printWellnessReport(double[] h, double[] w) {
        System.out.println("Person | Height | Weight | BMI | Status");
        for (int i = 0; i < h.length; i++) {
            double bmi = w[i] / (h[i] * h[i]);
            System.out.printf("%d | %.2f | %.2f | %.2f | %s%n", i+1, h[i], w[i], bmi, getBmiStatus(bmi));
        }
    }
    public static void main(String[] args) {
        double[] heights = {1.75, 1.60};
        double[] weights = {70, 90};
        printWellnessReport(heights, weights);
    }
}