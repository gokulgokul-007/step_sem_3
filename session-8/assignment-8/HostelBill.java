import java.util.*;

abstract class Room {
    int units;
    Room(int u) { units = u; }
    abstract double bill();
}
class Single extends Room {
    Single(int u) { super(u); }
    double bill() { return 8 * units; }
}
class Shared extends Room {
    int occupants;
    Shared(int u, int o) { super(u); occupants = o; }
    double bill() { return 6.0 * units / occupants; }
}
class AC extends Room {
    AC(int u) { super(u); }
    double bill() { return 10 * units + 200; }
}

public class HostelBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            int u = sc.nextInt();
            names.add(t);
            if (t.equals("SINGLE")) list.add(new Single(u));
            else if (t.equals("SHARED")) list.add(new Shared(u, sc.nextInt()));
            else list.add(new AC(u));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = list.get(i).bill();
            System.out.printf("%s: %.2f%n", names.get(i), b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}