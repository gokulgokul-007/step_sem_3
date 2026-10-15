import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Accepts input like: [3, 8, 12, 5, 7, 10]
        String line = sc.nextLine().replace("[", " ").replace("]", " ").replace(",", " ").trim();
        int even = 0, odd = 0;
        for (String t : line.split("\\s+")) {
            if (t.isEmpty()) continue;
            int x = Integer.parseInt(t);
            if (x % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}