public class SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;   // scores are >= 0, so -1 means "none"
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;              // skips scores equal to highest
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60})); // 78
        System.out.println(secondHighest(new int[]{50, 50, 50}));         // -1
    }
}