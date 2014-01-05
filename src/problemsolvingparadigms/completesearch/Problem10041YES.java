package problemsolvingparadigms.completesearch;

import java.util.Scanner;

/**
 * Vito's Family.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10041YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int total = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    total += Math.abs(arr[i] - arr[j]);
                }
                min = Math.min(min, total);
            }
            System.out.println(min);
        }
    }
}
