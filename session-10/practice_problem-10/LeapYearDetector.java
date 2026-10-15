import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int year = sc.nextInt();
            boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(leap ? "Leap year" : "Not a leap year");
        }
        sc.close();
    }
}