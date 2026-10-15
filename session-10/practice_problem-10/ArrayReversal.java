import java.util.Arrays;
import java.util.Scanner;

public class ArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Accepts input like: [11, 22, 33, 44]
        String[] parts = sc.nextLine().replace("[", " ").replace("]", " ").replace(",", " ").trim().split("\\s+");
        int[] a = new int[parts.length];
        for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(parts[i]);

        int left = 0, right = a.length - 1;
        while (left < right) {            // swap in place with two pointers
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(a));
        sc.close();
    }
}