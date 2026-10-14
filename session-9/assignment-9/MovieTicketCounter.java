import java.util.Scanner;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;   // written once
    String seat;
    int count;

    Ticket(String seat, int count) { this.seat = seat; this.count = count; }

    abstract double price();

    double amount() { return count * (price() + CONVENIENCE_FEE); }
}

class Regular extends Ticket {
    Regular(int c) { super("REGULAR", c); }
    double price() { return 150; }
}

class Premium extends Ticket {
    Premium(int c) { super("PREMIUM", c); }
    double price() { return 250; }
}

class Recliner extends Ticket {
    Recliner(int c) { super("RECLINER", c); }
    double price() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            Ticket t;
            if (seat.equals("REGULAR")) t = new Regular(count);
            else if (seat.equals("PREMIUM")) t = new Premium(count);
            else t = new Recliner(count);
            System.out.printf("%s: %.2f%n", t.seat, t.amount());
            total += t.amount();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}