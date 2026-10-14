import java.util.*;

abstract class Delivery {
    double w, d;
    Delivery(double w, double d) { this.w = w; this.d = d; }
    abstract double fee();
}
class Standard extends Delivery {
    Standard(double w, double d) { super(w, d); }
    double fee() { return 5 + 0.5 * w + 0.1 * d; }
}
class Express extends Delivery {
    Express(double w, double d) { super(w, d); }
    double fee() { return 15 + 1.0 * w + 0.2 * d; }
}
class International extends Delivery {
    double customs;
    International(double w, double d, double c) { super(w, d); customs = c; }
    double fee() { return 25 + 2.0 * w + 0.5 * d + customs; }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            double w = sc.nextDouble(), d = sc.nextDouble();
            names.add(t);
            if (t.equals("STANDARD")) list.add(new Standard(w, d));
            else if (t.equals("EXPRESS")) list.add(new Express(w, d));
            else list.add(new International(w, d, sc.nextDouble()));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = list.get(i).fee();
            System.out.printf("%s: %.2f%n", names.get(i), f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}