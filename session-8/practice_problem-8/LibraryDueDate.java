import java.util.*;
import java.time.LocalDate;

abstract class Item {
    String title;
    Item(String t) { title = t; }
    abstract int days();
    LocalDate dueDate(LocalDate today) { return today.plusDays(days()); }
}
class Book extends Item {
    Book(String t) { super(t); }
    int days() { return 14; }
}
class DVD extends Item {
    DVD(String t) { super(t); }
    int days() { return 7; }
}
class Magazine extends Item {
    Magazine(String t) { super(t); }
    int days() { return 3; }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate today = LocalDate.of(2023, 10, 26);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int sp = line.indexOf(' ');
            String t = line.substring(0, sp).toUpperCase();
            String title = line.substring(sp + 1).trim().replace("\"", "");
            if (t.equals("BOOK")) list.add(new Book(title));
            else if (t.equals("DVD")) list.add(new DVD(title));
            else list.add(new Magazine(title));
        }
        for (Item it : list)
            System.out.println(it.title + ": " + it.dueDate(today));
    }
}