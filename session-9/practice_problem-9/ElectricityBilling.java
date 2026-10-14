import java.util.Scanner;

abstract class Connection {
    String type;
    double units;

    Connection(String type, double units) { this.type = type; this.units = units; }

    abstract double bill();
}

class Home extends Connection {
    Home(double u) { super("HOME", u); }
    double bill() {
        if (units <= 100) return units * 5;
        return 100 * 5 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double u) { super("SHOP", u); }
    double bill() { return units * 8 + 100; }
}

class Factory extends Connection {
    Factory(double u) { super("FACTORY", u); }
    double bill() { return Math.max(units * 6, 1000); }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();
            Connection c;
            if (type.equals("HOME")) c = new Home(units);
            else if (type.equals("SHOP")) c = new Shop(units);
            else c = new Factory(units);
            System.out.printf("%s: %.2f%n", c.type, c.bill());
            total += c.bill();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}