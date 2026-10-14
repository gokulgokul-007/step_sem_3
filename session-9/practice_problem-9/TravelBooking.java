import java.util.Scanner;

abstract class Booking {
    static final double BOOKING_FEE = 50;   // the only place to change
    String mode;
    double km;

    Booking(String mode, double km) { this.mode = mode; this.km = km; }

    abstract double fare();

    double total() { return fare() + BOOKING_FEE; }
}

class Bus extends Booking {
    Bus(double km) { super("BUS", km); }
    double fare() { return 2 * km; }
}

class Train extends Booking {
    Train(double km) { super("TRAIN", km); }
    double fare() { return 1.5 * km; }
}

class Flight extends Booking {
    Flight(double km) { super("FLIGHT", km); }
    double fare() { return 2500 + 4 * km; }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double km = sc.nextDouble();
            Booking b;
            if (mode.equals("BUS")) b = new Bus(km);
            else if (mode.equals("TRAIN")) b = new Train(km);
            else b = new Flight(km);
            System.out.printf("%s: %.2f%n", b.mode, b.total());
        }
        sc.close();
    }
}