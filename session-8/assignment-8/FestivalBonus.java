import java.util.*;

abstract class Employee {
    String name;
    double salary;
    Employee(String n, double s) { name = n; salary = s; }
    abstract double bonus();
}
class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}
class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}
class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            String name = sc.next();
            double s = sc.nextDouble();
            if (t.equals("FULLTIME")) list.add(new FullTime(name, s));
            else if (t.equals("PARTTIME")) list.add(new PartTime(name, s));
            else list.add(new Intern(name, s));
        }
        double total = 0;
        for (Employee e : list) {
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", e.name, b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}