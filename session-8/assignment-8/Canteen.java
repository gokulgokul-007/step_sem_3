import java.util.*;

abstract class Customer {
    double amt;
    Customer(double amt) { this.amt = amt; }
    abstract double finalAmount();
}
class Student extends Customer {
    Student(double a) { super(a); }
    double finalAmount() { return amt * 0.90; }
}
class Staff extends Customer {
    Staff(double a) { super(a); }
    double finalAmount() { return amt * 0.95; }
}
class Guest extends Customer {
    Guest(double a) { super(a); }
    double finalAmount() { return amt + 10; }
}

public class Canteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            double a = sc.nextDouble();
            names.add(t);
            if (t.equals("STUDENT")) list.add(new Student(a));
            else if (t.equals("STAFF")) list.add(new Staff(a));
            else list.add(new Guest(a));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = list.get(i).finalAmount();
            System.out.printf("%s: %.2f%n", names.get(i), f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}