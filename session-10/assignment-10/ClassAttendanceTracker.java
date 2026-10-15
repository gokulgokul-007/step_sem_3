public class ClassAttendanceTracker {

    static int[] attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                streak++;
                if (streak > longest) longest = streak;
            } else {
                streak = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        int[] r1 = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + r1[0] + ", Longest streak: " + r1[1]);

        int[] r2 = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + r2[0] + ", Longest streak: " + r2[1]);
    }
}