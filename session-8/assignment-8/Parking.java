import java.util.*;

abstract class Vehicle {
    int hours;
    Vehicle(int h) { hours = h; }
    abstract double charge();
}
class Bike extends Vehicle {
    Bike(int h) { super(h); }
    double charge() { return 10 * hours; }
}
class Car extends Vehicle {
    Car(int h) { super(h); }
    double charge() { return 30 + 20 * (hours - 1); }
}
class Truck extends Vehicle {
    Truck(int h) { super(h); }
    double charge() { return Math.max(100, 50 * hours); }
}

public class Parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            int h = sc.nextInt();
            names.add(t);
            if (t.equals("BIKE")) list.add(new Bike(h));
            else if (t.equals("CAR")) list.add(new Car(h));
            else list.add(new Truck(h));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double c = list.get(i).charge();
            System.out.printf("%s: %.2f%n", names.get(i), c);
            total += c;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}