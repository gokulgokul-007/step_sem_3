import java.util.Scanner;

abstract class Item {
    String title;
    int daysLate;

    Item(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }

    abstract double fine();
}

class Book extends Item {
    Book(String t, int d) { super(t, d); }
    double fine() { return 2 * daysLate; }
}

class Dvd extends Item {
    Dvd(String t, int d) { super(t, d); }
    double fine() { return Math.min(5 * daysLate, 50); }
}

class Magazine extends Item {
    Magazine(String t, int d) { super(t, d); }
    double fine() { return 1 * daysLate; }
}

public class LibraryLateFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int days = sc.nextInt();
            Item it;
            if (type.equals("BOOK")) it = new Book(title, days);
            else if (type.equals("DVD")) it = new Dvd(title, days);
            else it = new Magazine(title, days);
            System.out.printf("%s: %.2f%n", it.title, it.fine());
            total += it.fine();
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}