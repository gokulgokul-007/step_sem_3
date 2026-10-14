import java.util.*;

abstract class Journey {
    double dist;
    Journey(double d) { dist = d; }
    abstract double fare();
}
class Bus extends Journey {
    Bus(double d) { super(d); }
    double fare() { return Math.min(10, 2 + 0.10 * dist); }
}
class Train extends Journey {
    Train(double d) { super(d); }
    double fare() { return 3 + 0.15 * dist; }
}
class Metro extends Journey {
    double factor;
    Metro(double d, double f) { super(d); factor = f; }
    double fare() { return (1.5 + 0.20 * dist) * factor; }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            double d = sc.nextDouble();
            names.add(t);
            if (t.equals("BUS")) list.add(new Bus(d));
            else if (t.equals("TRAIN")) list.add(new Train(d));
            else list.add(new Metro(d, sc.nextDouble()));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = list.get(i).fare();
            System.out.printf("%s: %.2f%n", names.get(i), f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}