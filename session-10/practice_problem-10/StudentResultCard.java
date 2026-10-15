import java.util.Scanner;

public class StudentResultCard {

   
    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return (double) sum / marks.length;
        }

        String grade() {
            double avg = average();
            if (avg >= 75) return "B";
            else if (avg >= 60) return "C";
            else if (avg >= 40) return "D";
            else return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Each line looks like: Asha [80, 90, 70]
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int open = line.indexOf('[');
            String name = line.substring(0, open).trim();
            String[] parts = line.substring(open + 1, line.indexOf(']')).split(",");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i].trim());

            Student s = new Student(name, marks);
            System.out.printf("%s: Average %.1f, Grade %s%n", s.name.toUpperCase(), s.average(), s.grade());
        }
        sc.close();
    }
}