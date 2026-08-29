public class FirstNonRepeatingChar {
    static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) freq[c]++;
        for (char c : text.toCharArray()) if (freq[c] == 1) return c;
        return '-';
    }
    public static void main(String[] args) {
        String s = "swiss";
        char res = findFirstNonRepeatingChar(s);
        if (res == '-') System.out.println("No Non-Repeating Character Found");
        else System.out.println("First Non-Repeating Character: '" + res + "'");
    }
}