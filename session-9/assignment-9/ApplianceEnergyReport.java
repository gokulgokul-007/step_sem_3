import java.util.Scanner;

interface SaverMode {
    double SAVING = 0.25;
}

abstract class Appliance {
    static final double RATE = 8;
    String name;
    double hours;

    Appliance(String name, double hours) { this.name = name; this.hours = hours; }

    abstract double power();   // watts

    double units(boolean saver) {
        double u = power() * hours / 1000;
        if (saver) u *= (1 - SaverMode.SAVING);
        return u;
    }
}

class Fridge extends Appliance {
    Fridge(double h) { super("FRIDGE", h); }
    double power() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double h) { super("AC", h); }
    double power() { return 1500; }
}

class Tv extends Appliance {
    Tv(double h) { super("TV", h); }
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) { super("WASHER", h); }
    double power() { return 500; }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0].toUpperCase();
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length > 2 && p[2].equalsIgnoreCase("SAVER");

            Appliance a;
            if (type.equals("FRIDGE")) a = new Fridge(hours);
            else if (type.equals("AC")) a = new AirConditioner(hours);
            else if (type.equals("TV")) a = new Tv(hours);
            else a = new Washer(hours);

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(a.name + ": saver mode not supported");
            } else {
                double u = a.units(saver);
                double cost = u * Appliance.RATE;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.name, u, cost);
                total += cost;
            }
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}