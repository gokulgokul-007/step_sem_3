import java.util.Scanner;

interface UsesBus {
    double TRANSPORT_FEE = 12000;   // written once
}

abstract class Student {
    String name;

    Student(String name) { this.name = name; }

    abstract double tuition();

    double fee() {
        double f = tuition();
        if (this instanceof UsesBus) f += UsesBus.TRANSPORT_FEE;
        return f;
    }
}

class DayScholar extends Student implements UsesBus {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 40000 + 60000; }
}

class Scholar extends Student implements UsesBus {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student s;
            if (type.equals("DAY_SCHOLAR")) s = new DayScholar(name);
            else if (type.equals("HOSTELLER")) s = new Hosteller(name);
            else s = new Scholar(name);
            System.out.printf("%s: %.2f%n", s.name, s.fee());
            total += s.fee();
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}