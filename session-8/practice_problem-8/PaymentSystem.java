import java.util.*;

abstract class Payment {
    double amt;
    Payment(double a) { amt = a; }
    abstract double finalAmount();
}
class Card extends Payment {
    Card(double a) { super(a); }
    double finalAmount() { return amt * 1.02; }
}
class Wallet extends Payment {
    Wallet(double a) { super(a); }
    double finalAmount() { return amt * 1.01; }
}
class BankTransfer extends Payment {
    BankTransfer(double a) { super(a); }
    double finalAmount() { return amt; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next().toUpperCase();
            double a = sc.nextDouble();
            names.add(t);
            if (t.equals("CARD")) list.add(new Card(a));
            else if (t.equals("WALLET")) list.add(new Wallet(a));
            else list.add(new BankTransfer(a));
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