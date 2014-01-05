package problemsolvingparadigms.dynamicprogramming;

import java.util.Scanner;

/**
 * Dividing Coins.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem562YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                total += arr[i];
            }
            int mid = total / 2;
            boolean[] sudah = new boolean[mid + 1];
            sudah[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = mid; j >= 0; j--) {
                    if (j - arr[i] >= 0 && sudah[j - arr[i]]) {
                        sudah[j] = true;
                    }
                }
            }
            int ret = 0;
            for (int i = mid; i >= 0; i--) {
                if (sudah[i]) {
                    ret = i;
                    break;
                }
            }
            System.out.println(total - ret - ret);
        }
    }
}
