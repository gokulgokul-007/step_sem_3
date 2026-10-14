import java.util.Scanner;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    String type;
    double weight, value;

    Parcel(String type, double weight, double value) {
        this.type = type; this.weight = weight; this.value = value;
    }

    abstract double charge();
}

class Standard extends Parcel {
    Standard(double w, double v) { super("STANDARD", w, v); }
    double charge() { return 40 + 10 * weight; }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) { super("EXPRESS", w, v); }
    double charge() { return 80 + 15 * weight; }
    public double insurance() { return 0.02 * value; }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) { super("FRAGILE", w, v); }
    double charge() { return 40 + 10 * weight + 50; }
    public double insurance() { return 0.02 * value; }
}

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double w = sc.nextDouble(), v = sc.nextDouble();
            Parcel p;
            if (type.equals("STANDARD")) p = new Standard(w, v);
            else if (type.equals("EXPRESS")) p = new Express(w, v);
            else p = new Fragile(w, v);

            double c = p.charge();
            double ins = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double t = c + ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.type, c, ins, t);
            grand += t;
        }
        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}