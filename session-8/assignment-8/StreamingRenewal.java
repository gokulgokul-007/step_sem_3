import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate start;
    Plan(String n, LocalDate s) { name = n; start = s; }
    abstract int validity();
    LocalDate renewal() { return start.plusDays(validity()); }
}
class Basic extends Plan {
    Basic(String n, LocalDate s) { super(n, s); }
    int validity() { return 30; }
}
class Standard extends Plan {
    Standard(String n, LocalDate s) { super(n, s); }
    int validity() { return 90; }
}
class Premium extends Plan {
    Premium(String n, LocalDate s) { super(n, s); }
    int validity() { return 365; }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate d = LocalDate.parse(sc.next());
            if (t.equals("BASIC")) list.add(new Basic(name, d));
            else if (t.equals("STANDARD")) list.add(new Standard(name, d));
            else list.add(new Premium(name, d));
        }
        for (Plan p : list)
            System.out.println(p.name + ": " + p.renewal());
    }
}