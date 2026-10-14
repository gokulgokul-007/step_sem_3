import java.util.*;
import java.util.regex.*;

abstract class Question {
    String correct, student;
    int points;
    Question(String c, String s, int p) { correct = c; student = s; points = p; }
    abstract double score();
}
class MCQ extends Question {
    MCQ(String c, String s, int p) { super(c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
}
class TF extends Question {
    TF(String c, String s, int p) { super(c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
}
class Essay extends Question {
    Essay(String c, String s, int p) { super(c, s, p); }
    double score() {
        int count = 0;
        String ans = student.toLowerCase();
        for (String k : correct.toLowerCase().split(",")) {
            k = k.trim();
            if (!k.isEmpty() && ans.contains(k)) count++;
        }
        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> list = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String t = line.substring(0, line.indexOf(' ')).toUpperCase();
            Matcher m = p.matcher(line);
            m.find(); // question text (skipped)
            m.find(); String correct = m.group(1);
            m.find(); String student = m.group(1);
            int pts = Integer.parseInt(line.substring(line.lastIndexOf('"') + 1).trim());
            names.add(t);
            if (t.equals("MCQ")) list.add(new MCQ(correct, student, pts));
            else if (t.equals("TF")) list.add(new TF(correct, student, pts));
            else list.add(new Essay(correct, student, pts));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double s = list.get(i).score();
            System.out.printf("%s: %.2f%n", names.get(i), s);
            total += s;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}