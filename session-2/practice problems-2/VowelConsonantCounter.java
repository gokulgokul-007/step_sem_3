public class VowelConsonantCounter {
    static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        String vSet = "aeiouAEIOU";
        for (char c : text.toCharArray()) {
            if (c == ' ') continue;
            if (vSet.indexOf(c) != -1) vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}