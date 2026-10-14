import java.util.Scanner;

interface NightService {
    double NIGHT_SURCHARGE = 0.20;
}

abstract class Cab {
    static final double MIN_FARE = 100;   // written once
    String type;

    Cab(String type) { this.type = type; }

    abstract double rate();

    double fare(double km, boolean night) {
        double f = Math.max(km * rate(), MIN_FARE);
        if (night) f *= (1 + NightService.NIGHT_SURCHARGE);
        return f;
    }
}

class Mini extends Cab {
    Mini() { super("MINI"); }
    double rate() { return 10; }
}

class Sedan extends Cab implements NightService {
    Sedan() { super("SEDAN"); }
    double rate() { return 14; }
}

class Suv extends Cab implements NightService {
    Suv() { super("SUV"); }
    double rate() { return 18; }
}

public class CabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            boolean night = sc.next().equalsIgnoreCase("NIGHT");
            Cab c;
            if (type.equals("MINI")) c = new Mini();
            else if (type.equals("SEDAN")) c = new Sedan();
            else c = new Suv();

            if (night && !(c instanceof NightService)) {
                System.out.println(c.type + ": night service not available");
            } else {
                double f = c.fare(km, night);
                System.out.printf("%s: %.2f%n", c.type, f);
                total += f;
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}